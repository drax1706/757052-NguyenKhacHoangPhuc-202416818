package hust.soict.dsai.garbage;

public class GarbageCreator {
    public static void main(String[] args) {
        String data = "";
        long start = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            data = data + i % 10;
        }

        long end = System.currentTimeMillis();
        System.out.println("Done in " + (end - start) + " ms");
    }
}