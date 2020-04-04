package ru.andrey.kvstorage;

import ru.andrey.kvstorage.commands.CommandParser;
import ru.andrey.kvstorage.commands.PositionCommandParser;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;

public class DatabaseServer {

    private static final CommandParser DEFAULT_COMMAND_PARSER = PositionCommandParser.INSTANCE;

    private final ExecutionEnvironment env;

    private final CommandParser parser;

    public DatabaseServer(ExecutionEnvironment env) {
        this(env, DEFAULT_COMMAND_PARSER);
    }

    public DatabaseServer(ExecutionEnvironment env, CommandParser parser) {
        this.env = env;
        this.parser = parser;
    }

    public static void main(String[] args) {

    }

    DatabaseCommandResult executeNextCommand(String commandText) {
        try {
            return parser.Parse(env, commandText).execute();
        }catch (Exception e){
            return null;
        }
    }
}

