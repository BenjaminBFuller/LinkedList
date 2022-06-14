import java.io.*;
import java.util.NoSuchElementException;

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
    //removes the last node from the list and returns its value
    public String pop(){
        if (isEmpty()){throw new NoSuchElementException(); }
        else {
            String nodeValue = last.getValue();
            last = last.getPrevNode();
            last.setNextNode(null);
            return nodeValue;
        }
    }

    //Appends a new node onto the front of the list with the value of item
    public void push(String item){
        if (!isEmpty()) {
            first.setPrevNode(new Node(null, first, item));
            first = first.getPrevNode();
        }
        else {
            last = new Node(item);
            first = last;
        }
    }

    //removes the first node from the list and returns its value
    public String remove(){
        if(isEmpty()){throw new NoSuchElementException();}
        String nodeValue = first.getValue();
        first = first.getNextNode();
        first.setPrevNode(null);
        return nodeValue;
    }

    public String remove(int index){
        if((index < 0 || index >= size())){throw new IndexOutOfBoundsException();}
        Node currNode = first;
        for (int i = 0; i < index; i++){
            currNode = currNode.getNextNode();
        }
        currNode.getPrevNode().setNextNode(currNode.getNextNode());
        currNode.getNextNode().setPrevNode(currNode.getPrevNode());
        return currNode.getValue();
    }
    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }
}
