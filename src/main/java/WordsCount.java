package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.util.stream.Collectors.toMap;

class WordsCount {

    static void readTxt(File file) throws FileNotFoundException {
        Scanner read = new Scanner(file);
        while (read.hasNext()) {
            String line = read.nextLine();
            System.out.println(line);
        }
        read.close();
    }

    static List<String> linesArray(File file) throws FileNotFoundException {
        Scanner read = new Scanner(file);
        List<String> lines = new ArrayList<>();
        while (read.hasNext()) {
            String word = read.next();
            lines.addAll(Arrays.asList(word.split("\\s*,\\s*")));
        }
        read.close();
        return lines;
    }
    static void wordCounterList(List<String> lines) {
        List<String> smallWords = new ArrayList<>();
        for (String words : lines) {
            long leterCounter = words.chars().filter(Character::isLetter).count();
            if (leterCounter < 3) {
                smallWords.add(words);
            }
        }
        int wordsException = lines.size() - smallWords.size();
        System.out.println("There are " + smallWords.size() + " words less than 3 char;");
        System.out.println("So we have " + wordsException + " words after exception.");
        System.out.println("List with words < 3 letters is: ");
        System.out.println(smallWords);
    }

    static void repeatWords(List<String> lines) {
        Map<String, Integer> dublicat = new HashMap<>();
        List<String> unique = new ArrayList<>(lines);
        for (String key : unique) {
            dublicat.put(key, Collections.frequency(lines, key));
        }
        LinkedHashMap<String, Integer> result = dublicat
                .entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).
                        collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        Iterator iterator = result.entrySet().iterator();
        for (int i = 0; i <= 4; i++) {
            Map.Entry pair = (Map.Entry) iterator.next();
            System.out.println("the word- "+pair.getKey() + " -repeat " + pair.getValue()+" times");
        }
    }
}
