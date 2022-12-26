package mains;

//        --- Day 3: Rucksack Reorganization ---
//        One Elf has the important job of loading all of the rucksacks with supplies for the jungle journey. Unfortunately, that Elf didn't quite follow the packing instructions, and so a few items now need to be rearranged.
//
//        Each rucksack has two large compartments. All items of a given type are meant to go into exactly one of the two compartments. The Elf that did the packing failed to follow this rule for exactly one item type per rucksack.
//
//        The Elves have made a list of all of the items currently in each rucksack (your puzzle input), but they need your help finding the errors. Every item type is identified by a single lowercase or uppercase letter (that is, a and A refer to different types of items).
//
//        The list of items for each rucksack is given as characters all on a single line. A given rucksack always has the same number of items in each of its two compartments, so the first half of the characters represent items in the first compartment, while the second half of the characters represent items in the second compartment.
//
//        For example, suppose you have the following list of contents from six rucksacks:
//
//        vJrwpWtwJgWrhcsFMMfFFhFp
//        jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
//        PmmdzqPrVvPwwTWBwg
//        wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
//        ttgJtRGJQctTZtZT
//        CrZsJsPPZsGzwwsLwLmpwMDw
//        The first rucksack contains the items vJrwpWtwJgWrhcsFMMfFFhFp, which means its first compartment contains the items vJrwpWtwJgWr, while the second compartment contains the items hcsFMMfFFhFp. The only item type that appears in both compartments is lowercase p.
//        The second rucksack's compartments contain jqHRNqRjqzjGDLGL and rsFMfFZSrLrFZsSL. The only item type that appears in both compartments is uppercase L.
//        The third rucksack's compartments contain PmmdzqPrV and vPwwTWBwg; the only common item type is uppercase P.
//        The fourth rucksack's compartments only share item type v.
//        The fifth rucksack's compartments only share item type t.
//        The sixth rucksack's compartments only share item type s.
//        To help prioritize item rearrangement, every item type can be converted to a priority:
//
//        Lowercase item types a through z have priorities 1 through 26.
//        Uppercase item types A through Z have priorities 27 through 52.
//        In the above example, the priority of the item type that appears in both compartments of each rucksack is 16 (p), 38 (L), 42 (P), 22 (v), 20 (t), and 19 (s); the sum of these is 157.
//
//        Find the item type that appears in both compartments of each rucksack. What is the sum of the priorities of those item types?

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DayThree {

    public static void main(String[] args) {

        // INPUTS:
        //      String, built from two different compartments
        //      Each char in compartment strings are a different item
        //      Rucksack string will always be an even number length, split evenly down the middle to denote the separation of compartments

        // psuedo:
        //      Get File
        //      Read file line by line
        //      Method to separate the two compartments of the rucksack string
        //      Method to identify items that both compartments contain
        //      Certain items are prioritized over others, will need a method to determine this
        //      Sum priority of all matching items, output sum



        try {
            Path path = Paths.get("C:\\Users\\jakeb\\OneDrive\\Documents\\CareerDevs\\cohort18\\elf_rucksacks.txt");
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

            // Initialize sum variable
            int total = 0;

            // Iterate through lines in file
            for (String line: lines) {

                // get compartments of rucksack
                String left = getLeftCompartment(line);
                String right = getRightCompartment(line);
                // get same item between compartments
                char item = getSameItem(left, right);
                // get item value, add to total variable
                total += getItemPriority(item);

                System.out.println(total);
            }
        } catch (Exception e) {
            System.out.println("Error occurred. Troubleshoot.");
        }

    }

    public static String getLeftCompartment(String rucksack) {
        int totalSack = rucksack.length();

        return rucksack.substring(0, totalSack/2);
    }

    public static String getRightCompartment(String rucksack) {
        int totalSack = rucksack.length();

        return rucksack.substring(totalSack/2, totalSack);
    }

    public static char getSameItem(String leftCompartment, String rightCompartment) {
        // Initialize return variable
        char errorGift = ' ';

        // iterate through each compartment, comparing indexes to check for sameness
        for (int i = 0; i < leftCompartment.length(); i++) {
            for (int j = 0; j < rightCompartment.length(); j++) {
                if (rightCompartment.charAt(j) == leftCompartment.charAt(i)) {
                    errorGift = leftCompartment.charAt(i);
                    // once same char is found, break from loop
                    break;
                }
            }
        }
        return errorGift;
    }

    public static int getItemPriority(char item) {
        // Cast char to an int in order to get decimal value of char
        int itemValue = (int) item;

        // Need to perform different arithmetic operations if character is upper or lower case
        if(Character.isLowerCase(item)) {
            itemValue -= 96;
        } else {
            itemValue -= 38;
        }

        return itemValue;
    }
}
