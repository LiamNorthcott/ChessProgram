

public class Bishop extends Piece{

    Type type;

    public Bishop (int x, int y, boolean isWhite, boolean onBoard, boolean hasMoved) {
        
        super(x, y, isWhite, onBoard, hasMoved);
        type = Type.BISHOP;

    }


    public char displaySymbol() {return 'B';}

    public Type getType() {return Type.BISHOP;}

    public String getTypeName(boolean isUppercase) {

        if(isUppercase){
            return "Bishop";
        }
        else{
            return "bishop";
        }
    }


    public boolean validMoveSpecific(int startX, int startY, int endX, int endY, boolean silent){  

        int xDiff = endX - startX;
        int yDiff = endY - startY;

        if(Math.abs(xDiff) != Math.abs(yDiff)){

            if(!silent){

                System.out.println("Invalid move. Bishops must move in a straight line diagonally, along the same colour of tile.");
            }
            
            return false;
            //For a bishop, X and Y must increase/decrease by the same amount.
        }
        else{

            return true;
        }
    }
    //checks if move is valid, specific to the type of piece.
    //NOTE: add capturing conditions.
    
}