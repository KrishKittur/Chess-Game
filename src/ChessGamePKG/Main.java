package ChessGamePKG;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Integer;
import java.lang.String;
import java.lang.Character;

public class Main {

    // Function to check whether inputs are valid
    static boolean valid(String uPiece, String uMove, String t) {

        //Check whether inputs are ints
        try {
            Integer.parseInt(uPiece);
            Integer.parseInt(uMove);
        } catch (NumberFormatException error) {
            System.out.println("Please enter Integers!");
            return false;
        }

        int userPiece = Integer.parseInt(uPiece);
        int userMove = Integer.parseInt(uMove);

        //Check whether the inputs are have a length of 2
        if (Integer.toString(userPiece).length() != 2 || Integer.toString(userMove).length() != 2) {
            System.out.println("Please enter two digit Integers!");
            return false;
        }

        //Change the input coordinates, and make sure that they are valid before we do indexing
        int pieceCol = (Integer.parseInt(String.valueOf(Integer.toString(userPiece).charAt(0)))) - 1;
        int pieceRow = (Integer.parseInt(String.valueOf(Integer.toString(userPiece).charAt(1)))) - 1;
        int moveCol = (Integer.parseInt(String.valueOf(Integer.toString(userMove).charAt(0)))) - 1;
        int moveRow = (Integer.parseInt(String.valueOf(Integer.toString(userMove).charAt(1)))) - 1;

        if (pieceCol < 0 || pieceCol > 7 || pieceRow < 0 || pieceRow > 7 || moveCol < 0 || moveCol > 7 || moveRow < 0 || moveRow > 7) {
            System.out.println("Your input was not inside the board!");
            return false;
        }

        //Check whether the piece they selected is actually in that coordinate and matches their color
        Piece selected_piece = null;
        for (Piece p : Piece.pieces) {
            if (p.col == pieceCol && p.row == pieceRow) {
                selected_piece = p;
                break;
            }
        }

        if (selected_piece == null) {
            System.out.println("There is not a piece where you selected");
            return false;
        } else if (!selected_piece.color.equals(Character.toString(t.charAt(0)))) {
            System.out.println("Hey... That's not your Piece!");
            return false;
        }

        //Check whether the move that they selected is a valid move that belongs to that piece
        int[] selectedUserMove = {moveRow, moveCol};
        for (int[] move : selected_piece.get_moves()) {
            if (Arrays.equals(selectedUserMove, move)) {
                return true;
            }
        }

        System.out.println("The Piece you have selected cannot move to " + "(" + (moveCol + 1) + ", " + (moveRow + 1) + ").");
        return false;
    }


