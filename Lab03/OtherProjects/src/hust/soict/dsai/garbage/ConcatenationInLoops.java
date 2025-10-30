package hust.soict.dsai.garbage;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        int n = 10000;

        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < n; i++) {
            s += "a";
        }
        long end = System.currentTimeMillis();
        System.out.println("Time with + operator: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        String result1 = sb.toString();
        end = System.currentTimeMillis();
        System.out.println("Time with StringBuilder: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbf.append("a");
        }
        String result2 = sbf.toString();
        end = System.currentTimeMillis();
        System.out.println("Time with StringBuffer: " + (end - start) + " ms");
    }
}
