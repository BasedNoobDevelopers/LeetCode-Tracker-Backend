package com.acompletenoobsmoke.leetcodetrackerbackend.model;

public enum Status {
    Not_Started("Not Started"),
    In_Progress("In Progress"),
    Completed("Completed");

    private final String displayName;

    Status(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static ProgrammingLanguage getByDisplayName(String displayName) {
        for (ProgrammingLanguage language : ProgrammingLanguage.values()) {
            if (language.getDisplayName().equals(displayName)) {
                return language;
            }
        }
        throw new IllegalArgumentException("No such status: " + displayName);
    }
}