    public static void main(String[] args) {

        /* Create all of the pieces */

        //Create all of the white Pawns
        Pawn wPawn1 = new Pawn(0, 6, "W");
        Pawn wPawn2 = new Pawn(1, 6, "W");
        Pawn wPawn3 = new Pawn(2, 6, "W");
        Pawn wPawn4 = new Pawn(3, 6, "W");
        Pawn wPawn5 = new Pawn(4, 6, "W");
        Pawn wPawn6 = new Pawn(5, 6, "W");
        Pawn wPawn7 = new Pawn(6, 6, "W");
        Pawn wPawn8 = new Pawn(7, 6, "W");

        // Create all of the black Pawns
        Pawn bPawn1 = new Pawn(0, 1, "B");
        Pawn bPawn2 = new Pawn(1, 1, "B");
        Pawn bPawn3 = new Pawn(2, 1, "B");
        Pawn bPawn4 = new Pawn(3, 1, "B");
        Pawn bPawn5 = new Pawn(4, 1, "B");
        Pawn bPawn6 = new Pawn(5, 1, "B");
        Pawn bPawn7 = new Pawn(6, 1, "B");
        Pawn bPawn8 = new Pawn(7, 1, "B");

        // Create all of the white Knights
        Knight wKnight1 = new Knight(1, 7, "W");
        Knight wKnight2 = new Knight(6, 7, "W");

        // Create all of the black Knights
        Knight bKnight1 = new Knight(1, 0, "B");
        Knight bKnight2 = new Knight(6, 0, "B");

        //Create all of the white Bishops
        Bishop wBishop1 = new Bishop(2, 7, "W");
        Bishop wBishop2 = new Bishop(5, 7, "W");

        //Create all of the black Bishops
        Bishop bBishop1 = new Bishop(2, 0, "B");
        Bishop bBishop2 = new Bishop(5, 0, "B");

        //Create all of the white Rooks
        Rook wRook1 = new Rook(0, 7, "W");
        Rook wRook2 = new Rook(7, 7, "W");

        //Create all of the black Rooks
        Rook bRook1 = new Rook(0, 0, "B");
        Rook bRook2 = new Rook(7, 0, "B");

        //Create the white Queen
        Queen wQueen1 = new Queen(3, 7, "W");

        //Create the black Queen
        Queen bQueen1 = new Queen(3, 0, "B");

        //Create the white King
        King wKing1 = new King(4, 7, "W");

        //Create the black King
        King bKing1 = new King(4, 0, "B");


        /* Create The Main Game "Loop" */

        // Print The Information about the game
        System.out.println("\nWelcome To Chess!");
        System.out.println("Created by Krish Kittur.");
        System.out.println("Simple chess rules apply.");
        System.out.println("When you are prompted to enter the position of the piece you want to select, please enter the column and then the row.");
        System.out.println("So if I wanted to select a piece in the top right hand corner I would enter: 81, because '8' is the column and '1' is the row.");
        System.out.println("Same rules apply when choosing where to move.");
        System.out.println("Have fun!\n\n\n");

        // Main Game Loop
        String turn = "White";
        while (true) {

            //Create the Scanner
            Scanner fetch = new Scanner(System.in);

            //Print Board
            Piece.drawBoard();

            //If one of the kings is non-existent then end the game
            if (!Piece.pieces.contains(wKing1)) {
                System.out.println("Black Wins!");
                break;
            }
            if (!Piece.pieces.contains(bKing1)) {
                System.out.println("White Wins!");
                break;
            }


            //Print who's turn it is
            System.out.println("It is " + turn + "'s turn.");

            //Get the inputs
            System.out.print("Which piece would you like to select: ");
            String userPiece = fetch.next();
            System.out.print("Where would you like to move: ");
            String userMove = fetch.next();

            //Check if the inputs are valid
            if (!valid(userPiece, userMove, turn)) {
                System.out.println("Please Try Again...\n");
                continue;
            } else {

                // Create the coordinates of where the selected piece is located and the moves
                int pieceCol = (Integer.parseInt(String.valueOf(Integer.toString(Integer.parseInt(userPiece)).charAt(0)))) - 1;
                int pieceRow = (Integer.parseInt(String.valueOf(Integer.toString(Integer.parseInt(userPiece)).charAt(1)))) - 1;
                int moveCol = (Integer.parseInt(String.valueOf(Integer.toString(Integer.parseInt(userMove)).charAt(0)))) - 1;
                int moveRow = (Integer.parseInt(String.valueOf(Integer.toString(Integer.parseInt(userMove)).charAt(1)))) - 1;

                //Find the piece that is located where the user selected and make it go away
                Piece selected_piece = null;
                for (Piece p : Piece.pieces) {
                    if (p.col == pieceCol && p.row == pieceRow) {
                        selected_piece = p;
                        break;
                    }
                }

                //If there is a piece which the user moved piece takes out, then delete it
                Piece delete_piece = null;
                for (Piece p : Piece.pieces) {
                    if (p.col == moveCol && p.row == moveRow) {
                        delete_piece = p;
                        break;
                    }
                }

                if (delete_piece != null) {
                    Piece.board[delete_piece.row][delete_piece.col] = "  ";
                    Piece.pieces.remove(delete_piece);
                }

                //Move the selected piece
                assert selected_piece != null;
                Piece.board[selected_piece.row][selected_piece.col] = "  ";
                selected_piece.col = moveCol;
                selected_piece.row = moveRow;
                Piece.board[selected_piece.row][selected_piece.col] = selected_piece.color + selected_piece.abr;

                //Check if the piece is a pawn, and set moved to true
                if (selected_piece instanceof Pawn) {
                    ((Pawn) selected_piece).moved = true;
                }


            }


            //Switch the turns at the end of the loop
            if (turn.equals("White")) {
                turn = "Black";
            } else {
                turn = "White";
            }


        }


    }
}
