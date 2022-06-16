import java.util.*;
import java.util.Collection;
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

    public LinkedList(Collection collection){
        first = null;
        last = null;
        N = 0;
        addAll(collection);
    }
    public Boolean add(String item) {
        if (!isEmpty()) {
            Node prev = last;
            last = new Node(prev,item);
            prev.setNextNode(last);
        } else {
            last = new Node(item);
            first = last;
        }
        N++;
        return true;
    }

    //adds a new node with the given value at the given index
    public void add(int index, String item){
        Node currNode = this.goToIndex(index);
        currNode.getPrevNode().setNextNode(new Node(currNode.getPrevNode(),currNode, item));
        currNode.setPrevNode(currNode.getPrevNode().getNextNode());
        N++;
    }

    //adds all the items from the collection to the end of the list in the order given
    public Boolean addAll(Collection<String> collection){
        if (collection == null)
            throw new NullPointerException();
        int startSize = this.size();
        for(String item:collection){
            add(item);
        }
        return startSize != this.size();
    }

    //adds all the items from the collection to the list at the specified index in the order given
    public Boolean addAll(int index,Collection<String> collection){
        if (collection == null)
            throw new NullPointerException();
        int startSize = this.size();
        for(String item:collection){
            add(index,item);
            index++;
        }
        return startSize != this.size();
    }

    //adds a new node with the value given at the beginning of the list
    public void addFirst(String item){
        if (!isEmpty()) {
            Node next = first;
            first = new Node(null,next,item);
            next.setPrevNode(first);
        } else {
            last = new Node(item);
            first = last;
        }
        N++;
    }

    //adds a new node with the specified value to the end of the list
    public void addLast(String item){
        add(item);
    }


    //creates and returns a shallow copy of the linked list
    public LinkedList clone(){
        LinkedList clone = new LinkedList();

        for (Node currNode = first; currNode != null; currNode = currNode.getNextNode()){
            clone.add(currNode.getValue());
        }

        return clone;
    }

    //returns the value of the head node
    public String element(){
        return first.getValue();
    }

    //removes the node at the start of the list, returning its value
    public String poll(){
        if(this.size() == 0)
            return null;
        String nodeValue = first.getValue();
        first = first.getNextNode();
        first.setPrevNode(null);
        N--;
        return nodeValue;
    }

    //removes the node at the start of the list, returning its value
    public String pollFirst(){
        return this.poll();
    }

    //removes the node at the end of the list, returning its value
    public String pollLast(){
        if(this.size() == 0)
            return null;
        String nodeValue = last.getValue();
        last = last.getPrevNode();
        last.setNextNode(null);
        N--;
        return nodeValue;
    }
    //removes the last node from the list and returns its value
    public String pop(){
        if (isEmpty()){throw new NoSuchElementException(); }
        else {
            String nodeValue = last.getValue();
            last = last.getPrevNode();
            last.setNextNode(null);
            N--;
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
        N++;
    }

    //removes the first node from the list and returns its value
    public String remove(){
        if(isEmpty()){throw new NoSuchElementException();}
        String nodeValue = first.getValue();
        first = first.getNextNode();
        first.setPrevNode(null);
        N--;
        return nodeValue;
    }

    //removes the node at the specified index and returns its value
    public String remove(int index){
        Node currNode = this.goToIndex(index);
        if(currNode.getPrevNode()!= null)
            currNode.getPrevNode().setNextNode(currNode.getNextNode());
        if(currNode.getNextNode()!= null)
            currNode.getNextNode().setPrevNode(currNode.getPrevNode());
        if (currNode == first)
            first = currNode.getNextNode();
        if (currNode == last)
            last = currNode.getPrevNode();
        N--;
        return currNode.getValue();
    }

    //removes the first node with the specified value from the list. Returns true if successful, and false if not
    public Boolean remove(String item){
        Node currNode = first;
        while (currNode != null){
            if (currNode.getValue().equals(item)){
                if (currNode == first)
                    first = currNode.getNextNode();
                if (currNode == last)
                    last = currNode.getPrevNode();
                if (currNode.getPrevNode() != null){
                    currNode.getPrevNode().setNextNode(currNode.getNextNode());
                }
                if (currNode.getNextNode() != null){
                    currNode.getNextNode().setPrevNode(currNode.getPrevNode());
                }
                N--;
                return true;
            }
            currNode = currNode.getNextNode();
        }
        return false;
    }

    //removes the first node from the list and returns its value
    public String removeFirst(){
        return this.remove();
    }

    //removes the first node with the specified value from the list. Returns true if successful, and false if not
    public Boolean removeFirstOccurrence(String item){
        return remove(item);
    }

    //removes the last node from the list, returning its value.
    public String removeLast(){
        if(isEmpty()){throw new NoSuchElementException();}
        String nodeValue = last.getValue();
        last = last.getPrevNode();
        last.setNextNode(null);
        N--;
        return nodeValue;
    }

    //    //removes the last node with the specified value from the list. Returns true if successful, and false if not
    public Boolean removeLastOccurrence(String item){
        Node currNode = last;
        while (currNode != null){
            if (currNode.getValue().equals(item)){
                if (currNode == first)
                    first = currNode.getNextNode();
                if (currNode == last)
                    last = currNode.getPrevNode();
                if (currNode.getPrevNode() != null){
                    currNode.getPrevNode().setNextNode(currNode.getNextNode());
                }
                if (currNode.getNextNode() != null){
                    currNode.getNextNode().setPrevNode(currNode.getPrevNode());
                }
                N--;
                return true;
            }
            currNode = currNode.getPrevNode();
        }
        return false;
    }

    // clear the linked list - java has automatic garbage collection; setting head to null clears list
    public void clear(){
        first = null;
        N = 0;
    }

    //sets the value of the node at the specified index to the specified value, returns the old value
    public String set(int index, String item){
        Node currNode = this.goToIndex(index);
        String prevValue = currNode.getValue();
        currNode.setValue(item);
        return prevValue;
    }

    // gets/returns the value at the given element
    public String get(int index){
        Node currNode = this.goToIndex(index);
        return currNode.getValue();
    }

    // retrieves and returns but does not remove head node; returns null if empty
    public String peek(){
        if(isEmpty())
            return null;
        else
            return first.getValue();
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    //returns the node at the given index
    private Node goToIndex(int index){
        if((index < 0 || index >= size())){throw new IndexOutOfBoundsException();}
        Node currNode = first;
        for (int i = 0; i < index; i++){
            currNode = currNode.getNextNode();
        }
        return currNode;
    }

    public String[] toArray() {
        String[] temp = new String[N];
        Node iterator = first;
        for (int i=0; i < N; i++) {
            temp[i] = iterator.getValue();
            iterator = iterator.getNextNode();
        }
        return temp;
    }
}
