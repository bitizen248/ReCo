package ru.iate.reco.obj;

public class RequestMenuModel {
    private final String REQUEST_PREFIX = "\u0009-";
    private final String REQUEST_POSTFIX = "";
    private final String PROJECT_PREFIX = "-";
    private final String PROJECT_POSTFIX = " (project settings)";

    private Type type;
    private String name;

    public RequestMenuModel(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString() {
        switch (type) {
            case PROJECT:
                return PROJECT_PREFIX + name + PROJECT_POSTFIX;
            case REQUEST:
                return REQUEST_PREFIX + name + REQUEST_POSTFIX;
        }
        return super.toString();
    }

    public enum Type {
        PROJECT,
        REQUEST
    }
}