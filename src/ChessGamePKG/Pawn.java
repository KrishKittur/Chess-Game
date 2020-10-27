package ChessGamePKG;

import java.util.ArrayList;
import java.util.Arrays;

public class Pawn extends Piece {

    //Create the moved attribute unique to the Pawn Piece
    boolean moved;

    //Create the constructor for the Pawn Piece
    Pawn(int start_x, int start_y, String color) {
        super(start_x, start_y, "P", color);
        this.moved = false;
    }

    //Create the get_moves method for the Pawn Piece
    ArrayList<int[]> get_moves() {
        ArrayList<int[]> moves = new ArrayList<int[]>();

        if (this.color.equals("W")) {
            if (this.row - 1 >= 0) {
                if (Piece.board[this.row - 1][this.col].equals("  ")) {
                    int[] move = {this.row - 1, this.col};
                    moves.add(move);
                    if (this.row - 2 >= 0 && !this.moved) {
                        int[] move2 = {this.row - 2, this.col};
                        moves.add(move2);
                    }
                }
            }

            if (this.row - 1 >= 0 && this.col - 1 >= 0) {
                if (!Piece.board[this.row - 1][this.col - 1].equals("  ")) {
                    if (!Character.toString(Piece.board[this.row - 1][this.col - 1].charAt(0)).equals(this.color)) {
                        int[] move = {this.row - 1, this.col - 1};
                        moves.add(move);
                    }
                }
            }
            if (this.row - 1 >= 0 && this.col + 1 <= 7) {
                if (!Piece.board[this.row - 1][this.col + 1].equals("  ")) {
                    if (!Character.toString(Piece.board[this.row - 1][this.col + 1].charAt(0)).equals(this.color)) {
                        int[] move = {this.row - 1, this.col + 1};
                        moves.add(move);
                    }
                }
            }

        } else if (this.color.equals("B")) {
            if (this.row + 1 <= 7) {
                if (Piece.board[this.row + 1][this.col].equals("  ")) {
                    int[] move = {this.row + 1, this.col};
                    moves.add(move);
                    if (this.row + 2 <= 7 && !this.moved) {
                        int[] move2 = {this.row + 2, this.col};
                        moves.add(move2);
                    }
                }
            }
            if (this.row + 1 <= 7 && this.col + 1 <= 7) {
                if (!Piece.board[this.row + 1][this.col + 1].equals("  ")) {
                    if (!Character.toString(Piece.board[this.row + 1][this.col + 1].charAt(0)).equals(this.color)) {
                        int[] move = {this.row + 1, this.col + 1};
                        moves.add(move);
                    }
                }
            }
            if (this.row + 1 <= 7 && this.col - 1 >= 0) {
                if (!Piece.board[this.row + 1][this.col - 1].equals("  ")) {
                    if (!Character.toString(Piece.board[this.row + 1][this.col - 1].charAt(0)).equals(this.color)) {
                        int[] move = {this.row + 1, this.col - 1};
                        moves.add(move);
                    }
                }
            }
        }

        return moves;
    }

}
