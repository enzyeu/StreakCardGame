import java.util.Arrays;
import java.util.Scanner;

public class gameReplay{
    gameReplay(){

    }
    Game game = new Game();
    public int cardLimit;
    int i = 0;
    Queue<String> queue = new Queue<String>();

 /*   public void addChangedCard(Card changedCard, Card[] cardsRemoved){
        System.out.println(cardsRemoved.length);
        for(int i = 0; i < cardsRemoved.length; i++){
            cardsRemoved[i] = changedCard;
            System.out.println(cardsRemoved[i] + "Test");
        }
    } */

    public void addDeck(Card[] myDeck){
        for(int i = 0; i < myDeck.length; i++){
            queue.enqueue(String.valueOf(myDeck[i]));
        }
    }
    public boolean seeReplay(){
        Scanner myInput = new Scanner(System.in);
        System.out.println("See replay? (y/n)");

        String replayChoice = myInput.nextLine();
        if ("Y".equalsIgnoreCase(replayChoice)){
            return true;
        }else if("N".equalsIgnoreCase(replayChoice)){
            return false;
        }
        else{
            System.out.println("Invalid option, try again");
            seeReplay();
        }
        return false;
    }

    public void generateReplay(int amountOfChanges, String player1Name, Card[] cardsRemoved, int gameCardLimit){
        System.out.println(cardsRemoved.length);
        for (int i = 0; i < amountOfChanges; i++){
            System.out.println(player1Name);
            for(int j = 0; j < gameCardLimit; j++){
                System.out.println(queue.getFront());
                queue.dequeue();
            }
            System.out.println("Selection was " + cardsRemoved[i]);
            Scanner myInput = new Scanner(System.in);
            System.out.print("\nPress any key to continue . . . \n");
            myInput.nextLine();

        }


    }

    public void getCardLimitReplay(int gameCardLimit){
        cardLimit = gameCardLimit;
    }



}
