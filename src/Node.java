public class Node
{
    //Previous Node in the list
    public Node prevNode;
    //Next Node in the list
    public Node nextNode;
    //Value of this node
    private String value;

    //Various constructors of different combinations of values.
    public Node(String valueObject) {
        prevNode = null;
        nextNode = null;
        value = valueObject;
    }

    public Node( Node prev, String valueObject) {
        prevNode = prev;
        nextNode = null;
        value = valueObject;
    }
    public Node( Node prev, Node next, String valueObject){
        //Assigns the
        prevNode = prev;
        nextNode = next;
        value = valueObject;
    }

    //Set and get functions to access and change the nodes variables
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public Node getPrevNode() {
        return prevNode;
    }

    public String getValue() {
        return value;
    }
}
