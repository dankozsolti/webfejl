package hu.dpara.webfejl.exception;

public class DeptManagerAlreadyExistsException extends Exception{

    public DeptManagerAlreadyExistsException(){

    }

    public DeptManagerAlreadyExistsException(String message){
        super(message);
    }
	
}
