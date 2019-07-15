package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.util.stream.Collectors.toMap;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("data.txt");
        Scanner read = new Scanner(file);
        List<String> lines = new ArrayList<>();

        System.out.println("Song by OneRepublic - Counting Stars \n    TEXT\n");
//        while (read.hasNext()) {
//            String line = read.nextLine();
//            System.out.println(line);
//        }
        System.out.println("-----------------");
        while (read.hasNext()) {
            String word = read.next();
            lines.addAll(Arrays.asList(word.split("\\s*,\\s*")));
        }

        System.out.println("There are " + lines.size() + " words in you text file.");

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
        System.out.println(smallWords);
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
            System.out.println(pair.getKey() + " repeat " + pair.getValue());
        }

//        Map<String, Integer> map = countWords(dublicat);
//        for(Map.Entry<String, Integer>pair:map.entrySet()){
//            System.out.println(pair.getKey()+" " +pair.getValue());
//        }
//        public static Map<String, Integer> countWords (ArrayList<String> list){
//            HashMap<String, Integer> result-new HashMap<>():
//        for(String word:list){
//            String word:list){
//        }

        read.close();
    }


}
