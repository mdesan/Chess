package com.example.chess;

import com.example.chess.pieces.Pawn;
import javafx.scene.image.Image;

public class Piece {

    public String name;
    public String color;
    public String imgPath;
    public Image image;



    public Piece(String name, String color,String imgPath){
        this.name=name;
        this.color=color;
        this.imgPath=imgPath;
        this.image=new Image(getClass().getResource(imgPath).toString());


    }
    public Piece(Piece piece){
        this.name= piece.getName();
        this.color=piece.getColor();
        this.imgPath = piece.getImgPath();
        this.image = new Image(getClass().getResource(imgPath).toString());


    }

    public String getName(){
        return this.name;
    }
    public String getColor(){
        return this.color;
    }

    public String getImgPath(){
        return this.imgPath;
    }

    public Image getImage(){
//        return new Image(this.image.getUrl());
        return this.image;
    }



    public static void main(String [] args){

    }



}
