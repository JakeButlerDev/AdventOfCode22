package mains.dayFour;

//        --- Day 4: Camp Cleanup ---
//        Space needs to be cleared before the last supplies can be unloaded from the ships, and so several Elves have been assigned the job of cleaning up sections of the camp. Every section has a unique ID number, and each Elf is assigned a range of section IDs.
//
//        However, as some of the Elves compare their section assignments with each other, they've noticed that many of the assignments overlap. To try to quickly find overlaps and reduce duplicated effort, the Elves pair up and make a big list of the section assignments for each pair (your puzzle input).
//
//        For example, consider the following list of section assignment pairs:
//
//        2-4,6-8
//        2-3,4-5
//        5-7,7-9
//        2-8,3-7
//        6-6,4-6
//        2-6,4-8
//        For the first few pairs, this list means:
//
//        Within the first pair of Elves, the first Elf was assigned sections 2-4 (sections 2, 3, and 4), while the second Elf was assigned sections 6-8 (sections 6, 7, 8).
//        The Elves in the second pair were each assigned two sections.
//        The Elves in the third pair were each assigned three sections: one got sections 5, 6, and 7, while the other also got 7, plus 8 and 9.
//        This example list uses single-digit section IDs to make it easier to draw; your actual list might contain larger numbers. Visually, these pairs of section assignments look like this:
//
//        .234.....  2-4
//        .....678.  6-8
//
//        .23......  2-3
//        ...45....  4-5
//
//        ....567..  5-7
//        ......789  7-9
//
//        .2345678.  2-8
//        ..34567..  3-7
//
//        .....6...  6-6
//        ...456...  4-6
//
//        .23456...  2-6
//        ...45678.  4-8
//        Some of the pairs have noticed that one of their assignments fully contains the other. For example, 2-8 fully contains 3-7, and 6-6 is fully contained by 4-6. In pairs where one assignment fully contains the other, one Elf in the pair would be exclusively cleaning sections their partner will already be cleaning, so these seem like the most in need of reconsideration. In this example, there are 2 such pairs.
//
//        In how many assignment pairs does one range fully contain the other?


import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.List;

public class DayFour {

    public static void main(String[] args) {

        // INPUTS:
        // two ranges, two different elves separated by a comma
        // multiple lines of two elves

        // pusedo:
        //      Load file
        //      read file line by line
        //      parse strings to find start int and end int, use method for this
        //      check if one range is within another, different method
        //      sum total of instances where above method returns true


        try {

            // Read file, get all lines in file
//            Path path = Paths.get("C:\\Users\\jakeb\\OneDrive\\Documents\\CareerDevs\\cohort18\\elf_ranges.txt");
//            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

            // Iterate line by line through file
//            for (String line: lines) {

//                char[] lineCharArr = line.toCharArray();
                // One range for each elf
//                int elfOneStart =
//                ValueRange elfOneRange = ValueRange.of(lineCharArr[0], lineCharArr[2]);
//                ValueRange elfTwoRange = ValueRange.of(lineCharArr[4], lineCharArr[6]);

//                if ( start && end are in range of elfTwo)
//            }

            String elf = "2-4,6-8";
//            System.out.println(elf);
//            List<Range> output = parseRanges(elf);
//            System.out.println(output);
        } catch (Exception e) {
            System.out.println("Fatal error occurred. Log to console for troubleshooting.");
        }


    }

    public static List<Range> parseRanges(String elfString) {
        String[] elves = elfString.split(",");
        String elfOneStr = elves[0];
        String elfTwoStr = elves[1];
        List<Range> elfRanges = new ArrayList<>();

        String[] elfOneArr = elfOneStr.split("-");
        int elfOneStart = Integer.parseInt(elfOneArr[0]);
        int elfOneEnd = Integer.parseInt(elfOneArr[1]);
        Range elfOne = new Range(elfOneStart, elfOneEnd);
        elfRanges.add(elfOne);

        String[] elfTwoArr = elfTwoStr.split("");
        int elfTwoStart = Integer.parseInt(elfTwoArr[0]);
        int elfTwoEnd = Integer.parseInt(elfTwoArr[1]);
        Range elfTwo = new Range(elfTwoStart, elfTwoEnd);
        elfRanges.add(elfTwo);
        return elfRanges;
    }

}
