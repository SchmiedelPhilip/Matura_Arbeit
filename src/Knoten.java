import java.util.*;

public class Knoten implements Cloneable {

    private final int value;
    private List<Knoten> children;

    public Knoten(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public Knoten addNode(int value) {
        Knoten child = new Knoten(value);
        this.children.add(child);
        return child;
    }
    public int getValue(){
        return value;
    }

    public Knoten addNodes(Knoten child) {
        this.children.add(child);
        return child;
    }
    /*public Knoten clone(){
        Knoten a = new Knoten(this.value);
        for(Knoten child : this.children){
            a.addNodes(child.clone());
        }
        return a;
    }
*/
    public List<Knoten> getChildren(){
        return this.children;
    }

    public static class main {
        public static void main(String[] args) {
            Knoten root = new Knoten(2);
            Knoten left = root.addNode(2);
            Knoten right = root.addNode(3);
            Knoten right_left = right.addNode(4);
            Knoten right_right = right.addNode(5);
            List<List<Knoten>> allWays = allWaysTraverse(new ArrayList<>(),root);
            allWaysOutput(allWays);
        }

        public static void allWaysOutput(List<List<Knoten>> listWays) {
            for (List<Knoten> a : listWays) {
                for (Knoten b : a) {
                    System.out.println(b.getValue());
                }
            }
        }
        public static List<List<Knoten>> allWaysTraverse(ArrayList<Knoten> way, Knoten one){
            List<Knoten> children = one.getChildren();
            way.add(one);
            if(children.isEmpty()){
                List<List<Knoten>> result = new ArrayList<>();
                result.add(way);
                return result;
            }
            List<List<Knoten>> result = new ArrayList<>();
            for(Knoten child : children){
                List<List<Knoten>> childWay = allWaysTraverse((ArrayList<Knoten>) way.clone(),child);
                result.addAll(childWay);
            }
            return result;
        }
    }
}






