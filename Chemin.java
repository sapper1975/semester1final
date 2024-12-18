import java.awt.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Chemin {

    private Random r = new Random();
    public int playerHandValue = 0;
    public int bankerHandValue = 0;
    public int playerThirdCardValue = -1;
    public int winner = -1;
    

    Croupier j = new Croupier();

    ArrayList<Card>Cards = new ArrayList<Card>(); {
        {
            Card aCardObject = new Card("Ace", 1);
            Cards.add(aCardObject);
            Card a2 = new Card("Two", 2);
            Cards.add(a2);
            Card a3 = new Card("Three", 3);
            Cards.add(a3);
            Card a4 = new Card("Four", 4);
            Cards.add(a4);
            Card a5 = new Card("Five", 5);
            Cards.add(a5);
            Card a6 = new Card("Six", 6);
            Cards.add(a6);
            Card a7 = new Card("Seven", 7);
            Cards.add(a7);
            Card a8 = new Card("Eight", 8);
            Cards.add(a8);
            Card a9 = new Card("Nine", 9);
            Cards.add(a9);
            Card a10 = new Card("Ten", 0);
            Cards.add(a10);
            Card a11 = new Card("Jack", 0);
            Cards.add(a11);
            Card a12 = new Card("Queen", 0);
            Cards.add(a12);
            Card a13 = new Card("King", 0);
            Cards.add(a13);
        }
    }


    ArrayList<Card>playerHand = new ArrayList<Card>(); {
        {
            int z = r.nextInt(Cards.size());
            Card firstPlayerCard = Cards.get(z);
            playerHand.add(firstPlayerCard);
            z = r.nextInt(Cards.size());
            Card secondPlayerCard = Cards.get(z);
            playerHand.add(secondPlayerCard);
            playerHandValue = playerHandValueTwo();
        }
    }

    ArrayList<Card>bankerHand = new ArrayList<Card>(); {
        {
            int z = r.nextInt(Cards.size());
            Card firstBankerCard = Cards.get(z);
            bankerHand.add(firstBankerCard);
            z = r.nextInt(Cards.size());
            Card secondBankerCard = Cards.get(z);
            bankerHand.add(secondBankerCard);
            bankerHandValue = bankerHandValueTwo();
        }
    }

    public int playerHandValueTwo(){
        int hand = playerHand.get(0).getValue() + playerHand.get(1).getValue();
        if (hand > 9)
            hand = hand -10;
        return hand;
    }

    public int bankerHandValueTwo(){
        int hand = bankerHand.get(0).getValue() + bankerHand.get(1).getValue();
        if (hand > 9)
            hand = hand -10;
        return hand;
    }

    

    public int playerHandValueThree(){
        int hand = playerHand.get(0).getValue() + playerHand.get(1).getValue() + playerHand.get(2).getValue();
        if (hand > 9)
            hand = hand -10;
        return hand;
    }

    public int bankerHandValueThree(){
        int hand = bankerHand.get(0).getValue() + bankerHand.get(1).getValue() + bankerHand.get(2).getValue();
        if (hand > 9)
            hand = hand -10;
        return hand;
    }
    
    public String playerHandFacesTwo(){
        return "You have a " + playerHand.get(0).readCard() + " and a " + playerHand.get(1).readCard() + ", which is worth " + playerHandValueTwo();
    }

    public String bankerHandRevealThree(){
        return "The banker has a " + bankerHand.get(0).readCard() + " and " + bankerHand.get(1).readCard() + ", which is worth " + bankerHandValueTwo();
    }

    public boolean naturalCheck () {
        if (playerHandValueTwo() >= 8 || bankerHandValueTwo() >=8) {
            System.out.println("Natural");
            playerHandFacesTwo();
            System.out.println(bankerHandRevealThree());
            return true;
        } else {
            return false;
        }

    }

    public void winCondition() {
        if (playerHandValue > bankerHandValue) {
            winner = 0;
            System.out.println("Player wins with a hand worth " + playerHandValue + " against the banker hand worth " + bankerHandValue);
        } else if (bankerHandValue > playerHandValue) {
            winner = 1;
            System.out.println("Banker wins with a hand worth " + bankerHandValue + " against the player hand worth " + playerHandValue);
        } else{ 
            winner = 2;
            System.out.println("Egalite, tie hand.");
        }
        j.winConditionBet(winner);
        
    }

    public void playerThirdCard(){
        int t = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want a third card? (y/n)");
        String userInput = input.nextLine();
        if (userInput.equals("y")||userInput.equals("yes")) {
            t = r.nextInt(Cards.size());
            playerHand.add(Cards.get(t));
            input.close();
            System.out.println("You were given a " + playerHand.get(2).readCard() + " bringing your hand to " + playerHandValueThree());
            playerHandValue = playerHandValueThree();
            playerThirdCardValue = playerHand.get(2).getValue();
        }
        else if (userInput.equals("n")||userInput.equals("no")) {
            System.out.println("The player does not take a third card");
        }


    }

    public void bankerThirdCard(){
        int t = 0;
        t = r.nextInt(Cards.size());
        if (bankerHandValue <= 2) {
            bankerHand.add(Cards.get(t));
            System.out.println("The banker takes a third card");
            bankerHandValue = bankerHandValueThree();
        }
        else if (bankerHandValue == 3 && playerThirdCardValue != 8) {
            bankerHand.add(Cards.get(t));
            System.out.println("The banker takes a third card");
            bankerHandValue = bankerHandValueThree();
        }
        else if (bankerHandValue == 4 && (playerThirdCardValue >=2 && playerThirdCardValue <=7)) {
            bankerHand.add(Cards.get(t));
            System.out.println("The banker takes a third card");
            bankerHandValue = bankerHandValueThree();
        }
        else if (bankerHandValue == 5 && (playerThirdCardValue >=4 && playerThirdCardValue <=7)) {
            bankerHand.add(Cards.get(t));
            System.out.println("The banker takes a third card");
            bankerHandValue = bankerHandValueThree();
        }
        else if (bankerHandValue == 6 && (playerThirdCardValue >=6 && playerThirdCardValue <=7)) {
            bankerHand.add(Cards.get(t));
            System.out.println("The banker takes a third card");
            bankerHandValue = bankerHandValueThree();
        }
        else {
            System.out.println("The banker does not take a third card");
        }
        
    }

public static void main(String[] args) {
    Chemin deck = new Chemin();
    boolean play = true;
    Scanner input = new Scanner(System.in);

    while (play == true) {
        
        System.out.println("Do you want to play a round? (y/n)");
        String userInput = input.nextLine();
            if (userInput.equals("y")||userInput.equals("yes")){
                System.out.println(deck.j.readPlayerChipsAmount());
                deck.j.playerBet();
                System.out.println(deck.playerHandFacesTwo());
                if (deck.naturalCheck()){
                    deck.winCondition();
                } else {
                deck.playerThirdCard();
                deck.bankerThirdCard();
                deck.winCondition();
                }
            } else if (userInput.equals("n")||userInput.equals("no"))
                play = false;
            else
                System.out.println("Unidentified response.");
            
        }
        System.exit(0);
    }
}
//i feel like bookclub shouldnt make the list
// at the rate we're going??