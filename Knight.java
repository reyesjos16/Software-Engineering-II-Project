import java.util.ArrayList;
public class Knight extends Piece {

    Knight(int x, int y, Player p, Board b) {
        super("knight", p, b);
        this.setXcoordinate(x);
        this.setYcoordinate(y);
    }

    private boolean captured = false;

    public void capture() {
        captured = true;
    }

    public boolean captured() {
        return captured;
    }

    private void movement(int x, int y, ArrayList<Tile> moveList){
        Tile nextMove = board.getTile(this.getXcoordinate()+x,this.getYcoordinate()+y);
        if(nextMove != null){
            if(!nextMove.isEmpty()){
                if(!nextMove.getPiece().getPlayer().getColor().equals(this.getPlayer().getColor())){
                    moveList.add(nextMove);
                }
            }
            else
            moveList.add(nextMove);
        }
    }

    public ArrayList<Tile> validMoveList() {
        ArrayList<Tile> moveList = new ArrayList<>();
            movement(1,2,moveList);
            movement(2,1 ,moveList);
            movement(2,-1,moveList);
            movement(1,-2,moveList);
            movement(-1,-2,moveList);
            movement(-2,-1, moveList);
            movement(-2,1, moveList);
            movement(-1, 2, moveList);
        return moveList
    }
}