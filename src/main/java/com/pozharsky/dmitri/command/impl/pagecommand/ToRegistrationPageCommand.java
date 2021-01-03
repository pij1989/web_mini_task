package com.pozharsky.dmitri.command.impl.pagecommand;

import com.pozharsky.dmitri.command.Command;
import com.pozharsky.dmitri.command.PagePath;

import javax.servlet.http.HttpServletRequest;

public class ToRegistrationPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return PagePath.REGISTER;
    }
}
