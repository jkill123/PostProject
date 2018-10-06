package com.pinchuk.postproject.command;

import com.pinchuk.postproject.OutputPrinter;
import com.pinchuk.postproject.PostBusinessLogic;

public class HelpCommand implements UserCommand{
    @Override
    public void execute(PostBusinessLogic logic, OutputPrinter printer) {
        printer.println("You can use following commands");
        printer.printHelp();
    }

    @Override
    public String toString() {
        return "HelpCommand{}";
    }
}
