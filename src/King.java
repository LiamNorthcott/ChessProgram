
public class King extends Piece{

    Type type;

    public King (int x, int y, boolean isWhite, boolean onBoard, boolean hasMoved) {
        
        super(x, y, isWhite, onBoard, hasMoved);
        type = Type.KING;

    }


    public char displaySymbol() {return 'K';}

    public Type getType() {return Type.KING;}

    public String getTypeName(boolean isUppercase) {

        if(isUppercase){
            return "King";
        }
        else{
            return "king";
        }
    }

    public boolean validMoveSpecific(int startX, int startY, int endX, int endY, boolean silent){  

        int xDiff = startX - endX;
        int yDiff = startY - endY;

        if(Math.abs(xDiff) <= 1 && Math.abs(yDiff) <= 1){
            
            return true;
        }
        else{

            if((startY == 0 && isWhite) || (startY == 7 && !isWhite)){
    
                if(endX == 2 || endX == 6){

                    return true;
                }
            }
            //If these conditions are met, the king is probably trying to castle. Will check for validity of that in later functions.

            if(!silent){

                System.out.println("Invalid move. A king can only move one space away in any direction (horizontal, vertical, or diagonal), unless castling.");
            }

            return false;
            //A king's X and Y coordinates cannot change by more than 1 each during a move.
        }
    }
    //checks if move is valid, specific to the type of piece.
    //NOTE: add capturing conditions.
    
}