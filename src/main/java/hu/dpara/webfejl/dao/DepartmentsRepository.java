package hu.dpara.webfejl.dao;

import hu.dpara.webfejl.dao.entity.DepartmentEntity;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentsRepository extends CrudRepository<DepartmentEntity, Integer> {

}
