package presentation.job;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.function.Supplier;

public class FigureProducerJob implements Runnable{
    private final Queue<String> queue;
    private final Supplier<String> supplier;

    public FigureProducerJob(Queue<String> queue, Supplier<String> supplier) {
        this.queue = queue;
        this.supplier = supplier;
    }

    @Override
    public final void run() {
        while (1 == 1){
            queue.add(supplier.get());
            display();
            try {
                TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(100, 300));
                //AbstractQueue q = new DelayQueue();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void display(){
        Iterator it = queue.iterator();
        while(it.hasNext()){
            System.out.println("it= "+ it.next());
        }
    }
}
