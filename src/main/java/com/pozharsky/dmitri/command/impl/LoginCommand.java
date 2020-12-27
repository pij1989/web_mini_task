package com.pozharsky.dmitri.command.impl;

import com.pozharsky.dmitri.command.Command;
import com.pozharsky.dmitri.constant.PagePath;
import com.pozharsky.dmitri.constant.RequestAttribute;
import com.pozharsky.dmitri.constant.RequestParameter;
import com.pozharsky.dmitri.manager.MessageManager;
import com.pozharsky.dmitri.stub.UserStub;
import com.pozharsky.dmitri.validator.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    private static final Logger logger = LogManager.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        UserValidator userValidator = UserValidator.INSTANCE;
        String email = request.getParameter(RequestParameter.EMAIL);
        String password = request.getParameter(RequestParameter.PASSWORD);
        if (userValidator.isEmail(email) && userValidator.isPassword(password)) {
            if (UserStub.checkUser(email, password)) {
                return PagePath.MAIN;
            } else {
                logger.info("User with this email and password can not exist");
                request.setAttribute(RequestAttribute.ERROR_USER, MessageManager.INSTANCE.getString(RequestAttribute.ERROR_USER));
                return PagePath.LOGIN;
            }

        } else {
            logger.info("Invalid email or password");
            request.setAttribute(RequestAttribute.ERROR_EMAIL_OR_PASSWORD, MessageManager.INSTANCE.getString(RequestAttribute.ERROR_EMAIL_OR_PASSWORD));
            return PagePath.LOGIN;
        }
    }
}
