



public class Rook extends Piece{

    Type type;

    public Rook (int x, int y, boolean isWhite, boolean onBoard, boolean hasMoved) {

        super(x, y, isWhite, onBoard, hasMoved);
        type = Type.ROOK;

    }

    public char displaySymbol() {return 'R';}

    public Type getType() {return Type.ROOK;}

    public String getTypeName(boolean isUppercase) {

        if(isUppercase){
            return "Rook";
        }
        else{
            return "rook";
        }
    }

    public boolean validMoveSpecific(int startX, int startY, int endX, int endY, boolean silent){  

        if(startX != endX && startY != endY){

            if(!silent){

                System.out.println("Invalid move. Rooks must move in a straight line, horizontally or vertically. They cannot move diagonally.");
            }
            
            return false;
            //For a rook, either the X or Y coordinate must remain the same.
        }
        else{

          return true;  
        }
    }
    //checks if move is valid, specific to the type of piece.
    //NOTE: add capturing conditions.
    
}