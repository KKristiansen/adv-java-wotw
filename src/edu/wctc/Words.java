package edu.wctc;

public class Words {
    private String value;
    private String key;

    public Words(String key, int value) {
        this.value = String.format("%04d",value);
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return key + " " + Integer.valueOf(value);
    }
}
