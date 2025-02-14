import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayListVsLinkedListTest {
    private ArrayListVsLinkedList listComparator;

    @BeforeEach
    public void setUp() {
        listComparator = new ArrayListVsLinkedList();
    }
    @Test
    public void testComparison() {
        int elementCount = 1000; // Количество элементов для тестирования
        listComparator.runComparison(elementCount);
    }

    @Test
    public void testAddEvaluationLL() {
        double time = listComparator.evaluateAddLinkedList(1000);
        assertTrue(time >= 0, "Time should be non-negative");
    }

    @Test
    public void testAddEvaluationAL() {
        double time = listComparator.evaluateAddArrayList(1000);
        assertTrue(time >= 0, "Time should be non-negative");
    }

    @Test
    public void testGetEvaluationLL() {
        listComparator.evaluateAddLinkedList(1000);
        double time = listComparator.evaluateGetLinkedList();
        assertTrue(time >= 0, "Time should be non-negative");
    }

    @Test
    public void testGetEvaluationAL() {
        listComparator.evaluateAddArrayList(1000);
        double time = listComparator.evaluateGetArrayList();
        assertTrue(time >= 0, "Time should be non-negative");
    }

    @Test
    public void testContainsEvaluationLL() {
        listComparator.evaluateAddLinkedList(1000);
        double time = listComparator.evaluateContainsLinkedList();
        assertTrue(time >= 0, "Time should be non-negative");
    }

    @Test
    public void testContainsEvaluationAL() {
        listComparator.evaluateAddArrayList(1000);
        double time = listComparator.evaluateContainsArrayList();
        assertTrue(time >= 0, "Time should be non-negative");
    }

    @Test
    public void testRemoveEvaluationLL() {
        listComparator.evaluateAddLinkedList(1000);
        double time = listComparator.evaluateRemoveLinkedList();
        assertTrue(time >= 0, "Time should be non-negative");
    }

    @Test
    public void testRemoveEvaluationAL() {
        listComparator.evaluateAddArrayList(1000);
        double time = listComparator.evaluateRemoveArrayList();
        assertTrue(time >= 0, "Time should be non-negative");
    }
}