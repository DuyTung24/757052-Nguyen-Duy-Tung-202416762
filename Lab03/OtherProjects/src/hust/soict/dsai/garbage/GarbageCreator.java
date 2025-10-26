package hust.soict.dsai.garbage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GarbageCreator {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("test.txt");
        Scanner scanner = new Scanner(file);
        String input = "";

        while (scanner.hasNextLine()) {
            input += scanner.nextLine();
        }
        scanner.close();

        System.out.println("Read done. Length = " + input.length());
    }
}
