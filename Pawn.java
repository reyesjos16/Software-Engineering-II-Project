
public class Pawn extends Piece {
    Pawn(int x, int y, Player p, Board b){
        super("Pawn", p, b);
        this.setXcoordinate(x);
        this.setYcoordinate(y);
    }
    private boolean captured = false;
    private boolean firstMove = true;
    public void move(int newX, int newY){

    }
    public void capture(){captured = true;}
    public boolean captured(){return captured;}
}
