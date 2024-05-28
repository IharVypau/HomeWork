package presentation.nonblocking;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class LockFree {
    private static final AtomicIntegerFieldUpdater<LockFree> updater =
            AtomicIntegerFieldUpdater.newUpdater(LockFree.class, "cnt");
    private volatile int cnt;

    public int add(int delta) {
        int cur;
        do {
            cur = cnt;
        } while (!updater.compareAndSet(this, cur, cur + delta));
        return cur + delta;
    }
    public int get() {
        return cnt;
    }
}