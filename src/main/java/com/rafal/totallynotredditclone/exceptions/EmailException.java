package com.rafal.totallynotredditclone.exceptions;

import org.springframework.mail.MailException;

public class EmailException extends RuntimeException {
    public EmailException(String exMessage) {
        super(exMessage);
    }
}
