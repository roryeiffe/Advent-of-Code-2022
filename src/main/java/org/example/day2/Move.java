package org.example.day2;

public class Move {
    String move;
    int points;

    public Move(String move) {
        if(move.equals("A") || move.equals("X")) {
            points = 1;
            this.move = "rock";
        }
        else if(move.equals("B") || move.equals("Y")) {
            points = 2;
            this.move = "paper";
        }
        else if(move.equals("C") || move.equals("Z")) {
            points = 3;
            this.move = "scissors";
        }
        else {
            System.out.println("Something went wrong!!!");
        }

    }

    public int beats(Move move) {
        if ((this.move.equals("rock") && move.move.equals("scissors")) || (this.move.equals("paper") && move.move.equals("rock")) ||(this.move.equals("scissors") && move.move.equals("paper"))) return 6;
        else if (this.move.equals(move.move)) return 3;
        else return 0;
    }
}
