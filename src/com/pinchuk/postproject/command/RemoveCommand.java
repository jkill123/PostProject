package com.pinchuk.postproject.command;

public class RemoveCommand  implements UserCommand {
    private long id;

    public RemoveCommand(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
