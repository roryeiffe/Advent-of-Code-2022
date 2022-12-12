package org.example.day5;

import org.example.util.Input;

import java.util.List;
import java.util.Stack;

public class Challenge1 {
    public static void main(String[] args) {
        List<String> input = Input.parseInputIntoStrings("input/day-5/challenge-1/real.txt");
        // figure out the height of the tallest stack (initially):
        int height = 0;
        for(String line: input) {
            System.out.println(line);
            if(line.equals("")) break;
            height ++;
        }
        height -= 1;

        int length = input.get(height).split("   ").length;

        // create the crates as an array of stacks:
        Stack<Character>[] crates = new Stack[length];
        for(int i = 0; i < length; i ++) {
            crates[i] = new Stack<>();
            char current;
            for(int j = height - 1; j >= 0; j --) {
                try {
                    current = input.get(j).charAt(i + 1 + (i * 3));
                } catch(StringIndexOutOfBoundsException e) {
                    continue;
                }
                if(current != ' ') {
                    crates[i].push(current);
                }
            }
        }

        // make sure input is parsed correctly:
        for(int i = 0; i < length; i ++) {
            System.out.println(crates[i]);
        }

        // perform the instructions:
        for(int i = height+2; i < input.size(); i ++) {
            String[] instructions = input.get(i).split(" ");
            int quantity = Integer.parseInt(instructions[1]);
            int source = Integer.parseInt(instructions[3]) - 1;
            int dest = Integer.parseInt(instructions[5]) - 1;
            for(int j = 0; j < quantity; j ++) {
                crates[dest].push(crates[source].pop());
            }
        }

        // make sure crates are good at the end:
        for(int i = 0; i < length; i ++) {
            System.out.println(crates[i]);
        }

        // finally, get the final answer:
        String result = "";
        for(int i = 0; i < length; i ++) {
            result += crates[i].peek();
        }
        System.out.println(result);
    }
}
