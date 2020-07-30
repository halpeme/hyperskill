package readability;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String line1 = readFileAsString(args[0]);

        String[] words = line1.split("\\s+");
        String[] sentences = line1.split("[.?!]");
        int syllables = 0;
        int pollySyllables = 0;

        int characters = 0;
        for (String word : words){
            characters += word.length();
            syllables = syllables + countSyllables(word);
            if (countSyllables(word) > 2){
                pollySyllables++;
            }
        }

        int L = characters / words.length * 100;
        int S =  sentences.length / words.length * 100;

        //Automated readability index
        double ARI = 4.71 * characters/words.length + 0.5 * words.length/sentences.length -21.43;

        //Flesch–Kincaid readability tests
        double FK = 0.39 * words.length/sentences.length + 11.8 * syllables/words.length - 15.59;

        //SMOG index
        double SMOG = 1.043 * Math.sqrt(pollySyllables * 30 / sentences.length) +3.1291 ;

        // Coleman–Liau index.
        double CL = 0.0588 * L - 0.296 * S - 15.8;

        System.out.println("The text is:\n" + line1 );
        System.out.println("Words: " + words.length );
        System.out.println("Sentences: " + sentences.length);
        System.out.println("Characters: " + characters );
        System.out.println("Syllables: " + syllables);
        System.out.println("Polysyllables: " + pollySyllables);
        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");

        String scoreToCalculate = scanner.nextLine().strip();
        switch(scoreToCalculate){
            case "ARI":
                System.out.println("Automated Readability Index: " + ARI + " (about " + scoreToAge(ARI) + " year olds)."  );

            case "FK":
                System.out.println("Flesch–Kincaid readability tests: " + FK + " (about " + scoreToAge(FK) + " year olds)."  );

            case "SMOG":
                System.out.println("Simple Measure of Gobbledygook: " + SMOG + " (about " + scoreToAge(SMOG) + " year olds)."  );

            case "CL":
                System.out.println("Coleman–Liau index: " + CL + " (about " + scoreToAge(CL) + " year olds)."  );

            case "all":
                System.out.println("Automated Readability Index: " + ARI + " (about " + scoreToAge(ARI) + " year olds)."  );
                System.out.println("Flesch–Kincaid readability tests: " + FK + " (about " + scoreToAge(FK) + " year olds)."  );
                System.out.println("Simple Measure of Gobbledygook: " + SMOG + " (about " + scoreToAge(SMOG) + " year olds)."  );
                System.out.println("Coleman–Liau index: " + CL + " (about " + scoreToAge(CL) + " year olds)."  );
                System.out.println("This text should be understood in average by "+ ((ARI+FK+SMOG+CL)/4.0) +" year olds.");
        }

    }



    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }


    public static int countSyllables(String word){
        int syllables = 0;
        boolean firstSyllable = false;
        word = word.toLowerCase();
        word = word.replaceAll("[.,!?\"]", "");
        if (word.charAt(word.length()-1) == 'e'){
            word = word.substring(0, word.length()-1);
        }
        for (int i = 0; word.length() > i ; i++){
            if(word.charAt(i) == 'a'||word.charAt(i) == 'e'||word.charAt(i) == 'i'||word.charAt(i) == 'o'||word.charAt(i) == 'u'||word.charAt(i) == 'y'){
                if(firstSyllable == false){
                    syllables++;
                    firstSyllable = true;
                }
            } else {
                firstSyllable = false;
            }
        }

        return (syllables == 0) ? 1 : syllables;
    }

    public static String scoreToAge(double doubleScore) {
        int score = (int) Math.ceil(doubleScore);
        if(score<=1){
                return "5-6";
        } else if(score == 2){
            return "6-7";
        }else if(score == 3){
            return "7-9";
        }else if(score == 4){
            return "9-10";
        }else if(score == 5){
            return "10-11";
        }else if(score == 6){
            return "11-12";
        }else if(score == 7){
            return "12-13";
        }else if(score == 8){
            return "13-14";
        }else if(score == 9){
            return "14-15";
        }else if(score == 10){
            return "15-16";
        }else if(score == 11){
            return "16-17";
        }else if(score == 12){
            return "17-18";
        }else if(score >= 13){
            return "18-24";
        }

        return "24+";
    }

    }





