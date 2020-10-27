package ChessGamePKG;

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Integer;

public abstract class Piece {

    // Create The Board
    static String[][] board = {
            {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
            {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
            {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
            {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
            {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
            {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
            {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
            {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},

    };

    //Create Pieces List
    static ArrayList<Piece> pieces = new ArrayList<Piece>();

    //Create all instance attributes
    int row;
    int col;
    String abr;
    String color;


    // Create The Constructor
    Piece(int start_x, int start_y, String abr, String color) {
        this.col = start_x;
        this.row = start_y;
        this.abr = abr;
        this.color = color;
        pieces.add(this);
        Piece.board[this.row][this.col] = this.color + this.abr;

    }

    //Create the get_moves method
    ArrayList<int[]> get_moves() {
        return new ArrayList<int[]>();
    }


    //Create The Draw Board Function
    static void drawBoard() {
        System.out.println("");
        System.out.println("     1    2    3    4    5    6    7    8   ");
        System.out.println("   - - - - - - - - - - - - - - - - - - - -");

        for (int i = 0; i < Piece.board.length; i++) {
            for (int j = 0; j < Piece.board[0].length; j++) {

                if (j == 0) {
                    System.out.print(i + 1 + " | " + Piece.board[i][j] + " | ");
                } else {
                    System.out.print(Piece.board[i][j] + " | ");
                }

            }

            System.out.println("");
            System.out.println("   - - - - - - - - - - - - - - - - - - - -");

        }
    }
}

