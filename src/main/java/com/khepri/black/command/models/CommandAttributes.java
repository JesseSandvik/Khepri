package com.khepri.black.command.models;

public class CommandAttributes {
    private String name;
    private String version;
    private String synopsis;
    private String description;
    private String[] originalArguments;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getOriginalArguments() { return originalArguments; }

    public void setOriginalArguments(String[] originalArguments) { this.originalArguments = originalArguments; }
}
