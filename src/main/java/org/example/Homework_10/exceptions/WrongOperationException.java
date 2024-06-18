package org.example.Homework_10.exceptions;

public class WrongOperationException extends Exception {
    public WrongOperationException(String message){
        super(message);
    }
    public WrongOperationException(){
        super("Акаунт не має достатньо коштів");
    }
}