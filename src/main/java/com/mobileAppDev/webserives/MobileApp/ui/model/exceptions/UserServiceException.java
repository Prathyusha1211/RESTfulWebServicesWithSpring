package com.mobileAppDev.webserives.MobileApp.ui.model.exceptions;

import java.rmi.server.UID;

public class UserServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public UserServiceException(String message) {
        super(message);
    }
}
