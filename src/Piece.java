
public abstract class Piece {

    public int x, y;
    public boolean isWhite;
    public boolean onBoard;
    public boolean hasMoved;

    /*
    x is x-coord of piece
    y is y-coord of piece
    isWhite tells us if the piece is white or black
    */

    public Piece(int x, int y, boolean isWhite, boolean onBoard, boolean hasMoved){


        this.x = x;
        this.y = y;
        this.isWhite = isWhite;
        this.onBoard = onBoard;
        this.hasMoved = hasMoved;

    }
    
    
    public boolean validMoveGeneral(int startX, int startY, int endX, int endY, boolean silent){

        if (endX < 0 || endY < 0 || endX > 7 || endY > 7) {

            if(endX <= -25 && endX >= -32 && endY >= 0 && endY <= 7){

                if(!silent){

                    System.out.println("Invalid move. Please use lowercase letters when specifying a location.");
                }
                //this shows only if the player enters an otherwise valid location but uses an uppercase letter instead of a lowercase one.
            }
            else{

                if(!silent){

                    System.out.println("Invalid input. That location does not exist on the chessboard. Valid locations are between a1 and h8.");
                }
                //this shows if the player enters a location which does not exist on the board, like "d9", "6c", "32", or "%!".
            }
            

            return false;
        }
        else {
            
            if (startX == endX && startY == endY) {

                if(!silent){

                    System.out.println("Invalid move. Players must move a piece to a different location on their turn.");
                }
                
                return false;
                //player must move their piece, staying still is invalid
            }
            else{

                return true;
            }
        }

    }
    
    //Checks if move ends on chessboard at all, and if move is a move at all

    //NOTE: Also add a test for whether or not move ends on a friendly piece to this function

    public abstract boolean validMoveSpecific(int startX, int startY, int endX, int endY, boolean silent);

    public abstract char displaySymbol();

    public abstract Type getType();

    public abstract String getTypeName(boolean isUppercase);

}

