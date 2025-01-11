package com.example.chess.pieces;

import com.example.chess.Piece;

public class Knight extends Piece {

    private static final String wUrl = "/pieces/w-knight.png";
    private static final String bUrl = "/pieces/b-knight.png";

    public Knight(String color){


        super("knight",color,color.equals("white")? wUrl: bUrl);




    }

}
