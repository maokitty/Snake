package com.my.snake.util;

import com.my.snake.constant.SnakeUnit;
import com.my.snake.domain.Snake;
import org.apache.log4j.PropertyConfigurator;
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
    public Pencil(Snake snake){
      this.snake=snake;
    }
    @Override
    public void paint(Graphics graphics){
//        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        drawSnakeUnit(snake,graphics);
    }
    private  void drawSnakeUnit(Snake snake,Graphics pencil){
        super.paint(pencil);
        drawSnakeUnitUp(snake, pencil);
        drawSnakeUnitDown(snake, pencil);
        drawSnakeUnitLeft(snake, pencil);
        drawSnakeUnitRight(snake,pencil);
    }
    private void drawSnakeUnitUp(Snake snake,Graphics pencil){
        System.out.println("Pencil.drawSnakeUnitUp 1x:{} 1y:{} 2:x{} 2y:{}" + snake.getX() + ":" + snake.getY() + ":" + (snake.getX() + SnakeUnit.WIDTH) + ":" + snake.getY());
        pencil.drawLine(snake.getX(), snake.getY(), snake.getX() + SnakeUnit.WIDTH, snake.getY());
        logger.info("Pencil.drawSnakeUnitUp 1x:{} 1y:{} 2:x{} 2y:{}", snake.getX(), snake.getY(), snake.getX() + SnakeUnit.WIDTH, snake.getY());
    }
    private void drawSnakeUnitDown(Snake snake,Graphics pencil){
        System.out.println("Pencil.drawSnakeUnitDown 1x:{} 1y:{} 2:x{} 2y:{}" + ":" + snake.getX() + ":" + snake.getY() + SnakeUnit.HEIGHT + ":" + snake.getX() + SnakeUnit.WIDTH + ":" + snake.getY() + SnakeUnit.HEIGHT);
        pencil.drawLine(snake.getX(), snake.getY() + SnakeUnit.HEIGHT, snake.getX() + SnakeUnit.WIDTH, snake.getY() + SnakeUnit.HEIGHT);
        logger.info("Pencil.drawSnakeUnitDown 1x:{} 1y:{} 2:x{} 2y:{}", snake.getX(), snake.getY() + SnakeUnit.HEIGHT, snake.getX() + SnakeUnit.WIDTH, snake.getY() + SnakeUnit.HEIGHT);
    }
    private void drawSnakeUnitLeft(Snake snake,Graphics pencil){
        System.out.println("Pencil.drawSnakeUnitLeft 1x:{} 1y:{} 2:x{} 2y:{}" + ":" + snake.getX() + ":" + snake.getY() + ":" + snake.getX() + ":" + snake.getY() + SnakeUnit.HEIGHT);
        pencil.drawLine(snake.getX(), snake.getY(), snake.getX(), snake.getY() + SnakeUnit.HEIGHT);
        logger.info("Pencil.drawSnakeUnitLeft 1x:{} 1y:{} 2:x{} 2y:{}", snake.getX(), snake.getY(), snake.getX(), snake.getY() + SnakeUnit.HEIGHT);
    }
    private void drawSnakeUnitRight(Snake snake,Graphics pencil){
        System.out.println("Pencil.drawSnakeUnitRight 1x:{} 1y:{} 2:x{} 2y:{}" + ":" + snake.getX() + SnakeUnit.WIDTH + ":" + snake.getY() + ":" + snake.getX() + SnakeUnit.WIDTH + ":" + snake.getY() + SnakeUnit.HEIGHT);
        pencil.drawLine(snake.getX() + SnakeUnit.WIDTH, snake.getY(), snake.getX() + SnakeUnit.WIDTH, snake.getY() + SnakeUnit.HEIGHT);
        logger.info("Pencil.drawSnakeUnitRight 1x:{} 1y:{} 2:x{} 2y:{}", snake.getX() + SnakeUnit.WIDTH, snake.getY(), snake.getX() + SnakeUnit.WIDTH, snake.getY() + SnakeUnit.HEIGHT);
    }

}
