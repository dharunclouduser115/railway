import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RailwayWaitingListQueue {

    // Maximum Waiting List Size
    private static final int MAX_WAITING_LIST = 5;

    public static void main(String[] args) {

        Queue<String> waitingList = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n===== RAILWAY WAITING LIST MANAGEMENT =====");
            System.out.println("1. Add Passenger to Waiting List");
            System.out.println("2. Remove Passenger (Ticket Confirmed)");
            System.out.println("3. View Waiting List");
            System.out.println("4. Check List Size");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    if (waitingList.size() < MAX_WAITING_LIST) {
                        System.out.print("Enter Passenger Name: ");
                        String name = sc.nextLine();
                        waitingList.add(name);
                        System.out.println("✔ Passenger added to waiting list.");
                    } else {
                        System.out.println("❌ Waiting List Full! No more passengers allowed.");
                    }
                    break;

                case 2:
                    if (!waitingList.isEmpty()) {
                        String removed = waitingList.poll();
                        System.out.println("✔ Passenger removed: " + removed);
                    } else {
                        System.out.println("❌ No passengers in waiting list.");
                    }
                    break;

                case 3:
                    if (!waitingList.isEmpty()) {
                        System.out.println("\nCurrent Waiting List: ");
                        for (String passenger : waitingList) {
                            System.out.println("- " + passenger);
                        }
                    } else {
                        System.out.println("Waiting List is empty.");
                    }
                    break;

                case 4:
                    System.out.println("Total passengers in waiting list: " + waitingList.size());
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again!");
            }

        } while (choice != 5);

        sc.close();
    }
}