package com.pinchuk.postproject.command;

import com.pinchuk.postproject.OutputPrinter;
import com.pinchuk.postproject.PostBusinessLogic;

public class EmptyCommand implements UserCommand{
    @Override
    public void execute(PostBusinessLogic logic, OutputPrinter printer) {

    }

    @Override
    public String toString() {
        return "EmptyCommand{}";
    }
}
