package com.zubarev.UserInterfaces;

import java.util.Scanner;
import com.zubarev.Functional.Operation;

/** реализует консольную работу с приложением калькулятор */
public  class ConsoleInterface {
    private static String line; // ее будем считывать и пробовать парсить в то что нам нужно
    private static Scanner in = new Scanner(System.in); // с помощью consoleInput считываем с консоли
    // точка входа в консольный интерфейс
    public static void Start() {
        System.out.println("Напоминание: для выхода из приложения напишите exit");
        TwoArgumentsOperation(); // вытаскиваем работу с бинарными операциями в отдельную функцию на случай добавления небинарных операций
    }

    // метод считывает с консоли 2 аргумента и операцию над ними, выводит на экран результат
    private static void TwoArgumentsOperation () {
        //String line; // будем считывать строку line с экрана и пробовать парсить в то что нам нужно
        // используем try-catch, чтобы поймать неверный ввод числа
        try {
            // ввод первого числа и проверка на правильность написания
            System.out.println("Введите первое число: ");
            line = in.nextLine();
            if (line.toLowerCase().equals("exit")) // добавляет возможность выхода из приложения в любой момент
                System.exit(0);
            double firstArgument = Double.parseDouble(line); // тут может возникнуть обрабатываемое исключение NumberFormatException

            // ввод второго числа и проверка на правильность написания
            System.out.println("Введите второе число: ");
            line = in.nextLine();
            if (line.toLowerCase().equals("exit")) // добавляет возможность выхода из приложения в любой момент
                System.exit(0);
            double secondArgument = Double.parseDouble(line); // тут может возникнуть обрабатываемое исключение NumberFormatException

            // ввод операции и применение операции к полученным ранее аргументам
            System.out.println("Введите интересующую операцию: ");
            line = in.nextLine();
            switch (line.toLowerCase())
            {
                case "exit":    System.exit(0);
                case "+":       System.out.println("Результат сложения: " + Operation.Addition(firstArgument, secondArgument));
                                break;

                case "-":       System.out.println("Результат вычитания: " + Operation.Subtraction(firstArgument, secondArgument));
                                break;

                case "*":       System.out.println("Результат умножения" + Operation.Multiplication(firstArgument, secondArgument));
                                break;
                // при делении на ноль с вещественными числами выходит бесконечность, что, в общем-то, не является ошибкой,
                // но на всякий добавил обработку деления на ноль в консольной версии калькулятора
                case "/":       if (secondArgument == 0)
                                    System.out.println("Ошибка: деление на ноль");
                                else
                                    System.out.println("Результат деления: " + Operation.Division(firstArgument, secondArgument));
                                break;

                case "div":     if (secondArgument == 0)
                                    System.out.println("Ошибка: деление на ноль");
                                else
                                    System.out.println("Результат деления нацело: " + Operation.DivisionWithoutReminder(firstArgument, secondArgument));
                                break;
                case "mod":     if (secondArgument == 0)
                                    System.out.println("Ошибка: остаток от деления на ноль - несуществующее число");
                                else System.out.println("Результат остатка от деления: " + Operation.RemainderOfDivision(firstArgument, secondArgument));
                                break;

                default:        System.out.println("Операции \"" + line + "\" не существует!");
            }
            // спрашиваем у пользователя, хочет ли он произвести новое вычисление
            if (NewOperation())
                ConsoleInterface.Start();
        }
        // ловим ошибку неверно введенного числа пользователем
        catch (NumberFormatException e) {
            System.out.println("Число введено неверно! Попробуйте еще раз");
            ConsoleInterface.Start();
        }
    }

    // спрашивает у пользователя, нужно ли еще произвести вычисление,
    // если да  - возврат в точку входа в интерфейс консоли,
    // если нет - выход из приложения
    private static boolean NewOperation() {
        System.out.println("Произвести новое вычисление? да/нет");
        while (true) {
            line = in.nextLine();
            if (line.toLowerCase().equals("да") || line.toLowerCase().equals("yes") || line.toLowerCase().equals("y") || line.equals("1")) {
                return true;
            }
            if (line.toLowerCase().equals("нет") || line.toLowerCase().equals("no") || line.toLowerCase().equals("n") || line.equals("0")) {
                return false;
            }
            System.out.println("Формат ответа неясен, попробуйте еще раз: (да/нет)");
        }
    }

}
