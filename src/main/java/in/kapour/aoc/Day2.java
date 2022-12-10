package in.kapour.aoc;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day2 {

    public int solution1() throws IOException {
        String content = Files.readString(Path.of("./src/main/resources/day2.txt"), StandardCharsets.UTF_8);
        return Arrays.stream(content.split("\n")).mapToInt(pairs -> getScore(pairs.charAt(0), pairs.charAt(2))).sum();
    }

    public int solution2() throws IOException {
        String content = Files.readString(Path.of("./src/main/resources/day2.txt"), StandardCharsets.UTF_8);
        return Arrays.stream(content.split("\n")).mapToInt(pairs -> getScore2(pairs.charAt(0), pairs.charAt(2))).sum();
    }


    public int solution3() throws IOException {
        String content = Files.readString(Path.of("./src/main/resources/day2.txt"), StandardCharsets.UTF_8);
        Map<String, Integer> map = new HashMap<>();
        map.put("A X", 4);
        map.put("B Y", 5);
        map.put("C Z", 6);
        map.put("A Y", 8);
        map.put("B Z", 9);
        map.put("C X", 7);
        map.put("A Z", 3);
        map.put("B X", 1);
        map.put("C Y", 2);
        return Arrays.stream(content.split("\n")).mapToInt(map::get).sum();
    }

    public int solution4() throws IOException {
        String content = Files.readString(Path.of("./src/main/resources/day2.txt"), StandardCharsets.UTF_8);
        Map<String, Integer> map = new HashMap<>();
        map.put("A X", 3);
        map.put("B Y", 5);
        map.put("C Z", 7);
        map.put("A Y", 4);
        map.put("B Z", 9);
        map.put("C X", 2);
        map.put("A Z", 8);
        map.put("B X", 1);
        map.put("C Y", 6);
        return Arrays.stream(content.split("\n")).mapToInt(map::get).sum();
    }

    private int getScore2(char a, char b) {
        int val1 = a - 'A';

        if(b == 'Y') return val1 + 4;

        if(b == 'Z'){
            if(val1 == 0) return 8;
            if(val1 == 1) return 9;
            if(val1 == 2) return 7;
        }
        if(val1 == 0) return 3;
        return val1;
    }

    private int getScore(char a, char b){
        int val1 = a - 'A';
        int val2 = b - 'X';
        if(val1 == val2){
            return val2 + 4;
        } else if( val1 == 0 && val2 == 1 || val1 == 1 && val2 == 2 || val1 == 2 && val2 == 0){
            return val2 + 7;
        } else {
            return val2 + 1;
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Day2().solution1());
        System.out.println(new Day2().solution2());
        System.out.println(new Day2().solution3());
        System.out.println(new Day2().solution4());
    }
}
