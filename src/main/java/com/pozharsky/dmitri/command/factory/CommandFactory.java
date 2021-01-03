package com.pozharsky.dmitri.command.factory;

import com.pozharsky.dmitri.command.Command;
import com.pozharsky.dmitri.command.CommandType;
import com.pozharsky.dmitri.command.RequestParameter;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.stream.Stream;

public class CommandFactory {
    public Optional<Command> defineCommand(HttpServletRequest request) {
        String value = request.getParameter(RequestParameter.COMMAND);
        if (value != null && !value.isEmpty()) {
            return Stream.of(CommandType.values())
                    .filter(e -> e.toString().equals(value.toUpperCase()))
                    .map(CommandType::getCommand).findAny();
        } else {
            return Optional.empty();
        }
    }
}
