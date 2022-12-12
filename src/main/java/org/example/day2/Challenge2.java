package org.example.day2;

import org.example.util.Input;

import java.util.List;



public class Challenge2 {
    public static void main(String[] args) {
        List<String> input = Input.parseInputIntoStrings("input/day-2/challenge-1/real.txt");
        int score = 0;
        for(String round: input) {
            char opponent = round.split(" ")[0].charAt(0);
            int scoreBoost = opponent - 64;
            char player = round.split(" ")[1].charAt(0);
            if(player == 'X') {
                score += 0;
                scoreBoost --;
                if(scoreBoost == 0) scoreBoost = 3;
            }
            if(player == 'Y') {
                score += 3;
            }
            if(player == 'Z') {
                score += 6;
                scoreBoost++;
                if(scoreBoost == 4) scoreBoost = 1;
            }
            score += scoreBoost;
            System.out.println(score);
     }
    System.out.println(score);
    }
}
