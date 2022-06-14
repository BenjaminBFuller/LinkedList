import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void givenNewNode_whenSetNextNode_thenReturnNewNodeWithGetNextNode() {
        Node testNode,testNextNode;
        testNode = new Node("hello");
        testNextNode = new Node ("bye");
        testNode.setNextNode(testNextNode);
        assert (testNode.getNextNode()==testNextNode);
    }

    @Test
    void givenNewNode_whenSetPrevNode_thenReturnNewNodeWithGetPrevNode(){
        Node testNode,testPrevNode;
        testNode = new Node("hello");
        testPrevNode = new Node ("bye");
        testNode.setNextNode(testPrevNode);
        assert (testNode.getNextNode()==testPrevNode);
    }

    @Test
    void givenNewValue_whenSetPrevNode_thenReturnNewValueWithGetValue(){
        Node testNode;
        String testValue = "bye";
        testNode = new Node("hello");
        testNode.setValue(testValue);
        assert (testNode.getValue().equals(testValue));
    }
}