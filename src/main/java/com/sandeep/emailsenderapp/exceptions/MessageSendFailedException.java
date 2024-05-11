package com.sandeep.emailsenderapp.exceptions;

public class MessageSendFailedException extends RuntimeException {
    public MessageSendFailedException(String message) {
        super(message);
    }
}
