import java.util.*;
import java.lang.*;

public class Tool {

    public static int getFactorial(int fakultaet){
        int result = 1;
        for(int i = 1; i <= fakultaet; i++){
            result = result * i;
        }
        return result;
    }
    // Die Funktion soll später dazu dienen den Schlüssel auszugeben
    public static void GetKey(String[] arr, String[] arr1, List<LetterCounter> lettercounters, int i) {
        for (LetterCounter a : lettercounters) {
            if (i < 26) {
                arr1[i] = a.getLetter();
                System.out.println(a.getLetter() + " = " + arr[i]);
                i++;
            }
        }
    }
    // Die Funktion zählt die Anzahl jedes Buchstaben in eimem Text
    public static void countLetters(List<LetterCounter> list, String chiffrat) {
        for (String readLetter : chiffrat.split("")) {
            for (LetterCounter letter : list) {
                if (letter.getLetter().equals(readLetter)) {
                    letter.increaseCount();
                }
            }
        }
    }
    // Die Funktion tauscht die Buchstaben in einem Text
    public static void changeLetter(int howMany,List<LetterCounter> list, String[] sortedLetters, String[] englishLetterFrequency, String chiffrat, StringBuilder buildChiffrat) {
        for (String readLetter : chiffrat.split("")) {
            if(readLetter.equals(" ")) {
                buildChiffrat.append(readLetter);
            }
            for (LetterCounter letter : list) {
                if (letter.getLetter().equals(readLetter)) {
                    int getIndex = Arrays.asList(sortedLetters).indexOf(readLetter);
                    if(getIndex <= howMany) {
                        String newLetter = readLetter.replace(readLetter, englishLetterFrequency[Math.abs(getIndex)]);
                        buildChiffrat.append(newLetter);
                    }
                    else{
                        buildChiffrat.append(readLetter);
                    }
                }
            }
        }
    }

    public static List<String> getFirstFourLetters(List<String> sortedLetterList) {
        List<String> firstFourLettersList = new ArrayList<>();
        // Die ersten 3 Buchstaben der SortedLetterList sollen entfernt werden
        for (String a : sortedLetterList) {
            if (sortedLetterList.size() > 23) {
                sortedLetterList.remove(a);
            }
        }
        for (String letter : sortedLetterList) {
            if (sortedLetterList.size() == 4) {
                return firstFourLettersList;
            } else {
                firstFourLettersList.add(letter);
            }
        }
        return firstFourLettersList;
    }
    public static void convertLetterCounterListToStringList(List<LetterCounter> letterCounterlist, List<String> stringList) {
        for (LetterCounter a : letterCounterlist) {
            stringList.add(a.getLetter());
        }
    }
    public static void convertStringToList(List<String> list, String mostFrequentWordsEnglish){
        for(String str : mostFrequentWordsEnglish.split(" ")){
            list.add(str);
        }
    }
    public static String findWayWithMostRecognizedWords(String[] verschlüsselteBuchstaben,int anzahlBuchstaben, String chiffrat, List<String> mostFrequentWordsEnglish, String[] englishLetterFrequency,String[] sortedLetters,List<LetterCounter> letterCounterList,StringBuilder buildChiffrat){
        for(int i = 0; i < Tool.getFactorial(anzahlBuchstaben);i++){
            if(anzahlBuchstaben == 3){
                if(i%2==0){
                    String temp = verschlüsselteBuchstaben[3];
                    verschlüsselteBuchstaben[3] = verschlüsselteBuchstaben[2];
                    verschlüsselteBuchstaben[2] = temp;
                }
                if(i%2==1){
                    String temp = verschlüsselteBuchstaben[2];
                    verschlüsselteBuchstaben[2] = verschlüsselteBuchstaben[1];
                    verschlüsselteBuchstaben[1] = temp;
                }
            }
            if(anzahlBuchstaben == 4){
                if(i%2==0){
                    String temp = verschlüsselteBuchstaben[3];
                    verschlüsselteBuchstaben[3] = verschlüsselteBuchstaben[4];
                    verschlüsselteBuchstaben[4] = temp;
                }
                if(i%2==1){
                    String temp = verschlüsselteBuchstaben[2];
                    verschlüsselteBuchstaben[2] = verschlüsselteBuchstaben[3];
                    verschlüsselteBuchstaben[3] = temp;
                }
                if(i%6==0){
                    String temp = verschlüsselteBuchstaben[1];
                    verschlüsselteBuchstaben[1] = verschlüsselteBuchstaben[2];
                    verschlüsselteBuchstaben[2] = temp;
                }
            }
            changeLetter(anzahlBuchstaben,letterCounterList, sortedLetters,englishLetterFrequency,chiffrat,buildChiffrat);
        }
        return chiffrat;
    }
/*
    public static void findKey(Node actuell, List<String> sortedLettersList,List<LetterCounter> letterCounterList) {
        // Abbruchbedingung
        if (sortedLettersList.isEmpty()) return;
        if (sortedLettersList.size() < 4) {
            Node knoten = actuell.addNode(sortedLettersList.get(0), "s");
            knoten = knoten.addNode(sortedLettersList.get(1), "u");
            knoten = knoten.addNode(sortedLettersList.get(2), "x");
        }
        List<String> firstFourLettersList = Tool.getFirstFourLetters(sortedLettersList);
        for (LetterCounter letterCounter : letterCounterList) {
            for (String letter : firstFourLettersList) {
                Node nextNode = actuell.addNode(letter, letterCounter.getLetter());
                List<LetterCounter> newLetterCounterList = new ArrayList<>(letterCounterList);
                List<String> nextSortedLetters = new ArrayList<>(sortedLettersList);
                nextSortedLetters.remove(letter);
                // Rekursion
                findKey(nextNode, nextSortedLetters, newLetterCounterList);
            }
        }
    }
    */
}

