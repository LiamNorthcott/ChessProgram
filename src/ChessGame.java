import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;

class ChessGame {

    



    /*
    *
    * MAIN FUNCTION
    *
    */
    public static void main(String[] args) {

        // Using scanner to get input from user
        Scanner input = new Scanner(System.in);

        String[][] board = new String[8][8];

        /*
        * This is the array representing the chessboard
        */
        

        Rook whtQueenRook = new Rook(0,0,true,true,false);
        Knight whtQueenKnight = new Knight(1,0,true,true,false);
        Bishop whtQueenBish = new Bishop(2,0,true,true,false);
        Queen whtQueen = new Queen(3,0,true,true,false);
        King whtKing = new King(4,0,true,true,false);
        Bishop whtKingBish = new Bishop(5,0,true,true,false);
        Knight whtKingKnight = new Knight(6,0,true,true,false);
        Rook whtKingRook = new Rook(7,0,true,true,false);
        Pawn whtQRookPawn = new Pawn(0,1,true,true,false);
        Pawn whtQKnightPawn = new Pawn(1,1,true,true,false);
        Pawn whtQBishPawn = new Pawn(2,1,true,true,false);
        Pawn whtQueenPawn = new Pawn(3,1,true,true,false);
        Pawn whtKingPawn = new Pawn(4,1,true,true,false);
        Pawn whtKBishPawn = new Pawn(5,1,true,true,false);
        Pawn whtKKnightPawn = new Pawn(6,1,true,true,false);
        Pawn whtKRookPawn = new Pawn(7,1,true,true,false);
        


        Rook blkQueenRook = new Rook(0,7,false,true,false);
        Knight blkQueenKnight = new Knight(1,7,false,true,false);
        Bishop blkQueenBish = new Bishop(2,7,false,true,false);
        Queen blkQueen = new Queen(3,7,false,true,false);
        King blkKing = new King(4,7,false,true,false);
        Bishop blkKingBish = new Bishop(5,7,false,true,false);
        Knight blkKingKnight = new Knight(6,7,false,true,false);
        Rook blkKingRook = new Rook(7,7,false,true,false);
        Pawn blkQRookPawn = new Pawn(0,6,false,true,false);
        Pawn blkQKnightPawn = new Pawn(1,6,false,true,false);
        Pawn blkQBishPawn = new Pawn(2,6,false,true,false);
        Pawn blkQueenPawn = new Pawn(3,6,false,true,false);
        Pawn blkKingPawn = new Pawn(4,6,false,true,false);
        Pawn blkKBishPawn = new Pawn(5,6,false,true,false);
        Pawn blkKKnightPawn = new Pawn(6,6,false,true,false);
        Pawn blkKRookPawn = new Pawn(7,6,false,true,false);
        
        //creating pieces
        /*
        The first integer is the x-coord, the second integer is the y-coord, 
        the first boolean shows if it's white or not, the second boolean shows if it's on the board or not, the third shows if it's moved before or not.
        */

        
        //For testing:

        /*
        Queen whtTestQueen = new Queen(2,2,true,true);
        Queen blkTestQueen = new Queen(2,4,false,true);
        King whtTestKing = new King(4,3,true,true);
        Pawn blkTestPawn = new Pawn(0,7,false,true);
        */
       

        ArrayList<Piece> pieces = new ArrayList<Piece>();
        //This is the array list in which all the pieces are stored

        pieces.add(whtQueenRook);
        pieces.add(whtQueenKnight);
        pieces.add(whtQueenBish);
        pieces.add(whtQueen);
        pieces.add(whtKing);
        pieces.add(whtKingBish);
        pieces.add(whtKingKnight);
        pieces.add(whtKingRook);
        pieces.add(whtQRookPawn);
        pieces.add(whtQKnightPawn);
        pieces.add(whtQBishPawn);
        pieces.add(whtQueenPawn);
        pieces.add(whtKingPawn);
        pieces.add(whtKBishPawn);
        pieces.add(whtKKnightPawn);
        pieces.add(whtKRookPawn);


        
        pieces.add(blkQueenRook);
        pieces.add(blkQueenKnight);
        pieces.add(blkQueenBish);
        pieces.add(blkQueen);
        pieces.add(blkKing);
        pieces.add(blkKingBish);
        pieces.add(blkKingKnight);
        pieces.add(blkKingRook);
        pieces.add(blkQRookPawn);
        pieces.add(blkQKnightPawn);
        pieces.add(blkQBishPawn);
        pieces.add(blkQueenPawn);
        pieces.add(blkKingPawn);
        pieces.add(blkKBishPawn);
        pieces.add(blkKKnightPawn);
        pieces.add(blkKRookPawn);
        

        //for testing:

        /*
        pieces.add(whtTestQueen);
        pieces.add(blkTestQueen);
        pieces.add(whtTestKing);
        pieces.add(blkTestPawn);
        */

        setBlankBoard(pieces, board);

        /*
        Creates a chessboard array with black and white squares and without pieces.
        A period signifies a white square, while a comma signifies a black square.
        */

        setLocations(pieces, board);

        //Adding all pieces to list, setting locations of pieces on board

        printBoard(board);

        /*
        Prints chessboard to terminal
        */

        //just declaring variables here.

        Boolean gameOver = false;
        //self-explanatory: the game ain't over 'til it is.

        String turnPhase = "select";
        //starts out with selecting a piece, will change to moving a piece

        boolean whiteTurn = true;
        //starts out with white's turn, will change to black's turn

        int selPcNum = -1;
        //number of the selected piece in the ArrayList "pieces". I'm initializing it to something invalid.

        boolean tryAgain = false;
        //used to avoid unnecessary lines being printed. Set to true if they had an invalid input, and false otherwise.

        int enPassCandidate = -1;
        //used to identify any candidates for en passant - there can be only one at a time, and there may be none


        while(gameOver == false){

            if (turnPhase.equals("select") && tryAgain == false){

                if(whiteTurn == true){

                    System.out.println("White's turn!");
                }
                else if(whiteTurn == false){

                    System.out.println("Black's turn!");
                }

                System.out.println("Please input the location of the piece you want to move.");
                System.out.println("For example, a1 is the bottom left corner, a8 is the top left corner, and h8 is the top right corner.");
                System.out.println("If you want to quit, just input \"quit\" in all lowercase at any point.");
            } 
            else if (turnPhase.equals("move") && tryAgain == false){

                System.out.println("Please input the location you would like to move your piece to.");
                System.out.println("If you want to go back, just input \"back\" in all lowercase.");
            }
            //explaining input

            if(tryAgain == true){

                System.out.println("Please try again.");
            }


            String loc = input.nextLine();
            //telling program where to move piece on grid


            if(loc.equals("quit")){

                gameOver = true;
                break;
            }
            //exits while loop for the game if user decides to quit

            if(loc.equals("back")){

                if (turnPhase.equals("select")){

                    System.out.println("You are already in the selection phase.");
                    tryAgain = true;
                }
                else if (turnPhase.equals("move")){

                    System.out.println("Returning to selection phase.");
                    turnPhase = "select";
                    tryAgain = false;
                }
            }
            //lets players go back from the moving phase to the selection phase.
            
            if(validInputLength(loc)){
                //Testing if the input contains exactly two characters or not
                
                char x_end_let = loc.charAt(0);
                char y_end_let = loc.charAt(1);
                // Separating an input string like 'd4' into its components, 'd' and '4'.
            
                int x_end_num = letterToInt(x_end_let) - 1;
                int y_end_num = y_end_let - 49;
                //Now we turn the two characters into numerical values in order to figure out grid position.
                //characters 'a' to 'h' minus 97 will get us integers '0' to '7', as will the characters '1' to '8' minus 49.

                if(turnPhase.equals("select")){
                    //Testing if it's the correct turn phase.
                    //Separated this into two if statements cuz I don't want "invalid input" things going off here during the move phase.
    
                    if(pieceAtLocation(pieces, x_end_num, y_end_num) != -1){
                        //Testing whether there's a piece at the selected location
    
                        selPcNum = pieceAtLocation(pieces, x_end_num, y_end_num);
                         //Determining which number on the list "pieces" the selected piece corresponds to
    
                        if(pieces.get(selPcNum).isWhite == whiteTurn){
                            //checking if the piece colour and player colour are the same
    
                            System.out.println(pieces.get(selPcNum).getTypeName(true) + " selected.");
    
                            turnPhase = "move";
                            //transitions to moving phase
    
                            tryAgain = false;
                        }
                        else{
    
                            if(whiteTurn){
                                System.out.println("Invalid input. Black pieces cannot be selected on white's turn.");
    
                            }
                            else{
    
                                System.out.println("Invalid input. White pieces cannot be selected on black's turn.");
                            }
                            //notifying player that they have selected the wrong colour piece
    
                            tryAgain = true;
                        }
    
                        
                    }
                    else{
                        //different messages for different invalid inputs
                        
                        if(x_end_num < 0 || y_end_num < 0 || x_end_num > 7 || y_end_num > 7){

                            if(x_end_num <= -25 && x_end_num >= -32 && y_end_num >= 0 && y_end_num <= 7){

                                System.out.println("Invalid input. Please use lowercase letters when specifying a location.");
                                //this shows only if the player enters an otherwise valid location but uses an uppercase letter instead of a lowercase one.
                            }
                            else{

                                System.out.println("Invalid input. That location does not exist on the chessboard. Valid locations are between a1 and h8.");
                            }
                            //this shows if the player enters a location which does not exist on the board, like "d9", "6c", "32", or "%!".
                        }
                        else{

                            System.out.println("Invalid input. No piece found at that location.");
                            //this shows if the player enters a valid location on the chessboard but there is no piece there.
                        }

                        tryAgain = true;
                    }
    
                } else if(turnPhase.equals("move")){
                    //Testing if it's the correct turn phase.
                    
                    boolean validMove = false;
    
                    tryAgain = true;
    
                    if(pieces.get(selPcNum).validMoveGeneral(pieces.get(selPcNum).x, pieces.get(selPcNum).y, x_end_num, y_end_num, false)){
                        //Testing if the piece's move ends on the board and is not staying in the same place
    
                        if(pieces.get(selPcNum).validMoveSpecific(pieces.get(selPcNum).x, pieces.get(selPcNum).y, x_end_num, y_end_num, false)){
                            //Testing if the particular type of piece is allowed to move there
    
                            if (!friendCollisions(pieces, selPcNum, x_end_num, y_end_num, pieces.get(selPcNum).getType(), false)){
                                //Testing if the move will make the piece collide with friendly pieces
                                
                                if(!enemyCollisions(pieces, selPcNum, x_end_num, y_end_num, pieces.get(selPcNum).getType(), false, enPassCandidate)){
                                    //Testing if the move will collide with enemy pieces (note that valid capture conditions will not fail this test)

                                    if(validCheckConditions(pieces, whtKing, blkKing, selPcNum, x_end_num, y_end_num, false)){
                                        //Testing if the player's move will put their own king into check (not castling).

                                        if(pieces.get(selPcNum).getType() == Type.KING && Math.abs(x_end_num - pieces.get(selPcNum).x) > 1){
                                            //If this is true and we've passed all the other tests, then we're looking at a king trying to castle.
                                            //Otherwise, we're just looking at a normal move, and it goes to the else statement.
    
                                            if(validCastleCheckConds(pieces, whtKing, blkKing, selPcNum, x_end_num, y_end_num)){

                                                validMove = true;
                                                tryAgain = false; 
                                            }
                                            
                                        }
                                        else{
                                            //If we've passed all tests up to this point and we aren't castling, then it's a valid move.

                                            validMove = true;
                                            tryAgain = false;
                                        }
                                        
                                    }
                                } 
                            }
                        }
                    }
                    //testing for if the move is valid. If we fail any of these tests, the move is invalid.

    
                    if(validMove){
                        //Checks if the move passes all the tests
                        
                        /*
                        int x_start_num = pieces.get(selPcNum).x;
                        int y_start_num = pieces.get(selPcNum).y;
                        */
                        //May need these later. For now, though, they're not being used.

                        System.out.println(pieces.get(selPcNum).getTypeName(true) + " moved.");
                        //tells user that their piece has been moved

                        
                        capturePiece(pieces, x_end_num, y_end_num);
                        //If there is an enemy piece on the square the piece moved to, it is captured (its onBoard value is set to false). Informs players that piece has been captured.
                        
                        if(pieces.get(selPcNum).getType() == Type.PAWN && enPassCandidate != -1){

                            if(x_end_num == pieces.get(enPassCandidate).x && pieces.get(selPcNum).y == pieces.get(enPassCandidate).y){

                                capturePiece(pieces, pieces.get(enPassCandidate).x, pieces.get(enPassCandidate).y);
                                System.out.println("En passant!");
                            }

                        }
                        //En passant capture

                        if(pieces.get(selPcNum).getType() == Type.PAWN && Math.abs(y_end_num - pieces.get(selPcNum).y) == 2){

                            enPassCandidate = selPcNum;
                        } else {

                            enPassCandidate = -1;
                        }
                        //If a pawn just moved 2 spaces, it becomes vulnerable to an en passant capture. Any previous en passant candidates stop being vulnerable to that move.

                        pieces.get(selPcNum).hasMoved = true;
                        //Makes sure the program knows that the piece has moved before (this is important for castling)

                        if(pieces.get(selPcNum).getType() == Type.KING && Math.abs(pieces.get(selPcNum).x - x_end_num) > 1){
                            //checks conditions for castling

                            int castleRookNum;

                            if(x_end_num == 2){

                                castleRookNum = pieceAtLocation(pieces, 0, pieces.get(selPcNum).y);

                                System.out.println("Queenside castle!");

                                pieces.get(castleRookNum).x = 3;
                                //moves rook
                            }

                            if(x_end_num == 6){

                                castleRookNum = pieceAtLocation(pieces, 7, pieces.get(selPcNum).y);

                                System.out.println("Kingside castle!");

                                pieces.get(castleRookNum).x = 5;
                            }
                            
                        }
                        //Notifies players about castling and moves the rook


                        pieces.get(selPcNum).x = x_end_num;
                        pieces.get(selPcNum).y = y_end_num;
                        //changing the x and y coords of the moved piece


                        if(pieces.get(selPcNum).getType() == Type.PAWN){

                            if((y_end_num == 7 && pieces.get(selPcNum).isWhite) || (y_end_num == 0 && !pieces.get(selPcNum).isWhite)){
                                //checking if pawn has reached end of the board

                                System.out.println("You have moved your pawn to the end of the board. It can now be promoted into a queen, knight, rook, or bishop!");

                                boolean promLoop = true;

                                while(promLoop){
                                    //keeps asking for promotion until there is a valid input

                                    System.out.println("Type \"queen\" to promote into a queen, \"knight\" for a knight, \"rook\" for a rook, or \"bishop\" for a bishop.");

                                    String promInput = input.nextLine();
                                    //getting input

                                    if(promInput.equals("queen")){

                                        pieces.add(new Queen(x_end_num, y_end_num, pieces.get(selPcNum).isWhite, true, false));
                                        //creates new queen

                                        pieces.get(selPcNum).onBoard = false;
                                        //pawn is no longer on the board

                                        System.out.println("Pawn promoted!");

                                        promLoop = false;
                                        //lets us exit the while loop

                                    }
                                    else if(promInput.equals("knight")){

                                        pieces.add(new Knight(x_end_num, y_end_num, pieces.get(selPcNum).isWhite, true, false));
                                        //creates new knight

                                        pieces.get(selPcNum).onBoard = false;

                                        System.out.println("Pawn promoted!");

                                        promLoop = false;
                                    }
                                    else if(promInput.equals("rook")){

                                        pieces.add(new Rook(x_end_num, y_end_num, pieces.get(selPcNum).isWhite, true, false));
                                        //creates new rook

                                        pieces.get(selPcNum).onBoard = false;

                                        System.out.println("Pawn promoted!");

                                        promLoop = false;
                                    }
                                    else if(promInput.equals("bishop")){

                                        pieces.add(new Bishop(x_end_num, y_end_num, pieces.get(selPcNum).isWhite, true, false));
                                        //creates new rook

                                        pieces.get(selPcNum).onBoard = false;

                                        System.out.println("Pawn promoted!");

                                        promLoop = false;
                                    }
                                    else{

                                        System.out.println("Invalid input. Please try again. Make sure to use all lowercase letters.");
                                    }
                                }
                            }
                        }
                        //promoting pawn if it reaches the end of the board


                        if(mateTest(pieces, whtKing, blkKing, (!whiteTurn), enPassCandidate)){
                            //Testing if the players have reached stalemate or checkmate

                            if(whiteTurn == true){
                            
                                if(kingInCheck(pieces, blkKing)){
                                    //If the king is in check, it's checkmate. If the king is not in check but mate conditions still apply, it's stalemate.

                                    System.out.println("CHECKMATE!");

                                    setBlankBoard(pieces, board);
                                    setLocations(pieces, board);
                                    printBoard(board);
                                    //updates and prints board as it looks at the end of the game

                                    System.out.println("WHITE WINS!");

                                    gameOver = true;
                                    break;
                                    //exits main game loop, ends game
                                }
                                else{

                                    System.out.println("STALEMATE!");

                                    setBlankBoard(pieces, board);
                                    setLocations(pieces, board);
                                    printBoard(board);
                                    
                                    System.out.println("DRAW! NO WINNER!");

                                    gameOver = true;
                                    break;
                                }
                            }
                            else if (whiteTurn == false){
                                
                                if(kingInCheck(pieces, whtKing)){
                                    //If the king is in check, it's checkmate. If the king is not in check but mate conditions still apply, it's stalemate.

                                    System.out.println("CHECKMATE!");

                                    setBlankBoard(pieces, board);
                                    setLocations(pieces, board);
                                    printBoard(board);
                                    //updates and prints board as it looks at the end of the game

                                    System.out.println("BLACK WINS!");

                                    gameOver = true;
                                    break;
                                    //exits main game loop, ends game
                                }
                                else{

                                    System.out.println("STALEMATE!");

                                    setBlankBoard(pieces, board);
                                    setLocations(pieces, board);
                                    printBoard(board);
                                    
                                    System.out.println("DRAW! NO WINNER!");

                                    gameOver = true;
                                    break;
                                }
                            }
                        }
                        //tests for checkmate and stalemate, ending the game accordingly if mate has been reached


                        if(whiteTurn == true){
                            
                            if(kingInCheck(pieces, blkKing)){
                                System.out.println("Black king in check!");
                            }
                        }
                        else if (whiteTurn == false){
                            
                            if(kingInCheck(pieces, whtKing)){
                                System.out.println("White king in check!");
                            }
                        }
                        //If the player's move put the enemy king in check, a message is printed to the console.

                        setBlankBoard(pieces,board);
                        //sets board to blank

                        setLocations(pieces, board);
                        //moves pieces (updates board with current locations of pieces)
    
                        printBoard(board);
                        //prints board as it looks after the move
    
                        turnPhase = "select";
                        //transitions to selection phase
    
                        tryAgain = false;
    
                        if (whiteTurn == true){
                            whiteTurn = false;
                        }
                        else if (whiteTurn == false){
                            whiteTurn = true;
                        }
                        //changes which player's turn it is
                    }  
                }
                //This is our "move" turn phase.

            }
            else{

                if(!loc.equals("back")){
                    tryAgain = true;
                }
                //this is for if our initial input  has an incorrect number of characters
            }
            
            
        }
        
        System.out.println("Thanks for playing!");

        input.close();

    }
    //END OF MAIN FUNCTION










