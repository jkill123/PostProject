package com.pinchuk.postproject.command;

import com.pinchuk.postproject.MessageBox;
import com.pinchuk.postproject.OutputPrinter;

public class EmptyCommand implements UserCommand{
    @Override
    public void execute(MessageBox messageBox, OutputPrinter printer) {

    }

    @Override
    public String toString() {
        return "EmptyCommand{}";
    }
}
