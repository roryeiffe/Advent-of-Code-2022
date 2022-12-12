package org.example.day3;

import org.example.util.Input;

import java.util.*;

public class Challenge1 {

    public static HashMap<Character,Integer> priorities;

    public static void initPriorities() {
        priorities = new HashMap<>();
        char c1 = 'a';
        char c2 = 'A';
        for(int i = 0; i < 26; i ++) {
            priorities.put(c1, i+1);
            priorities.put(c2, i+27);
            c1 ++;
            c2 ++;
        }
    }

    public static Set<Character> stringToSet(String s) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i ++) {
            set.add(s.charAt(i));
        }
        return set;
    }

    public static void main(String[] args) {
        initPriorities();
        List<String> input = Input.parseInputIntoStrings("input/day-3/challenge-1/real.txt");
        int total = 0;
        for(String line: input) {
            Set<Character> first = stringToSet(line.substring(0,line.length()/2));
            Set<Character> second = stringToSet(line.substring(line.length()/2));
            for(Iterator<Character> itr = first.iterator(); itr.hasNext();) {
                char current = itr.next();
                if(second.contains(current)) {
                    System.out.println(current);
                    total += priorities.get(current);
                }
            }
        }
        System.out.println(total);
    }
}
