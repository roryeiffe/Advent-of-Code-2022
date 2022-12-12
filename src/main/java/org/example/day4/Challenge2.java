package org.example.day4;

import org.example.util.Input;

import java.util.List;

public class Challenge2 {
    public static void main(String[] args) {
        List<String> input = Input.parseInputIntoStrings("input/day-4/challenge-1/real.txt");
        int num = 0;
        for(String line: input) {
            String elf1 = line.split(",")[0];
            String elf2 = line.split(",")[1];
            int elf1Start = Integer.parseInt(elf1.split("-")[0]);
            int elf1End = Integer.parseInt(elf1.split("-")[1]);
            int elf2Start = Integer.parseInt(elf2.split("-")[0]);
            int elf2End = Integer.parseInt(elf2.split("-")[1]);
            if(elf1Start >= elf2Start && elf1Start <= elf2End) num++;
            else if(elf1End >= elf2Start && elf1End <= elf2End) num++;
            else if(elf2Start >= elf1Start && elf2Start <= elf1End) num++;
            else if(elf2End >= elf1Start && elf2End <= elf1End) num++;
        }
        System.out.println(num);
    }
}
