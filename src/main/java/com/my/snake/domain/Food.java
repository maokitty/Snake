package com.my.snake.domain;

/**
 * Created by liwangchun on 16/4/30.
 */
public class Food {
    private int row; //运动区域开始就有10个像素的偏移，刚好设定第1行1列就是起点
    private int col;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
