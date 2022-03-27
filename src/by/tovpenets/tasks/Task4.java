package by.tovpenets.tasks;

/*
    Дана строка произвольной длины с произвольными словами.
    Написать программу для проверки является ли любое выбранное слово в строке палиндромом.
*/

public class Task4 {

    public static void main(String[] args) {
        String input = "балл кабан казак";

        String[] inputs = input.split(" ");
        for (String word : inputs) {
            StringBuilder bufferedWord = new StringBuilder(word);
            if (word.equals(bufferedWord.reverse().toString())) {
                System.out.printf("Слово %s является палиндромом", word);
                break;
            }
        }
    }

}
