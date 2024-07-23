package src.core.util;

public enum Doings {
    ADD("add"), DELETE("delete"), LIST("list"), TRAIN("train");

    private final String doing;

    Doings(String doing) {
        this.doing = doing;
    }

    public String doing() {
        return doing;
    }
}
