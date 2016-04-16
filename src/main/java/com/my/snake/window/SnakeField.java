package com.my.snake.window;

import com.my.snake.constant.Field;

import javax.swing.*;
import java.awt.*;

/**
 * Created by liwangchun on 16/4/16.
 */
public class SnakeField extends JFrame {
    public SnakeField(){
        setTitle("蛇蛇蛇蛇");
        setSize(new Dimension(Field.WIDTH, Field.HEIGHT));
        setLocation(Field.LOCATION_X, Field.LOCATION_Y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
