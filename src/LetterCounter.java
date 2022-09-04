import java.util.Comparator;

public class LetterCounter {

    private final String letter;
    private int count;

    public LetterCounter(String letter){
        this.letter = letter;
        this.count = 0;
    }
    public void increaseCount() {
        this.count += 1;
    }

    public String getLetter() {
        return letter;
    }

    public int getCount() {
        return count;
    }

    //Dient dazu, dass die Liste nach dem Vorkommen der Buchstaben sortiert wird
    public static Comparator<LetterCounter> LetCountComparator = new Comparator<LetterCounter>() {
        @Override
        public int compare(LetterCounter l1, LetterCounter l2) {
            int a = l1.getCount();
            int b = l2.getCount();

            return a-b;
        }
    };
}
