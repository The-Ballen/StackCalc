package com.StackCalc;

import java.util.*;

public class AnalisadorLexico {
    /**
     * Performs a lexical analysis of a StackCalc expression.
     * @param inputCode
     * @return A list of StackCalc tokens
     */
    public static List<Token> run(String inputCode) {
        List<Token> tokens = new ArrayList<>();
        String[] partes = inputCode.trim().split(" ");
        
        for (String s : partes) {
            if ( s.matches("\\d+") ) {
                tokens.add( new Token(TokenType.NUM, s) );
                continue;
            }
            
            switch (s) {
                case "+":
                    tokens.add(new Token(TokenType.PLUS, s));
                    break;
                case "-":
                    tokens.add(new Token(TokenType.MINUS, s));
                    break;
                case "*":
                    tokens.add(new Token(TokenType.MULT, s));
                    break;
                case "/":
                    tokens.add(new Token(TokenType.DIV, s));
                    break;
                case "":
                    break;
                default:
                    tokens.add(new Token(TokenType.UNKNOWN, s));
                    break;
            }

        }

        return tokens;
    }
}
