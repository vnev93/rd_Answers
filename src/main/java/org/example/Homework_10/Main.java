package org.example.Homework_10;

import org.example.Homework_10.exceptions.WrongAccountException;
import org.example.Homework_10.exceptions.WrongCurrencyException;
import org.example.Homework_10.exceptions.WrongOperationException;

public class Main {
    public static BankApplication bankApp;

    public static void main(String[] args) {
        bankApp = new BankApplication();

        processWrapper("accountId000", 50, "USD");
        processWrapper("accountId003", 250, "HRV");
        processWrapper("accountId001", 50, "EUR");
        processWrapper("accountId001", 50, "USD");
        processWrapper("accountId001", 2000, "USD");
    }

    private static void processWrapper(String id, int amount, String currency){
        try {
            bankApp.process(id,amount,currency);
        } catch (WrongAccountException e){
            System.out.println("Такого акаунту не існує");
        } catch (WrongCurrencyException e) {
            System.out.println("Акаунт має рахунок в іншій валюті");
        } catch (WrongOperationException e){
        System.out.println("Акаунт не має достатньо коштів");
        } catch (Exception e){
            System.out.println("Сталася помилка при процесінгу, спробуйте ще раз");
        } finally {
            System.out.println("Дякуємо, що скористалися нашим сервісом");
        }
    }
}

