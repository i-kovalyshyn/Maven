package main.java;

import java.io.File;
import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {


       File file = new File("data.txt");
        System.out.println("Song by OneRepublic - Counting Stars \n-TEXT-\n------------------------------");
        main.java.WordsCount.readTxt(file);
        System.out.println("---------------------------------------");
        main.java.WordsCount.linesArray(file);
        System.out.println("There are " + main.java.WordsCount.linesArray(file).size() + " words in you text file.");
        main.java.WordsCount.wordCounterList(main.java.WordsCount.linesArray(file));
        System.out.println("=============================================");
        main.java.WordsCount.repeatWords(main.java.WordsCount.linesArray(file));

    }

}
