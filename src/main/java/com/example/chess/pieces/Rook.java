package com.example.chess.pieces;

import com.example.chess.Board;
import com.example.chess.Piece;
import com.example.chess.Square;

import java.util.ArrayList;

public class Rook extends Piece {

    private static final String wUrl = "/pieces/w-rook.png";
    private static final String bUrl = "/pieces/b-rook.png";

    public Rook(String color){




        super("rook",color,color.equals("white")? wUrl: bUrl);

    }

    //this method changes the pieces possibleMoves arraylist

    public void findPossibleSquares(Square square , ArrayList<Square> possibleSquares){
        int x = square.getX();
        int y = square.getY();

        //up

        for(int i =y;i>=0;i++){
            possibleSquares.add(Board.squares[x][i]);
            Board.squares[x][i].setStyle("-fx-base: yellow");
        }

        //down

        //left

        //right
        for(int i=x;i>=7;i++){
            possibleSquares.add(Board.squares[i][y]);
            Board.squares[i][y].setStyle("-fx-base: yellow");
        }


    }

    public static void main(String[] args){


    }

}
