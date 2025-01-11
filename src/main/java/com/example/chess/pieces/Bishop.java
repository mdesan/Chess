package com.example.chess.pieces;

import com.example.chess.Piece;

public class Bishop extends Piece {

    private static final String wUrl = "/pieces/w-bishop.png";
    private static final String bUrl = "/pieces/b-bishop.png";

    public Bishop(String color){


        super("bishop",color,color.equals("white")? wUrl: bUrl);




    }

}
