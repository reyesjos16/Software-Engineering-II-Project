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
