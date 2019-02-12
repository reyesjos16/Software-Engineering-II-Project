public class Knight extends Piece{

    Knight(int x, int y, Player p, Board b){
        super("knight", p, b);
        this.setXcoordinate(x);
        this.setYcoordinate(y);
    }

    private boolean captured = false;

    public void move(int newX, int newY){


    }
    public void capture(){captured = true;}
    public boolean captured(){return captured;}

}