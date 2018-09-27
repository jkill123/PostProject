package com.pinchuk.postproject;

import com.pinchuk.postproject.command.EditCommand;
import com.pinchuk.postproject.command.UserCommand;

public class Main {
    public static void main(String[] args) {
        MessageBox messageBox = new MessageBox();
        UserConsoleInputReader consoleInputReader = new UserConsoleInputReader(messageBox);
        while (true){
            UserCommand userCommand = consoleInputReader.nextComand();
            if (userCommand == null){
                System.out.println("Unknown command");
            }else {
            execute(userCommand, messageBox, consoleInputReader);
            }
        }

    }

    private static void execute(UserCommand userCommand, MessageBox messageBox, UserConsoleInputReader consoleInputReader) {
        if (userCommand instanceof EditCommand) {
            EditCommand command = (EditCommand) userCommand;
            Message message = messageBox.search(command.getId());
            if (message == null) {
                System.out.println("User unknown!");
            } else {
                consoleInputReader.readEdit(userCommand, message);
            }
        }

    }
}
