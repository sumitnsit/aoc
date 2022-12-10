package in.kapour.aoc;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;

public class Day1 {

    public int solution1() throws IOException {
        String content = Files.readString(Path.of("./src/main/resources/day1.txt"), StandardCharsets.UTF_8);
        return  Arrays.stream(content.split("\n\n"))
                .mapToInt(block -> Arrays.stream(block.split("\n")).mapToInt(Integer::parseInt).sum())
                .max()
                .getAsInt();
    }

    public int solution2() throws IOException {
        String content = Files.readString(Path.of("./src/main/resources/day1.txt"), StandardCharsets.UTF_8);
        return Arrays.stream(content.split("\n\n"))
                .map(block -> Arrays.stream(block.split("\n")).mapToInt(Integer::parseInt).sum())
                .sorted(Collections.reverseOrder())
                .limit(3)
                .mapToInt(i -> i)
                .sum();
    }


    public static void main(String[] args) throws IOException {
        Day1 d1 = new Day1();
        System.out.println(d1.solution1());
        System.out.println(d1.solution2());
    }
}
