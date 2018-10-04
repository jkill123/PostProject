package com.pinchuk.postproject;

import com.pinchuk.postproject.command.EditCommand;
import com.pinchuk.postproject.command.UserCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger commandLog = LoggerFactory.getLogger("CommandLog");
    public static void main(String[] args) {
        MessageBox messageBox = new MessageBox();
        OutputPrinter printer= new OutputPrinter(System.out);
        UserConsoleInputReader consoleInputReader = new UserConsoleInputReader(printer);
        while (true){
            printer.printUserPromt();
            UserCommand userCommand = consoleInputReader.nextCommand();
            if (userCommand == null){
                printer.println("Unknown command");
            }else {
            commandLog.debug(userCommand.toString());
            execute(userCommand, messageBox, consoleInputReader, printer);
            }
        }
    }

    private static void execute(UserCommand userCommand, MessageBox messageBox, UserConsoleInputReader consoleInputReader, OutputPrinter printer) {
        if (userCommand instanceof EditCommand) {
            EditCommand command = (EditCommand) userCommand;
            Message message = messageBox.search(command.getId());
            if (message == null) {
                printer.println("User unknown!");
            } else {
                consoleInputReader.readEdit(command, message.getSender(), message.getReceiver(), message.getAddress(), message.getCategory());
            }
        }
        userCommand.execute(messageBox, printer); // реализация шаблона проектирования "Команда"
    }
}
