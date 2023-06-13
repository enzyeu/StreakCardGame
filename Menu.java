import java.util.Scanner;


public class Menu {
    String cardLimitInput;
    int cardLimit;
    Menu(){
        System.out.println("\nStreak\n");
        System.out.println("----------------");
        System.out.println("1. Single Player game");
        System.out.println("2. 2-Player game");
        System.out.println("3. View Hi-Score Table");
        System.out.println("4. Exit");

        Scanner myInput = new Scanner(System.in);
        System.out.println("Enter Choice: ");

        String menuChoice = myInput.nextLine();
        checkUserChoice(menuChoice);

    }

    public void runMenu(){

    }

    public void checkUserChoice(String menuChoice){
        String userChoice = menuChoice;
        if ("1".equalsIgnoreCase(userChoice)){
            Game game = new Game();
            game.singlePlayerGame();
        }

        if ("2".equalsIgnoreCase(userChoice)){

        }

        if ("3".equalsIgnoreCase(userChoice)){
            highScoreTable table = new highScoreTable();
            table.displayTable();
            Menu Menu;
        }

        if ("4".equalsIgnoreCase(userChoice)){
            System.exit(0);
        }

        else{
            // this(Menu);
        }

    }


}
