import java.util.*;
import java.lang.*;

public class Tool {
    // Die Funktion rechnet Fakultät einer Zahl aus
    public static int getFactorial(int fakultaet) {
        int result = 1;
        for (int i = 1; i <= fakultaet; i++) {
            result = result * i;
        }
        return result;
    }

    // Die Funktion soll später dazu dienen den Schlüssel auszugeben und macht nebenbei die sortierten Buchstaben der Reihe nach in eine Liste
    public static void getKey(String[] arr, String[] arr1, List<LetterCounter> lettercounters) {
        int i = 0;
        for (LetterCounter a : lettercounters) {
            if (i < 26) {
                arr1[i] = a.getLetter();
                System.out.println(a.getLetter() + " = " + arr[i]);
                i++;
            }
        }
    }

    // Die Funktion gibt den Schlüssel aus, wie der Text verschlüsselt ist
    public static void getKeyModified(String[] sortedLetterCounter, String[] englishLetterFequency) {
        int i = 0;
        for (String a : sortedLetterCounter) {
            if (i < 26) {
                System.out.println(a + " = " + englishLetterFequency[i]);
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
    public static void countWords(List<WordCounter> wordCounterList, String chiffrat) {
        for (String readWord : chiffrat.split(" ")) {
            for (WordCounter word : wordCounterList) {
                if (readWord.equals(word.getWord())) {
                    word.increaseCount();
                }
            }
        }
    }

    // Die Funktion tauscht die Buchstaben in einem Text
    public static void changeLetter(int howMany, List<LetterCounter> list, String[] sortedLetterCounter, String[] englishLetterFrequency, String chiffrat, StringBuilder buildChiffrat) {
        for (String readLetter : chiffrat.split("")) {
            if (readLetter.equals(" ")) {
                buildChiffrat.append(readLetter);
            }
            for (LetterCounter letter : list) {
                if (letter.getLetter().equals(readLetter)) {
                    int getIndex = Arrays.asList(sortedLetterCounter).indexOf(readLetter);
                    if (getIndex < howMany) {
                        String newLetter = readLetter.replace(readLetter, englishLetterFrequency[Math.abs(getIndex)]);
                        buildChiffrat.append(newLetter);
                    } else {
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
    public static void convertStringToList(List<String> list, String mostFrequentWordsEnglish) {
        for (String str : mostFrequentWordsEnglish.split(" ")) {
            list.add(str);
        }
    }

    // Die Funktion tauscht die Werte von 2 Arrayplätzen
    public static void swapTwoPlaces(int placeOne, int placeTwo, String[] arr) {
        String temp = arr[placeOne];
        arr[placeOne] = arr[placeTwo];
        arr[placeTwo] = temp;
    }

    // Die Funktion gebt den summierten count aller gezählten Wörter zurück
    public static int getAllCounts(List<WordCounter> wordCounterList) {
        int result = 0;
        for (WordCounter word : wordCounterList) {
            result = result + word.getCount();
        }
        return result;
    }

    // Die Funktion kann alle möglichen Permultation mit 3 Buchstaben durchführen
    public static void makeAllPossiblePermutationWithThreeLetters(String[] verschluesselteBuchstaben, int i) {
        if (i % 2 == 0) {
            Tool.swapTwoPlaces(1, 2, verschluesselteBuchstaben);
        }
        if (i % 2 == 1) {
            Tool.swapTwoPlaces(0, 1, verschluesselteBuchstaben);
        }
    }

    // Die Funktion kann alle möglichen Permultation mit 4 Buchstaben durchführen
    public static void makeAllPossiblePermutationWithFourLetters(String[] verschluesselteBuchstaben, int i) {
        if (i % 2 == 0) {
            Tool.swapTwoPlaces(2, 3, verschluesselteBuchstaben);
        }
        if (i % 2 == 1 && i % 6 != 5) {
            Tool.swapTwoPlaces(1, 2, verschluesselteBuchstaben);
        }
        if (i % 6 == 5) {
            Tool.swapTwoPlaces(0, 1, verschluesselteBuchstaben);
            Tool.swapTwoPlaces(2, 3, verschluesselteBuchstaben);
        }
    }

    public static void findWayWithMostRecognizedWords(int anzahlBuchstaben, int howManyChangedLetters, String chiffrat, String[] englishLetterFrequency, String[] sortedLetterCounter, List<LetterCounter> letterCounterList, List<WordCounter> wordCounterList, StringBuilder buildChiffrat) {
        String[] verschluesselteBuchstaben = new String[anzahlBuchstaben];
        String[] entschluesselteBuchstaben = new String[anzahlBuchstaben];
        String[] verschluesselteBuchstaben1 = new String[anzahlBuchstaben];
        List<ArrayKeeper> arrayWithHiqhestCount = new ArrayList<>();
        for (int i = howManyChangedLetters - anzahlBuchstaben; i < howManyChangedLetters; i++) {
            verschluesselteBuchstaben[i - (howManyChangedLetters - anzahlBuchstaben)] = sortedLetterCounter[i];
            entschluesselteBuchstaben[i - (howManyChangedLetters - anzahlBuchstaben)] = englishLetterFrequency[i];
        }
        for (int i = 0; i < Tool.getFactorial(anzahlBuchstaben); i += 1) {
            /*
            for (String a : entschluesselteBuchstaben) {
                System.out.print(a + " ");
            }
            System.out.println();
            for (String b : verschluesselteBuchstaben) {
                System.out.print(b + " ");
            }
             */
            for (int j = 0; j < anzahlBuchstaben; j++) {
                sortedLetterCounter[j + (howManyChangedLetters - anzahlBuchstaben)] = verschluesselteBuchstaben[j];
            }
            //System.out.println();
            // Die Buchstaben werden ersetzt
            Tool.changeLetter(howManyChangedLetters, letterCounterList, sortedLetterCounter, englishLetterFrequency, chiffrat, buildChiffrat);
            String newChiffrat = buildChiffrat.toString();
            buildChiffrat.setLength(0);
            // Alle Wörter werden gezählt
            Tool.countWords(wordCounterList, newChiffrat);
            //System.out.println(newChiffrat);
            /*
            for(WordCounter word : wordCounterList){
                System.out.println(word.getWord()+" = "+word.getCount());
            }
             */
            //System.out.println("Gezählte Wörter im Text: " + Tool.getAllCounts(wordCounterList));
            if(arrayWithHiqhestCount.isEmpty()) {
                ArrayKeeper arrayKeeper = new ArrayKeeper(verschluesselteBuchstaben, Tool.getAllCounts(wordCounterList));
                arrayWithHiqhestCount.add(arrayKeeper);
            }
            if(arrayWithHiqhestCount.get(0).getCount() < Tool.getAllCounts(wordCounterList)) {
                for(int k = 0; k<anzahlBuchstaben; k++) {
                    verschluesselteBuchstaben1[k] = verschluesselteBuchstaben[k];
                }
                ArrayKeeper arrayKeeper1 = new ArrayKeeper(verschluesselteBuchstaben1,Tool.getAllCounts(wordCounterList));
                arrayWithHiqhestCount.set(0,arrayKeeper1);
            }
            // Der Count wird wieder auf 0 gebracht, weil er sich sonst summieren würde
            for (WordCounter word : wordCounterList) {
                word.makeCountZero();
            }
            //System.out.println();
            if (anzahlBuchstaben == 3) {
                Tool.makeAllPossiblePermutationWithThreeLetters(verschluesselteBuchstaben, i);
            }
            if (anzahlBuchstaben == 4) {
                Tool.makeAllPossiblePermutationWithFourLetters(verschluesselteBuchstaben, i);
            }
            //System.out.print(newChiffrat);
            //System.out.println();
            //System.out.println();
        }
        arrayWithHiqhestCount.get(0).changeArr(sortedLetterCounter, howManyChangedLetters - anzahlBuchstaben, howManyChangedLetters);
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


