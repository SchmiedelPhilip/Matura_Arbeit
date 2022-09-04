import java.util.Comparator;

public class ArrayKeeper {

    private final String[] arr;
    private final int count;

    ArrayKeeper(String[] arr, int count) {
        this.arr = arr;
        this.count = count;
    }

    public String[] getArr(){
        return arr;
    }

    public int getCount(){
        return count;
    }

    public void changeArr(String[] sortedLetterCounter, int fromWhere, int toWhere){
        for(int i = 0; i < (toWhere-fromWhere); i++){
            sortedLetterCounter[i+fromWhere] = arr[i];
        }
    }

    public static Comparator<ArrayKeeper> LetCountComparator1 = new Comparator<ArrayKeeper>() {
        @Override
        public int compare(ArrayKeeper l1, ArrayKeeper l2) {
            int a = l1.getCount();
            int b = l2.getCount();

            return a - b;
        }
    };
}
