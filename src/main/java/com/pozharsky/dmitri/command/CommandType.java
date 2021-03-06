package com.pozharsky.dmitri.command;

import com.pozharsky.dmitri.command.impl.*;
import com.pozharsky.dmitri.command.impl.pagecommand.ToLoginPageCommand;
import com.pozharsky.dmitri.command.impl.pagecommand.ToRegistrationPageCommand;

public enum CommandType {
    CIRCLE_SQUARE(new CircleSquareCommand()),
    CHANGE_LANGUAGE(new ChangeLanguageCommand()),
    LOGIN(new LoginCommand()),
    REGISTER(new RegistrationCommand()),
    LOGOUT(new LogoutCommand()),
    TO_LOGIN_PAGE_COMMAND(new ToLoginPageCommand()),
    TO_REGISTER_PAGE_COMMAND(new ToRegistrationPageCommand());

    CommandType(Command command) {
        this.command = command;
    }

    private Command command;

    public Command getCommand() {
        return command;
    }
}
