package com.pozharsky.dmitri.command.impl;

import com.pozharsky.dmitri.command.Command;
import com.pozharsky.dmitri.command.PagePath;
import com.pozharsky.dmitri.command.RequestAttribute;
import com.pozharsky.dmitri.command.RequestParameter;
import com.pozharsky.dmitri.manager.MessageManager;
import com.pozharsky.dmitri.service.impl.CircleService;
import com.pozharsky.dmitri.validator.NumberValidator;

import javax.servlet.http.HttpServletRequest;

public class CircleSquareCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        NumberValidator numberValidator = NumberValidator.INSTANCE;
        CircleService circleService = CircleService.INSTANCE;
        String value = request.getParameter(RequestParameter.RADIUS);
        String text = request.getParameter(RequestParameter.TEXT);
        if (numberValidator.isNumber(value)) {
            double radius = Double.parseDouble(value);
            double square = circleService.defineSquare(radius);
            request.setAttribute(RequestAttribute.SQUARE, square);
            request.setAttribute(RequestParameter.TEXT, text);
            return PagePath.CIRCLE_SQUARE_RESULT;
        } else {
            request.setAttribute(RequestAttribute.ERROR_RADIUS_PASS_MESSAGE, MessageManager.INSTANCE.getString(RequestAttribute.ERROR_RADIUS_PASS_MESSAGE));
            return PagePath.MAIN;
        }
    }


}
