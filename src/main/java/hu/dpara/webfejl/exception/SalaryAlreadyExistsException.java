package hu.dpara.webfejl.exception;

public class SalaryAlreadyExistsException extends Exception{

    public SalaryAlreadyExistsException(){

    }

    public SalaryAlreadyExistsException(String message){
        super(message);
    }
	
}
