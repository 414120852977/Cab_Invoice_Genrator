package com.invoicegenrator;

public class InvoiceGeneratorException extends Exception {
    String message;

    public InvoiceGeneratorException(ExceptionType userAlreadyExists, String message) {
        super(message);
        this.message = message;
    }
    public enum ExceptionType {
        USER_ALREADY_EXISTS
    }
}