    /*
    *
    * FUNCTIONS
    *
    */




    /*
    * FUNCTION: letterToInt
    * Parameters: 
    * c - the lowercase letter we want to change to an integer
    * Purpose: to take a lowercase character and output its respective value from 1 to 26
    */
    static int letterToInt(char c){
        int i = c - 96;
        return i;
    }


    
    /*
    * FUNCTION: printBoard
    * Parameters: 
    * board - the array of characters to be printed
    * Purpose: to take the array and use it to print the chessboard to the terminal, with 0,0 being the bottom left and 7,7 being the top right.
    */
    static void printBoard(String board[][]){

        String[] numbers = {"1 ","2 ","3 ","4 ","5 ","6 ","7 ","8 "};
        //sets numbers for sides of chessboard

        System.out.println("*  a  b  c  d  e  f  g  h  ");
        //prints letters for top of chessboard

        for (int i = 7; i >= 0; i--){

            System.out.print(numbers[i]);
            //prints out the row number before squares

            for (int j = 0; j < 8; j++){

                System.out.print(board[j][i]);
            }
            System.out.println("");
        }
        //prints out black and white squares
    }



    /*
    * FUNCTION: setLocations
    * Parameters:
    * pieces - array list of the pieces involved in the game
    * board - the array of strings used for printing the board
    * Purpose: to take the symbols according to the pieces and allocate them to their respective locations in the chessboard array
    */
    public static void setLocations(ArrayList<Piece> pieces, String board[][]){
        
        char bracketA;
        char bracketB;

        for(int i = 0; i < pieces.size(); i++){

            if(pieces.get(i).onBoard){
                //checks if pieces are on the board before adding them to the display

                if(pieces.get(i).isWhite){
                    bracketA = '(';
                    bracketB = ')';
                }
                else{
                    bracketA = '[';
                    bracketB = ']';
                }
                //using brackets to differentiate the two colours of pieces on the board

                board[pieces.get(i).x][pieces.get(i).y] = ("" + bracketA + pieces.get(i).displaySymbol() + bracketB + "");
            }
        }
    }


