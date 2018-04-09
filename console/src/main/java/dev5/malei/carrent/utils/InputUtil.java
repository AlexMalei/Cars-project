package dev5.malei.carrent.utils;

import java.util.Scanner;

public class InputUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputCarId() {
        do {
            try {
                OutputUtil.outputLine("Input car id");
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                OutputUtil.outputLine("Invalid car id, try again\n");
            }
        } while (true);
    }

    public static int inputUserId() {
        do {
            try {
                OutputUtil.outputLine("Input user id");
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                OutputUtil.outputLine("Invalid user id, try again\n");
            }
        } while (true);
    }

    public static int inputCountStars() {
        do {
            try {
                OutputUtil.outputLine("Input count stars");
                int countStars = Integer.parseInt(scanner.next());
                if (countStars >= 1 && countStars <= 5) {
                    return countStars;
                } else {
                    OutputUtil.outputLine("Invalid count stars");
                }
            } catch (NumberFormatException e) {
                OutputUtil.outputLine("Invalid count stars, try again\n");
            }
        } while (true);
    }

    public static String inputComment() {
        OutputUtil.outputLine("Input comment");
        return inputLine();
    }

    public static Integer inputNumber() {
        return Integer.parseInt(scanner.next());
    }

    public static String inputLine() {
        String inputString = scanner.nextLine();
        if (!inputString.isEmpty()) {
            return inputString;
        } else {
            return scanner.nextLine();
        }
    }


    public static int inputRentInfoId() {
        do {
            try {
                OutputUtil.outputLine("Input rent info id");
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                OutputUtil.outputLine("Invalid rent info id, try again\n");
            }
        } while (true);
    }
}
