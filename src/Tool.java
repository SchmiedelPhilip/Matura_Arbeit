import java.util.*;
import java.lang.*;

public class Tool {

    public static void countLetters(List<LetterCounter> list, String chiffrat) {
        for (String readLetter : chiffrat.split("")) {
            for (LetterCounter letter : list) {
                if (letter.getLetter().equals(readLetter)) {
                    letter.increaseCount();
                }
            }
        }
    }

    public static void changLetter(List<LetterCounter> list, String[] sortedLetters, String[] englishLetterFrequency, String chiffrat, StringBuilder buildChiffrat) {
        for (String readLetter : chiffrat.split("")) {
            for (LetterCounter letter : list) {
                if (letter.getLetter().equals(readLetter)) {
                    int getIndex = Arrays.asList(sortedLetters).indexOf(readLetter);
                    String newLetter = readLetter.replace(readLetter, englishLetterFrequency[Math.abs(getIndex)]);
                    buildChiffrat.append(newLetter);
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
}

