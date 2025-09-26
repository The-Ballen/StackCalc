package com.StackCalc;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Token> tokens;
        ArrayDeque<Integer> resultStack;
        Iterator<Integer> iterator;
        String inputCode;
        Boolean valido;

        // Lendo expressão StackCalc
        System.out.print("Insira a expressão em StackCalc: ");
        inputCode = scanner.nextLine();
        scanner.close();

        // Análise Léxica
        tokens = AnalisadorLexico.run(inputCode);
        System.out.println("Tokens:\n");
        for (Token t : tokens) {
            System.out.println(t);
        }

        // Análise Sintática
        valido = AnalisadorSintatico.run(tokens);
        System.out.println("\nAnálise sintática: " + (valido ? "Sintaxe Válida" : "Erro de Sintaxe"));

        // Valorando resultado e imprimindo
        if (valido) {
            System.out.print("Resultado da expressão na pilha: ");
            resultStack = AnalisadorSintatico.eval(tokens);
            iterator = resultStack.descendingIterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
        }
    }
}
