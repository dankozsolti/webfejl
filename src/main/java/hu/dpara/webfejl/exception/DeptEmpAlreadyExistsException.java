package hu.dpara.webfejl.exception;

public class DeptEmpAlreadyExistsException extends Exception{

    public DeptEmpAlreadyExistsException(){

    }

    public DeptEmpAlreadyExistsException(String message){
        super(message);
    }
	
}
