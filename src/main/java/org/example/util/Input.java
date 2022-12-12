package org.example.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
    public static List<String> parseInputIntoStrings(String filen) {
        List<String> inputs = new ArrayList<>();
        File file = new File(filen);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                inputs.add(scanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return inputs;
        }
        return inputs;
    }
}
