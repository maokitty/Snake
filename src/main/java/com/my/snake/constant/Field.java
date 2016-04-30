package com.my.snake.constant;

/**
 * Created by liwangchun on 16/4/16.
 */
public class Field {
    //蛇可运行的区域 每个区域都需要画一个蛇的单元
    public static final int WIDTH=40;
    public static final int HEIGHT=40;

    //运动区域的每个单元代表像素长度
    public static final int UNIT_PIX=10;
    //蛇总共可运行的区域
    public static  final int FIELD_SIZE=WIDTH*HEIGHT;
    //蛇运行窗口的起始位置
    public static final int SNAKE_FIELD_LOCATION_X=10;
    public static final int SNAKE_FIELD_LOCATION_Y=10;

    //游戏整个窗口的位置
    public static final int GAME_LOCATION_X=400;
    public static final int GAME_LOCATION_Y=200;

    //游戏整个窗口的大小
    public static  final int GANE_WIDTH=610;
    public static  final int GANE_HEIGHT=450;

    //游戏的名字
    public static final String GAME_NAME="蛇蛇蛇";

}
