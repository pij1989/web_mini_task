package com.pozharsky.dmitri.command.impl;

import com.pozharsky.dmitri.command.Command;
import com.pozharsky.dmitri.constant.PagePath;
import com.pozharsky.dmitri.constant.RequestAttribute;
import com.pozharsky.dmitri.constant.RequestParameter;
import com.pozharsky.dmitri.manager.MessageManager;
import com.pozharsky.dmitri.service.CircleService;
import com.pozharsky.dmitri.validator.NumberValidator;

import javax.servlet.http.HttpServletRequest;

public class CircleSquareCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        NumberValidator numberValidator = NumberValidator.INSTANCE;
        CircleService circleService = CircleService.INSTANCE;
        String value = request.getParameter(RequestParameter.RADIUS);
        if (numberValidator.isNumber(value)) {
            double radius = Double.parseDouble(value);
            double square = circleService.defineSquare(radius);
            request.setAttribute(RequestAttribute.SQUARE, square);
            return PagePath.CIRCLE_SQUARE_RESULT;
        } else {
            request.setAttribute(RequestAttribute.ERROR_RADIUS_PASS_MESSAGE, MessageManager.INSTANCE.getString(RequestAttribute.ERROR_RADIUS_PASS_MESSAGE));
            return PagePath.MAIN;
        }
    }


}
