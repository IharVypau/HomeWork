package presentation;
import java.util.concurrent.*;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(List.of(4, 7, 3, 8, 2, 9, 6, 5, 1));

        System.out.println("priorityQueue = " + pq); // Вывод: [1, 2, 4, 3, 7, 9, 6, 8, 5]
        System.out.println(pq.poll()+" " +pq.poll()+" " +pq.poll()+" " +pq.poll()+" " +pq.poll());
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        pq2.add(20);
        pq2.add(25);
        pq2.add(30);
        System.out.println(pq2); // Вывод: [30, 25, 20]
    }

}

