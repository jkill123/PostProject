package com.pinchuk.postproject;

import com.pinchuk.postproject.command.EditCommand;
import com.pinchuk.postproject.command.UserCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger commandLog = LoggerFactory.getLogger("CommandLog");
    public static void main(String[] args) {
        PostBusinessLogic logic = new PostBusinessLogic();
        OutputPrinter printer= new OutputPrinter(System.out);
        UserConsoleInputReader consoleInputReader = new UserConsoleInputReader(printer);
        printer.println("Plz use following commands");
        printer.printHelp();
        while (true){
            printer.printUserPromt();
            UserCommand userCommand = consoleInputReader.nextCommand();
            if (userCommand == null){
                printer.println("Unknown command");
            }else {
            commandLog.debug(userCommand.toString());
            execute(userCommand, logic, consoleInputReader, printer);
            }
        }
    }

    private static void execute(UserCommand userCommand, PostBusinessLogic logic, UserConsoleInputReader consoleInputReader, OutputPrinter printer) {
        if (userCommand instanceof EditCommand) {
            EditCommand command = (EditCommand) userCommand;
            Message message = logic.search(command.getId());
            if (message == null) {
                printer.println("User unknown!");
            } else {
                consoleInputReader.readEdit(command, message.getSender(), message.getReceiver(), message.getAddress(), message.getCategory());
            }
        }
        userCommand.execute(logic, printer); // реализация шаблона проектирования "Команда"
    }
}
