package mains;

//    The Elves take turns writing down the number of Calories contained by the various meals, snacks, rations, etc. that they've brought with them, one item per line. Each Elf separates their own inventory from the previous Elf's inventory (if any) by a blank line.
//
//        For example, suppose the Elves finish writing their items' Calories and end up with the following list:
//
//        1000
//        2000
//        3000
//
//        4000
//
//        5000
//        6000
//
//        7000
//        8000
//        9000
//
//        10000
//        This list represents the Calories of the food carried by five Elves:
//
//        The first Elf is carrying food with 1000, 2000, and 3000 Calories, a total of 6000 Calories.
//        The second Elf is carrying one food item with 4000 Calories.
//        The third Elf is carrying food with 5000 and 6000 Calories, a total of 11000 Calories.
//        The fourth Elf is carrying food with 7000, 8000, and 9000 Calories, a total of 24000 Calories.
//        The fifth Elf is carrying one food item with 10000 Calories.
//        In case the Elves get hungry and need extra snacks, they need to know which Elf to ask: they'd like to know how many Calories are being carried by the Elf carrying the most Calories. In the example above, this is 24000 (carried by the fourth Elf).
//
//        Find the Elf carrying the most Calories. How many total Calories is that Elf carrying?

import java.io.File;
import java.io.FileReader;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayOne {

    public static void main(String[] args) {
        // INPUTS:
        //      text file ->
        //          blank line, representing a new elf
        //          integer, denoting how many calories are in an elf's inventory


        // Psuedo:
        //      Load file
        //      Read file line by line
        //      Identify if line is either an integer or a blank space

        try {

            Path path = Paths.get("C:\\Users\\jakeb\\OneDrive\\Documents\\CareerDevs\\cohort18\\elf_calories.txt");
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

            // Initialize variables to store data
            int elfCalories = 0;
            int snackCalories = 0;
            int elfMaxCalories = 0;

            for (String line: lines) {

                if (line.equals("")) {
//                    System.out.println("Elf total: " + elfCalories);
                    if (elfCalories > elfMaxCalories) { elfMaxCalories = elfCalories;}
                    elfCalories = 0;
                } else {
                    snackCalories = Integer.parseInt(line);
                    elfCalories += snackCalories;
                    System.out.println(snackCalories);
                    snackCalories = 0;
                }
            }

            if (elfCalories > elfMaxCalories) { elfMaxCalories = elfCalories;} // Checking the very last elf at end of file

            // Print last line elf total and total max elf calories
//            System.out.println("Elf total: " + elfCalories);
            System.out.println("Elf max calories: " + elfMaxCalories);
        } catch (Exception e) {
            System.out.println("Error: File note found. Check file path.");
        }


    }


}