package com.zubarev;

import com.zubarev.UserInterfaces.ConsoleInterface;

public class Main {

    public static void main(String[] args) {
        // запуск консольного интерфейса
        System.out.println("Поддерживаемые операции: +, -, *, /, div (деление нацело), mod (остаток от деления).");
        ConsoleInterface.Start();
    }
}
