package lesson_04.homework;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Запросить значение n у пользователя.
        // Вызвать метод и передать туда значение, полученное от пользователя.
        // Посмотреть, какие ошибки возможны в данном коде и для каждой
        // ошибки создать пользовательское исключение.
        // Выбросить эти исключения в нужное время и обработать их в main.
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        try {
            System.out.println("Введите целое число: ");
            n = Integer.parseInt(scanner.nextLine());
            testingExceptions(n);
        } catch (DivisionByZero | ArraySizeIsNegative e) {
            System.out.println("Ошибка - " + e.getMessage());
        } catch (ArrayOverrun e) {
            System.out.println("При получении элемента под индексом " + n + " будет ошибка, " +
                    "т.к. длина массива больше индекса последнего элемента");
            System.out.println("Ошибка - " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Нужно ввести целое число!");
        }
    }

    public static void testingExceptions(int n) throws DivisionByZero, ArraySizeIsNegative, ArrayOverrun {
        if (n == 0) {
            throw new DivisionByZero("Делить на ноль нельзя!");
        }

        int x = 10 / n;
        System.out.printf("Результат целочисленного деления 10 / " + n + " = %d \n", x);
        System.out.println();

        if (n < 0) {
            throw new ArraySizeIsNegative("Размер массива не может быть отрицательным!");
        }

        int[] array = new int[n];
        System.out.println("Длина массива равна " + array.length);
        System.out.println();

        try {
            System.out.println(array[n]);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayOverrun("Выход за границы массива");
        }
    }
}