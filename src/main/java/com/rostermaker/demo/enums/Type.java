package com.rostermaker.demo.enums;

public enum Type {
    CONTRACTED, SUB;

    public int compare(Type otherType) {
        if (this == CONTRACTED && otherType == SUB) {
            return -1;
        } else if (this == SUB && otherType == CONTRACTED) {
            return 1;
        } else {
            return 0;
        }
    }
}
