import java.util.Scanner;

public class Launcher {

    private static int RedPieces = 12;
    private static int WhitePieces = 12;
    public static void main(String[] args) {

        ChessBoard board = new ChessBoard();
        String userMove;


        // Define 'reader'<Scanner object>
        // to save the input from the user through command line.
        Scanner reader = new Scanner(System.in);

        // Display the initial checker board.
        displayBoard(board);

        // Repeat the game until when the game is stopped by user
        // or when the winner is defined.
        while(true) {

            System.out.print("Enter your move: ");
            userMove = reader.nextLine();

            // if the user put the command 'quit'
            // the game will be stopped.
            if (userMove.equals("quit")){
                System.out.print("Game was ended by player...");
                break;
            }

            makeMove(userMove, board);

            //////////////////////////////////////////
            ///////////Check the winner///////////////
            //////////////////////////////////////////
            if (RedPieces == 0 || WhitePieces == 0)
            {   if(RedPieces==0)
            {
                displayBoard(board);
                System.out.println("White player wins!");
            }
                if(WhitePieces==0)
                {
                    displayBoard(board);
                    System.out.println("White player wins!");
                }
                break;
            }
            displayBoard(board);

            //////////////////////////////////////////
            ///////////Check whose turn is////////////
            //////////////////////////////////////////
        }
        
    }

