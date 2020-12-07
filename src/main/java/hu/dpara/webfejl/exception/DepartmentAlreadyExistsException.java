package hu.dpara.webfejl.exception;

public class DepartmentAlreadyExistsException extends Exception{

    public DepartmentAlreadyExistsException(){

    }

    public DepartmentAlreadyExistsException(String message){
        super(message);
    }
	
}
