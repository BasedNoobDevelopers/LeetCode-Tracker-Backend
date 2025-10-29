package com.acompletenoobsmoke.leetcodetrackerbackend.model;

public enum ProgrammingLanguage {

    Java("Java"),
    Python("Python"),
    C("C"),
    C_PLUS_PLUS("C++"),
    C_SHARP("C#"),
    GO("Go"),
    JavaScript("JavaScript");

    private final String displayName;

    ProgrammingLanguage(String displayName) {
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
        throw new IllegalArgumentException("No such programming language with displayName: " + displayName);
    }
}
