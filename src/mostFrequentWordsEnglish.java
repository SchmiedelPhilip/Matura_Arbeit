import java.util.*;

public class mostFrequentWordsEnglish {

    public static void main(String[] args) {
        List<String> mostFrequentWordsEnglishList = new ArrayList<>();
        List<WordCounter> wörterZählerListe = new ArrayList<>();
        String mostFreuquentWordsEnglish = "about all also and as at be because but by can come could day do even find first for from get give go have he her here him his how if in into it its just know like look make man many me more my new no not now of on one only or other our out people say see she so some take tell than that the their them then there these they thing think this those time to two up use very want way we well what when which who will with would year you your";
        // Jedes einzelne Wort wird in die Liste mostFrequentWordsEnglishList eingefügt
        Tool.convertStringToList(mostFrequentWordsEnglishList,mostFreuquentWordsEnglish);

        for(String word : mostFreuquentWordsEnglish.split(" ")){
            WordCounter wort = new WordCounter(word);
            wörterZählerListe.add(wort);
        }
    }
}

class WordCounter{

    private final String word;
    private int count;

    WordCounter(String word) {
        this.word = word;
        this.count = 0;
    }
    public void increaseCount(){
        this.count += 1;
    }
    public String getWord(){
        return word;
    }
    public int getCount(){
        return count;
    }
}