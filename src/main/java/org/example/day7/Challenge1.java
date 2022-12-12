package org.example.day7;

import org.example.util.Input;

import java.util.*;

public class Challenge1 {
    public static void main(String[] args) {
        Map<String, Integer> sizes = new HashMap<>();
        List<String> input = Input.parseInputIntoStrings("input/day-7/test1.txt");

        Stack<String> directories = new Stack<>();
        for(String line: input) {
            String[] instructions = line.split(" ");
            if(instructions[0].equals("$") && instructions[1].equals("cd")) {
                // if we're going up a level, pop a directory:
                if(instructions[2].equals("..")) {
                    directories.pop();
                }
                // otherwise, push this new directory:
                else directories.push(instructions[2]);
            }
            else if (isNumeric(instructions[0])) {
                int size = Integer.parseInt(instructions[0]);
                // add size to all directories in the stack:
                for(Iterator<String> itr = directories.iterator(); itr.hasNext();){
                    String dir = itr.next();
                    // add to directoy if already initialized
                    if(sizes.containsKey(dir)) sizes.put(dir, sizes.get(dir) + size);
                    // otherwise, initialize:
                    else sizes.put(dir, size);
                }
            }
        }
        long sum = 0l;
        for(String key:sizes.keySet()) {
            int value = sizes.get(key);
            if(value <= 100000) sum += value;
        }
        System.out.println(sum);
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

}


/*
1504273 too low
 */