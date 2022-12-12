package org.example.day2;

import org.example.util.Input;

import java.util.List;



public class Challenge1 {
    public static void main(String[] args) {
        List<String> input = Input.parseInputIntoStrings("input/day-2/challenge-1/real.txt");
        int score = 0;
        for(String round: input) {
            String opponent = round.split(" ")[0];
            String player = round.split(" ")[1];
            Move playerMove = new Move(player);
            Move opponentMove = new Move(opponent);
            score += playerMove.beats(opponentMove) + playerMove.points;
        }
        System.out.println(score);
    }
}
