package com.pinchuk.postproject.command;

import com.pinchuk.postproject.Message;
import com.pinchuk.postproject.OutputPrinter;
import com.pinchuk.postproject.PostBusinessLogic;

public class ListCommand implements UserCommand {
    @Override
    public void execute(PostBusinessLogic logic, OutputPrinter printer) {
        printer.println();
        printer.println("List of messages: ");
        for (Message message : logic.list() ) {
            printer.printSmallSeparator();
            printer.print(message);
            printer.println();
        }
        printer.printSeparator();
    }

    @Override
    public String toString() {
        return "ListCommand{}";
    }
}
