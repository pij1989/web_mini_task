package com.pozharsky.dmitri.command.impl;

import com.pozharsky.dmitri.command.Command;
import com.pozharsky.dmitri.command.PagePath;
import com.pozharsky.dmitri.command.RequestAttribute;
import com.pozharsky.dmitri.command.RequestParameter;
import com.pozharsky.dmitri.exception.UserServiceException;
import com.pozharsky.dmitri.manager.MessageManager;
import com.pozharsky.dmitri.service.impl.UserServiceImpl;
import com.pozharsky.dmitri.validator.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {
    private static final Logger logger = LogManager.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        try {
            UserValidator userValidator = UserValidator.INSTANCE;
            UserServiceImpl userService = UserServiceImpl.INSTANCE;
            String email = request.getParameter(RequestParameter.EMAIL);
            String password = request.getParameter(RequestParameter.PASSWORD);
            if (userValidator.isEmail(email) && userValidator.isPassword(password)) {
                if (userService.checkUser(email, password)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("isAuthentication",true);
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
        } catch (UserServiceException e) {
            logger.error(e);
            throw new RuntimeException();
        }
    }
}
