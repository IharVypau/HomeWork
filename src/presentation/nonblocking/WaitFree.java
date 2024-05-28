package presentation.nonblocking;

import java.util.concurrent.atomic.AtomicInteger;

public class WaitFree {
    private final AtomicInteger cnt = new AtomicInteger();
    public int add(int delta) {
        return cnt.addAndGet(delta);
    }
    public int get() {
        return cnt.get();
    }
}