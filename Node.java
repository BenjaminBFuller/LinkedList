public class Node
{
    private Node prevNode;
    private Node nextNode;
    private String value;

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
