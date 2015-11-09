package com.bsc.utils;

import com.bsc.entities.Payment;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Ladislav
 * Date: 11/8/15
 * Time: 4:46 PM
 */
public class FileLoader {

    public static ArrayList<Payment> loadFromFile() throws Exception {
        ArrayList<Payment> inputFromFile = new ArrayList<Payment>();
        String decision = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to load transactions from a file? Y/N:");
        //read input from console
        decision = scanner.nextLine();
        decision = decision.trim();
        if (decision.toUpperCase().equals("Y")) {
            System.out.println("Please specify filename to read from:");
            Scanner stdin = new Scanner(new BufferedInputStream(System.in)).useDelimiter("\n");
            inputFromFile = readFromFile(stdin.nextLine());
        } else {
            if (decision.toUpperCase().equals("N")) {
            } else {
                throw new Exception("Error: Invalid input!");
            }
        }
        return inputFromFile;
    }


    public static ArrayList<Payment> readFromFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        ArrayList<Payment> payments = new ArrayList<Payment>();
        Scanner scanner = new Scanner(path).useDelimiter("\n");
        while (scanner.hasNextLine()) {
            //process each line in some way
            Payment payment = new Payment();
            String[] parts = scanner.nextLine().split(" ");
            payment.setCurrency(parts[0]);
            payment.setAmount(Long.parseLong(parts[1]));
            payments.add(payment);
        }
        if (payments.size() != 0) System.out.println("File " + fileName + " loaded successfully.");
        return payments;
    }

}
