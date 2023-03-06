package com.courier.security.exception;

public class EmailAlreadyExistException extends Exception {


    public EmailAlreadyExistException(String emailAlreadyInUse) {
        super(emailAlreadyInUse);
    }
}
