package ru.andrey.kvstorage.commandsResults;

import ru.andrey.kvstorage.console.DatabaseCommandResult;

import java.util.Objects;
import java.util.Optional;

public class UpdateKeyResult implements DatabaseCommandResult {
    private final String errorMessage;

    private UpdateKeyResult(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static UpdateKeyResult CreateSuccessResult() {
        return new UpdateKeyResult(null);
    }

    public static UpdateKeyResult CreateFailedResult(String errorMessage) {
        return new UpdateKeyResult(errorMessage);
    }


    public Optional<String> getResult() {
        return null;
    }

    public DatabaseCommandResult.DatabaseCommandStatus getStatus() {
        return Objects.isNull(errorMessage) ? DatabaseCommandResult.DatabaseCommandStatus.SUCCESS : DatabaseCommandResult.DatabaseCommandStatus.FAILED;
    }

    public boolean isSuccess() {
        return Objects.isNull(errorMessage);
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
