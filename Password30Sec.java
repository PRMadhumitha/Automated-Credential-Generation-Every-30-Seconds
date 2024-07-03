package programbasic;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Password30Sec {

    // Method to generate a random string of a given length
    private static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            result.append(characters.charAt(random.nextInt(characters.length())));
        }
        return result.toString();
    }

    // Method to generate a random username
    private static String generateUsername() {
        return generateRandomString(8); // Example: 8 characters long
    }

    // Method to generate a random password
    private static String generatePassword() {
        return generateRandomString(12); // Example: 12 characters long
    }

    // Method to generate a random email
    private static String generateEmail() {
        String username = generateRandomString(6); // Example: 6 characters long
        String domain = "example.com";
        return username + "@" + domain;
    }

    // Task to generate and print the report
    private static void generateReport() {
        String username = generateUsername();
        String password = generatePassword();
        String email = generateEmail();

        System.out.println("Report generated:");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Email: " + email);
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a ScheduledExecutorService
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Schedule the task to run every 30 seconds
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                generateReport();
            }
        }, 0, 30, TimeUnit.SECONDS);
    }
}