    /*
    * FUNCTION: setBlankBoard
    * Parameters:
    * pieces - the array list of the pieces involved in the game
    * board - the array of strings used for printing the board
    * Purpose: sets all squares on the chessboard to "." for white squares or to "," for black squares. 
    */
    public static void setBlankBoard(ArrayList<Piece> pieces, String board[][]){

        for (int j = 0; j < 8; j++){
            for (int i = 0; i < 8; i++){

                if((i+j)%2 == 0){
                    
                    board[i][j] = " , ";
                } else {
                    
                    board[i][j] = " . ";
                }          
            }
        }
    }

    

    /*
    * FUNCTION: validInputLength
    * Parameters:
    * loc - the string inputted by the player to determine their move
    * Purpose: to determine whether the inputted string is two characters long, returning "true" if so and "false" if not.
    */
    static Boolean validInputLength(String loc){

        if (loc.length() == 2) {

            return true;
        }
        else {

            if (!loc.equals("back")){
                System.out.println("Invalid input. Only strings with exactly two characters accepted.");
            }
            
            return false;
        }
    }



    /*
    * FUNCTION: pieceAtLocation
    * Parameters:
    * pieces - the array list of pieces involved in the game
    * xLoc - the x coordinate of the square being searched
    * yLoc - the y coordinate of the square being searched
    * Purpose: checks if there is a piece on a certain square, returns the number of the piece in the list if there is, returns -1 if no piece on square.
    */
    public static int pieceAtLocation(ArrayList<Piece> pieces, int xLoc, int yLoc){

        for(int i = 0; i < pieces.size(); i++){

            if(pieces.get(i).x == xLoc && pieces.get(i).y == yLoc && pieces.get(i).onBoard){

                return i;
            }
        }

        return -1;
    }



