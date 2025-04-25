package com.example.patterns_banking.models.decorator;

import com.example.patterns_banking.models.Account;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class AccountWithdrawDecorator extends AccountDecorator {

    private static final double WITHDRAW_EXTRA_MAX = 20000;

    public AccountWithdrawDecorator(Account account) {
        super(account);
    }

    @Override
    public void withdraw(double amount) {
        double balance = getBalance();

        if (amount > balance + WITHDRAW_EXTRA_MAX) {
            throw new IllegalArgumentException("El monto excede el balance más el límite de sobregiro permitido.");
        }

        System.out.println("Se realizó el retiro de: " + amount + " en la cuenta de: " + getAccountNumber());

        if (amount >= balance) {
            System.out.println("El excedente retirado fue de: " + (amount - balance));
            setBalance(0.0);
            amount = 0.0;
        }

        super.withdraw(amount);
    }

}
