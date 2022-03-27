package by.tovpenets.tasks;

/*
    Дана строка произвольной длины с произвольными словами.
    Найти самое короткое слово в строке и вывести его на экран.
    Найти самое длинное слово в строке и вывести его на экран.
    Если таких слов несколько, то вывести последнее из них.
*/


public class Task2 {

    public static void main(String[] args) {
        String input = "привет море пока как ты java core stream";
        String[] inputs = input.split(" ");

        printLongest(inputs);
        printShortest(inputs);
    }

    private static void printLongest(String[] inputs) {
        String result = "";

        int maxLength = 0;
        for (String word : inputs) {
            if (word.length() >= maxLength) {
                maxLength = word.length();
                result = word;
            }
        }

        System.out.println("Самое длинное: " + result);
    }

    private static void printShortest(String[] inputs) {
        String result = "";

        int minLength = inputs[0].length();
        for (String word : inputs) {
            if (word.length() <= minLength) {
                minLength = word.length();
                result = word;
            }
        }

        System.out.println("Самое короткое: " + result);
    }

}
