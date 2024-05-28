package presentation;

import presentation.job.ConsumerJob;
import presentation.job.FigureProducerJob;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class MainLinkedList {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        ExecutorService producers = Executors.newFixedThreadPool(1);

        producers.submit(new FigureProducerJob(queue, () ->{
            ThreadLocalRandom rnd = ThreadLocalRandom.current();
            return System.currentTimeMillis() + ": First";
        }));

        producers.submit(new FigureProducerJob(queue, () ->{
            ThreadLocalRandom rnd = ThreadLocalRandom.current();
            return System.currentTimeMillis() + ": Second";
        }));




        ExecutorService consumers = Executors.newFixedThreadPool(4);

        consumers.submit(new ConsumerJob(queue));
    }
}
