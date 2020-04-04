package ru.andrey.kvstorage.commands;

import ru.andrey.kvstorage.commandsResults.ReadKeyResult;
import ru.andrey.kvstorage.commandsResults.ResultMessages;
import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.util.Optional;

public class ReadKeyCommand implements DatabaseCommand {
    private final String databaseName;

    private final String tableName;

    private final String keyName;

    private final ExecutionEnvironment context;

    public ReadKeyCommand(ExecutionEnvironment context, String databaseName, String tableName, String keyName) {
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.keyName = keyName;
        this.context = context;
    }

    public DatabaseCommandResult execute() {
        Optional<Database> odb = context.getDatabase(databaseName);
        if (odb.isEmpty()) {
            return ReadKeyResult.CreateFailedResult(ResultMessages.NO_SUCH_DATABASE);
        }
        try {
            String value = odb.get().read(tableName, keyName);
            return ReadKeyResult.CreateSuccessResult(value);
        }
        catch (DatabaseException e) {
            return ReadKeyResult.CreateFailedResult(e.getMessage());
        }
    }

}
