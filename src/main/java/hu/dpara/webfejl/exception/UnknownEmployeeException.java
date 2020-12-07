package hu.dpara.webfejl.exception;

public class UnknownEmployeeException extends Exception{

    public UnknownEmployeeException(){

    }

    public UnknownEmployeeException(String message){
        super(message);
    }
	
}
