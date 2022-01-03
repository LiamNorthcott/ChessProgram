
public class Knight extends Piece{

    Type type;

    public Knight (int x, int y, boolean isWhite, boolean onBoard, boolean hasMoved) {
        
        super(x, y, isWhite, onBoard, hasMoved);
        type = Type.KNIGHT;

    }


    public char displaySymbol() {return 'N';}

    public Type getType() {return Type.KNIGHT;}

    public String getTypeName(boolean isUppercase) {

        if(isUppercase){
            return "Knight";
        }
        else{
            return "knight";
        }
    }


    public boolean validMoveSpecific(int startX, int startY, int endX, int endY, boolean silent){  

        int xDiff = startX - endX;
        int yDiff = startY - endY;

        if((Math.abs(xDiff) == 2 && Math.abs(yDiff) == 1) || (Math.abs(xDiff) == 1 && Math.abs(yDiff) == 2)){
            //A knight must make... well... a "knight's move". 

            return true;
        }
        else{

            if(!silent){

                System.out.println("Invalid move. Knights must move two spaces in a direction and one space perpendicular to that.");
            }
            
            return false;
        }
    }
    //checks if move is valid, specific to the type of piece.
    //NOTE: add capturing conditions.
    
}