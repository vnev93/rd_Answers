package org.example.Homework_10;

import org.example.Homework_10.exceptions.WrongAccountException;
import org.example.Homework_10.exceptions.WrongCurrencyException;
import org.example.Homework_10.exceptions.WrongOperationException;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankApplication {

    public void process(String id, int amount, String currency) throws Exception {
        accounts.stream().filter(account -> account.getId().equals(account.getId()))
                .findAny().orElseThrow(WrongAccountException::new);

        accounts.stream().filter(account -> account.getId().equals(account.getId()))
                .filter(account -> account.getCurrency().equals(currency))
                .findAny().orElseThrow(WrongAccountException::new);

        accounts.stream().filter(account -> account.getId().equals(account.getId()))
                .filter(account -> account.getCurrency().equals(currency))
                .filter(account -> account.getBalance() >= amount)
                .findAny().orElseThrow(WrongAccountException::new);


        Account desiredAccount = accounts.stream()
                .filter(account -> account.getId().equals(account.getId()))
                .filter(account -> account.getCurrency().equals(currency))
                .filter(account -> account.getBalance() >= amount).findAny()
                .orElseThrow();

        int randomInt = new Random().nextInt(2);

        if (randomInt == 1) {
            throw new Exception();
        }

        desiredAccount.setBalance(desiredAccount.getBalance() - amount);
    }

        private final List<Account> accounts = new ArrayList<>() {{
            add(new Account("accountId001", 100, "USD"));
            add(new Account("accountId002", 500, "EUR"));
            add(new Account("accountId003", 250, "HRV"));
            add(new Account("accountId004", 1000, "USD"));
            add(new Account("accountId005", 750, "USD"));
            add(new Account("accountId006", 50, "USD"));
        }};
        }
