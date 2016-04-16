package com.my.snake.domain;

import com.my.snake.constant.SnakeUnit;

/**
 * Created by liwangchun on 16/4/16.
 */
public class Snake {
    private int x;
    private int y;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void moveLeft(){
      x-= SnakeUnit.SPEED;
    }

    public void moveRight(){
      x+=SnakeUnit.SPEED;
    }

    public void moveUp(){
     y-=SnakeUnit.SPEED;
    }
    public void moveDown(){
     y+=SnakeUnit.SPEED;
    }
}
