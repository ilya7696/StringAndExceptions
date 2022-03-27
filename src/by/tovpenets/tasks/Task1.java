package by.tovpenets.tasks;

/*
    Написать программу со следующим функционалом:
    На вход передать строку (будем считать, что это номер документа).
    Номер документа имеет формат xxxx-yyy-xxxx-yyy-xyxy, где x — это число,
    а y — это буква.
    - Вывести на экран в одну строку два первых блока по 4 цифры.
    - Вывести на экран номер документа, но блоки из трех букв заменить
    на *** (каждая буква заменятся на *).
    - Вывести на экран только одни буквы из номера документа в формате
    yyy/yyy/y/y в нижнем регистре.
    - Вывести на экран буквы из номера документа в формате
    "Letters:yyy/yyy/y/y" в верхнем регистре(реализовать с помощью
    класса StringBuilder).
    - Проверить содержит ли номер документа последовательность abc и
    вывести сообщение содержит или нет(причем, abc и ABC считается
    одинаковой последовательностью).
    - Проверить начинается ли номер документа с последовательности 555.
    - Проверить заканчивается ли номер документа на последовательность 1a2b.
    Все эти методы реализовать в отдельном классе в статических методах,
    которые на вход (входным параметром) будут принимать вводимую на вход
    программы строку.
*/

/*
    Доработать нулевое домашнее задание предыдущего урока.
    Теперь надо создать свои классы исключений на каждую ситуацию:
    - Проверить содержит ли номер документа последовательность abc. +
    - Проверить начинается ли номер документа с последовательности 555.
    - Проверить заканчивается ли номер документа на последовательность
*/

import java.util.Scanner;

public class Task1 {

    private static String documentNumber;

    public static void main(String[] args) {
        // xxxx-yyy-xxxx-yyy-xyxy
        // char[] chars = {'8', '7', '6', '2'};
        documentNumber = "5552-abc-7462-xzd-3f7d";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер документа: ");
        documentNumber = scanner.nextLine();
        System.out.println();

        System.out.println("documentNumber is " + documentNumber);

        try {
            doTask();
        } catch (Exception e) {
            System.out.println("Some exception was thrown!");
        }
    }

    private static void doTask() throws NotABCSequenceException, NotStartsWith555Exception, NotEndsWith1a2bException {
        printTwoNumbersBlocks();
        printReplacedCharactersBlocksByDocumentNumber();
        printOnlyCharactersByDocumentNumber();
        printCharactersInUpperCase();
        printIsDocumentNumberHasSeqABC();
        printDocumentNumberStartsWith555();
        printDocumentNumberEndsWith1a2b();
    }

    private static void printTwoNumbersBlocks() {
        // Вывести на экран в одну строку два первых блока по 4 цифры.
        String result;
        result = documentNumber.substring(0, 4) + documentNumber.substring(9, 13);
        System.out.println("1. " + result);
    }

    private static void printReplacedCharactersBlocksByDocumentNumber() {
        // Вывести на экран номер документа, но блоки из трех букв
        // заменить на *** (каждая буква заменятся на *).
        String result;
        result = documentNumber.replaceAll("[a-z, A-Z]", "*");
        System.out.println("2. " + result);
    }
    // С дедушкой говорю пара мин
    private static void printOnlyCharactersByDocumentNumber() {
        // Вывести на экран только одни буквы из номера документа в формате
        // yyy/yyy/y/y в нижнем регистре.
        String result;
        result = documentNumber.replaceAll("\\W+", "");
        result = result.substring(4);
        result = result.replaceAll("\\d+", "/");
        System.out.println("3. " + result);
    }

    private static void printCharactersInUpperCase() {
        // Вывести на экран буквы из номера документа в формате "Letters:yyy/yyy/y/y"
        // в верхнем регистре(реализовать с помощью класса StringBuilder).
        StringBuilder builder = new StringBuilder();
        builder.append("Letters:");
//        for (String block : documentNumber.split("\\W")) {
//            if (block.matches(".*[a-z, A-Z]+.*")) {
//                builder.append("/");
//                builder.append(block.replaceAll("\\d", ""));
//            }
//        }
        boolean isFirst = true;
        for (String block : documentNumber.split("\\d+")) {
            if (!block.isEmpty()) {
                if (!isFirst) builder.append("/");
                isFirst = false;

                block = block.replaceAll("-", "");
                builder.append(block);
            }
        }
        System.out.println("4. " + builder);
    }

    private static void printIsDocumentNumberHasSeqABC() throws NotABCSequenceException {
        // Проверить содержит ли номер документа последовательность abc и
        // вывести сообщение содержит или нет(причем, abc и ABC считается
        // одинаковой последовательностью).
        boolean isHasSequence = documentNumber.matches(".*(abc|ABC).*");
        if (isHasSequence) {
            System.out.println("5. Да");
        } else {
            throw new NotABCSequenceException();
        }
    }

    private static void printDocumentNumberStartsWith555() throws NotStartsWith555Exception {
        // Проверить заканчивается ли номер документа на последовательность 555.
        if (documentNumber.startsWith("555")) {
            System.out.println("6. Да");
        } else {
            throw new NotStartsWith555Exception();
        }
    }

    private static void printDocumentNumberEndsWith1a2b() throws NotEndsWith1a2bException {
        // Проверить заканчивается ли номер документа на последовательность 1a2b.
        if (documentNumber.endsWith("1a2b")) {
            System.out.println("7. Да");
        } else {
            throw new NotEndsWith1a2bException();
        }
    }
}

class NotABCSequenceException extends Exception {}
class NotStartsWith555Exception extends Exception {}
class NotEndsWith1a2bException extends Exception {}