    public static ChessBoard makeMove(String move, ChessBoard board) {

        // [a3]x[b4]

        String[] moves = move.split("x");
        for(int i = 0; i < moves.length; i++)
            moves[i] = moves[i].substring(1, 3);


        int oldX = ((int) moves[0].charAt(0)) - 97;
        int oldY = 8 - Integer.parseInt(Character.toString(moves[0].charAt(1)));
        int newX = ((int) moves[1].charAt(0)) - 97;
        int newY = 8 - Integer.parseInt(Character.toString(moves[1].charAt(1)));

        // System.out.println("Move xCo from: " + Integer.toString(oldX) + " to xcCo: " + Integer.toString(newX));
        // System.out.println("Move yCo from: " + Integer.toString(oldY) + " to yCo: " + Integer.toString(newY));



        //////////////////////////////////////////
        /////////////////Validity/////////////////
        //////Check the pieces too///////////////

        ///sorry i couldnt find another way but for start that works//////

        if (board.getPositions()[newY][newX].getPiece() == null) {
            //non-diagonal
            if (Math.abs(oldX - newX) != Math.abs(oldY - newY)) {
                System.out.println("You did not move your piece diagonally try again!");
                System.out.println("");
            }
            //diagonal
            else {
                //single movement
                if (Math.abs(oldX - newX) == 1) {
                    Color c =  board.getPositions()[oldY][oldX].getPiece().getColor();
                    board.getPositions()[newY][newX].setPiece(board.getPositions()[oldY][oldX].getPiece());
                    board.getPositions()[oldY][oldX].setPiece(null);

                    //depending on the colour of the moving piece checks if its new
                    //position is on boundaries in order to change its rank from pawn
                    //to king
                    if((newY==7)&(c==Color.Red))
                    {
                        board.getPositions()[newY][newX].getPiece().setRank(Rank.King);

                    }
                    else if((newY==0)&(c==Color.White))
                    {
                        board.getPositions()[newY][newX].getPiece().setRank(Rank.King);
                    }
                    // Make again the letters of the coordinates as characters to
                    // print a message about where moved the piece
                    char letterS = (char) (oldX + 97);
                    char letterE = (char) (newX + 97);
                    System.out.println("Your piece moved from " + letterS + (8 - oldY) + " to " + letterE + (8 - newY));
                }
                //jump
                if (Math.abs(oldX - newX) == 2) {
                    //keeps the colour of the piece that is going to jump
                    Color jumperColor =  board.getPositions()[oldY][oldX].getPiece().getColor();


                    //Check if the piece moved North East and find the Jumped Piece
                    if (((oldX - newX) == 2) & ((newY - oldY) == 2))
                    {
                        //keeps the colour of the piece that is going to be erased
                        Color jumpedColor = board.getPositions()[oldY+1][oldX-1].getPiece().getColor();

                        //checks if the one piece can jump the other by contrasting their colours
                        if(jumperColor != jumpedColor)

                        {   board.getPositions()[newY][newX].setPiece(board.getPositions()[oldY][oldX].getPiece());
                            //erase the jumped piece from the board
                            board.getPositions()[oldY+1][oldX-1].setPiece(null);
                            //erase the piece that we moved from its starting position at the board
                            board.getPositions()[oldY][oldX].setPiece(null);

                            if((newY==7)&(jumperColor==Color.Red))
                            {
                                board.getPositions()[newY][newX].getPiece().setRank(Rank.King);

                            }
                            else if((newY==0)&(jumperColor==Color.White))
                            {
                                board.getPositions()[newY][newX].getPiece().setRank(Rank.King);
                            }
                            //we track the number of the eaten pieces in order to determine later the winner
                            if (jumpedColor == Color.Red)
                            {
                                RedPieces -= 1;
                            }
                            else
                            {
                                 WhitePieces -= 1;
                            }

                            // Make again the letters of the coordinates as characters to
                            // print a message about where moved the piece
                            char letterS = (char) (oldX + 97);
                            char letterE = (char) (newX + 97);
                            System.out.println("Your piece moved from " + letterS + (8 - oldY) + " to " + letterE + (8 - newY));

                        }
                        // if the colours of the pieces are the same then the jump can not be performed
                        //because the player can not jump his/her own pieces
                        else
                        {
                            System.out.println("You can not jump your own piece");
                        }
                    }
                    //Check if the piece moved South East and find the Jumped Piece
                    else if (((oldX - newX) == -2) & ((newY - oldY) == 2))
                    {
                        Color jumpedColor = board.getPositions()[oldY+1][oldX+1].getPiece().getColor();
                        if(jumperColor != jumpedColor) {
                            board.getPositions()[newY][newX].setPiece(board.getPositions()[oldY][oldX].getPiece());
                            board.getPositions()[oldY + 1][oldX + 1].setPiece(null);
                            board.getPositions()[oldY][oldX].setPiece(null);

                            if((newY==7)&(jumperColor==Color.Red))
                            {
                                board.getPositions()[newY][newX].getPiece().setRank(Rank.King);

                            }
                            else if((newY==0)&(jumperColor==Color.White))
                            {
                                board.getPositions()[newY][newX].getPiece().setRank(Rank.King);
                            }

                            if (jumpedColor == Color.Red) {
                                RedPieces -= 1;
                            } else {
                                WhitePieces -= 1;
                            }
                            // Make again the letters of the coordinates as characters to
                            // print a message about where moved the piece
                            char letterS = (char) (oldX + 97);
                            char letterE = (char) (newX + 97);
                            System.out.println("Your piece moved from " + letterS + (8 - oldY) + " to " + letterE + (8 - newY));

                        }
                        else
                        {
                            System.out.println("You can not jump your own piece");
                        }

                    }
                    //Check if the piece moved North West and find the Jumped Piece
                    else if (((oldX - newX) == 2) & ((newY - oldY) == -2))
                    {
                        Color jumpedColor = board.getPositions()[oldY-1][oldX-1].getPiece().getColor();
                        if(jumperColor != jumpedColor) {
                            board.getPositions()[newY][newX].setPiece(board.getPositions()[oldY][oldX].getPiece());
                            board.getPositions()[oldY - 1][oldX - 1].setPiece(null);
                            board.getPositions()[oldY][oldX].setPiece(null);
                            if((newY==7)&(jumperColor==Color.Red))
                            {
                                board.getPositions()[newY][newX].getPiece().setRank(Rank.King);

                            }
                            else if((newY==0)&(jumperColor==Color.White))
                            {
                                board.getPositions()[newY][newX].getPiece().setRank(Rank.King);
                            }
                            if (jumpedColor == Color.Red) {
                                RedPieces -= 1;
                            } else {
                                WhitePieces -= 1;
                            }
                            // Make again the letters of the coordinates as characters to
                            // print a message about where moved the piece
                            char letterS = (char) (oldX + 97);
                            char letterE = (char) (newX + 97);
                            System.out.println("Your piece moved from " + letterS + (8 - oldY) + " to " + letterE + (8 - newY));

                        }
                        else{
                            System.out.println("You can not jump your own piece");
                        }
                    }
                    //Check if the piece moved South West and find the Jumped Piece
                    else
                    {
                        Color jumpedColor = board.getPositions()[oldY - 1][oldX + 1].getPiece().getColor();
                        if(jumperColor != jumpedColor) {
                            board.getPositions()[newY][newX].setPiece(board.getPositions()[oldY][oldX].getPiece());
                            board.getPositions()[oldY - 1][oldX + 1].setPiece(null);
                            board.getPositions()[oldY][oldX].setPiece(null);
                            if((newY==7)&(jumperColor==Color.Red))
                            {
                                board.getPositions()[newY][newX].getPiece().setRank(Rank.King);

                            }
                            else if((newY==0)&(jumperColor==Color.White))
                            {
                                board.getPositions()[newY][newX].getPiece().setRank(Rank.King);
                            }
                            if (jumpedColor == Color.Red) {
                                RedPieces -= 1;
                            } else {
                                WhitePieces -= 1;
                            }
                            // Make again the letters of the coordinates as characters to
                            // print a message about where moved the piece
                            char letterS = (char) (oldX + 97);
                            char letterE = (char) (newX + 97);
                            System.out.println("Your piece moved from " + letterS + (8 - oldY) + " to " + letterE + (8 - newY));

                        }
                        else{
                            System.out.println("You can not jump your own piece");
                        }
                    }


                    }
            }
            //////////////////////////////////////////
            //////////////////////////////////////////

            //////////////////////////////////////////
            ////////Check the killed piece////////////
            //////////////////////////////////////////
        }
        else
        {
            System.out.println("Invalid");
        }
        return board;

    }

    public static void displayBoard(ChessBoard board) {

        System.out.println("      a     b     c     d     e     f     g     h     ");
        System.out.println("  +--------------------------------------------------+");

        for(int i = 0; i < 8; i++)
        {
        int rowNumber = i;
        String row = Integer.toString(8 - rowNumber) + " | ";

        for(int j = 0; j < 8; j++)
            row = row + board.getPositions()[rowNumber][j].getPieceRepresentation() + " ";

        row = row + " | " + Integer.toString(8 - rowNumber) ;

        System.out.println(row);
    }

        System.out.println("  +--------------------------------------------------+");
        System.out.println("      a     b     c     d     e     f     g     h     ");

    }

   
}


