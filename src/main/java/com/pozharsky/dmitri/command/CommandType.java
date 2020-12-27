package com.pozharsky.dmitri.command;

import com.pozharsky.dmitri.command.impl.ChangeLanguageCommand;
import com.pozharsky.dmitri.command.impl.CircleSquareCommand;
import com.pozharsky.dmitri.command.impl.LoginCommand;
import com.pozharsky.dmitri.command.impl.ToLoginPageCommand;

public enum CommandType {
    CIRCLE_SQUARE(new CircleSquareCommand()),
    CHANGE_LANGUAGE(new ChangeLanguageCommand()),
    LOGIN(new LoginCommand()),
    TO_LOGIN_PAGE_COMMAND(new ToLoginPageCommand());

    CommandType(Command command) {
        this.command = command;
    }

    private Command command;

    public Command getCommand() {
        return command;
    }
}
