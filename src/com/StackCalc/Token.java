package com.StackCalc;

enum TokenType {
    NUM,
    PLUS,
    MINUS,
    MULT,
    DIV,
    UNKNOWN,
}

public class Token {
    public String value;
    public TokenType type;

    public Token(TokenType type, String value) {
        this.value = value;
        this.type = type;
    }

    @Override
    public String toString() {
        return "TOKEN_" + type + "(`" + value + "`)";
    }
}
