package com.pozharsky.dmitri.command.impl;

import com.pozharsky.dmitri.command.Command;
import com.pozharsky.dmitri.constant.PagePath;
import com.pozharsky.dmitri.constant.RequestParameter;
import com.pozharsky.dmitri.manager.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

public class ChangeLanguageCommand implements Command {
    private static final String RU = "ru";
    private static final String EN = "en";
    private static final String LANGUAGE = "language";
    private static final String LANGUAGE_RU = "ru";
    private static final String LANGUAGE_EN = "en";
    private static final String COUNTRY_RU = "RU";
    private static final String COUNTRY_US = "US";

    @Override
    public String execute(HttpServletRequest request) {
        String value = request.getParameter(RequestParameter.LANGUAGE);
        HttpSession session = request.getSession();
        switch (value) {
            case RU: {
                session.setAttribute(LANGUAGE, LANGUAGE_RU);
                MessageManager.INSTANCE.changeLocale(new Locale(LANGUAGE_RU, COUNTRY_RU));
                break;
            }
            case EN: {
                session.setAttribute(LANGUAGE, LANGUAGE_EN);
                MessageManager.INSTANCE.changeLocale(new Locale(LANGUAGE_EN, COUNTRY_US));
                break;
            }
            default: {
                session.setAttribute(LANGUAGE, LANGUAGE_RU);
                MessageManager.INSTANCE.changeLocale(new Locale(LANGUAGE_RU, COUNTRY_RU));
            }
        }
        return PagePath.LOGIN;
    }
}
