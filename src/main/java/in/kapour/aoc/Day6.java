package in.kapour.aoc;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Day6 {

    public int solution1() throws IOException {
        String content = Files.readString(Path.of("./src/main/resources/day6.txt"), StandardCharsets.UTF_8);

        char[] chars = content.toCharArray();
        int i = 0;

        Set<Character> set = new HashSet<>();
        for(i = 0; i < chars.length && set.size() < 4; i++){
            set.clear();
            for(int j = i; j < i+4; j++){
                if(set.contains(chars[j])) break;
                set.add(chars[j]);
            }
        }
        return (i+3);
    }

    public int solution2() throws IOException {
        String content = Files.readString(Path.of("./src/main/resources/day6.txt"), StandardCharsets.UTF_8);

        char[] chars = content.toCharArray();
        int i = 0;

        Set<Character> set = new HashSet<>();
        for(i = 0; i < chars.length && set.size() < 14; i++){
            set.clear();
            for(int j = i; j < i+14; j++){
                if(set.contains(chars[j])) break;
                set.add(chars[j]);
            }
        }
        return (i+13);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Day6().solution1());
        System.out.println(new Day6().solution2());

    }
}
