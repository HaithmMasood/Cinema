import java.util.Scanner;

public class Cinema {

    public static void cinema() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scan.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int cols = scan.nextInt();

        int totalSeats = rows * cols;

        boolean t = true;

        String[][] array = new String[rows][cols];
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                array[row][col] = "S ";
            }
        }

        System.out.println("");

        int purchasedTicket = 0;
        double percentageOF_PT = 0;
        int currentIncome = 0;
        int totalIncome = 0;
        int frontRows = rows / 2;
        int backRows = rows - frontRows ;

        if (totalSeats <= 60){
            totalIncome = totalSeats * 10;

        }else{
            totalIncome = (frontRows * cols *  10) + (backRows * cols * 8);
        }


        do {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");


            String choice = scan.next();
            System.out.println("");

            if (choice.equalsIgnoreCase("1")){
                System.out.println("Cinema:");
                System.out.print("  ");
                for (int i = 1; i <= cols; i++) {
                    System.out.print(i + " ");
                }
                System.out.println();
                for (int row = 0; row < array.length; row++){
                    System.out.print((row + 1) + " ");
                    for (int col = 0; col < array[row].length; col++){
                        System.out.print(array[row][col]);
                    }
                    System.out.println("");
                }
                System.out.println("");


            } else if(choice.equalsIgnoreCase("2")){
                boolean correctInput = false;

                while (!correctInput) {
                    System.out.println("Enter a row number:");
                    int rowToBuy = scan.nextInt() - 1;
                    int validRow = rowToBuy + 1;

                    System.out.println("Enter a seat number in that row:");
                    int colToBuy = scan.nextInt() - 1;
                    int validCol = colToBuy + 1;

                    if (validRow <= rows && validCol<= cols){
                        if (rowToBuy < rows && colToBuy < cols && array[rowToBuy][colToBuy].equals("S ")) {
                            correctInput = true;

                            int ticketPrice;

                            if (totalSeats <= 60) {
                                ticketPrice = 10;
                                totalIncome = ticketPrice * totalSeats;
                            } else {

                                if (rowToBuy < frontRows) {
                                    ticketPrice = 10;

                                } else {
                                    ticketPrice = 8;
                                }
                            }

                            System.out.println("Ticket price: $" + ticketPrice + "\n");
                            array[rowToBuy][colToBuy] = "B ";
                            ++purchasedTicket;
                            percentageOF_PT = ((double) purchasedTicket/totalSeats) * 100;
                            currentIncome += ticketPrice;

                        } else {
                            System.out.println("\nThat ticket has already been purchased!\n");
                        }
                    }else{
                        System.out.println("\nWrong input!\n");
                    }
                }


            } else if(choice.equalsIgnoreCase("0")){
                t = false;


            } else if (choice.equalsIgnoreCase("3")) {
                System.out.println("Number of purchased tickets: " + purchasedTicket);
                System.out.println(String.format("Percentage: %.2f%%", percentageOF_PT));
                System.out.println("Current income: $" + currentIncome);
                System.out.println("Total income: $" + totalIncome + "\n");

            }
        } while(t);
    }
}
