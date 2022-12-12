package org.example.day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Challenge2 {
    public static void main(String[] args) throws FileNotFoundException {
        String test1 = "mjqjpqmgbljsphdztnvjfqwrcgsmlb";
        String test2 = "bvwbjplbgvbhsrlpgdmjqwftvncz";
        String test3 = "nppdvjthqldpwncqszvftbrmjlhg";
        String test4 = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg";
        String test5 = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw";
        String real = new Scanner(new File("input/day-6/real.txt")).nextLine();

        System.out.println(solve(test1));
        System.out.println(solve(test2));
        System.out.println(solve(test3));
        System.out.println(solve(test4));
        System.out.println(solve(test5));
        System.out.println(solve(real));




    }

    public static int solve (String s) {
        for(int i = 14; i < s.length(); i ++) {
            Set<Character> characterSet = new HashSet<>();
            for(int j = i-14; j < i; j ++) {
                characterSet.add(s.charAt(j));
            }
            if (characterSet.size() == 14) return i;
        }
        return -1;
    }
}
