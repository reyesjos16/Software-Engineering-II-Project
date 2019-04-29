package projecteevee.eevilchess.chessgame;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class Pawn extends Piece {
    Pawn(int x, int y, Player p, Board b){
        super("Pawn", p, b);
        this.firstMove = true;
        this.setXcoordinate(x);
        this.setYcoordinate(y);
    }
    private boolean captured = false;
    private boolean firstMove;
    public void capture(){captured = true;}
    public boolean captured(){return captured;}

    public void move(int x, int y)
    {
        this.board.getTile(this.getXcoordinate(), this.getYcoordinate()).setPiece(null);
        this.xcoordinate = x;
        this.ycoordinate = y;
        this.board.placeOnTile(x, y, this);
        this.firstMove = false;
        this.updateMoves();
        
    }

    private ArrayList<Tile> diagonalMovement() {
        ArrayList<Tile> validMove = new ArrayList<>();
        Tile nextMove;
        int black = 1;
        if (this.getPlayer().getColor().equals("black")) {
            black = -1;
        }
        nextMove = board.getTile(this.xcoordinate - 1, this.ycoordinate + 1 * black);
        if (nextMove != null &&!nextMove.isEmpty()) {
            if (!nextMove.getPiece().getPlayer().getColor().equals(this.getPlayer().getColor())) {
                validMove.add(nextMove);
            }
        }
        nextMove = board.getTile(this.xcoordinate + 1, this.ycoordinate + 1 * black);
        if (nextMove!= null && !nextMove.isEmpty()) {
            if (!nextMove.getPiece().getPlayer().getColor().equals(this.getPlayer().getColor())) {
                validMove.add(nextMove);
            }
        }
        return validMove;
    }


    public ArrayList<Tile>validMoveList(){
        ArrayList<Tile> validMoves = new ArrayList<>();
        Tile nextMove;
        int black = 1;
        if(this.getPlayer().getColor().equals("black")){
            black = -1;
        }
        nextMove = board.getTile(this.xcoordinate, this.ycoordinate + 1 * black);
        if (nextMove != null && nextMove.isEmpty()) {
            validMoves.add(nextMove);
            if(firstMove)
            {
                nextMove = board.getTile(this.xcoordinate, this.ycoordinate + 2 * black);
                if (nextMove != null && nextMove.isEmpty()){
                    validMoves.add(nextMove);
                }
            }
        }
        validMoves.addAll(this.diagonalMovement());
        return validMoves;
    }

}

