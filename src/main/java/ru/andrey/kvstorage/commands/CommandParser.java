package ru.andrey.kvstorage.commands;

import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.ExecutionEnvironment;

public interface CommandParser {
    DatabaseCommand Parse(ExecutionEnvironment environment, String command);
}
