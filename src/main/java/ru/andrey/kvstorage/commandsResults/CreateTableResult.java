package ru.andrey.kvstorage.commandsResults;

import ru.andrey.kvstorage.console.DatabaseCommandResult;

import java.util.Objects;
import java.util.Optional;

public class CreateTableResult implements DatabaseCommandResult{
    private final String errorMessage;

    private CreateTableResult() {
        this.errorMessage = null;
    }

    private CreateTableResult(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static CreateTableResult createSuccessResult() {
        return new CreateTableResult();
    }

    public static CreateTableResult createFailedResult(String errorMessage) {
        return new CreateTableResult(errorMessage);
    }

    public Optional<String> getResult() {
        return null;
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
