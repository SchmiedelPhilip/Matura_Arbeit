import java.util.*;
import java.lang.*;

public class Tool {
    // Die Funktion rechnet Fakultät einer Zahl aus
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
    // Die Funktion zählt die Wörter in einem Text
    public static void countWords(List<WordCounter> wordCounterList, String chiffrat){
        for(String readWord : chiffrat.split(" ")) {
            for(WordCounter word : wordCounterList) {
                if(readWord.equals(word.getWord())) {
                    word.increaseCount();
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
    // Die Funktion nimmt die ersten 4 Buchstaben einer Liste
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
    // Die Funktion macht aus einer List<LetterCounter> eine List<String>
    public static void convertLetterCounterListToStringList(List<LetterCounter> letterCounterlist, List<String> stringList) {
        for (LetterCounter a : letterCounterlist) {
            stringList.add(a.getLetter());
        }
    }
    // Die Funktion macht aus einem String eine Liste
    public static void convertStringToList(List<String> list, String mostFrequentWordsEnglish){
        for(String str : mostFrequentWordsEnglish.split(" ")){
            list.add(str);
        }
    }
    // Die Funktion tauscht die Werte von 2 Arrayplätzen
    public static void swapTwoPlaces(int placeOne,int placeTwo,String[] arr){
        String temp = arr[placeOne];
        arr[placeOne] = arr[placeTwo];
        arr[placeTwo] = temp;
    }

    public static void findWayWithMostRecognizedWords(String[] entschlüsselteBuchstaben,int anzahlBuchstaben, String chiffrat, List<String> mostFrequentWordsEnglish, String[] englishLetterFrequency,String[] sortedLetters,List<LetterCounter> letterCounterList,List<WordCounter> wordCounterList, StringBuilder buildChiffrat, String[] verschlüsselteBuchstaben){
        for(int i = 0; i < Tool.getFactorial(anzahlBuchstaben);i+=1){
            for(String a : entschlüsselteBuchstaben) {
                System.out.print(a+" ");
            }
            System.out.println();
            if(anzahlBuchstaben == 3){
                if(i%2==0){
                    Tool.swapTwoPlaces(1,2,entschlüsselteBuchstaben);
                }
                if(i%2==1){
                    Tool.swapTwoPlaces(0,1,entschlüsselteBuchstaben);
                }
            }
            if(anzahlBuchstaben == 4){
                if(i%2==0){
                    Tool.swapTwoPlaces(2,3,entschlüsselteBuchstaben);
                }
                if(i%2==1 && i%6 != 5){
                    Tool.swapTwoPlaces(1,2,entschlüsselteBuchstaben);
                }
                if(i%6==5){
                    Tool.swapTwoPlaces(0,1,entschlüsselteBuchstaben);
                    Tool.swapTwoPlaces(2,3,entschlüsselteBuchstaben);
                }
            }
            changeLetter(anzahlBuchstaben,letterCounterList, verschlüsselteBuchstaben,entschlüsselteBuchstaben,chiffrat,buildChiffrat);
            String newChiffrat = buildChiffrat.toString();
            Tool.countWords(wordCounterList,newChiffrat);
            for(WordCounter word : wordCounterList){
                System.out.println(word.getWord()+" = "+word.getCount());
            }
            //System.out.print(newChiffrat);
            System.out.println();
            System.out.println();
        }
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

