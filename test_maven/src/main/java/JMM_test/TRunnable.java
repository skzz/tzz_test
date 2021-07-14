package JMM_test;

public class TRunnable {

    public static void main(String[] args) {
        Thread t = new Thread("t1") {
            public void run() {
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    System.out.println(this.getState().toString()+i);
                }
            }
        };
        t.start();
    }

}