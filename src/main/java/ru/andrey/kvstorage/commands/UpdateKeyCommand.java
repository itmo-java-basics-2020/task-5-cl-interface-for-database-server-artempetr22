package ru.andrey.kvstorage.commands;

import ru.andrey.kvstorage.commandsResults.ResultMessages;
import ru.andrey.kvstorage.commandsResults.UpdateKeyResult;
import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.util.Optional;

public class UpdateKeyCommand implements DatabaseCommand {
    private final String databaseName;

    private final String tableName;

    private final String keyName;

    private final String valueName;

    private final ExecutionEnvironment context;

    public UpdateKeyCommand(ExecutionEnvironment context, String databaseName, String tableName, String keyName, String valueName) {
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.keyName = keyName;
        this.valueName = valueName;
        this.context = context;
    }

    public DatabaseCommandResult execute() {
        Optional<Database> odb = context.getDatabase(databaseName);
        if (odb.isEmpty()) {
            return UpdateKeyResult.CreateFailedResult(ResultMessages.NO_SUCH_DATABASE);
        }
        try {
            odb.get().write(tableName, keyName, valueName);
            return UpdateKeyResult.CreateSuccessResult();
        }
        catch (DatabaseException e) {
            return UpdateKeyResult.CreateFailedResult(e.getMessage());
        }
    }
}
