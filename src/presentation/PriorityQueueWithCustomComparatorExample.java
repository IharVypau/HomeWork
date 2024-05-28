package presentation;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

public class PriorityQueueWithCustomComparatorExample {
    public static void main(String[] args) {
        Comparator<Task> comparator = Comparator.comparingInt(Task::getPriority);
        //Comparator<Task> comparator = Comparator.comparing(Task::getName);
        Queue<Task> queue = new PriorityQueue<>(comparator);

        // Enqueue tasks with random priorities
        for (int i = 0; i < 5; i++) {
            String name = "Task " + (i + 1);
            int priority = ThreadLocalRandom.current().nextInt(10, 100);
            Task task = new Task(name, priority);
            queue.offer(task);
            System.out.printf("queue.offer(%s)    -->  queue = %s%n", task, queue);
        }

        // Dequeue all elements
        while (!queue.isEmpty()) {
            System.out.printf("queue.poll() = %s  -->  queue = %s%n", queue.poll(), queue);
        }
    }

    private static class Task {
        private String name;
        private int priority;

        public Task(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return name + " (prio " + priority + ")";
        }

        public int getPriority() {
            return priority;
        }

        public String getName() {
            return name;
        }
    }
}