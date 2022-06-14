import java.io.*;

public class LinkedList {
    private Node first;
    private Node last;
    private int N;

    public LinkedList() {
        first = null;
        last = null;
        N = 0;
    }

    public void add(String item) {
        if (item == null) { System.out.print("The first argument for addLast() is null."); }
        if (!isEmpty()) {
            Node prev = last;
            last = new Node(item);
            prev.setNextNode(last);
        }
        else {
            last = new Node(item);
            first = last;
        }
        N++;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }
}
