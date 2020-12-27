package com.pozharsky.dmitri.command.impl;

import com.pozharsky.dmitri.command.Command;
import com.pozharsky.dmitri.constant.PagePath;

import javax.servlet.http.HttpServletRequest;

public class ToLoginPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return PagePath.LOGIN;
    }
}
