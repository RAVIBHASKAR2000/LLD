package questions;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class CallBackDemo {
    public static void main( String args[] ) throws InterruptedException {
        DeferredCallbackExecutor deferredCallbackExecutor = new DeferredCallbackExecutor();
        Set<Thread> allThreads = new HashSet<>();
        Thread executor = new Thread(() -> {
            try {
                deferredCallbackExecutor.start();
            }catch (Exception e) {

            }
        });

        executor.start();

        for (int i = 0 ; i < 10; i++){
            Thread cb = new Thread(() -> {
               CallBack callBack = new CallBack(1, "Hello this is " + Thread.currentThread().getName());
               deferredCallbackExecutor.registerCallBack(callBack);
            });

            cb.start();
            allThreads.add(cb);
            TimeUnit.SECONDS.sleep(1);
        }

        for (Thread t : allThreads) {
            t.join();
        }

    }
}

class CallBack{
    long executeAt;
    String message;

    public CallBack(long executeAt, String message) {
        this.executeAt = executeAt;
        this.message = message;
    }
}

class DeferredCallbackExecutor {
    PriorityQueue<CallBack> callBacks = new PriorityQueue<CallBack>((a,b) -> Long.compare(a.executeAt, b.executeAt));
    ReentrantLock lock = new ReentrantLock();
    Condition newCallBackReceived = lock.newCondition();

    public long getSleepDuration(){
        long currentTime = System.currentTimeMillis();
        return callBacks.peek().executeAt-currentTime;
    }

    public void start() throws InterruptedException {
        long sleepFor = 0;

        while (true){
            lock.lock();

            while (callBacks.isEmpty()){
                newCallBackReceived.await();
            }

            while (!callBacks.isEmpty()){
                sleepFor = getSleepDuration();

                if(sleepFor <= 0)
                    break;

                newCallBackReceived.await(sleepFor, TimeUnit.MILLISECONDS);
            }

            CallBack cb = callBacks.poll();
            System.out.println(
        "Executed at " + System.currentTimeMillis()/1000 + " required at " + cb.executeAt/1000
                + ": message:" + cb.message);

            lock.unlock();

        }
    }

    public void registerCallBack(CallBack callBack){
        lock.lock();
        callBacks.offer(callBack);
        newCallBackReceived.signal();
        lock.unlock();
    }
}




//class DeferredCallbackExecutor {
//
//    PriorityQueue<CallBack> q = new PriorityQueue<CallBack>(new Comparator<CallBack>() {
//        public int compare(CallBack o1, CallBack o2) {
//            return (int) (o1.executeAt - o2.executeAt);
//        }
//    });
//    ReentrantLock lock = new ReentrantLock();
//    Condition newCallbackArrived = lock.newCondition();
//
//    private long findSleepDuration() {
//        long currentTime = System.currentTimeMillis();
//        return q.peek().executeAt - currentTime;
//    }
//
//    public void start() throws InterruptedException {
//        long sleepFor = 0;
//
//        while (true) {
//
//            lock.lock();
//
//            while (q.size() == 0) {
//                newCallbackArrived.await();
//            }
//
//            while (q.size() != 0) {
//                sleepFor = findSleepDuration();
//
//                if(sleepFor <=0)
//                    break;
//
//                newCallbackArrived.await(sleepFor, TimeUnit.MILLISECONDS);
//            }
//
//            CallBack cb = q.poll();
//            System.out.println(
//                    "Executed at " + System.currentTimeMillis()/1000 + " required at " + cb.executeAt/1000
//                            + ": message:" + cb.message);
//
//            lock.unlock();
//        }
//    }
//
//    public void registerCallback(CallBack callBack) {
//        lock.lock();
//        q.add(callBack);
//        newCallbackArrived.signal();
//        lock.unlock();
//    }
//
//    static class CallBack {
//        long executeAt;
//        String message;
//
//        public CallBack(long executeAfter, String message) {
//            this.executeAt = System.currentTimeMillis() + (executeAfter * 1000);
//            this.message = message;
//        }
//    }
//
//    public static void runTestTenCallbacks() throws InterruptedException {
//        Set<Thread> allThreads = new HashSet<Thread>();
//        final DeferredCallbackExecutor deferredCallbackExecutor = new DeferredCallbackExecutor();
//
//        Thread service = new Thread(new Runnable() {
//            public void run() {
//                try {
//                    deferredCallbackExecutor.start();
//                } catch (InterruptedException ie) {
//
//                }
//            }
//        });
//
//        service.start();
//
//        for (int i = 0; i < 10; i++) {
//            Thread thread = new Thread(new Runnable() {
//                public void run() {
//                    CallBack cb = new CallBack(1, "Hello this is " + Thread.currentThread().getName());
//                    deferredCallbackExecutor.registerCallback(cb);
//                }
//            });
//            thread.setName("Thread_" + (i + 1));
//            thread.start();
//            allThreads.add(thread);
//            Thread.sleep(1000);
//        }
//
//        for (Thread t : allThreads) {
//            t.join();
//        }
//    }
//}
