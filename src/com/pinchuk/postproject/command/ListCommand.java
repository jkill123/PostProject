package com.pinchuk.postproject.command;

import com.pinchuk.postproject.Message;
import com.pinchuk.postproject.MessageBox;
import com.pinchuk.postproject.OutputPrinter;

public class ListCommand implements UserCommand {
    @Override
    public void execute(MessageBox messageBox, OutputPrinter printer) {
        printer.println("List of messages: ");
        for (Message message : messageBox.list() ) {
            printer.println(message+ "");
        }
        printer.printSeparator();
    }

    @Override
    public String toString() {
        return "ListCommand{}";
    }
}
