/* 
 * The King is the most important piece on the chess board.
 * This piece moves one square in any direction.
 * If it is placed in check by an opponent's piece, the King is threatened with capture.
 * The player must then move the King out of check.
 * Failure to do so leads to CheckMate and end of game.
 */
package projecteevee.eevilchess;

import java.util.ArrayList;

public class King extends Piece {
    // TODO: Define special behavior for King
    King(int x, int y, Player p, Board b) {
        super("king", p, b);
        this.setXcoordinate(x);
        this.setYcoordinate(y);
    }
    
    public void capture() {}
    
    public boolean captured() {return false;}
    
    public Boolean isThreatened() {
        /* isThreatened() returns true if the King is in check,
         * and false otherwise.
         */
        
         //TODO: How is this to be implemented? Should we use an Observer pattern?
         return false;
    }

    private boolean isCheck(Tile t)
    {
        //TODO: returns true if given tile will put king in check
        return false;
    }

    // ( 0, 1)
    // ( 1, 1)
    // ( 1, 0)
    // ( 1,-1)
    // ( 0,-1)
    // (-1,-1)
    // (-1, 0)
    // (-1, 1)
    private void checkMove(int x, int y, ArrayList<Tile> movelist)
    {
        Tile nexttile = this.getBoard().getTile(this.getXcoordinate() + x, this.getYcoordinate() + y);
        if(nexttile != null)
        {
            //Tile exists
            if(nexttile.isEmpty() || !nexttile.getPiece().getPlayer().getColor().equals(this.getPlayer().getColor()))
            {
                //Tile is empty or has an enemy piece on it
                if(!this.isCheck(nexttile))
                {
                    //Tile will not put the king in check
                    movelist.add(nexttile);
                }
            }
        }
    }

    public ArrayList<Tile> validMoveList()
    {
        ArrayList<Tile> movelist = new ArrayList<>();
        this.checkMove(0, 1, movelist);
        this.checkMove(1, 1, movelist);
        this.checkMove(1, 0, movelist);
        this.checkMove(1, -1, movelist);
        this.checkMove(0, -1, movelist);
        this.checkMove(-1, -1, movelist);
        this.checkMove(-1, 0, movelist);
        this.checkMove(-1, 1, movelist);
        return movelist;
    }
}
