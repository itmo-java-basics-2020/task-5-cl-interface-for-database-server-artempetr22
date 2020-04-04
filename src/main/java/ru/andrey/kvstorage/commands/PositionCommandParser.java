package ru.andrey.kvstorage.commands;

import ru.andrey.kvstorage.commandsResults.ReadKeyResult;
import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.ExecutionEnvironment;

import java.util.Objects;

public class PositionCommandParser implements CommandParser {

    public static final PositionCommandParser INSTANCE = new PositionCommandParser();

    private static final String CREATE_DATABASE_COMMAND = "CREATE_DATABASE";

    private static final String CREATE_TABLE_COMMAND = "CREATE_TABLE";

    private static final String UPDATE_KEY_COMMAND = "UPDATE_KEY";

    private static final String READ_KEY_COMMAND = "READ_KEY";

    private static final Character COMMAND_ARGUMENT_SEPARATOR = ' ';

    private PositionCommandParser() {

    }

    private String[] InternalParse(String command) {
        String[] primaryResult = command.split("\\" + COMMAND_ARGUMENT_SEPARATOR);
        String[] result = new String[primaryResult.length - 1];
        for (int i = 1; i < primaryResult.length; ++i) {
            result[i - 1] = primaryResult[i];
        }
        return result;
    }

    public DatabaseCommand Parse(ExecutionEnvironment environment, String command) {
        if (Objects.isNull(command)) {
            return UnsupportedCommand.INSTANCE;
        }
        String[] arguments = InternalParse(command);
        if (command.startsWith(CREATE_TABLE_COMMAND) && arguments.length == 2) {
            return new CreateTableCommand(environment, arguments[0], arguments[1]);
        }
        if (command.startsWith(UPDATE_KEY_COMMAND) && arguments.length == 4) {
            return new UpdateKeyCommand(environment, arguments[0], arguments[1], arguments[2], arguments[3]);
        }
        if (command.startsWith(READ_KEY_COMMAND) && arguments.length == 3) {
            return new ReadKeyCommand(environment, arguments[0], arguments[1], arguments[2]);
        }
        return UnsupportedCommand.INSTANCE;
    }

}
