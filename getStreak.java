public class getStreak {

    Card card = new Card();

    public int getStreak(Card[] myCards, int cardLimit) {
        int Streak = 0;
        int colourBonus = 0;
        int suitBonus = 0;
        int[] maxStreak = new int[0];
        Card nextToCheck;
        Card index;

        for (int i = 1; i < myCards.length - 1; i++) {
            index = myCards[i];
            nextToCheck = myCards[i + 1];
            if (index.streakCompareTo(nextToCheck) == 1) {
                Streak++;
                if (index.getColour() == nextToCheck.getColour()) {
                    colourBonus = 1;
                    if(index.streakCheckSuit() == nextToCheck.streakCheckSuit()){
                        suitBonus = 1;
                    }
                }
            }
        }
        Streak = Streak + colourBonus + suitBonus;
        return Streak;
    }

}
