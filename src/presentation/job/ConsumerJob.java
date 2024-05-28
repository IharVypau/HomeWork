package presentation.job;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ConsumerJob implements Callable<String> {
    private final Queue<String> queue;

    public ConsumerJob(Queue<String> queue) {
        this.queue = queue;
    }

    @Override
    public String call() throws Exception {
        StringBuffer result = new StringBuffer();
        while (1 == 1){
            String figure = queue.poll();
            if(figure != null){
                System.out.println("Получил: " + figure);
                //display();
                result.append(figure.toUpperCase()).append(" - ");
            }else{
                System.out.println("пуста");
            }
            TimeUnit.MILLISECONDS.sleep(100);
        }
         //return result.toString();
    }

}