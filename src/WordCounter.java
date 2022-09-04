public class WordCounter {

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

    public void makeCountZero(){
        this.count = 0;
    }
}
