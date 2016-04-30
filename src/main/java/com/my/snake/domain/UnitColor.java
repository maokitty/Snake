package com.my.snake.domain;

/**
 * Created by liwangchun on 16/4/30.
 */
public enum UnitColor {
    BLACK(0),RED(1);
    private int value;
    public int getValue(){
        return value;
    }
    UnitColor(int value){
        this.value=value;
    }
}
