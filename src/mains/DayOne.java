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

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class DayOne {

    public static void main(String[] args) {
        // JSON object of Elf data
        // attribute unskipped lines as same Elf, skipped lines start a new Elf
        // want to find the Elf holding the most calories

        // PSEUDO
        // Read data
        // Initiate max_value at 0
        // sum individual Elves' total calories held
        // while summing, if current Elf's calories is greater than max_value, overwrite max
        // Print out max calories held and which number Elf for fun

//        try {
//            int max_Calories = 0;
//            String line;
//            int doubleLineBreak = 0;
//            int currentElfValue = 0;
//            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\jakeb\\OneDrive\\Documents\\CareerDevs\\cohort18\\elf_calories.txt"));
//            while (doubleLineBreak < 2) {
//
//                if (!reader.readLine().equals("")){
//                    int currentLineVal = Integer.parseInt(reader.readLine().trim());
//                    currentElfValue += currentLineVal;
//                    if (reader.lines())
//                }
//            }
//
//
//            reader.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }


}