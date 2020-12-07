package hu.dpara.webfejl.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
@RequiredArgsConstructor
public class DepartmentDaoImpl implements DepartmentDao {

    private final DepartmentRepository customerRepository;
    private final YearMonthRepository yearMonthRepository;
    private final TransactionRepository transactionRepository;
    @Override
    public void createCustomer(Customer customer)throws CustomerAlreadyExistsException {
        CustomerEntity customerEntity;
        try {
            customerEntity = queryCustomer(customer.getId());

        }
        catch (UnknownCustomerException e){
            log.error("Exception: {} handled with message: "+e.getMessage(),e.getClass());
            customerEntity = CustomerEntity.builder()
                    .id(customer.getId())
                    .segment(customer.getSegment())
                    .currency(customer.getCurrency())
                    .build();
            customerRepository.save(customerEntity);
            log.trace("Recorded new Customer: {}",customerEntity);
            return;
        }
        CustomerAlreadyExistsException customerException = new CustomerAlreadyExistsException("Customer with id: "+customer.getId()+" already exists.");
        log.error("Exception: {} thrown with message: "+customerException.getMessage(),customerException.getClass());
        throw customerException;

    }

    @Override
    public Collection<Customer> readAll() {
        log.trace("Read all customers");
        return StreamSupport.stream(customerRepository.findAll().spliterator(),false)
                .map(entity -> new Customer(
                        entity.getId(),
                        entity.getSegment(),
                        entity.getCurrency()
                )).collect(Collectors.toList());
    }

    @Override
    public Customer readById(int id) throws UnknownCustomerException {

        CustomerEntity customerEntity = queryCustomer(id);
        log.trace("Customer found by id: {} customer: {}", id,customerEntity);
        return  new Customer(customerEntity.getId(),customerEntity.getSegment(), customerEntity.getCurrency());

    }




    @Override
    public void deleteById(int id) throws UnknownCustomerException {

        CustomerEntity customerEntity = queryCustomer(id);
        yearMonthRepository.deleteAllByCustomerId(id);
        log.trace("All yearMonths deleted by customerId: {}", id);
        transactionRepository.deleteAllByCustomerId(id);
        log.trace("All transactions deleted by customerId: {}", id);
        customerRepository.deleteById(id);
        log.trace("Customer deleted: {}", customerEntity);

    }

    @Override
    public void update( Customer customer) throws UnknownCustomerException {

        CustomerEntity customerEntity = queryCustomer(customer.getId());

        customerEntity.setSegment(customer.getSegment());
        customerEntity.setCurrency(customer.getCurrency());

        customerRepository.save(customerEntity);
        log.trace("Customer updated: {}", customerEntity);
    }

    @Override
    public Collection<Customer> readAllBySegment(String segment) throws UnknownCustomerException {
        Collection<CustomerEntity> customerEntities = queryCustomerBySegment(segment);
        log.trace("All customer found by segment: {} customers:{}",segment,customerEntities);
        return StreamSupport.stream(customerEntities.spliterator(),false)
                .map(entity -> new Customer(
                        entity.getId(),
                        entity.getSegment(),
                        entity.getCurrency()
                )).collect(Collectors.toList());
    }

    @Override
    public Collection<Customer> readAllByCurrency(String currency) throws UnknownCustomerException {
        Collection<CustomerEntity> customerEntities = queryCustomerByCurrency(currency);
        log.trace("All customer found by currency: {} customers:{}",currency,customerEntities);
        return StreamSupport.stream(customerEntities.spliterator(),false)
                .map(entity -> new Customer(
                        entity.getId(),
                        entity.getSegment(),
                        entity.getCurrency()
                )).collect(Collectors.toList());
    }

    private CustomerEntity queryCustomer(int id) throws UnknownCustomerException {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);

        if (!customerEntity.isPresent()) {
            UnknownCustomerException customerException = new UnknownCustomerException("Customer with id: " + Integer.toString(id)+" not exists.");
            log.error("Exception: {} thrown with message: "+customerException.getMessage(),customerException.getClass());
            throw customerException;
        }
        return customerEntity.get();
    }

    protected Collection<CustomerEntity> queryCustomerBySegment(String segment) throws UnknownCustomerException {
        Collection<CustomerEntity> customerEntities = customerRepository.findAllBySegment(segment);

        if (customerEntities.isEmpty()) {
            UnknownCustomerException customerException = new UnknownCustomerException("Customer with segment: " + segment+" not exists.");
            log.error("Exception: {} thrown with message: "+customerException.getMessage(),customerException.getClass());
            throw customerException;
        }
        return customerEntities;
    }

    protected Collection<CustomerEntity> queryCustomerByCurrency(String currency) throws UnknownCustomerException {
        Collection<CustomerEntity> customerEntities = customerRepository.findAllByCurrency(currency);

        if (customerEntities.isEmpty()) {
            UnknownCustomerException customerException = new UnknownCustomerException("Customer with currency: " + currency +" not exists.");
            log.error("Exception: {} thrown with message: "+customerException.getMessage(),customerException.getClass());
            throw customerException;
        }
        return customerEntities;
    }
}
