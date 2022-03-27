package by.tovpenets.tasks;

/*
    Дана произвольная строка.
    Вывести на консоль новую строку,
        которой задублирована каждая буква из начальной строки.
    Например, "Hello" -> "HHeelllloo".
*/

public class Task5 {

    public static void main(String[] args) {
        String input = "fffff ab f 1234 jkjk";
        StringBuilder result = new StringBuilder(input.length() * 2);
        for (char symbol : input.toCharArray())
            result.append(symbol).append(symbol);

        System.out.println("Результат: " + result);
    }

}
