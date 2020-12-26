package com.pozharsky.dmitri.command;

import com.pozharsky.dmitri.command.impl.ChangeLanguageCommand;
import com.pozharsky.dmitri.command.impl.CircleSquareCommand;

public enum CommandType {
    CIRCLE_SQUARE(new CircleSquareCommand()),
    CHANGE_LANGUAGE(new ChangeLanguageCommand());

    CommandType(Command command) {
        this.command = command;
    }

    private Command command;

    public Command getCommand() {
        return command;
    }
}
