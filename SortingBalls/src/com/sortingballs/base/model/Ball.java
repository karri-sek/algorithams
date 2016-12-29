package com.sortingballs.base.model;

/**
 * Created by sekhar on 28/12/16.
 */
public class Ball {


    private int value;

    private String colour;
    
    public Ball(int value){
	this.value = value;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
	return "Ball [value=" + value + ", colour=" + colour + "]";
    }


}
