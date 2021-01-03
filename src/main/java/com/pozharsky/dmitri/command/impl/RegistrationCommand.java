package com.pozharsky.dmitri.command.impl;

import com.pozharsky.dmitri.command.Command;
import com.pozharsky.dmitri.command.PagePath;
import com.pozharsky.dmitri.command.RequestAttribute;
import com.pozharsky.dmitri.command.RequestParameter;
import com.pozharsky.dmitri.exception.UserServiceException;
import com.pozharsky.dmitri.manager.MessageManager;
import com.pozharsky.dmitri.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class RegistrationCommand implements Command {
    private static final Logger logger = LogManager.getLogger(RegistrationCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        try {
            UserServiceImpl userService = UserServiceImpl.INSTANCE;
            String email = request.getParameter(RequestParameter.EMAIL);
            String password = request.getParameter(RequestParameter.PASSWORD);
            if (userService.createUser(email, password)) {
                return PagePath.LOGIN;
            } else {
                logger.info("Invalid email or password");
                request.setAttribute(RequestAttribute.ERROR_EMAIL_OR_PASSWORD, MessageManager.INSTANCE.getString(RequestAttribute.ERROR_EMAIL_OR_PASSWORD));
                return PagePath.REGISTER;
            }
        } catch (UserServiceException e) {
            logger.error(e);
            throw new RuntimeException();
        }
    }
}
