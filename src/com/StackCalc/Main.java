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

        // Lendo expressao StackCalc
        System.out.print("Insira o codigo em StackCalc: ");
        inputCode = scanner.nextLine();
        scanner.close();

        // Analise Lexica
        tokens = AnalisadorLexico.run(inputCode);
        System.out.println("Tokens:\n");
        for (Token t : tokens) {
            System.out.println(t);
        }

        // Analise Sintatica
        valido = AnalisadorSintatico.run(tokens);
        System.out.println("\nAnalise sintatica: " + (valido ? "Sintaxe Valida" : "Erro de Sintaxe"));

        // Valorando resultado e imprimindo
        if (valido) {
            System.out.print("Resultado da expressao na pilha: ");
            resultStack = AnalisadorSintatico.eval(tokens);
            iterator = resultStack.descendingIterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
        }
    }
}
