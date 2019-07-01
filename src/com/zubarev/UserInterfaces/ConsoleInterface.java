package com.zubarev.UserInterfaces;

import java.util.Scanner;
import com.zubarev.Functional.Operation;

/** реализует консольную работу с приложением */
public  class ConsoleInterface {

    // точка входа в консольный интерфейс
    public static void Start() {
        Scanner consoleInput = new Scanner(System.in);
        System.out.println("Напоминание: для выхода из приложения напишите exit");
        TwoArgumentsOperation(consoleInput); // вытаскиваем работу с бинарными операциями в отдельную функцию на случай добавления небинарных операций
    }

    // метод считывает с консоли 2 аргумента и операцию над ними, выводит на экран результат
    private static void TwoArgumentsOperation (Scanner in) {
        String line; // будем считывать строку line с экрана и пробовать парсить в то что нам нужно
        // используем try-catch, чтобы поймать неверный ввод числа
        try {
            // ввод первого числа и проверка на правильность написания
            System.out.println("Введите первое число: ");
            line = in.nextLine();
            if (line.equals("exit")) // добавляет возможность выхода из приложения в любой момент
                System.exit(0);
            double firstArgument = Double.parseDouble(line); // тут может возникнуть NumberFormatException

            // ввод второго числа и проверка на правильность написания
            System.out.println("Введите второе число: ");
            line = in.nextLine();
            if (line.equals("exit")) // добавляет возможность выхода из приложения в любой момент
                System.exit(0);
            double secondArgument = Double.parseDouble(line); // тут может возникнуть NumberFormatException

            // ввод операции и применение операции к полученным ранее аргументам
            System.out.println("Введите интересующую операцию: ");
            line = in.nextLine();
            switch (line)
            {
                case "exit":    System.exit(0);
                case "+":       System.out.println("Результат сложения: " + Operation.Addition(firstArgument, secondArgument));
                                break;

                case "-":       System.out.println("Результат вычитания: " + Operation.Subtraction(firstArgument, secondArgument));
                                break;

                case "*":       System.out.println("Результат умножения" + Operation.Multiplication(firstArgument, secondArgument));
                                break;

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
        }
        //ловим ошибку неверно введенного числа пользователем
        catch (NumberFormatException e) {
            System.out.println("Число введено неверно! Попробуйте еще раз");
        }
        // в любом случае, возвращаемся в точку входа в консольный интерфейс
        finally {
            ConsoleInterface.Start();
        }
    }
}
