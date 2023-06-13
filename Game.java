
public class Game {
    public int gameCardLimit;
    String player1Name;
    String player2Name;
    Card myCards[];
    Card cardsRemoved[];
    Game(){

    }

    public void singlePlayerGame(){
        Card card = new Card();
        gameReplay replay = new gameReplay();

        player1Name = card.getName();
        gameCardLimit = card.getCardLimit();
        replay.getCardLimitReplay(gameCardLimit);

        myCards = new Card[gameCardLimit];
        cardsRemoved = new Card[gameCardLimit];

        playerHand hand = new playerHand();
        System.out.println("\n" + player1Name);
        myCards = hand.getPlayerHand(gameCardLimit);

        getStreak streak = new getStreak();
        int currentStreak = streak.getStreak(myCards,gameCardLimit);
        System.out.println("\nMax Streak is " + currentStreak);
        int amountOfChanges = 0;
        for (int i = 0; i < 5; i++){
            int cardToChange = card.getCardToChange(gameCardLimit, i);
            if (cardToChange == 10){
                break;
            }
            else{
                cardsRemoved[i] = myCards[cardToChange];
                replay.addDeck(myCards);
                myCards = hand.changeCard(cardToChange,myCards);
                myCards = hand.sortHand(myCards);
                amountOfChanges++;
                currentStreak = streak.getStreak(myCards,gameCardLimit);
                System.out.println("\nMax Streak is " + currentStreak);
            }
        }
        int finalScore = currentStreak;
        System.out.println("\n \n**********");
        System.out.println("Streak value is " + finalScore);
        System.out.println("**********");
        highScoreTable table = new highScoreTable();
        table.manageHighScoreTable(player1Name,finalScore);

        if (amountOfChanges == 0){
            System.out.println("No changes made, replay not available\n\n");
            Menu menu = new Menu();
            Menu Menu;
        }
        boolean seeReplay = false;
        seeReplay = replay.seeReplay();

        if (seeReplay){
            replay.generateReplay(amountOfChanges, player1Name, cardsRemoved, gameCardLimit);
        }
        Menu menu = new Menu();
        Menu Menu;

    }

    public void twoPlayerGame(){
        int player1Score;
        int player2Score;

        Card card = new Card();
        player1Name = card.getName();
        gameCardLimit = card.getCardLimit();

        myCards = new Card[gameCardLimit];

        playerHand hand = new playerHand();
        System.out.println("\n" + player1Name);
        myCards = hand.getPlayerHand(gameCardLimit);

        getStreak streak = new getStreak();
        int currentStreak = streak.getStreak(myCards,gameCardLimit);
        System.out.println("\nMax Streak is " + currentStreak);
        int amountOfChanges = 0;
        for (int i = 0; i < 5; i++){
            int cardToChange = card.getCardToChange(gameCardLimit, i);
            if (cardToChange == 10){
                break;
            }
            else{
                myCards = hand.changeCard(cardToChange,myCards);
                myCards = hand.sortHand(myCards);
                amountOfChanges++;
                currentStreak = streak.getStreak(myCards,gameCardLimit);
                System.out.println("\nMax Streak is " + currentStreak);
            }
        }
        int finalScore = currentStreak;
        System.out.println("\n \n**********");
        System.out.println("Streak value is " + finalScore);
        System.out.println("**********");
        highScoreTable table = new highScoreTable();
        table.manageHighScoreTable(player1Name,finalScore);



    }

}
