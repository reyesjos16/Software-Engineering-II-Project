/* 
 * The King is the most important piece on the chess board.
 * This piece moves one square in any direction.
 * If it is placed in check by an opponent's piece, the King is threatened with capture.
 * The player must then move the King out of check.
 * Failure to do so leads to CheckMate and end of game.
 */

public class King extends Piece {
    // TODO: Define special behavior for King

    public Boolean isThreatened(): {
        /* isThreatened() returns true if the King is in check,
         * and false otherwise.
         */
        
         //TODO: How is this to be implemented? Should we use an Observer pattern?
         return false;
    }
}