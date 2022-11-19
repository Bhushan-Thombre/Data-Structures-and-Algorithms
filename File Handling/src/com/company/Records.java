package com.company;

import java.io.*;
import java.util.*;

public class Records {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    Scanner scanner = new Scanner(System.in);
    public void showMenu() throws IOException {
        System.out.println("Student Database");
        System.out.println("--------------------");
        System.out.println("Enter your choice: ");
        System.out.println("1. Add Record");
        System.out.println("2. Display Record");
        System.out.println("3. Search in Record");
        System.out.println("4. Clear All Records");
        System.out.println("5. Exit");
        System.out.println("--------------------");

        int choice = Integer.parseInt(bufferedReader.readLine());
        switch (choice) {
            case 1:
                addRecords();
                break;
            case 2:
                displayRecord();
                break;
            case 3:
                search();
                break;
            case 4:
                clearRecords();
                break;
            case 5:
                exit();
                break;
            default:
                System.out.println("Please entry valid choice");
                break;
        }
    }

    public void addRecords() throws IOException {
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("StudentRecords.txt", true)));
        String name, standard, fatherName, motherName, address, dob;
        int age;
        long telephoneNo;
        boolean addMore = false;
        String s;

        do {
            System.out.println("Enter Name: ");
            name = bufferedReader.readLine();

            System.out.println("Enter Father's Name: ");
            fatherName = bufferedReader.readLine();

            System.out.println("Enter Mother's Name: ");
            motherName = bufferedReader.readLine();

            System.out.println("Enter Address: ");
            address = bufferedReader.readLine();

            System.out.println("Enter Standard: ");
            standard = bufferedReader.readLine();

            System.out.println("Enter Date of Birth (dd/mm/yyyy): ");
            dob = bufferedReader.readLine();

            System.out.println("Enter Age: ");
            age = Integer.parseInt(bufferedReader.readLine());

            System.out.println("Enter Telephone No. : ");
            telephoneNo = Long.parseLong(bufferedReader.readLine());

            printWriter.println(name);
            printWriter.println(fatherName);
            printWriter.println(motherName);
            printWriter.println(address);
            printWriter.println(standard);
            printWriter.println(dob);
            printWriter.println(age);
            printWriter.println(telephoneNo);

            System.out.println("Records added successfully!");
            System.out.println("Do you want to add more records ? (Y/N): ");
            s = bufferedReader.readLine();
            if (s == "Y" || s == "y") {
                addMore = true;
            }else {
                addMore = false;
            }

        }while (addMore);
        printWriter.close();
        showMenu();
    }

    public void displayRecord() throws IOException {
        try {
            BufferedReader file = new BufferedReader(new FileReader("StudentRecords.txt"));
            String name;
            int i = 1;

            while ((name = file.readLine()) != null) {
                System.out.println("Sr No.: " + i++);
                System.out.println("----------------");
                System.out.println("Name: " + name);
                System.out.println("Father's Name: " + file.readLine());
                System.out.println("Mother's Name: " + file.readLine());
                System.out.println("Address: " + file.readLine());
                System.out.println("Standard: " + file.readLine());
                System.out.println("Date of Birth: " + file.readLine());
                System.out.println("Age: " + Integer.parseInt(file.readLine()));
                System.out.println("Telephone No.: " + Long.parseLong(file.readLine()));
                System.out.println("----------------");

            }
            file.close();
            showMenu();
        }catch (FileNotFoundException e) {
            System.out.println("Error!! File not found");
        }
    }

    public void clearRecords() throws IOException {
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("StudentRecords.txt")));
        printWriter.close();
        System.out.println("All Records Cleared");
        showMenu();
    }

    public void search() throws IOException {
        File file = new File("StudentRecords.txt");
        String[] words = null;
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file));
        String s;
        System.out.println("Enter the word which you want to search in file: ");
        String input = scanner.nextLine();
        int count = 0;
        while ((s = bufferedReader1.readLine()) != null) {
            words = s.split(" ");
            for (String word : words) {
                 if (word.equals(input)) {
                     count++;
                 }
            }
        }
        if (count != 0) {
            System.out.println("The given word is present " + count + " times in the file.");
        }else {
            System.out.println("The given word is not present in the file.");
        }
        bufferedReader1.close();
        showMenu();
    }

    public void exit() {
        System.exit(1);
    }
}