    /*
    * FUNCTION: capturePiece
    * Parameters:
    * pieces - the array list of pieces involved in the game
    * xLoc - the x coordinate of the square being moved into
    * yLoc - the y coordinate of the square being moved into
    * Purpose: checks if the square being moved into is occupied by an enemy piece, sets the enemy piece's onBoard value to false if so, does nothing if square is unoccupied.
    * Also prints out "enemy ___ captured", with the ____ representing the type of piece captured.
    */
    public static void capturePiece(ArrayList<Piece> pieces, int xLoc, int yLoc){

        int capPcNum = pieceAtLocation(pieces, xLoc, yLoc);

        if (capPcNum != -1){
            //checks if there is a piece at the location

            pieces.get(capPcNum).onBoard = false;
            //sets onBoard to false

            System.out.println("Enemy " + pieces.get(capPcNum).getTypeName(false) + " captured!");
            //reports piece capture to players
        }
    }





    /*
    * FUNCTION: friendCollisions
    * Parameters:
    * pieces - the array list of pieces involved in the game
    * selPcNum - the number of the selected piece in the list "pieces"
    * xEnd - the x-coordinate of the endpoint of the requested move
    * yEnd - the y-coordinate of the endpoint of the requested move
    * type - the type of piece the player is attempting to move
    * silent - prints out "invalid move" messages if false, does not print the messages if true
    * Purpose: to check if any friendly pieces are preventing the player from making a requested move
    */
    public static boolean friendCollisions(ArrayList<Piece> pieces, int selPcNum, int xEnd, int yEnd, Type type, boolean silent){

        /********************************************************************************************************* */

        if(type == Type.ROOK || type == Type.QUEEN){
            //first we identify the type of piece.

            if(pieces.get(selPcNum).x == xEnd){
            //For rooks, we check if it moves in the x or y direction, or rather, if it didn't.

                if(pieces.get(selPcNum).y < yEnd){
                //Our for loops will have to be different depending on whether the rook moved forwards or backwards.

                    for(int j = (pieces.get(selPcNum).y + 1); j <= yEnd; j++){
                    //Now we check all the spaces from the selected piece to the selected location

                        int collPcNum = pieceAtLocation(pieces, pieces.get(selPcNum).x, j);

                        if (collPcNum != -1 && pieces.get(selPcNum).isWhite == pieces.get(collPcNum).isWhite){
                            //If we find a piece of the same colour on the path, then there is a friendly collision.
                            //Note that in this function, we are NOT concerned with enemy capturing/collisions. That's a different function's job.

                            if(!silent){
                                //we will call this silently if we're testing for check, but not silently when testing for a valid move.

                                System.out.println("Invalid move. A " + pieces.get(selPcNum).getTypeName(false) + " cannot jump over or end on the same space as a friendly piece.");
                                //that bit in the middle will either be "rook" or "queen" depending on the piece being moved.
                            }
                           
                            return true;
                        }
                    }
                    return false;
                    //returs false if we've checked all spaces and found no friendly piece.

                }
                else if(pieces.get(selPcNum).y > yEnd){
                //now we repeat for the opposite direction.

                    for(int j = (pieces.get(selPcNum).y - 1); j >= yEnd; j--){

                        int collPcNum = pieceAtLocation(pieces, pieces.get(selPcNum).x, j);

                        if (collPcNum != -1 && pieces.get(selPcNum).isWhite == pieces.get(collPcNum).isWhite){

                            if(!silent){

                                System.out.println("Invalid move. A " + pieces.get(selPcNum).getTypeName(false) + " cannot jump over or end on the same space as a friendly piece.");
                            }
                            
                            return true;
                        }
                    }
                    return false;

                }
                else {

                    if(!silent){

                        System.out.println("Error. Check Rook section of function friendCollisions.");
                    }
                    
                    return true;
                    //reports error and returns true to render the move invalid as a precaution. This should not print if things work properly.
                }

            }
            else if(pieces.get(selPcNum).y == yEnd){
                //this is for if the rook moves horizontally

                if(pieces.get(selPcNum).x < xEnd){
    
                    for(int i = (pieces.get(selPcNum).x + 1); i <= xEnd; i++){
    
                        int collPcNum = pieceAtLocation(pieces, i, pieces.get(selPcNum).y);
    
                        if (collPcNum != -1 && pieces.get(selPcNum).isWhite == pieces.get(collPcNum).isWhite){
    
                            if(!silent){

                                System.out.println("Invalid move. A " + pieces.get(selPcNum).getTypeName(false) + " cannot jump over or end on the same space as a friendly piece.");
                            }
                            
                            return true;
                        }
                    }
                    return false;
    
                }
                else if(pieces.get(selPcNum).x > xEnd){
                //now we repeat for the opposite direction.
    
                    for(int i = (pieces.get(selPcNum).x - 1); i >= xEnd; i--){
    
                        int collPcNum = pieceAtLocation(pieces, i, pieces.get(selPcNum).y);
    
                        if (collPcNum != -1 && pieces.get(selPcNum).isWhite == pieces.get(collPcNum).isWhite){
    
                            if(!silent){

                                System.out.println("Invalid move. A " + pieces.get(selPcNum).getTypeName(false) + " cannot jump over or end on the same space as a friendly piece.");
                            }
                            
                            return true;
                        }
                    }
                    return false;
    
                }
                else {
                    if(!silent){

                        System.out.println("Error. Check Rook section of function friendCollisions.");
                    }
                    return true;
                }

            }
            else {

                if(type == Type.ROOK){
                    if(!silent){

                        System.out.println("Error. Check Rook section of function friendCollisions.");
                    }
                    return true;
                }
                //Don't want this printing out if a queen makes a bishop's move

            }
        }
        //END OF ROOK TEST
        
        /********************************************************************************************************** */

        if(type == Type.BISHOP || type == Type.QUEEN){

            if(pieces.get(selPcNum).x < xEnd){
                //For bishops, we check if it moves in the positive or negative x direction. This is for the positive x direction.
                
                if(pieces.get(selPcNum).y < yEnd){
                    //We also need to check if it moves in the positive or negative y direction. This is for the positive y direction.

                    for(int k = 1; (pieces.get(selPcNum).x + k) <= xEnd; k++){
                        //Now we check all the spaces from the selected piece to the selected location like with the rook, just using different math.

                        int collPcNum = pieceAtLocation(pieces, (pieces.get(selPcNum).x + k), (pieces.get(selPcNum).y + k));

                        if (collPcNum != -1 && pieces.get(selPcNum).isWhite == pieces.get(collPcNum).isWhite){
                            
                            if(!silent){

                                System.out.println("Invalid move. A " + pieces.get(selPcNum).getTypeName(false) + " cannot jump over or end on the same space as a friendly piece.");
                            }
                            
                            return true;
                        }
                    }
                }
                else if(pieces.get(selPcNum).y > yEnd){
                    //this is for the negative y direction

                    for(int k = 1; (pieces.get(selPcNum).x + k) <= xEnd; k++){

                        int collPcNum = pieceAtLocation(pieces, (pieces.get(selPcNum).x + k), (pieces.get(selPcNum).y - k));

                        if (collPcNum != -1 && pieces.get(selPcNum).isWhite == pieces.get(collPcNum).isWhite){
                            
                            if(!silent){

                                System.out.println("Invalid move. A " + pieces.get(selPcNum).getTypeName(false) + " cannot jump over or end on the same space as a friendly piece.");
                            }
                            
                            return true;
                        }
                    }
                }
                else {
                    if(!silent){
                        System.out.println("Error. Check Bishop section of function friendCollisions.");  
                    } 
                    return true;
                }
            }
            else if(pieces.get(selPcNum).x > xEnd){
                //this is for the negative x direction

                if(pieces.get(selPcNum).y < yEnd){
                    
                    for(int k = 1; (pieces.get(selPcNum).x - k) >= xEnd; k++){

                        int collPcNum = pieceAtLocation(pieces, (pieces.get(selPcNum).x - k), (pieces.get(selPcNum).y + k));

                        if (collPcNum != -1 && pieces.get(selPcNum).isWhite == pieces.get(collPcNum).isWhite){
                            
                            if(!silent){

                                System.out.println("Invalid move. A " + pieces.get(selPcNum).getTypeName(false) + " cannot jump over or end on the same space as a friendly piece.");
                            }
                            
                            return true;
                        }
                    }
                }
                else if(pieces.get(selPcNum).y > yEnd){
                    
                    for(int k = 1; (pieces.get(selPcNum).x - k) >= xEnd; k++){

                        int collPcNum = pieceAtLocation(pieces, (pieces.get(selPcNum).x - k), (pieces.get(selPcNum).y - k));

                        if (collPcNum != -1 && pieces.get(selPcNum).isWhite == pieces.get(collPcNum).isWhite){
                            
                            if(!silent){

                                System.out.println("Invalid move. A " + pieces.get(selPcNum).getTypeName(false) + " cannot jump over or end on the same space as a friendly piece.");
                            }
                            
                            return true;
                        }
                    }
                }
                else {
                    if(!silent){
                        System.out.println("Error. Check Bishop section of function friendCollisions.");  
                    } 
                    return true;
                }
            }
            else {
                
                if(type == Type.BISHOP){
                    if(!silent){
                        System.out.println("Error. Check Bishop section of function friendCollisions.");  
                    } 
                    return true;
                }
                //Don't want this printing out if a queen makes a rook's move
                
            }

        }
        //END OF BISHOP TEST

        /**************************************************************************************************** */

        if(type == Type.PAWN){

            int collPcNum = pieceAtLocation(pieces, xEnd, yEnd);
            int forward;

            if(pieces.get(selPcNum).isWhite){
                
                forward = 1;
            }
            else{

                forward = -1;
            }
            //using "forward" to account for different directions of white and black pieces


            if (collPcNum != -1){

                if(pieces.get(selPcNum).isWhite == pieces.get(collPcNum).isWhite){
                    
                    if(pieces.get(selPcNum).x != xEnd){
                        //giving special output if pawn attempts move specific to capturing

                        if(!silent){

                            System.out.println("Invalid move. Cannot capture a friendly piece.");
                        }
                        
                        return true;
                    }
                    else{

                        if(!silent){

                            System.out.println("Invalid move. A pawn cannot jump over or end on the same space as a friendly piece.");
                        }
                        
                        return true;
                    }
                }
            }
            else if((pieces.get(selPcNum).y + (2*forward)) == yEnd){
                //pawns can't jump over friendly pieces during their two-space first move

                collPcNum = pieceAtLocation(pieces, xEnd, (pieces.get(selPcNum).y + forward));

                if(collPcNum != -1){

                    if(pieces.get(selPcNum).isWhite == pieces.get(collPcNum).isWhite){

                        if(!silent){

                            System.out.println("Invalid move. A pawn cannot jump over or end on the same space as a friendly piece.");
                        }
                        
                        return true;
                    }  
                }
            }
            else{

                return false;
            }


        }
        //END OF PAWN TEST

        /**************************************************************************************************** */

        if(type == Type.KNIGHT){

            int collPcNum = pieceAtLocation(pieces, xEnd, yEnd);

            if(collPcNum != -1){

                if(pieces.get(selPcNum).isWhite == pieces.get(collPcNum).isWhite){

                    if(!silent){

                        System.out.println("Invalid move. A knight cannot end on the same space as a friendly piece.");
                    }
                    
                    return true;
                }
                else{
                    
                    return false;
                } 
            }
            else{
                
                return false;
            }
            //Knights can hop over friendly pieces, they just can't end on the same space as one.

        }
        //END OF KNIGHT TEST

        /************************************************************************************************** */

        if(type == Type.KING){

            int collPcNum = pieceAtLocation(pieces, xEnd, yEnd);

            if(collPcNum != -1){

                if(pieces.get(selPcNum).isWhite == pieces.get(collPcNum).isWhite){

                    if(!silent){

                        System.out.println("Invalid move. A king's move cannot end on the same space as a friendly piece.");
                    }
                    
                    return true;
                }
            }
            //Pretty simple: no ending on a friendly space.


            if(Math.abs(pieces.get(selPcNum).x - xEnd) > 1){
                //If we've passed validMoveSpecific and the king is moving more than 1 space, then the king must be attempting to castle.

                if(pieces.get(selPcNum).hasMoved){

                    if(!silent){

                        System.out.println("Invalid move. A king cannot castle if it has already moved.");
                    }
                    return true;
                }
                //checking if king has moved before anything else

                int castleRookNum;


                if(xEnd == 2){
                    //this is for queenside castling

                    castleRookNum = pieceAtLocation(pieces, 0, pieces.get(selPcNum).y);

                    if(castleRookNum != -1 && pieces.get(castleRookNum).getType() == Type.ROOK && !pieces.get(castleRookNum).hasMoved){
                        //checking if there is an unmoved rook in the correct location (it has to be friendly if it's unmoved).

                        if(pieceAtLocation(pieces, 1, pieces.get(selPcNum).y) != -1 || pieceAtLocation(pieces, 3, pieces.get(selPcNum).y) != -1){
                            //checking if all spaces between king and rook are empty (we've already checked for the endpoint of the move)

                            if(!silent){

                                System.out.println("Invalid move. All spaces between the king and the rook must be unoccupied in order to castle.");
                            }
                            return true;
                        }
                    }
                    else {

                        if(!silent){

                            System.out.println("Invalid move. There must be an unmoved rook present on the chosen side in order to castle.");
                        }
                        return true;
                    }
                }


                if(xEnd == 6){
                    //this is for kingside castling

                    castleRookNum = pieceAtLocation(pieces, 7, pieces.get(selPcNum).y);

                    if(castleRookNum != -1 && pieces.get(castleRookNum).getType() == Type.ROOK && !pieces.get(castleRookNum).hasMoved){
                        //checking if there is an unmoved rook in the correct location (it has to be friendly if it's unmoved).

                        if(pieceAtLocation(pieces, 5, pieces.get(selPcNum).y) != -1){

                            if(!silent){

                                System.out.println("Invalid move. All spaces between the king and the rook must be unoccupied in order to castle.");
                            }
                            return true;
                        }
                        
                    }
                    else {

                        if(!silent){

                            System.out.println("Invalid move. There must be an unmoved rook present on the chosen side in order to castle.");
                        }
                        return true;
                    }
                }
            }
            //Checking for castling conditions related to friendly pieces


            return false;
            //returns false if the king doesn't bump into anything or try to castle incorrectly.

        }
        //END OF KING TEST

        /************************************************************************************************** */


        return false;
    }




