import java.awt.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Croupier{

    public int playerBetAmount = 0;
    public int playerBet = -1;

    public void playerBet(){
        Scanner input = new Scanner(System.in);
        
        while (playerBet == -1) {
            System.out.println("Place you bet on either the player, banker, or a tie (p/b/t)");
            String bet = input.nextLine();
            if (bet.equals("p")||bet.equals("player")) {
                playerBet = 0;
            } else if (bet.equals("b")||bet.equals("banker")){
                playerBet = 1;
            } else if (bet.equals("t")||bet.equals("tie")){
                playerBet = 2;
            } else
                System.out.println("Please choose something to bet on");
        }
        System.out.println("How much do you wish to bet?");
            String betAmount = input.nextLine();
            playerBetAmount = betAmount.value
    }



}