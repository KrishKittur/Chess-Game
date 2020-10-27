package ChessGamePKG;

import java.util.ArrayList;
import java.lang.Math;
import java.lang.Character;
import java.lang.Integer;

public class Bishop extends Piece {

    //Create the constructor for the Bishop Piece
    Bishop(int start_x, int start_y, String color) {
        super(start_x, start_y, "B", color);
    }

    //Create the get_moves method for the Bishop Piece
    ArrayList<int[]> get_moves() {
        ArrayList<int[]> moves = new ArrayList<int[]>();

        int[][] possibleDirs = {{1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
        int currentDirPointer = 0;

        for (int i = 0; i < possibleDirs.length; i++) {
            for (int j = 1; j < Piece.board.length; j++) {
                int row_change = j * possibleDirs[currentDirPointer][0];
                int col_change = j * possibleDirs[currentDirPointer][1];
                int new_row = this.row + row_change;
                int new_col = this.col + col_change;

                if (new_row < 0 || new_row > 7 || new_col < 0 || new_col > 7) {
                    break;
                }
                if (!Piece.board[new_row][new_col].equals("  ")) {
                    if (!Character.toString(Piece.board[new_row][new_col].charAt(0)).equals(this.color)) {
                        int[] move = {new_row, new_col};
                        moves.add(move);
                    }
                    break;
                } else if (Piece.board[new_row][new_col].equals("  ")) {
                    int[] move = {new_row, new_col};
                    moves.add(move);
                }
            }
            currentDirPointer += 1;
        }
        return moves;
    }


}
