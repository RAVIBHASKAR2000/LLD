package basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PasswordGuesser {
    private static final int MAX_PASSWORD = 9999;

    public static void main(String[] args) {
        Random rand = new Random();
        Vault vault = new Vault(rand.nextInt(MAX_PASSWORD));

        List<Thread> threads = new ArrayList<>();
        threads.add(new AscendingHacker(vault));
        threads.add(new DescendingHacker(vault));
        threads.add(new Police());

        for (Thread thread : threads) {
            thread.start();
        }
    }

    public static class Vault {
        private final int password;

        public Vault(int password) {
            this.password = password;
        }

        public boolean isCorrectPassword(int guessedPwd) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return this.password == guessedPwd;
        }
    }

    public static abstract class Hacker extends Thread{
        protected Vault vault;

        public Hacker(Vault vault) {
            this.vault = vault;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);
        }

        public abstract void guess();

        @Override
        public void run() {
            guess(); // Execute custom task defined in subclass
        }
    }

    public static class AscendingHacker extends Hacker{

        public AscendingHacker(Vault vault) {
            super(vault);
        }

        @Override
        public void guess() {
            for(int guess = 0 ; guess <= MAX_PASSWORD ; guess++) {
                if(this.vault.isCorrectPassword(guess)) {
                    System.out.println(this.getName() + " guessed the password");
                    System.exit(0);
                }
            }
        }

    }

    public static class DescendingHacker extends Hacker{

        public DescendingHacker(Vault vault) {
            super(vault);
        }

        @Override
        public void guess() {
            for(int guess = MAX_PASSWORD ; guess >= 0 ; guess--) {
                if(this.vault.isCorrectPassword(guess)) {
                    System.out.println(this.getName() + " guessed the password");
                    System.exit(0);
                }
            }
        }
    }

    public static class Police extends Thread{
        @Override
        public void run() {
            for (int i = 10; i > 0; i--) {
                System.out.println("remaining time : "+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println("times up");
            System.exit(0);
        }
    }

}
