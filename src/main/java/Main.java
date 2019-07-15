package main.java;

import java.io.File;
import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {


       File file = new File("data.txt");
        System.out.println("Song by OneRepublic - Counting Stars \n-TEXT-\n------------------------------");
        WordsCount.readTxt(file);
        System.out.println("---------------------------------------");
        WordsCount.linesArray(file);
        System.out.println("There are " + WordsCount.linesArray(file).size() + " words in you text file.");
        WordsCount.wordCounterList(WordsCount.linesArray(file));
        System.out.println("=============================================");
        WordsCount.repeatWords(WordsCount.linesArray(file));

    }

}
