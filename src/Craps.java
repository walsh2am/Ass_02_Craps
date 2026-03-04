import java.util.Random;
import java.util.Scanner;

public class Craps {
    static void main(String[] args) {
        Random random = new Random();
        int die1 = 0;//random.nextInt(1,7);
        int die2 = 0; //random.nextInt(1,7);
        int dieTotal;
        int pointSum = 0;
        int rollCount = 0;
        String done = "";
        String trash = "";
        boolean gameOver = false;
        boolean doneYN = false;
        boolean gotEnd = false;

        Scanner in = new Scanner(System.in);

        do { //Outer do-while loop that will keep rerunning the game, dependent on if the user wants to
            gotEnd = false;
            die1 = random.nextInt(1, 7);
            die2 = random.nextInt(1, 7);
            rollCount++;
            dieTotal = die1 + die2;
            System.out.println("For role (" + rollCount + ") Your roles were " + die1 + " and " + die2 + " for a total of: " + dieTotal);
            if (dieTotal == 2 || dieTotal == 3 || dieTotal == 12) {
                do { //inner do-while loop that determines if player wants to play again after crapping out
                    System.out.print("You crapped out with a (" + dieTotal + ")! Game over. Do you want to play again? [Y/N]: ");
                    done = in.nextLine();
                    done = done.toUpperCase();
                    if (done.equals("Y")) {
                        System.out.print("You chose (" + done + "); so you'll play again");
                        gotEnd = true;
                        in.nextLine();
                        dieTotal = 0;
                        pointSum = 0;
                        rollCount = 0;
                    } else if (done.equals("N")) {
                        System.out.print("You chose (" + done + "); game is over!");
                        gotEnd = true;
                        gameOver = true;
                    } else {
                        trash = done;
                        System.out.println("You inputted (" + trash + "); that doesn't answer my question; please try again.");
                    }
                } while (!gotEnd);
            } else if (dieTotal == 7 || dieTotal == 11) {
                do { //inner do-while loop that determines if player wants to play again after winning
                    System.out.print("You won with a natural on a roll of " + dieTotal + "! Do you want to play again? [Y/N]: ");
                    done = in.nextLine();
                    done = done.toUpperCase();
                    if (done.equals("Y")) {
                        System.out.print("You chose (" + done + "); so you'll play again");
                        gotEnd = true;
                        dieTotal = 0;
                        pointSum = 0;
                        rollCount = 0;
                        in.nextLine();
                    } else if (done.equals("N")) {
                        System.out.print("You chose (" + done + "); game is over!");
                        gotEnd = true;
                        gameOver = true;
                    } else {
                        trash = done;
                        System.out.println("You inputted (" + trash + "); that doesn't answer my question; please try again.");
                    }
                } while (!gotEnd);
            } else {
                // Inner else code with do-while loop for if they roll a point sum
                pointSum = dieTotal;
                System.out.println("The Point Sum is now: " + pointSum);
                do {

                    rollCount++;
                    die1 = random.nextInt(1, 7);
                    die2 = random.nextInt(1, 7);
                    dieTotal = die1 + die2;
                    System.out.println("You're trying for the Point Sum of: (" + pointSum + ") on role: (" + rollCount + ") Your roles were " + die1 + " and " + die2 + " for a total of: " + dieTotal);
                    if (dieTotal == 7) {

                        do { //inner do-while loop that determines if player wants to play again after crapping out
                            System.out.print("You crapped out with a roll of: (" + dieTotal + ")! Game over. Do you want to play again? [Y/N]: ");
                            done = in.nextLine();
                            done = done.toUpperCase();
                            if (done.equals("Y")) {
                                System.out.println("You chose (" + done + "); so you'll play again");
                                gotEnd = true;
                                doneYN = true;
                                in.nextLine();
                                dieTotal = 0;
                                pointSum = 0;
                                rollCount = 0;
                            } else if (done.equals("N")) {
                                System.out.print("You chose (" + done + "); game is over!");
                                gotEnd = true;
                                doneYN = true;
                                gameOver = true;
                            } else {
                                trash = done;
                                System.out.println("You inputted (" + trash + "); that doesn't answer my question; please try again.");
                            }
                        } while (!gotEnd);
                    } else if (dieTotal == pointSum) {
                        do { //inner do-while loop that determines if player wants to play again after winning
                            System.out.print("You made the point with " + dieTotal + " and won! Game over. Do you want to play again? [Y/N]: ");
                            done = in.nextLine();
                            done = done.toUpperCase();
                            if (done.equals("Y")) {
                                System.out.println("You chose (" + done + "); so you'll play again");
                                gotEnd = true;
                                doneYN = true;
                                dieTotal = 0;
                                pointSum = 0;
                                rollCount = 0;
                                in.nextLine();
                            } else if (done.equals("N")) {
                                System.out.println("You chose (" + done + "); game is over!");
                                gotEnd = true;
                                doneYN = true;
                                gameOver = true;
                            } else {
                                trash = done;
                                System.out.println("You inputted (" + trash + "); that doesn't answer my question; please try again.");
                            }
                        } while (!gotEnd);
                    }
                    else {
                        System.out.println();
                    }
                } while (!doneYN); // loop for pointSum
            }
            gotEnd = false;
            doneYN = false;
        } while (!gameOver); // end of loop for game
    }
}

