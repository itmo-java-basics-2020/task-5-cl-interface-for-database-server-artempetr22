package ru.andrey.kvstorage.commandsResults;

import ru.andrey.kvstorage.console.DatabaseCommandResult;

import java.util.Objects;
import java.util.Optional;

public class ReadKeyResult implements DatabaseCommandResult{
    private final String errorMessage;

    private String keyValue;

    private ReadKeyResult() {
        this.errorMessage = null;
    }

    private ReadKeyResult(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static ReadKeyResult CreateSuccessResult(String keyValue) {
        ReadKeyResult result = new ReadKeyResult();
        result.keyValue = keyValue;
        return new ReadKeyResult();
    }

    public static ReadKeyResult CreateFailedResult(String errorMessage) {
        return new ReadKeyResult(errorMessage);
    }

    public Optional<String> getResult() {
        return Optional.of(keyValue);
    }


    public DatabaseCommandResult.DatabaseCommandStatus getStatus() {
        return isSuccess() ? DatabaseCommandResult.DatabaseCommandStatus.SUCCESS : DatabaseCommandResult.DatabaseCommandStatus.FAILED;
    }

    public boolean isSuccess() {
        return Objects.isNull(errorMessage);
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