    /*
    * FUNCTION: enemyCollisions
    * Parameters:
    * pieces - the array list of pieces involved in the game
    * selPcNum - the number of the selected piece in the list "pieces"
    * xEnd - the x-coordinate of the endpoint of the requested move
    * yEnd - the y-coordinate of the endpoint of the requested move
    * type - the type of piece the player is attempting to move
    * silent - prints out "invalid move" messages if false, does not print the messages if true
    * enPassCandidate - the number of the pawn currently vulnerable to en passant (or -1 if there is no such pawn that turn)
    * Purpose: to check if any enemy pieces are preventing the player from making a requested move
    */
    public static boolean enemyCollisions(ArrayList<Piece> pieces, int selPcNum, int xEnd, int yEnd, Type type, boolean silent, int enPassCandidate){

        /********************************************************************************************************* */

        if(type == Type.ROOK || type == Type.QUEEN){
            //first we identify the type of piece.

            if(pieces.get(selPcNum).x == xEnd){
            //For rooks, we check if it moves in the x or y direction, or rather, if it didn't.

                if(pieces.get(selPcNum).y < yEnd){
                //Our for loops will have to be different depending on whether the rook moved forwards or backwards.

                    for(int j = (pieces.get(selPcNum).y); j < yEnd; j++){
                    //Now we check all the spaces from the selected piece to the selected location

                        int collPcNum = pieceAtLocation(pieces, pieces.get(selPcNum).x, j);

                        if (collPcNum != -1 && pieces.get(selPcNum).isWhite != pieces.get(collPcNum).isWhite){
                            //If we find a piece of the opposite colour on the path (not at the end), then there is an enemy collision.
                            //Note that in this function, we are NOT concerned with enemy capturing. That's a different function's job.

                            if(!silent){
                                //we will call this silently if we're testing for check, but not silently when testing for a valid move.

                                System.out.println("Invalid move. A " + pieces.get(selPcNum).getTypeName(false) + " cannot jump over an enemy piece.");
                            }
                            
                            return true;
                        }
                    }
                    return false;
                    //returs false if we've checked all spaces and found no enemy piece.

                }
                else if(pieces.get(selPcNum).y > yEnd){
                //now we repeat for the opposite direction.

                    for(int j = (pieces.get(selPcNum).y); j > yEnd; j--){

                        int collPcNum = pieceAtLocation(pieces, pieces.get(selPcNum).x, j);

                        if (collPcNum != -1 && pieces.get(selPcNum).isWhite != pieces.get(collPcNum).isWhite){

                            if(!silent){

                                System.out.println("Invalid move. A " + pieces.get(selPcNum).getTypeName(false) + " cannot jump over an enemy piece.");
                            }
                            
                            return true;
                        }
                    }
                    return false;

                }
                else {
                    if(!silent){
                        System.out.println("Error. Check Rook section of function enemyCollisions.");
                    }
                    return true;
                    //reports error and returns true to render the move invalid as a precaution. This should not print if things work properly.
                }

            }
            else if(pieces.get(selPcNum).y == yEnd){
                //this is for if the rook moves horizontally

                if(pieces.get(selPcNum).x < xEnd){
    
                    for(int i = (pieces.get(selPcNum).x); i < xEnd; i++){
    
                        int collPcNum = pieceAtLocation(pieces, i, pieces.get(selPcNum).y);
    
                        if (collPcNum != -1 && pieces.get(selPcNum).isWhite != pieces.get(collPcNum).isWhite){
    
                            if(!silent){

                                System.out.println("Invalid move. A " + pieces.get(selPcNum).getTypeName(false) + " cannot jump over an enemy piece.");
                            }
                            
                            return true;
                        }
                    }
                    return false;
    
                }
                else if(pieces.get(selPcNum).x > xEnd){
                //now we repeat for the opposite direction.
    
                    for(int i = (pieces.get(selPcNum).x); i > xEnd; i--){
    
                        int collPcNum = pieceAtLocation(pieces, i, pieces.get(selPcNum).y);
    
                        if (collPcNum != -1 && pieces.get(selPcNum).isWhite != pieces.get(collPcNum).isWhite){
    
                            if(!silent){

                                System.out.println("Invalid move. A " + pieces.get(selPcNum).getTypeName(false) + " cannot jump over an enemy piece.");
                            }
                            
                            return true;
                        }
                    }
                    return false;
    
                }
                else {
                    if(!silent){
                        System.out.println("Error. Check Rook section of function enemyCollisions.");
                    }
                    return true;
                }

            }
            else {

                if(type == Type.ROOK){
                    if(!silent){
                        System.out.println("Error. Check Rook section of function enemyCollisions.");
                    }
                    return true;
                }
            }
        }
        //END OF ROOK TEST
        
        /********************************************************************************************************** */

        if(type == Type.BISHOP || type == Type.QUEEN){

            if(pieces.get(selPcNum).x < xEnd){
                //For bishops, we check if it moves in the positive or negative x direction. This is for the positive x direction.
                
                if(pieces.get(selPcNum).y < yEnd){
                    //We also need to check if it moves in the positive or negative y direction. This is for the positive y direction.

                    for(int k = 0; (pieces.get(selPcNum).x + k) < xEnd; k++){
                        //Now we check all the spaces from the selected piece to the selected location like with the rook, just using different math.

                        int collPcNum = pieceAtLocation(pieces, (pieces.get(selPcNum).x + k), (pieces.get(selPcNum).y + k));

                        if (collPcNum != -1 && pieces.get(selPcNum).isWhite != pieces.get(collPcNum).isWhite){
                            
                            if(!silent){

                                System.out.println("Invalid move. A " + pieces.get(selPcNum).getTypeName(false) + " cannot jump over an enemy piece.");
                            }
                            
                            return true;
                        }
                    }
                }
                else if(pieces.get(selPcNum).y > yEnd){
                    //this is for the negative y direction

                    for(int k = 0; (pieces.get(selPcNum).x + k) < xEnd; k++){

                        int collPcNum = pieceAtLocation(pieces, (pieces.get(selPcNum).x + k), (pieces.get(selPcNum).y - k));

                        if (collPcNum != -1 && pieces.get(selPcNum).isWhite != pieces.get(collPcNum).isWhite){
                            
                            if(!silent){

                                System.out.println("Invalid move. A " + pieces.get(selPcNum).getTypeName(false) + " cannot jump over an enemy piece.");
                            }
                            
                            return true;
                        }
                    }
                }
                else {
                    if(!silent){
                    System.out.println("Error. Check Bishop section of function enemyCollisions.");
                    }
                    return true;
                }
            }
            else if(pieces.get(selPcNum).x > xEnd){
                //this is for the negative x direction

                if(pieces.get(selPcNum).y < yEnd){
                    
                    for(int k = 0; (pieces.get(selPcNum).x - k) > xEnd; k++){

                        int collPcNum = pieceAtLocation(pieces, (pieces.get(selPcNum).x - k), (pieces.get(selPcNum).y + k));

                        if (collPcNum != -1 && pieces.get(selPcNum).isWhite != pieces.get(collPcNum).isWhite){
                            
                            if(!silent){

                                System.out.println("Invalid move. A " + pieces.get(selPcNum).getTypeName(false) + " cannot jump over an enemy piece.");
                            }
                            
                            return true;
                        }
                    }
                }
                else if(pieces.get(selPcNum).y > yEnd){
                    
                    for(int k = 0; (pieces.get(selPcNum).x - k) > xEnd; k++){

                        int collPcNum = pieceAtLocation(pieces, (pieces.get(selPcNum).x - k), (pieces.get(selPcNum).y - k));

                        if (collPcNum != -1 && pieces.get(selPcNum).isWhite != pieces.get(collPcNum).isWhite){
                            
                            if(!silent){

                                System.out.println("Invalid move. A " + pieces.get(selPcNum).getTypeName(false) + " cannot jump over an enemy piece.");
                            }
                            
                            return true;
                        }
                    }
                }
                else {
                    if(!silent){
                    System.out.println("Error. Check Bishop section of function enemyCollisions.");
                    }
                    return true;
                }
            }
            else {

                if(type == Type.BISHOP){
                    if(!silent){
                    System.out.println("Error. Check Bishop section of function enemyCollisions.");
                    }
                    return true;
                } 
            }

        }
        //END OF BISHOP TEST

        /**************************************************************************************************** */

        if(type == Type.PAWN){

            int collPcNum = pieceAtLocation(pieces, xEnd, yEnd);
            int forward;

            if(pieces.get(selPcNum).isWhite){
                
                forward = 1;
            }
            else{

                forward = -1;
            }
            //using "forward" to account for different directions of white and black pieces


            if (collPcNum != -1 && pieces.get(selPcNum).isWhite != pieces.get(collPcNum).isWhite){

                if(pieces.get(selPcNum).x != xEnd){
                    //Pawns can capture on the diagonal, so not "colliding" with enemy pieces, rather "capturing".
                    //All other possibilities for where pawns can move (diagonally) should be accounted for by the validMoveSpecific test, leaving only the capture spaces on the diagonal.

                    return false;
                }
                else{

                    if(!silent){

                        System.out.println("Invalid move. A pawn can only capture enemy pieces on the diagonal.");
                    }
                    
                    return true;
                }
            }
            else if ((pieces.get(selPcNum).y + (2*forward)) == yEnd){
                //pawns can't jump over friendly pieces during their two-space first move

                collPcNum = pieceAtLocation(pieces, xEnd, (pieces.get(selPcNum).y + forward));

                if(collPcNum != -1 && pieces.get(selPcNum).isWhite != pieces.get(collPcNum).isWhite){

                    if(!silent){

                        System.out.println("Invalid move. A pawn cannot jump over an enemy piece.");
                    }
                    
                    return true;
                }
            }
            else if (collPcNum == -1 && pieces.get(selPcNum).x != xEnd){
                //pawns can only move diagonally while capturing

                if((enPassCandidate != -1) && xEnd == pieces.get(enPassCandidate).x && pieces.get(selPcNum).y == pieces.get(enPassCandidate).y){
                    //checks for en passant before declaring an invalid move

                    return false;
                }
                
                if(!silent){

                    System.out.println("Invalid move. A pawn cannot move diagonally without capturing an enemy piece.");
                }
                
                return true;
            }
            else{

                return false;
            }


        }
        //END OF PAWN TEST

        /**************************************************************************************************** */

        if(type == Type.KNIGHT){

            return false;
            //Yeah. No enemy collisions for knights.
        }
        //END OF KNIGHT TEST

        /**************************************************************************************************** */

        if(type == Type.KING){

            return false;
            //No enemy collisions for kings, as they have no path to follow. Avoiding check is the more important factor here.
        }
        //END OF KING TEST

        /**************************************************************************************************** */


        return false;
    }



