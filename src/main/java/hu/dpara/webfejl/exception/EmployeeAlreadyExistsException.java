package hu.dpara.webfejl.exception;

public class EmployeeAlreadyExistsException extends Exception{

    public EmployeeAlreadyExistsException(){

    }

    public EmployeeAlreadyExistsException(String message){
        super(message);
    }
	
}
