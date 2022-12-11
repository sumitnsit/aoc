package in.kapour.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Day4 {

    public int solution1() throws IOException {
        AtomicInteger ai = new AtomicInteger(0);
        Files.lines(Path.of("./src/main/resources/day4.txt")).forEach(line -> {
            int[] nums = Arrays.stream(line.split("[,-]")).mapToInt(Integer::parseInt).toArray();
            if((nums[0] <= nums[2] && nums[3] <= nums[1]) || (nums[0] >= nums[2] && nums[3] >= nums[1])) ai.incrementAndGet();
        });

        return ai.get();
    }

    public int solution2() throws IOException {
        AtomicInteger ai = new AtomicInteger(0);
        Files.lines(Path.of("./src/main/resources/day4.txt")).forEach(line -> {
            int[] nums = Arrays.stream(line.split("[,-]")).mapToInt(Integer::parseInt).toArray();
            if((nums[0] <= nums[2] && nums[2] <= nums[1]) || (nums[2] <= nums[0] && nums[0] <= nums[3])) ai.incrementAndGet();
        });

        return ai.get();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Day4().solution1());
        System.out.println(new Day4().solution2());
    }
}