    /*
    * FUNCTION: validCheckConditions
    * Parameters:
    * pieces - the array list of pieces involved in the game
    * whtKing - the white king
    * blkKing - the black king
    * selPcNum - the number corresponding to the selected piece in the array list "pieces"
    * xEnd - the x position the requested move would end on
    * yEnd - the y position the requested move would end on 
    * Purpose: to test if a player's move will place their own king in check
    */
    public static boolean validCheckConditions(ArrayList<Piece> pieces, King whtKing, King blkKing, int selPcNum, int xEnd, int yEnd, boolean silent){

        int resetX = pieces.get(selPcNum).x;
        int resetY = pieces.get(selPcNum).y;
        //saves x and y coords to reset them

        int testCapPcNum = pieceAtLocation(pieces, xEnd, yEnd);

        if (testCapPcNum != -1){
            //checks if there is a piece at the location

            pieces.get(testCapPcNum).onBoard = false;
            //sets onBoard to false
        }
        //This section simulates capturing a piece, while allowing us to reset it to uncaptured at the end of the function.

        
        pieces.get(selPcNum).x = xEnd;
        pieces.get(selPcNum).y = yEnd;
        //changes coords as if piece had moved for purposes of testing for check


        boolean inCheck = false;
        //if this remains unchanged, then we have valid conditions, otherwise we don't.

        if(pieces.get(selPcNum).isWhite){
            //testing white king if moved piece is white, testing black king if moved piece is black

            if(kingInCheck(pieces, whtKing)){

                inCheck = true;
            }
        }
        else{

            if(kingInCheck(pieces, blkKing)){

                inCheck = true;
            }
        }
        //changes inCheck to true if king is in check after move, keeps it as false if king is not in check after move


        pieces.get(selPcNum).x = resetX;
        pieces.get(selPcNum).y = resetY;
        //returning coords to what they were originally


        if (testCapPcNum != -1){
            //checks if there is a piece at the location

            pieces.get(testCapPcNum).onBoard = true;
            //sets onBoard to true
        }
        //This "un-captures" the potentially captured piece, in case the move is not valid


        if(inCheck){
            
            if(!silent){

                System.out.println("Invalid move. Cannot end move with own king in check.");
            }
            
            return false;
        }
        else{

            return true;
        }
        
    }



