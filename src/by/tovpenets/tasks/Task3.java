package by.tovpenets.tasks;

/*
    Дана строка произвольной длины с произвольными словами.
    Найти слово, в котором число различных символов минимально.
    Слово может содержать буквы и цифры.
    Если таких слов несколько, найти первое из них.
    Например, в строке "fffff ab f 1234 jkjk" найденное слово должно быть "fffff".
*/


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Task3 {

    public static void main(String[] args) {

        String input = "fffff ab f 1234 jkjk";
        String[] inputs = input.split(" ");

        Map<String, Integer> rowsAndCounter = new LinkedHashMap<>();
        Map<Character, Integer> charsAndCounter = new HashMap<>();

        for (String word : inputs) {
            int bufferCount;
            charsAndCounter.clear();
            for (Character symbol : word.toCharArray()) {
                if (charsAndCounter.containsKey(symbol)) {
                    bufferCount = charsAndCounter.get(symbol);
                    charsAndCounter.put(symbol, bufferCount + 1);
                } else {
                    charsAndCounter.put(symbol, 1);
                }
            }
            rowsAndCounter.put(word, charsAndCounter.size());
        }

        String result = "";
        int minCount = 0;
        boolean isFirst = true;
        for (Map.Entry<String, Integer> entry : rowsAndCounter.entrySet()) {
            if (isFirst) {
                minCount = entry.getValue();
                result = entry.getKey();
            } else {
                if (entry.getValue() < minCount) {
                    minCount = entry.getValue();
                    result = entry.getKey();
                }
            }

            isFirst = false;
        }

        System.out.println("Результат: " + result);
    }

}
