package lab13;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteToTextFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter text to write to the file (type 'exit' to finish):");

        try (FileWriter fileWriter = new FileWriter("output.txt")) {
            while (true) {
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                fileWriter.write(input + "\n");
            }
            System.out.println("Text entered successfully written to file 'output.txt'");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
