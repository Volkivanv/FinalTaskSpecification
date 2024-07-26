package src.core.util;

public enum Doings {
    ADD("ADD"), DELETE("DELETE"), LIST("LIST"), TRAIN("TRAIN"), COUNT("COUNT");

    private final String doing;

    Doings(String doing) {
        this.doing = doing;
    }

    public String doing() {
        return doing;
    }
}
