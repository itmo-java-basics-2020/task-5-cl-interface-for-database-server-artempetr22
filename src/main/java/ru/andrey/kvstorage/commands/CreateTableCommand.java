package ru.andrey.kvstorage.commands;


import ru.andrey.kvstorage.commandsResults.CreateTableResult;
import ru.andrey.kvstorage.commandsResults.ResultMessages;
import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.util.Optional;

public class CreateTableCommand implements DatabaseCommand {
    private final String databaseName;
    private final String tableName;
    private final ExecutionEnvironment environment;

    public CreateTableCommand(ExecutionEnvironment environment, String databaseName, String tableName) {
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.environment = environment;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        Optional<Database> database = environment.getDatabase(databaseName);

        if (database.isEmpty()) return CreateTableResult.createFailedResult(ResultMessages.NO_SUCH_DATABASE);;

        try {
            database.get().createTableIfNotExists(tableName);
            return CreateTableResult.createSuccessResult();
        }
        catch (DatabaseException e) {
            return CreateTableResult.createFailedResult(e.getMessage());
        }
    }
}
