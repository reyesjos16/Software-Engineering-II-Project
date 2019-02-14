import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.*;
import java.net.URL;
import javax.imageio.ImageIO;

public class ChessGUI 
{

    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JButton[][] chessBoardSquares = new JButton[8][8];
    private Image[][] chessPieceImages = new Image[2][6];
    private JPanel chessBoard;
   
    private static final String COLS = "ABCDEFGH";
    public static final int QUEEN = 0, KING = 1,
            ROOK = 2, KNIGHT = 3, BISHOP = 4, PAWN = 5;
    public static final int[] STARTING_ROW = {
        ROOK, KNIGHT, BISHOP, KING, QUEEN, BISHOP, KNIGHT, ROOK
    };

    public static final int red = 0, pink = 1;

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

        tools.add(new JButton("Save")); 
        tools.add(new JButton("Restore")); 
        tools.addSeparator();
        tools.add(new JButton("Resign"));  
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
                        c.getHeight()>d.getHeight()) {
                    prefSize = c.getSize();
                } else {
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
                new LineBorder(Color.red)
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
        for (int ii = 0; ii < chessBoardSquares.length; ii++) {
            for (int jj = 0; jj < chessBoardSquares[ii].length; jj++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                if ((jj % 2 == 1 && ii % 2 == 1)
                        
                        || (jj % 2 == 0 && ii % 2 == 0)) {
                    b.setBackground(Color.pink);
                } else {
                    b.setBackground(Color.red);
                }
                chessBoardSquares[jj][ii] = b;
            }
        }

        /*
         * fill the chess board
         */
        chessBoard.add(new JLabel(""));
        
        for (int ii = 0; ii < 8; ii++) 
        {
            chessBoard.add(
                    new JLabel(COLS.substring(ii, ii + 1),
                    SwingConstants.CENTER));
        }
        
        for (int ii = 0; ii < 8; ii++) 
        {
            for (int jj = 0; jj < 8; jj++) 
            {
                switch (jj) 
                {
                    case 0:
                        chessBoard.add(new JLabel("" + (9-(ii + 1)),
                                SwingConstants.CENTER));
                    default:
                        chessBoard.add(chessBoardSquares[jj][ii]);
                }
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

                JFrame f = new JFrame("Eevil Chess");
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