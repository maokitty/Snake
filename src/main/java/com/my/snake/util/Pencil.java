package com.my.snake.util;

import com.my.snake.constant.Field;
import com.my.snake.domain.Food;
import com.my.snake.domain.Snake;
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
    private Snake snake;
    private Food food;
    public Pencil(Snake snake,Food food){
        this.snake=snake;
        this.food=food;
    }
    @Override
    public void paint(Graphics graphics){
        super.paint(graphics);
        playSnakeField(graphics);
        drawUnit(food.getX(), food.getY(), UnitColor.RED, graphics);
        drawUnit(snake.getX(), snake.getY(), UnitColor.BLACK, graphics);
    }

    /**
     * 以左上角为一个单元的起点，每个单元为运动场地的像素长度
     * @param x
     * @param y
     * @param graphics
     */
    private  void drawUnit(int x,int y,UnitColor unitColor,Graphics graphics){
        Color origColor=graphics.getColor();
        if (unitColor.getValue() == 0)
        {
            graphics.setColor(Color.BLACK);
        }else if (unitColor.getValue() == 1){
            graphics.setColor(Color.RED);
        }
        graphics.drawRect(x,y, Field.UNIT_PIX, Field.UNIT_PIX);
        logger.info("drawUnit x1:{} y1:{} x2:{} y2:{}",new Object[]{x,y,x+Field.UNIT_PIX,y+Field.UNIT_PIX});
        graphics.setColor(origColor);
    }
    private void playSnakeField(Graphics graphics){
        graphics.drawRect(Field.SNAKE_FIELD_LOCATION_X,Field.SNAKE_FIELD_LOCATION_Y,
                Field.SNAKE_FIELD_LOCATION_X+Field.WIDTH* Field.UNIT_PIX,Field.SNAKE_FIELD_LOCATION_Y+Field.HEIGHT* Field.UNIT_PIX);
    }
}
