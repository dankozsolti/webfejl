package hu.dpara.webfejl.exception;

public class TitleAlreadyExistsException extends Exception{

    public TitleAlreadyExistsException(){

    }

    public TitleAlreadyExistsException(String message){
        super(message);
    }
	
}
