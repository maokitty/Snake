package com.my.snake.util;

import com.my.snake.constant.Field;
import com.my.snake.domain.UnitColor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;

/**
 * Created by liwangchun on 16/4/16.
 */
public class Pencil extends JPanel{
    private static final Logger logger= LoggerFactory.getLogger(Pencil.class);
    private int[] playField;
    public Pencil(int[] playField){
        this.playField=playField;
    }
    @Override
    public void paint(Graphics graphics){
        super.paint(graphics);
        playSnakeField(graphics);
        for (int i=0;i<playField.length;i++)
        {
            if (playField[i] == Field.SNAKE_BODY || playField[i]== Field.FOOD)
            {
                int row=i/Field.COL;
                int col=i%Field.COL;

                if (playField[i] == Field.SNAKE_BODY)
                {
                    logger.info("row"+row+":"+col+":"+i);
                    drawUnit(col, row, UnitColor.BLACK, graphics);//col -> x row -> y
                }else{
                    drawUnit(col, row, UnitColor.RED, graphics);
                }

            }
        }
    }

    /**
     * 以左上角为一个单元的起点，每个单元为运动场地的像素长度
     * @param row
     * @param col
     * @param graphics
     */
    private  void drawUnit(int row,int col,UnitColor unitColor,Graphics graphics){
        Color origColor=graphics.getColor();
        if (unitColor.getValue() == 0)
        {
            graphics.setColor(Color.BLACK);
        }else if (unitColor.getValue() == 1){
            graphics.setColor(Color.RED);
        }
        graphics.drawRect(row * Field.UNIT_PIX + Field.SNAKE_FIELD_LOCATION_X, col * Field.UNIT_PIX+Field.SNAKE_FIELD_LOCATION_Y, Field.UNIT_PIX, Field.UNIT_PIX);//row ,col从0开始计数，但是整个游戏框有个偏移
        graphics.setColor(origColor);
    }
    private void playSnakeField(Graphics graphics){
        graphics.drawRect(Field.SNAKE_FIELD_LOCATION_X,Field.SNAKE_FIELD_LOCATION_Y,
                Field.ROW* Field.UNIT_PIX,Field.COL* Field.UNIT_PIX);
    }
}
