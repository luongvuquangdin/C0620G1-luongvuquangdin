package casestudy.thu_vien.controllers;

import casestudy.thu_vien.models.Request;

import java.util.Scanner;

public class DisplayMain {
    private static Scanner scanner=new Scanner(System.in);
    public static void menu() {
        while (true) {
            String action = null;
            do {
                System.out.print("Action: ");
                action = scanner.nextLine();
            } while (!action.matches("^((lookup)|(define)|(drop)|(export))\\s\\D+$"));
            String[] string = action.split("\\s");
            Request request = new Request();
            request.setAction(string[0]);
            request.setKeyword(string[1]);
            request.checkAction();
        }
    }
}


