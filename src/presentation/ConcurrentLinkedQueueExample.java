package presentation;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

public class ConcurrentLinkedQueueExample {

    private static final int NUMBER_OF_PRODUCERS = 4;
    private static final int NUMBER_OF_CONSUMERS = 3;
    private static final int NUMBER_OF_ELEMENTS_TO_PUT_INTO_QUEUE_PER_THREAD = 5;
    private static final int MIN_SLEEP_TIME_MILLIS = 500;
    private static final int MAX_SLEEP_TIME_MILLIS = 1000;

    private static final int POISON_PILL = -1;

    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();

        // Start producers
        CountDownLatch producerFinishLatch = new CountDownLatch(NUMBER_OF_PRODUCERS);
        for (int i = 0; i < NUMBER_OF_PRODUCERS; i++) {
            createProducerThread(queue, producerFinishLatch).start();
        }

        // Start consumers
        for (int i = 0; i < NUMBER_OF_CONSUMERS; i++) {
            createConsumerThread(queue).start();
        }

        // Ждем пока все продюсеры завершатся
        producerFinishLatch.await();

        // Вбрасываем -1 для прерывания потока consumera и ждем пока все консьюмеры закончат работу
        for (int i = 0; i < NUMBER_OF_CONSUMERS; i++) {
            queue.offer(POISON_PILL);
        }

    }

    private static Thread createProducerThread(
            Queue<Integer> queue, CountDownLatch finishLatch) {
        return new Thread(
                () -> {
                    ThreadLocalRandom random = ThreadLocalRandom.current();
                    for (int i = 0; i < NUMBER_OF_ELEMENTS_TO_PUT_INTO_QUEUE_PER_THREAD; i++) {
                        sleepRandomTime();

                        Integer element = random.nextInt(1000);
                        queue.offer(element);
                        System.out.printf(
                                "[%s] queue.offer(%3d)        --> queue = %s%n",
                                Thread.currentThread().getName(), element, queue);
                    }

                    finishLatch.countDown();
                });
    }

    private static Thread createConsumerThread(Queue<Integer> queue) {
        return new Thread(
                () -> {
                    while (true) {
                        sleepRandomTime();

                        Integer element = queue.poll();
                        System.out.printf(
                                "[%s]     queue.poll() = %4d --> queue = %s%n",
                                Thread.currentThread().getName(), element, queue);

                        // End the thread when a poison pill is detected
                        if (element != null && element == POISON_PILL) {
                            break;
                        }
                    }
                });
    }

    private static void sleepRandomTime() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        try {
            Thread.sleep(random.nextInt(MIN_SLEEP_TIME_MILLIS, MAX_SLEEP_TIME_MILLIS));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}