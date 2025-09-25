public class WaterMolecule {
    private static String water = "HHHHHHHHHHOOOOO";
    static int count = 0;

    public static void main(String[] args) {
        print();
    }

    public static void print(){
        Object lock = new Object();

        Thread hydrogen = new Thread(()->{
            int i = 0;

            while (i < water.length()){

                synchronized (lock){
                    while (count == 2){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if (water.charAt(i) != 'H'){
                        i++;
                    }
                    else if(water.charAt(i) == 'H'){
                        System.out.print(water.charAt(i));
                        i++;
                        count++;

                        if(count == 2)
                            lock.notify();
                    }
                }
            }

        });

        Thread oxygen = new Thread(()->{
            int i = 0;
            while (i < water.length()){

                synchronized (lock) {
                    while (count !=2){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if (water.charAt(i) != 'O') {
                        i++;
                    } else if (water.charAt(i) == 'O') {
                        System.out.println(water.charAt(i));
                        i++;
                        count = 0;
                        lock.notify();
                    }
                }
            }
        });

        hydrogen.start();
        oxygen.start();
    }
}
