

import java.awt.*; 

import java.applet.*; 

  
// Extends Applet Class 

public class Chessboard extends Applet { 

  

    private static final long serialVersionUID = 1L;
    static int N = 10;

  

    // Use paint() method 

    public void paint(Graphics g) 

    { 

        int x, y; 

        for (int row = 0; row < N; row++) { 

  

            for (int col = 0; col < N; col++) { 

  

                // Set x coordinates of rectangle 

                // by 20 times 

                x = row * 90; 

  

                // Set y coordinates of rectangle 

                // by 20 times 

                y = col * 80; 

  

                // Check whether row and column 

                // are in even position 

                // If it is true set Black color 

                if ((row % 2 == 0) == (col % 2 == 0)) 

                    g.setColor(Color.RED); 

                else

                    g.setColor(Color.PINK); 

  

                // Create a rectangle with 

                // length and breadth of 20 

                g.fillRect(x, y, 90, 80); 

            } 

        } 

    } 
} 