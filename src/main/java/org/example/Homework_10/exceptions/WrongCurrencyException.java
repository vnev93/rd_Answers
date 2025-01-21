package org.example.Homework_10.exceptions;

public class WrongCurrencyException extends Exception {
    public WrongCurrencyException(String message){
        super(message);
    }
    public WrongCurrencyException(){
        super("Акаунт має рахунок ");
    }
}
