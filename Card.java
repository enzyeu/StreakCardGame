
import java.util.Random;
import java.util.Scanner;

public class Card implements Comparable<Card>{

    private final int RANK, SUIT;
    private String face;
    private String value;
    private static final Random Generator = new Random();

    public static String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace"};
    public static String[] SUITS = {"Clubs","Diamonds","Hearts","Spades"};

    public Card(){
        RANK = Generator.nextInt(RANKS.length);
        SUIT = Generator.nextInt(SUITS.length);
    }

    public String getRank(){
        return RANKS[RANK];
    }

    public String getSuit(){
        return SUITS[SUIT];
    }

    public int getRankValue(){
        return RANK;
    }

    @Override
    public String toString(){
        return getRank() + " of " + getSuit();
    }

    @Override
    public int compareTo(Card otherCard){
        if(this.getRankValue() > otherCard.getRankValue()) return 1;
        else if(this.getRankValue() < otherCard.getRankValue()) return -1;
        else return 0;
    }

    public int streakCompareTo(Card otherCard){
        if(this.getRankValue() == otherCard.getRankValue() - 1) return 1;
        if(this.getRankValue() != otherCard.getRankValue()) return -1;
        else return 0;
    }

    public String getColour(){
        if(getSuit() == "Diamonds" || getSuit() == "Hearts"){
            return "Red";
        } else{
            return "Black";
        }
    }

    public String streakCheckSuit(){
        if(getSuit() == "Diamonds" || getSuit() == "Diamonds"){
            return "Diamonds";
        }
        else if(getSuit() == "Hearts" || getSuit() == "Hearts"){
            return "Hearts";
        }
        if(getSuit() == "Spades" || getSuit() == "Spades"){
            return "Spades";
        }
        if(getSuit() == "Clubs" || getSuit() == "Clubs"){
            return "Clubs";
        }
        else{
            return null;
        }
    }



    public int getCardLimit(){
        Scanner myInput = new Scanner(System.in);
        System.out.println("How many cards do you want to play with (5-10)?: ");

        String cardLimitInput = myInput.nextLine();
        if (Integer.parseInt(cardLimitInput) > 10) {
            System.out.println("Cannot have more than 10 cards. ");
            System.exit(1);
        }
        if (Integer.parseInt(cardLimitInput) < 5) {
            System.out.println("Cannot have less than 5 cards. ");
            System.exit(1);
        }

        return Integer.parseInt(cardLimitInput);
    }

    public String getName(){
        Scanner myInput = new Scanner(System.in);
        System.out.println("Enter Player name: ");
        return myInput.nextLine();
    }

    public int getCardToChange(int cardLimit, int changesMade){
        Scanner myInput = new Scanner(System.in);
        System.out.println("\n" + changesMade + " of 5 : Choose card to change or X to exit > ");
        String cardToChangeInput = myInput.nextLine();

        if("x".equalsIgnoreCase(cardToChangeInput)){
            return 10;
        }

        if (Integer.parseInt(cardToChangeInput) > cardLimit) {
            System.out.println("Invalid card selected");
            getCardToChange(cardLimit, changesMade);
        }

        if (Integer.parseInt(cardToChangeInput) < 0) {
            System.out.println("Invalid card selected");
            getCardToChange(cardLimit, changesMade);
        }

        changesMade += 1;
        return Integer.parseInt(cardToChangeInput);
    }


}
