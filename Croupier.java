import java.awt.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Croupier{

    public int playerBetAmount = 0;
    public boolean playerBet = false;
    public int bankerBetAmount = 0;
    public int chips = 500;

    private Random r = new Random();

    public void playerBet(){
        playerBet = false;
        Scanner input = new Scanner(System.in);

        bankerBetAmount = r.nextInt(401);
        System.out.println("The banker has wagered " + bankerBetAmount);
        
        while (playerBet == false) {
            System.out.println("Do you wish to wager bank? (y/n)");
            String bet = input.nextLine();
            if (bet.equals("y")||bet.equals("yes")) {
                playerBetAmount = bankerBetAmount;
                playerBet = true;
            } else if (bet.equals("n")||bet.equals("no")){
                System.out.println("How much do you wish to bet?");
                String betAmount = input.nextLine();
                if (Integer.valueOf(betAmount) <= chips && Integer.valueOf(betAmount) > 0) {
                    playerBetAmount = Integer.valueOf(betAmount);
                    playerBet = true;
                } else {
                    System.out.println("This is not an acceptable value");
                }
            } else
                System.out.println("Please choose something to bet on");
            System.out.println("The player has wagered " + playerBetAmount);
        }
        
            //hahaha i am evilllllllllllllllll
    }

    // public boolean betAmountChecker(int playerChips, int betAmount) {
    //     if (betAmount <= playerChips && betAmount > 0)
    //         return true;
    //     return false;
         
    // }

    public void winConditionBet(int winner){
        if (winner == 0) {
            chips = chips + 2*playerBetAmount;
            playerBetAmount = 0;
            System.out.println("The player wins " + 2*playerBetAmount + " chips");
        } else if (winner == 1) {
            chips = chips - playerBetAmount;
            System.out.println("The player loses" + playerBetAmount + " chips");
            playerBetAmount = 0;
        } else if (winner == 2) {
            System.out.println(playerBetAmount + " chips are retained for the next hand");
             
        }
        
    }



}