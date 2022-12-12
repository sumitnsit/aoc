package in.kapour.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Day5 {

    public String solution2() throws IOException {
        List<ArrayDeque<String>> lists = new ArrayList<>();

        IntStream.rangeClosed(0, 8).forEach(e -> {
            lists.add(e, new ArrayDeque<>());
        });

        Files.lines(Path.of("./src/main/resources/day5.txt")).forEach(line -> {
                    if (!line.startsWith("move")) {
                        AtomicInteger ai = new AtomicInteger(-1);
                        Arrays.stream(line.split("(?<=\\G.{4})")).map(word -> word.replaceAll("[\\[\\] ]", "")).forEach(
                                word -> {
                                    ai.incrementAndGet();
                                    if (!word.equals("")) lists.get(ai.get()).add(word);
                                }
                        );
                        return;
                    }
                    String[] str = line.split(" ");
                    int count = Integer.parseInt(str[1]);
                    int from = Integer.parseInt(str[3]) - 1;
                    int to = Integer.parseInt(str[5]) - 1;
                    ArrayDeque<String> fromQ = lists.get(from);
                    ArrayDeque<String> toQ = lists.get(to);

                    Stack<String> stack = new Stack<>();
                    IntStream.rangeClosed(1, count).forEach(e -> {
                        stack.push(fromQ.removeFirst());
                    });

                    IntStream.rangeClosed(1, count).forEach(e -> {
                        toQ.addFirst(stack.pop());
                    });
                }
        );

        StringBuffer sb = new StringBuffer();

        IntStream.rangeClosed(0, 8).forEach(e -> {
            sb.append(lists.get(e).getFirst());
        });
        return sb.toString();
    }
    public String solution1() throws IOException {
        List<ArrayDeque<String>> lists = new ArrayList<>();

        IntStream.rangeClosed(0, 8).forEach(e -> {
            lists.add(e, new ArrayDeque<>());
        });

        Files.lines(Path.of("./src/main/resources/day5.txt")).forEach(line -> {
                    if (!line.startsWith("move")) {
                        AtomicInteger ai = new AtomicInteger(-1);
                        Arrays.stream(line.split("(?<=\\G.{4})")).map(word -> word.replaceAll("[\\[\\] ]", "")).forEach(
                                word -> {
                                    ai.incrementAndGet();
                                    if (!word.equals("")) lists.get(ai.get()).add(word);
                                }
                        );
                        return;
                    }
                    String[] str = line.split(" ");
                    int count = Integer.parseInt(str[1]);
                    int from = Integer.parseInt(str[3]) - 1;
                    int to = Integer.parseInt(str[5]) - 1;
                    ArrayDeque<String> fromQ = lists.get(from);
                    ArrayDeque<String> toQ = lists.get(to);


                    IntStream.rangeClosed(1, count).forEach(e -> {
                        toQ.addFirst(fromQ.removeFirst());
                    });
                }
        );

        StringBuffer sb = new StringBuffer();

        IntStream.rangeClosed(0, 8).forEach(e -> {
            sb.append(lists.get(e).getFirst());
        });
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {

        System.out.println(new Day5().solution1());
        System.out.println(new Day5().solution2());
    }
}