    /*
    * FUNCTION: kingInCheck
    * Parameters:
    * pieces - the array list of pieces involved in the game
    * thisKing - the king we're testing check for
    * Purpose: to determine whether a king is in check or not
    */
    public static boolean kingInCheck(ArrayList<Piece> pieces, King thisKing){

        for(int a = 0; a <= 7; a++){
            for (int b = 0; b <= 7; b++){
                //testing all x and y coordinates

                int checkPcNum = pieceAtLocation(pieces, a, b);

                if(checkPcNum != -1 && pieces.get(checkPcNum).isWhite != thisKing.isWhite){
                    //testing if the selected square has an enemy piece on it

                    if(pieces.get(checkPcNum).validMoveGeneral(pieces.get(checkPcNum).x, pieces.get(checkPcNum).y, thisKing.x, thisKing.y, true)){
                        //Testing if the move is allowed for any type of piece (mainly ensuring the piece doesn't stay put)

                        if(pieces.get(checkPcNum).validMoveSpecific(pieces.get(checkPcNum).x, pieces.get(checkPcNum).y, thisKing.x, thisKing.y, true)){
                            //Testing if the particular type of piece is allowed to move there
    
                            if (!friendCollisions(pieces, checkPcNum, thisKing.x, thisKing.y, pieces.get(checkPcNum).getType(), true)){
                                //Testing if the move will make the piece collide with friendly pieces
                                    
                                if(!enemyCollisions(pieces, checkPcNum, thisKing.x, thisKing.y, pieces.get(checkPcNum).getType(), true, -1)){
                                    //Testing if the move will collide with enemy pieces (note that valid capture conditions will not fail this test)
                                    
                                    return true;
                                    //returns true if an enemy piece can capture the king at the specified location (xLoc, yLoc).
                                }    
                            }
                        }
                    }      
                }
                //does all this for all coordinates on board

            }
        }
        
        return false;
        //returns false if the king is safe
    }



