package com.pinchuk.postproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserCommandLineCommand {
    private String name, description;
    private List<Parameter> parameters;

    public UserCommandLineCommand(String name, String description) {
        this(name, description, new Parameter[0]);
    }

    public UserCommandLineCommand(String name, String description, Parameter... parameters) {
        this.name = name;
        this.description = description;
        this.parameters = Arrays.asList(parameters);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Parameter> getParameters() {
        return new ArrayList<>(parameters);
    }

    public static class  Parameter{
        private String name, description;

        public Parameter(String name, String description) {
            this.name = name;
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }
    }
}
