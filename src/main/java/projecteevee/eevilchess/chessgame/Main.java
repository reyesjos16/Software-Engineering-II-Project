package projecteevee.eevilchess.chessgame;

/*
 *	Main handles running the Eevil Chess
 *	Authors: Team Eevee
 *
 * */

import java.util.*;
import projecteevee.eevilchess.chessgame.Board;

public class Main
{
    public static void main(String[] args)
    {
        Board tmpboard = new Board(8, 8);
        tmpboard.populateTableNormal(new Player("white"), new Player("black"));
        String origjson = tmpboard.getBoardJSON().toString(4);
        //System.out.println(origjson);
        Board convboard = Board.convertBoardJSON(tmpboard.getBoardJSON());
        String convjson = convboard.getBoardJSON().toString(4);
        System.out.println(origjson.equals(convjson));
    }
}
