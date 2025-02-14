
import java.util.*;

/**
 * Класс для сравнения производительности операций с LinkedList и ArrayList.
 * Содержит методы для оценки времени выполнения различных операций, таких как добавление,
 * получение, проверка наличия и удаление элементов.
 */
public class ArrayListVsLinkedList {
    private final LinkedList<Integer> linkedList;
    private final ArrayList<Integer> arrayList;


    public ArrayListVsLinkedList() {
        linkedList = new LinkedList<>();
        arrayList = new ArrayList<>();
    }

    /**
     * Оценивает время выполнения операции добавления элементов в LinkedList.
     *
     * @param count количество элементов для добавления
     * @return время выполнения операции в наносекундах
     */
    double evaluateAddLinkedList(int count) {
        Random rng = new Random();
        long startTime = System.nanoTime();
        while (linkedList.size() < count) {
            linkedList.add(rng.nextInt(1000));
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Оценивает время выполнения операции добавления элементов в ArrayList.
     *
     * @param count количество элементов для добавления
     * @return время выполнения операции в наносекундах
     */
    double evaluateAddArrayList(int count) {
        Random rng = new Random();
        long startTime = System.nanoTime();
        while (arrayList.size() < count) {
            arrayList.add(rng.nextInt(1000));
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Оценивает время выполнения операции получения элементов из LinkedList.
     *
     * @return время выполнения операции в наносекундах
     */
    double evaluateGetLinkedList() {
        long startTime = System.nanoTime();
        for (int index = 0; index < linkedList.size(); index++) {
            linkedList.get(index);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Оценивает время выполнения операции получения элементов из ArrayList.
     *
     * @return время выполнения операции в наносекундах
     */
    double evaluateGetArrayList() {
        long startTime = System.nanoTime();
        for (int index = 0; index < arrayList.size(); index++) {
            arrayList.get(index);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Оценивает время выполнения операции проверки наличия элементов в LinkedList.
     *
     * @return время выполнения операции в наносекундах
     */
    double evaluateContainsLinkedList() {
        long startTime = System.nanoTime();
        for (int value = 0; value < 1000; value++) {
            linkedList.contains(value);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Оценивает время выполнения операции проверки наличия элементов в ArrayList.
     *
     * @return время выполнения операции в наносекундах
     */
    double evaluateContainsArrayList() {
        long startTime = System.nanoTime();
        for (int value = 0; value < 1000; value++) {
            arrayList.contains(value);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Оценивает время выполнения операции удаления элементов из LinkedList.
     *
     * @return время выполнения операции в наносекундах
     */
    double evaluateRemoveLinkedList() {
        long startTime = System.nanoTime();
        while (!linkedList.isEmpty()) {
            linkedList.remove(0);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Оценивает время выполнения операции удаления элементов из ArrayList.
     *
     * @return время выполнения операции в наносекундах
     */
    double evaluateRemoveArrayList() {
        long startTime = System.nanoTime();
        while (!arrayList.isEmpty()) {
            arrayList.remove(0);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Выполняет сравнение производительности операций для заданного количества элементов.
     *
     * @param count количество элементов для тестирования
     */
    public void runComparison(int count) {
        System.out.printf("%-15s %-10s %-15s %-15s%n", "Collection Type", "Operation", "Element Count", "Duration (ns)");
        System.out.printf("%-15s %-10s %-15d %-15.3f%n", "LinkedList", "add", count, evaluateAddLinkedList(count));
        System.out.printf("%-15s %-10s %-15d %-15.3f%n", "ArrayList", "add", count, evaluateAddArrayList(count));
        System.out.printf("%-15s %-10s %-15d %-15.3f%n", "LinkedList", "get", count, evaluateGetLinkedList());
        System.out.printf("%-15s %-10s %-15d %-15.3f%n", "ArrayList", "get", count, evaluateGetArrayList());
        System.out.printf("%-15s %-10s %-15d %-15.3f%n", "LinkedList", "contains", count, evaluateContainsLinkedList());
        System.out.printf("%-15s %-10s %-15d %-15.3f%n", "ArrayList", "contains", count, evaluateContainsArrayList());
        System.out.printf("%-15s %-10s %-15d %-15.3f%n", "LinkedList", "remove", count, evaluateRemoveLinkedList());
        System.out.printf("%-15s %-10s %-15d %-15.3f%n", "ArrayList", "remove", count, evaluateRemoveArrayList());
    }
}