    /*
    * FUNCTION: validCastleCheckConds
    * Parameters:
    * pieces - the array list of pieces involved in the game
    * whtKing - the white king
    * blkKing - the black king
    * selPcNum - the number corresponding to the selected piece in the array list "pieces"
    * xEnd - the x position the requested move would end on
    * yEnd - the y position the requested move would end on 
    * Purpose: to test if castling check conditions are correct (cannot castle out of, through, or into check)
    */
    public static boolean validCastleCheckConds(ArrayList<Piece> pieces, King whtKing, King blkKing, int selPcNum, int xEnd, int yEnd){

        if(xEnd == 2){
            //testing queenside castling

            if(validCheckConditions(pieces, whtKing, blkKing, selPcNum, 4, pieces.get(selPcNum).y, true)){

                if(validCheckConditions(pieces, whtKing, blkKing, selPcNum, 3, pieces.get(selPcNum).y, true)){

                    return true;
                }
                else{

                    System.out.println("Invalid move. A king cannot castle if it must pass through a square attacked by an enemy piece to do so.");
                    return false;
                }

            }
            else{

                System.out.println("Invalid move. A king cannot castle if it is currently in check.");
                return false;
            }
            //testing check conditions for all spaces that the king will be moving through, including the space the king is on.
            //No need to check the endpoint, if we get to this function we'll have done that already.

        }
        else if(xEnd == 6){
            //testing kingside castling

            if(validCheckConditions(pieces, whtKing, blkKing, selPcNum, 4, pieces.get(selPcNum).y, true)){

                if(validCheckConditions(pieces, whtKing, blkKing, selPcNum, 5, pieces.get(selPcNum).y, true)){

                    return true;
                }
                else{

                    System.out.println("Invalid move. A king cannot castle if it must pass through a square attacked by an enemy piece to do so.");
                    return false;
                }

            }
            else{

                System.out.println("Invalid move. A king cannot castle if it is currently in check.");
                return false;
            }

        }
        else{

            System.out.println("Error. Function validCastleCheckConds has somehow been run with an invalid endpoint.");
            return false;
        }

    }




    

    /*
    * FUNCTION: mateTest
    * Parameters:
    * pieces - the array list of pieces involved in the game
    * whtKing - the white king
    * blkKing - the black king
    * nextTurnWhite - true if the next turn will be white's, false if the next turn will be black's.
    * enPassCandidate - the piece currently able to be captured via en passant. 
    * Purpose: to determine if a move causes an end to the game - checkmate or stalemate - returning false if no mate and true if mate.
    */
    public static boolean mateTest(ArrayList<Piece> pieces, King whtKing, King blkKing, boolean nextTurnWhite, int enPassCandidate){

        for(int k = 0; k < pieces.size(); k++){
            //cycling through all the pieces

            if(pieces.get(k).onBoard && pieces.get(k).isWhite == nextTurnWhite){
                //only moving the pieces corresponding to the next turn

                
                for(int i = 0; i <= 7; i++){
                    for(int j = 0; j <= 7; j++){
                        //i and j correspond to the x and y coords of all possible locations
                        
                        /*
                        if(validCheckConditions(pieces, whtKing, blkKing, k, i, j, true)){
                            

                            return false;
                        }
                        */

                        if(pieces.get(k).validMoveGeneral(pieces.get(k).x, pieces.get(k).y, i, j, true)){
                            //Testing if the piece's move ends on the board and is not staying in the same place
        
                            if(pieces.get(k).validMoveSpecific(pieces.get(k).x, pieces.get(k).y, i, j, true)){
                                //Testing if the particular type of piece is allowed to move there
        
                                if (!friendCollisions(pieces, k, i, j, pieces.get(k).getType(), true)){
                                    //Testing if the move will make the piece collide with friendly pieces
                                    
                                    if(!enemyCollisions(pieces, k, i, j, pieces.get(k).getType(), true, enPassCandidate)){
                                        //Testing if the move will collide with enemy pieces (note that valid capture conditions will not fail this test)
    
                                        if(validCheckConditions(pieces, whtKing, blkKing, k, i, j, true)){
                                            //Testing if the player's move will put their own king into check (not castling).
    
                                            return false;
                                        }
                                    } 
                                }
                            }
                        }
                        //Testing for if the move is valid. If we fail any of these tests, the move is invalid.
                        //However, if we find even one valid move for the next turn (that doesn't end with the king in check), then it's not mate.



                    }
                }

            }
        }

        
        return true;
        //If, however, we have tested everything and found zero valid moves, then it's either checkmate or stalemate.
    }

    


}




