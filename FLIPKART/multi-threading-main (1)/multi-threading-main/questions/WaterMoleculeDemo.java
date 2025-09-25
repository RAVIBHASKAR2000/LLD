package questions;

public class WaterMoleculeDemo {
    public static void main(String[] args) throws InterruptedException {
        WaterMolecule waterMolecule = new WaterMolecule("HHHHHHHHHHOOOOO");
        Thread hydrogen = new Thread(() -> {
            try {
                waterMolecule.buildHydrogen();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread oxygen = new Thread(() -> {
            try {
                waterMolecule.buildWater();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        hydrogen.start();
        oxygen.start();

        hydrogen.join();
        oxygen.join();


    }
}

class WaterMolecule {
    String atomsString;
    Object lock = new Object();
    int count = 0;

    public WaterMolecule(String atoms) {
        atomsString = atoms;
    }

    public void buildHydrogen() throws InterruptedException {
        int i = 0;

        while (i < atomsString.length()){
            synchronized (lock) {
                while (count == 2) {
                    lock.wait();
                }

                if(i >= atomsString.length()){
                    lock.notifyAll();
                    return;
                }

                if(i < atomsString.length() && atomsString.charAt(i) != 'H')
                    i++;

                if(i < atomsString.length() && atomsString.charAt(i) == 'H'){
                    System.out.print(atomsString.charAt(i));
                    count++;
                    i++;

                    if (count == 2)
                        lock.notify();
                }
            }
        }
    }

    public void buildWater() throws InterruptedException {
        int i = 0;
        while (i < atomsString.length()){
            synchronized (lock) {
                while (count != 2) {
                    lock.wait();
                }

                if(i >= atomsString.length()){
                    lock.notifyAll();
                    return;
                }

                if (i <= atomsString.length() && atomsString.charAt(i) != 'O')
                    i++;

                if(i <= atomsString.length() && atomsString.charAt(i) == 'O'){
                    System.out.print(atomsString.charAt(i));
                    System.out.println();
                    i++;
                    count = 0;
                    lock.notify();
                }
            }


        }
    }

}
