package com.my.snake.window;

import com.my.snake.constant.SnakeUnit;
import com.my.snake.domain.Snake;
import org.apache.log4j.PropertyConfigurator;

import javax.swing.*;

/**
 * Created by liwangchun on 16/4/16.
 */
public class SnakeGo {
    public static void main(String[] args) {
        Snake snake=new Snake();
        snake.setX(SnakeUnit.DEFAULT_X);
        snake.setY(SnakeUnit.DEFAULT_Y);
        SnakeField snakeField=new SnakeField(snake);
    }
}
