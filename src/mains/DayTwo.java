package mains;

//      The Elves begin to set up camp on the beach. To decide whose tent gets to be closest to the snack storage, a giant Rock Paper Scissors tournament is already in progress.
//
//        Rock Paper Scissors is a game between two players. Each game contains many rounds; in each round, the players each simultaneously choose one of Rock, Paper, or Scissors using a hand shape. Then, a winner for that round is selected: Rock defeats Scissors, Scissors defeats Paper, and Paper defeats Rock. If both players choose the same shape, the round instead ends in a draw.
//
//        Appreciative of your help yesterday, one Elf gives you an encrypted strategy guide (your puzzle input) that they say will be sure to help you win. "The first column is what your opponent is going to play: A for Rock, B for Paper, and C for Scissors. The second column--" Suddenly, the Elf is called away to help with someone's tent.
//
//        The second column, you reason, must be what you should play in response: X for Rock, Y for Paper, and Z for Scissors. Winning every time would be suspicious, so the responses must have been carefully chosen.
//
//        The winner of the whole tournament is the player with the highest score. Your total score is the sum of your scores for each round. The score for a single round is the score for the shape you selected (1 for Rock, 2 for Paper, and 3 for Scissors) plus the score for the outcome of the round (0 if you lost, 3 if the round was a draw, and 6 if you won).
//
//        Since you can't be sure if the Elf is trying to help you or trick you, you should calculate the score you would get if you were to follow the strategy guide.
//
//        For example, suppose you were given the following strategy guide:
//
//        A Y
//        B X
//        C Z
//        This strategy guide predicts and recommends the following:
//
//        In the first round, your opponent will choose Rock (A), and you should choose Paper (Y). This ends in a win for you with a score of 8 (2 because you chose Paper + 6 because you won).
//        In the second round, your opponent will choose Paper (B), and you should choose Rock (X). This ends in a loss for you with a score of 1 (1 + 0).
//        The third round is a draw with both players choosing Scissors, giving you a score of 3 + 3 = 6.
//        In this example, if you were to follow the strategy guide, you would get a total score of 15 (8 + 1 + 6).
//
//        What would your total score be if everything goes exactly according to your strategy guide?

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DayTwo {

    public static void main(String[] args) {

        // INPUTS:
        //    two columns ->
        //          left column is what the opponent has played (A, B, C)
        //          right column we guess is what should be played in response (X, Y, Z)

        // psuedo:
        //      import file
        //      read file
        //      row by row, determine what opponent chose, then what we chose
        //      utilize conversion methods to determine win/draw/loss and score

        try {

            int totalScore = 0;

            Path path = Paths.get("C:\\Users\\jakeb\\OneDrive\\Documents\\CareerDevs\\cohort18\\elf_rps.txt");
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

            for (String line : lines) {
                char myInput = line.charAt(2);

                char otherIput = line.charAt(0);

                totalScore += scoreRound(charConversion(otherIput), charConversion(myInput));
                System.out.println(totalScore);
            }
        } catch (Exception e) {
            System.out.println("Error occurred. Check inputs.");
        }

    }

    public static String charConversion(char c) {
        char c1 = c;
        String rps = "";

        if (c1 == 'A' || c1 == 'a' || c1 == 'X' || c1 == 'x') {
            rps = "Rock";
        } else if(c1 == 'B' || c1 == 'b' || c1 == 'Y' || c1 == 'y') {
            rps = "Paper";
        } else if (c1 == 'C' || c1 == 'c' || c1 == 'Z' || c1 == 'z') {
            rps = "Scissors";
        } else {
            System.out.println("Invalid character presented, check input.");
        }
        return rps;
    }

    public static int roundValue(String rps) {
        int value = 0;
        switch (rps) {
            case "Rock":
                value = 1;
                break;
            case "Paper":
                value = 2;
                break;
            case "Scissors":
                value = 3;
                break;
        }
        return value;
    }

    public static boolean isWin(String opponent, String me) {
        boolean won = false;

        // Using enhanced switch statement
        switch (opponent) {
            case "Rock" -> won = me.equals("Paper");
            case "Paper" -> won = me.equals("Scissors");
            case "Scissors" -> won = me.equals("Rock");
        }
        return won;
    }

    public static boolean isDraw(String opponent, String me) {

        return (opponent.equals(me));
    }

    public static int scoreRound(String opponent, String me) {
        int score = roundValue(me);
        if (isWin(opponent, me)) { score += 6; }
        else if (isDraw(opponent, me)) { score += 3; }
        return score;
    }
}
