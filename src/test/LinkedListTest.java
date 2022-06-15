import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void givenString_whenAddedToEmptyList_thenSuccessfullyAddValue() {
        LinkedList test = new LinkedList();
        test.add("Hello");
        assertSame(test.get(0), "Hello");
    }

    @Test
    void givenStringsAddedToList_whenToArray_thenReturnStringsAsArray(){
        LinkedList test = new LinkedList();
        String[] strings = new String[]{"Hello","There","Obi","Wan","Kenobi"};
        test.add("Hello");
        test.add("There");
        test.add("Obi");
        test.add("Wan");
        test.add("Kenobi");
        assertArrayEquals(test.toArray(), strings);
    }
    @Test
    void givenCollectionOfStrings_whenConstructor_thenMakeLinkedListConsistingOfCollection(){
        ArrayList<String> stringArray= new ArrayList<>(List.of("1","2", "3", "4", "5", "6", "7", "8", "9", "10"));
        LinkedList test = new LinkedList(stringArray);
        assertArrayEquals(test.toArray(), stringArray.toArray());
    }

    @Test
    void givenString_whenAddWithIndex_thenProperlyAddToIndex(){
        LinkedList test = createTestLinkedList();
        test.add(4,"4th");
        assertSame(test.get(4),"4th");
    }
    @Test
    void givenCollectionOfStrings_whenAddAll_thenAddAllToLinkedList() {
        ArrayList<String> stringArray= new ArrayList<>(List.of("1","2", "3", "4", "5", "6", "7", "8", "9", "10"));
        LinkedList test = new LinkedList();
        test.addAll(stringArray);
        assertArrayEquals(test.toArray(), stringArray.toArray());
    }

    @Test
    void givenCollectionOfStringsAndIndex_whenAddAll_thenAddAllToLinkedListAtIndex(){
        ArrayList<String> stringArray= new ArrayList<>(List.of("1","2", "3", "4", "5", "6", "7", "8", "9", "10"));
        LinkedList test = new LinkedList();
        test.add("0");
        test.add("11");
        test.addAll(1,stringArray);
        String[] arrayCheck = new String[]{"0","1","2", "3", "4", "5", "6", "7", "8", "9", "10","11"};
        assertArrayEquals(test.toArray(), arrayCheck);
    }
    @Test
    void addFirst() {
    }

    @Test
    void addLast() {
    }

    @Test
    void testClone() {
    }

    @Test
    void element() {
    }

    @Test
    void poll() {
    }

    @Test
    void pollFirst() {
    }

    @Test
    void pollLast() {
    }

    @Test
    void pop() {
    }

    @Test
    void push() {
    }

    @Test
    void remove() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void testRemove1() {
    }

    @Test
    void removeFirst() {
    }

    @Test
    void removeFirstOccurrence() {
    }

    @Test
    void removeLast() {
    }

    @Test
    void removeLastOccurrence() {
    }

    @Test
    void set() {
    }

    @Test
    void get() {
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    LinkedList createTestLinkedList(){
        ArrayList<String> stringArray= new ArrayList<>(List.of("1","2", "3", "4", "5", "6", "7", "8", "9", "10"));
        return new LinkedList(stringArray);
    }
}