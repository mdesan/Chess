package com.example.chess;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;



public class Square extends Button {

    public Piece piece=null;
    public boolean isLightSquare = false;
    public boolean isClickable;
    public boolean occupied = false;
    public boolean isSelected = false;

    //coordinates
    public int x; //j (row starting from the top)
    public int y; //i (column starting from the left)


    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }


    public boolean getIsLightSquare(){
        return this.isLightSquare;
    }
    public void setToLightSquare(){
        this.isLightSquare=true;
    }

    public void setPiece(Piece piece){
        this.piece = new Piece(piece);
        this.occupied = true;
        this.displayImg();


    }
    public Piece getPiece(){
        return new Piece(this.piece); //this may not need a defensive copy
    }

    public void displayImg(){

        Image test = new Image(getClass().getResource(getPiece().getImgPath()).toString());
        ImageView view = new ImageView(test);
        view.setFitWidth(70);
        view.setFitHeight(70);
        setGraphic(view);


    }

    public void removeImg(){
        this.setGraphic(null);
    }


    public boolean getOccupied(){

        return this.occupied;


    }

    public void removePiece(){
        this.piece=null;
        this.occupied=false;
        this.setGraphic(null);
    }


    public void select(){
        this.isSelected=!isSelected;

    }

    public boolean getSelected(){
        return this.isSelected;
    }














}
