package ChessGamePKG;

import java.util.ArrayList;
import java.lang.Math;
import java.lang.Character;


public class Knight extends Piece {

    //Create the constructor for the Knight Piece
    Knight(int start_x, int start_y, String color) {
        super(start_x, start_y, "N", color);
    }

    //Create the get_moves method for the Knight Piece
    ArrayList<int[]> get_moves() {
        ArrayList<int[]> moves = new ArrayList<int[]>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((Math.abs(j - this.col) == 1 && Math.abs(i - this.row) == 2) || (Math.abs(j - this.col) == 2 && Math.abs(i - this.row) == 1)) {

                    if (Piece.board[i][j].equals("  ")) {
                        int[] move = {i, j};
                        moves.add(move);
                    } else if (!Character.toString(Piece.board[i][j].charAt(0)).equals(this.color)) {
                        int[] move = {i, j};
                        moves.add(move);
                    }
                }
            }
        }

        return moves;
    }


}
