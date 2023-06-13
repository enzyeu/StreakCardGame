public class highScoreTable {
    String[] playerNames = new String[5];
    int[] highScoreTable = new int[5];

    public void manageHighScoreTable(String playerName, int playerScore){
        for (int i = 0; i < highScoreTable.length; i++){
            System.out.println("Check 1");
            // Check if the arrays are empty
            if(playerNames[i] == null){
                // Adding the first element
                playerNames[i] = playerName;
                highScoreTable[i] = playerScore;
                break;
            }
            // If not empty find where it slots in
            else if(playerScore > highScoreTable[i]){
                int temp = highScoreTable[i];
                String tempName = playerNames[i];
                highScoreTable[i] = playerScore;
                playerNames[i] = playerName;
                manageTableChanges(tempName,temp,i);
            }
        }
    }

    public void manageTableChanges(String tempName, int temp, int startOfChanges){
        for (int i = startOfChanges; i < highScoreTable.length; i++){
            System.out.println("Check 2");
            String tempName2 = playerNames[i + 1];
            int temp2 = highScoreTable[i + 1];
            highScoreTable[i] = temp;
            playerNames[i] = tempName;
            tempName = tempName2;
            temp2 = temp;
        }
    }

    public void displayTable(){
        for (int i = 0; i < highScoreTable.length; i++){
            System.out.println(playerNames[i] + " with a score of " + highScoreTable[i]);
        }
        Menu menu = new Menu();
        Menu Menu;
    }
}
