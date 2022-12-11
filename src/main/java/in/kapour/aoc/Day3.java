package in.kapour.aoc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Day3 {

    public int score() throws IOException {
        Path path = Path.of("./src/main/resources/day3.txt");
        AtomicInteger ai = new AtomicInteger();
        Files.lines(path).forEach(line -> {ai.addAndGet(getScore(line));});
        return ai.get();
    }

    public int score2() throws IOException {
        int score = 0;
        File file = new File("./src/main/resources/day3.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        String l1 = null;
        String l2 = null;
        String l3 = null;
        while(line != null){

            if(l1 == null){
                l1 = line;
            } else if (l2 == null){
                l2 = line;
            } else if (l3 == null){
                l3 = line;
                score += getScore2(l1, l2, l3);
                l1 = null;
                l2 = null;
                l3 = null;
            }

            line = br.readLine();
        }
        return score;
    }


    public int getScore2(String input1, String input2, String input3){
        Set<Character> set = input1.chars().mapToObj(i -> (char) i).collect(Collectors.toSet());
        set.retainAll(input2.chars().mapToObj(i -> (char) i).collect(Collectors.toSet()));
        set.retainAll(input3.chars().mapToObj(i -> (char) i).collect(Collectors.toSet()));
        char ans = set.iterator().next();
        return ans - 'a' < 0 ? ans - 'A' + 27 : ans - 'a' + 1;
    }
    public int getScore(String input){
        String fHalf = input.substring(0, input.length()/2);
        String sHalf = input.substring(input.length()/2, input.length());
        Set<Character> set1 = fHalf.chars().mapToObj(i -> (char) i).collect(Collectors.toSet());
        set1.retainAll(sHalf.chars().mapToObj(i -> (char) i).collect(Collectors.toSet()));
        char ans = set1.iterator().next();
        return ans - 'a' < 0 ? ans - 'A' + 27 : ans - 'a' + 1;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Day3().score());
        System.out.println(new Day3().score2());
    }
}
