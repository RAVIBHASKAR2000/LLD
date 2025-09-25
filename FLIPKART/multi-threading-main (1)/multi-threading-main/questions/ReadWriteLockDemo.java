package questions;

public class ReadWriteLockDemo {
}

class ReadWriteLock {

    boolean isWriteLocked = false;
    int reader = 0;

    public synchronized void acquireReadLock() throws InterruptedException {
        while (isWriteLocked) {
            wait();
        }

        reader++;
    }

    public synchronized void acquireWriteLock() throws InterruptedException {
        while (isWriteLocked || reader != 0) {
            wait();
        }

        isWriteLocked = true;
    }

    public synchronized void releaseReadLock() {
        reader--;
        notify();
    }

    public synchronized void releaseWriteLock() {
        isWriteLocked = false;
        notify();
    }
}