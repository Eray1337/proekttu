package bg.tu_varna.sit.b1.f23621680;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FileManager fileManager = new FileManager("students.txt");

        while (true) {
            System.out.print(">>> ");
            String input = scanner.nextLine().trim();

            System.out.println("Командите все още не са добавени.");
        }
    }
}
