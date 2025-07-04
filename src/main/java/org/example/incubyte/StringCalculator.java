package org.example.incubyte;
import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";
        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf('\n');
            delimiter = numbers.substring(2, delimiterEndIndex);
            numbers = numbers.substring(delimiterEndIndex + 1);
        }

        String[] tokens = numbers.split(delimiter);
        List<Integer> negativeNumbers = new ArrayList<>();
        int sum = 0;

        for (String token : tokens) {
            if (!token.trim().isEmpty()) {
                int num = Integer.parseInt(token.trim());
                if (num < 0) {
                    negativeNumbers.add(num);
                }
                sum += num;
            }
        }

        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("negative numbers not allowed " + negativeNumbers.toString().replaceAll("[\\[\\]]", ""));
        }

        return sum;
    }
}
