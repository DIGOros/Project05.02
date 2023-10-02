package bookrecommender;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static String getUserString(String prompt) {
        print(prompt);
        return scanner.nextLine().trim();
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static String recommendBook(int age, String genre) {
        String recommendation = "";

        if (age >= 13 && age <= 16) {
            if (genre.equalsIgnoreCase("detective")) {
                recommendation = "I recommend you read 'Nancy Drew' series by Carolyn Keene.";
            } else {
                recommendation = "I recommend you read 'Percy Jackson' series by Rick Riordan.";
            }
        } else if (age >= 17 && age <= 25) {
            if (genre.equalsIgnoreCase("non-fiction")) {
                recommendation = "I recommend you read 'Sapiens: A Brief History of Humankind' by Yuval Noah Harari.";
            } else {
                recommendation = "I recommend you read 'The Hunger Games' series by Suzanne Collins.";
            }
        } else {
            recommendation = "I recommend you read 'To Kill a Mockingbird' by Harper Lee.";
        }

        return recommendation;
    }

    public static boolean continueDialog() {
        String choice = getUserString("Do you want to continue (Y/N)? ");
        return choice.equalsIgnoreCase("Y");
    }

    public static void main(String[] args) {
        do {
            String name = getUserString("May I know your name? ");
            int age = Integer.parseInt(getUserString("Hello, " + name + "! How old are you? "));
            String genre = getUserString("What is your favorite book genre? ");

            String recommendation = recommendBook(age, genre);
            print(recommendation + "\n");
        } while (continueDialog());

        print("Thank you for using the Book Recommender System!");
    }
}
