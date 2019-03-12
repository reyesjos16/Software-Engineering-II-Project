
package mychess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ChessGUI {

    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JButton[][] chessBoardSquares = new JButton[8][8];
    
    private Image[][] chessPieceImages = new Image[2][6];
    private JPanel chessBoard;
    
    public static final String wrk="white_rook.png", brk="black_rook.png", wbs="white_bishop.png",bbs="black_bishop.png",
                    whr="white_knight.png", bhr="black_knight.png",wp="white_pawn.png",bp="black_pawn.png",wk="white_king.png",
                    bk="black_king.png", wq="white_queen.png",bq="black_queen.png"; 
    private static final String COLS = "ABCDEFGH";
    public static final int QUEEN = 0, KING = 1,
            ROOK = 2, KNIGHT = 3, BISHOP = 4, PAWN = 5;
    public static final int[] STARTING_ROW = {
        ROOK, KNIGHT, BISHOP, KING, QUEEN, BISHOP, KNIGHT, ROOK
    };
    public static final int BLACK = 0, WHITE = 1;

    
    ChessGUI() 
    {
        initializeGui();
    }

    public final void initializeGui() 
    {
        
        // set up the main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        Action newGameAction = new AbstractAction("New") 
        {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                setupNewGame();
            }
        };
        tools.add(newGameAction);
        tools.add(new JButton("Save")); // TODO - add functionality!
        tools.add(new JButton("Restore")); // TODO - add functionality!
        tools.addSeparator();
        tools.add(new JButton("Resign")); // TODO - add functionality!
        tools.addSeparator();

        gui.add(new JLabel("?"), BorderLayout.LINE_START);

        chessBoard = new JPanel(new GridLayout(0, 9)) 
        {

            @Override
            public final Dimension getPreferredSize() 
            {
                Dimension d = super.getPreferredSize();
                Dimension prefSize = null;
                Component c = getParent();
                if (c == null) {
                    prefSize = new Dimension(
                            (int)d.getWidth(),(int)d.getHeight());
                } else if (c!=null &&
                        c.getWidth()>d.getWidth() &&
                        c.getHeight()>d.getHeight()) 
                {
                    prefSize = c.getSize();
                } 
                else 
                {
                    prefSize = d;
                }
                int w = (int) prefSize.getWidth();
                int h = (int) prefSize.getHeight();
                // the smaller of the two sizes
                int s = (w>h ? h : w);
                return new Dimension(s,s);
            }
        };
        chessBoard.setBorder(new CompoundBorder(
                new EmptyBorder(8,8,8,8),
                new LineBorder(Color.BLACK)
                ));
        // Set the BG to be ochre
        Color ochre = new Color(204,119,34);
        chessBoard.setBackground(ochre);
        JPanel boardConstrain = new JPanel(new GridBagLayout());
        boardConstrain.setBackground(ochre);
        boardConstrain.add(chessBoard);
        gui.add(boardConstrain);

        // create the chess board squares
        Insets buttonMargin = new Insets(0, 0, 0, 0);
        for (int ii = 0; ii < chessBoardSquares.length; ii++) 
        {
            for (int jj = 0; jj < chessBoardSquares[ii].length; jj++) 
            {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
               
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB));
                
                b.setIcon(icon);
                b.setPreferredSize(new Dimension(60,60));
                if ((jj % 2 == 1 && ii % 2 == 1)
                      
                        || (jj % 2 == 0 && ii % 2 == 0)) 
                {
                    b.setBackground(Color.PINK);
                } else {
                    b.setBackground(Color.BLUE);
                }
                chessBoardSquares[jj][ii] = b;
            }
        }

        /*
         * fill the chess board
         */
        chessBoard.add(new JLabel(""));
        // fill the top row
        for (int ii = 0; ii < 8; ii++) 
        {
            chessBoard.add(
                    new JLabel(COLS.substring(ii, ii + 1),
                    SwingConstants.CENTER));
        }
        // fill the black non-pawn piece row
        for (int ii = 0; ii < 8; ii++) 
        {
            for (int jj = 0; jj < 8; jj++) 
            {
                switch (jj) {
                    case 0:
                        chessBoard.add(new JLabel("" + (9-(ii + 1)),
                                SwingConstants.CENTER));
                    default:
                        chessBoard.add(chessBoardSquares[jj][ii]);
                }
            }
        }
    }
     private final void setupNewGame() 
     {
            String P;
        for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
			{	
                            P = null;
				if(i==0&&j==0)
					P=brk;
				else if(i==0&&j==7)
					P=brk;
				else if(i==7&&j==0)
					P=wrk;
				else if(i==7&&j==7)
					P=wrk;
				else if(i==0&&j==2)
					P=bbs;
				else if (i==0&&j==5)
					P=bbs;
				else if(i==7&&j==2)
					P=wbs;
				else if (i==7&&j==5)
					P=wbs;
				else if(i==0&&j==1)
					P=bhr;
				else if (i==0&&j==6)
					P=bhr;
				else if(i==7&&j==1)
					P=whr;
				else if(i==7&&j==6)
					P=whr;
				else if(i==0&&j==3)
					P=bk;
				else if(i==0&&j==4)
					P=bq;
				else if(i==7&&j==3)
					P=wk;
				else if(i==7&&j==4)
					P=wq;
				else if(i==1)
                                        P=bp;
				else if(i==6)
					P=wp;
                                
                                     try {
    Image img = ImageIO.read(getClass().getResource(P));
     Image newimg = img.getScaledInstance( 40, 40,  java.awt.Image.SCALE_SMOOTH ) ;  

    chessBoardSquares[j][i].setIcon(new ImageIcon(newimg));
  } 
                                     catch (Exception ex) 
  {
    System.out.println(ex);
  }
        }
        
			}
    
		

    public final JComponent getGui() 
    {
        return gui;
    }
    public static void main(String[] args) 
    {
        Runnable r = new Runnable() 
        {

            @Override
            public void run() 
            {
                ChessGUI cg = new ChessGUI();

                JFrame f = new JFrame("ChessChamp");

                f.add(cg.getGui());
                
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.pack();
                
                f.setMinimumSize(f.getSize());
                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}