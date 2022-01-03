

public class Pawn extends Piece{

    Type type;

    public Pawn (int x, int y, boolean isWhite, boolean onBoard, boolean hasMoved) {
        
        super(x, y, isWhite, onBoard, hasMoved);
        type = Type.PAWN;

    }


    public char displaySymbol() {return 'P';}

    public Type getType() {return Type.PAWN;}

    public String getTypeName(boolean isUppercase) {

        if(isUppercase){
            return "Pawn";
        }
        else{
            return "pawn";
        }
    }


    public boolean validMoveSpecific(int startX, int startY, int endX, int endY, boolean silent){  

        int xDiff = endX - startX;
        int yDiff = endY - startY;
        int forward;
        int canMoveTwo;
        //declaring variables

        if (isWhite){ 

            forward = 1;
            canMoveTwo = 1;
        }
        else {

            forward = -1;
            canMoveTwo = 6;
        }
        //Pawns can only move "forward", and the direction of "forward" changes depending on whether the piece is white or black.
        //Also changes the y-value for which it can move two spaces forward.


        if ((forward*yDiff) <= 0) {

            if(!silent){

                System.out.println("Invalid move. Pawns cannot move backwards or sideways. They must move forwards or capture forwards diagonally.");
            }
            
            return false;
        }
        //checking if pawn moves forward at all


        if(Math.abs(xDiff) > 1){

            if(!silent){

                System.out.println("Invalid move. Pawns cannot move more than one space diagonally, and only to capture.");
            }
            
            return false;
        }
        //checking if pawn moves too far sideways


        if(Math.abs(xDiff) == 1){

            if((forward*yDiff) == 1){

                return true;
            }
            else{

                if(!silent){

                    System.out.println("Invalid move. Pawns cannot move more than one space diagonally, and only to capture.");
                }
                
                return false;
            }
        }
        //checking if diagonal movement is exactly one space forward and one space sideways


        if (xDiff == 0){

            if(forward*yDiff == 1){

                return true;
            }
            else if(forward*yDiff == 2){
                //checking conditions for special first move if pawn moves forward two squares

                if(startY == canMoveTwo){

                    return true;
                }
                else{
                    
                    if(!silent){

                        System.out.println("Invalid move. Pawns can only move two spaces forward if they have not been moved before.");
                    }
                    return false;
                }

            }
            else{

                if(!silent){

                    System.out.println("Invalid move. Pawns can move a maximum of one space forwards (or two if they have not been moved before).");
                }
                
                return false;
            }
        }
        //testing for how far forward the piece moves


        System.out.println("Error. This should not print. See function validMoveSpecific for Pawns.");
        return false;
        //prints if none of the testing criteria are met

    }
    //checks if move is valid, specific to the type of piece.
    //NOTE: add capturing conditions.
    
}