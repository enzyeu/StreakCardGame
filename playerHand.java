public class playerHand {
    
    playerHand() {

    }

    public Card[] getPlayerHand(int cardLimit){
        Card myCards[] = new Card[cardLimit];
        for (int i = 0; i < cardLimit; i++){
            myCards[i] = new Card();
        }
        myCards = sortHand(myCards);
        return myCards;
    }
    public Card[] sortHand(Card[] myCards){
        Card nextToInsert;
        int index;

        for(int i = 0; i < myCards.length; i++){
            nextToInsert = myCards[i];

            index = i - 1;
            while(index >= 0 && myCards[index].compareTo(nextToInsert) > 0){
                myCards[index + 1] = myCards[index];
                index--;
            }
            myCards[index + 1] = nextToInsert;
        }

        for(int i = 0; i < myCards.length; i++){
            System.out.println(i + " : " +myCards[i]);
        }
        return myCards;
    }

    public Card[] changeCard(int positionOfChange, Card[] myCards){
        Card newCard = new Card();
        Card[] originalDeck = new Card[myCards.length];
        boolean madeChange = false;

        for (int i = 0; i < myCards.length; i++){
            if(i == positionOfChange){
                myCards[i] = newCard;
                madeChange = true;
                break;
            }
        }

        if (madeChange = true){

            return myCards;
        }

        else{
            System.out.println("Unable to make change");
            return null;
        }
    }

}
