package ru.andrey.kvstorage.commands;

import ru.andrey.kvstorage.commandsResults.UnsupportedCommandResult;
import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;

public class UnsupportedCommand implements DatabaseCommand {


    public static final UnsupportedCommand INSTANCE = new UnsupportedCommand();

    private UnsupportedCommand() {

    }

    public DatabaseCommandResult execute() {
        return UnsupportedCommandResult.INSTANCE;
    }
}
