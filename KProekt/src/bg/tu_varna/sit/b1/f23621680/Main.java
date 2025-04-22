package bg.tu_varna.sit.b1.f23621680;

import java.util.*;
import java.util.Scanner;

public class Main {

    private static FileManager fileManager = new FileManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nМеню:");
            System.out.println("1. Отвори файл");
            System.out.println("2. Записване на студент в дисциплина");
            System.out.println("3. Добавяне на оценка");
            System.out.println("4. Записване на промените в текущия файл");
            System.out.println("5. Записване на промените в нов файл (Save As)");
            System.out.println("6. Създаване на нов студент");
            System.out.println("7. Помощ");
            System.out.println("8. Изход");
            System.out.print("Изберете операция: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Въведете пътя до файла за отваряне: ");
                    String filePath = scanner.nextLine();
                    fileManager.openFile(filePath);
                    break;

                case 2:
                    System.out.print("Въведете факултетен номер на студента: ");
                    String fn = scanner.nextLine();
                    System.out.print("Въведете име на дисциплина: ");
                    String course = scanner.nextLine();
                    fileManager.enrollInCourse(fn, course);
                    break;

                case 3:
                    System.out.print("Въведете факултетен номер на студента: ");
                    String studentFn = scanner.nextLine();
                    System.out.print("Въведете дисциплина: ");
                    String discipline = scanner.nextLine();
                    System.out.print("Въведете оценка: ");
                    double grade = scanner.nextDouble();
                    fileManager.addGrade(studentFn, discipline, grade);
                    break;

                case 4:
                    fileManager.saveToFile();
                    break;

                case 5:
                    System.out.print("Въведете ново име на файл: ");
                    String newFilePath = scanner.nextLine();
                    fileManager.saveAs(newFilePath);
                    break;

                case 6:
                    createStudent(scanner);
                    break;

                case 7:
                    printHelp();
                    break;

                case 8:
                    System.out.println("Изход от програмата.");
                    break;

                default:
                    System.out.println("Невалиден избор! Моля, опитайте отново.");
            }

        } while (choice != 8);

        scanner.close();
    }

    private static void createStudent(Scanner scanner) {
        System.out.println("Въведете данни за нов студент:");

        System.out.print("Име: ");
        String name = scanner.nextLine();
        System.out.print("Факултетен номер: ");
        String fn = scanner.nextLine();
        System.out.print("Специалност: ");
        String program = scanner.nextLine();
        System.out.print("Курс: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Група: ");
        String group = scanner.nextLine();
        System.out.print("Статус (например: Записан): ");
        String status = scanner.nextLine();

        fileManager.createStudent(name, fn, program, year, group, status);
        System.out.println("Ново добавен студент:");
    }

    private static void printHelp() {
        System.out.println("\nПомощ:");
        System.out.println("1. 'Отвори файл' - Зарежда студентите от даден файл.");
        System.out.println("2. 'Записване на студент в дисциплина' - Записва студент в дадена дисциплина.");
        System.out.println("3. 'Добавяне на оценка' - Добавя оценка за студент в дисциплина.");
        System.out.println("4. 'Записване на промените в текущия файл' - Записва промените обратно в съществуващия файл.");
        System.out.println("5. 'Записване на промените в нов файл' - Записва промените в нов файл.");
        System.out.println("6. 'Създаване на нов студент' - Добавя нов студент.");
        System.out.println("7. 'Помощ' - Показва това меню.");
        System.out.println("8. 'Изход' - Изход от програмата.");
    }
}
