package com.pinchuk.postproject.command;

import com.pinchuk.postproject.OutputPrinter;
import com.pinchuk.postproject.PostBusinessLogic;

public class RemoveCommand  implements UserCommand {
    private long id;

    public RemoveCommand(long id) {
        this.id = id;
    }

    @Override
    public void execute(PostBusinessLogic logic, OutputPrinter printer) {
        boolean delete = logic.delete(id);
        printer.println();
        if (delete){
            printer.println("Message"+id+ "was successfully removed");
        }else {
            printer.println("Message"+id+ "was not found");
        }
        printer.printSeparator();

    }

    @Override
    public String toString() {
        return "RemoveCommand{" +
                "id=" + id +
                '}';
    }
}
