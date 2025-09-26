package com.StackCalc;

import java.util.*;

public class AnalisadorSintatico {
    /**
     *  Parses a list of StackCalc tokens
     *  @param tokens A list of StackCalc tokens
     *  @return true if syntactically correct
     */
    public static boolean run(List<Token> tokens) {
        int count = 0;

        for (Token t : tokens) {
            
            switch (t.type) {
                case TokenType.NUM:
                    count++;
                    break;
                case TokenType.PLUS:
                case TokenType.MINUS:
                case TokenType.MULT:
                case TokenType.DIV:
                    if (count < 2)  return false;
                    count--;
                    break;
                default:
                    return false;
            }

        }
        return true;
    }
    /**
     *  Evaluates an expression in StackCalc and returns the resulting stack
     *  @param tokens A list of StackCalc tokens
     *  @return A list containing the final stack output
     *  @throws IllegalArgumentException If the provided token list is syntactically incorrect
     */
    public static ArrayDeque<Integer> eval(List<Token> tokens) throws IllegalArgumentException {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n1, n2;

        if (!run(tokens))
            throw new IllegalArgumentException("Erro de sintaxe!");

        for (Token t : tokens) {
            switch (t.type) {
                case TokenType.NUM:
                    stack.push(Integer.parseInt(t.value));
                    break;
                case TokenType.PLUS:
                    n2 = stack.pop();
                    n1 = stack.pop();
                    stack.push( n1 + n2 );
                    break;
                case TokenType.MINUS:
                    n2 = stack.pop();
                    n1 = stack.pop();
                    stack.push( n1 - n2 );
                    break;
                case TokenType.MULT:
                    n2 = stack.pop();
                    n1 = stack.pop();
                    stack.push( n1 * n2 );
                    break;
                case TokenType.DIV:
                    n2 = stack.pop();
                    n1 = stack.pop();
                    stack.push( (int) (n1 / n2) );
                    break;
                default:
                    break;
            }
        }
        return stack;
    }
}
