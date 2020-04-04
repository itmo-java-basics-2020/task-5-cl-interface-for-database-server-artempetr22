package ru.andrey.kvstorage.commandsResults;

import ru.andrey.kvstorage.console.DatabaseCommandResult;

import java.util.Optional;

public class UnsupportedCommandResult implements DatabaseCommandResult {

    public static final DatabaseCommandResult INSTANCE = new UnsupportedCommandResult();

    private static final String ERROR_UNSUPPORTED_COMMAND = "Unsupported command";

    private UnsupportedCommandResult() {

    }

    public Optional<String> getResult() {
        return null;
    }

    public DatabaseCommandStatus getStatus() {
        return DatabaseCommandStatus.FAILED;
    }

    public boolean isSuccess() {
        return false;
    }

    public String getErrorMessage() {
        return ERROR_UNSUPPORTED_COMMAND;
    }

}
