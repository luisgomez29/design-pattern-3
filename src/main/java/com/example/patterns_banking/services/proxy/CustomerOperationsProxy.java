package com.example.patterns_banking.services.proxy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerOperationsProxy implements ICustomerOperations {

    @Override
    public boolean isValidEmail(String email) {
        return email.toLowerCase().endsWith("@yahoo.com") ? Boolean.FALSE : Boolean.TRUE;
    }
}
