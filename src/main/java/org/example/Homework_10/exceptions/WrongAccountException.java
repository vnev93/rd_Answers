package org.example.Homework_10.exceptions;

public class WrongAccountException extends Exception {
    public WrongAccountException(String message){
        super(message);
    }
    public WrongAccountException(){
        super("Такого акаунту не існує");
    }
}
