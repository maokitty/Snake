package com.my.snake.constant;

/**
 * Created by liwangchun on 16/4/16.
 */
public class Field {
    //蛇可运行的区域 每个区域都需要画一个蛇的单元
    public static final int ROW=40;
    public static final int COL=40;

    //运动区域的每个单元代表像素长度
    public static final int UNIT_PIX=10;
    //蛇总共可运行的区域
    public static  final int FIELD_SIZE=ROW*COL;
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

    //蛇移动的方向
    public static final int LEFT=-1;
    public static final int RIGHT=1;
    public static final int UP=-COL;
    public static final int DOWN=COL;

    //用值来代表单元格属性：食物 空白 蛇身
    public static final int FOOD=0;
    public static final int SPACE=FIELD_SIZE;
    public static final int SNAKE_BODY=2*FIELD_SIZE;

}
