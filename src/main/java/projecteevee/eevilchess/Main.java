package projecteevee.eevilchess;

/*
 *	Main handles running the Eevil Chess
 *	Authors: Team Eevee
 *
 * */

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        // To be replaced by checkmate or threatened function later
        boolean checkmate = false;
        Scanner keyboard = new Scanner(System.in);

        // Game is being played
        while(!checkmate) {
            Board newboard = new Board(8, 8);
            newboard.populateTableNormal(new Player("white"), new Player("black"));
            System.out.println(newboard.getBoardJSON().toString(4));
            // Temporary check for testing. Enter 1 to break the loop.
            System.out.println("Continue?\n");
            int check = keyboard.nextInt();
            if(check == 1) {
                checkmate = true;
            }

            // Player turn code goes here

        }
    }
}
