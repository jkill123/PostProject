package com.pinchuk.postproject.command;

import com.pinchuk.postproject.MessageBox;
import com.pinchuk.postproject.OutputPrinter;

public class HelpCommand implements UserCommand{
    @Override
    public void execute(MessageBox messageBox, OutputPrinter printer) {
        printer.println("You can use following commands");
        printer.println("add");
        printer.println("send");
        printer.println("list");
        printer.println("edit <id>");
        printer.println("remove <id>");
        printer.println("help");
        printer.println("exit");
        printer.printSeparator();
    }

    @Override
    public String toString() {
        return "HelpCommand{}";
    }
}
