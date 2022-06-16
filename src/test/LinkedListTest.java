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
    void givenInvalidIndex_whenAddWithIndex_thenThrowError(){
        LinkedList test = createTestLinkedList();
        assertThrows(IndexOutOfBoundsException.class, () -> test.add(20,"4th"));

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
    void givenString_whenaddFirst_thenAddToFront() {
        LinkedList test = new LinkedList();
        test.addFirst("To the front!");
        assertSame(test.get(0), "To the front!");
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
    void givenTestLinkedList_whenRemove_thenRemoveSuccessfully() {
        LinkedList test = createTestLinkedList();
        test.remove();
        String[] arrayCheck = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10"};
        assertArrayEquals(test.toArray(), arrayCheck);
    }

    @Test
    void givenTestLinkedList_whenRemoveAtIndex_thenRemoveSuccessfully(){
        LinkedList test = createTestLinkedList();
        test.remove(5);
        String[] arrayCheck = new String[]{"1","2", "3", "4", "5", "7", "8", "9", "10"};
        assertArrayEquals(test.toArray(), arrayCheck);
    }

    @Test
    void givenTestLinkedList_whenRemoveString_thenRemoveSuccessfully() {
        LinkedList test = createTestLinkedList();
        test.remove("8");
        String[] arrayCheck = new String[]{"1","2", "3", "4", "5","6", "7", "9", "10"};
        assertArrayEquals(test.toArray(), arrayCheck);
    }

    @Test
    void removeFirst() {
    }

    @Test
    void removeFirstOccurrence() {
    }

    @Test
    void givenTestLinkedList_whenRemoveLast_thenRemoveSuccessfully() {
        LinkedList test = createTestLinkedList();
        test.removeLast();
        String[] arrayCheck = new String[]{"1","2", "3", "4", "5", "6", "7", "8", "9"};
        assertArrayEquals(test.toArray(), arrayCheck);
    }

    @Test
    void removeLastOccurrence() {
    }

    @Test
    void set() {
    }

    @Test
    void givenTestLinkedList_whengetForNIndex_returnNIndex() {
        LinkedList test = createTestLinkedList();
        assertEquals(test.get(3),"4");
    }

    @Test
    void givenListSize0_whenTestSize0_returnTrue() {
        LinkedList test = new LinkedList();
        assertEquals(test.size(), 0);
    }

    @Test
    void givenListSizeN_whenTestSizeN_returnTrue() {
        LinkedList test = new LinkedList();
        test.add("Should");
        test.add("be");
        test.add("size");
        test.add("4");
        assertEquals(test.size(), 4);
    }

    @Test
    void givenEmptyLinkedList_whenisEmpty_thenReturnTrue() {
        LinkedList test = new LinkedList();
        assertTrue(test.isEmpty());
    }

    @Test
    void givenLinkedListWithAddedThenDeletedItem_whenIsEmpty_thenReturnTrue() {
        LinkedList test = new LinkedList();
        test.add("Testing...");
        test.remove(0);
        assertTrue(test.isEmpty());
    }

    LinkedList createTestLinkedList(){
        ArrayList<String> stringArray= new ArrayList<>(List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        return new LinkedList(stringArray);
    }
}