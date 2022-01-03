

public class Queen extends Piece{

    Type type;

    public Queen (int x, int y, boolean isWhite, boolean onBoard, boolean hasMoved) {
        
        super(x, y, isWhite, onBoard, hasMoved);
        type = Type.QUEEN;

    }


    public char displaySymbol() {return 'Q';}

    public Type getType() {return Type.QUEEN;}

    public String getTypeName(boolean isUppercase) {

        if(isUppercase){
            return "Queen";
        }
        else{
            return "queen";
        }
    }


    public boolean validMoveSpecific(int startX, int startY, int endX, int endY, boolean silent){  

        int xDiff = startX - endX;
        int yDiff = startY - endY;

        if(Math.abs(xDiff) == Math.abs(yDiff) || xDiff == 0 || yDiff == 0){
            
            return true;
        }
        else{

            if(!silent){

                System.out.println("Invalid move. A queen must move in a straight line, which can be either vertical, horizontal, or diagonal along the same colour of tile.");
            }
            
            return false;
            //In other words, a queen can make any move that a rook or bishop could make in its place.
        }
    }
    //checks if move is valid, specific to the type of piece.
    //NOTE: add capturing conditions.
    
}