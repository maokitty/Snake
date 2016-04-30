package com.my.snake.window;

import com.my.snake.constant.Field;
import com.my.snake.domain.Food;
import com.my.snake.domain.Snake;
import com.my.snake.util.Pencil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by liwangchun on 16/4/16.
 */
public class SnakeField extends JFrame implements KeyListener{
    private static final Logger logger= LoggerFactory.getLogger(SnakeField.class);
    private Pencil pencil=null;
    private Snake snake;
    private Food food;
    public SnakeField(Snake snake,Food food){
        this.snake=snake;
        pencil=new Pencil(snake,food);
        add(pencil);
        addKeyListener(this);
        setTitle(Field.GAME_NAME);
        setSize(new Dimension(Field.GANE_WIDTH, Field.GANE_HEIGHT));
        setLocation(Field.GAME_LOCATION_X, Field.GAME_LOCATION_Y);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void keyTyped(KeyEvent e) {
     logger.info("SnakeField.keyTyped ",e.getKeyChar());
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
//           snake.moveDown();
        } else if(e.getKeyCode() == KeyEvent.VK_UP){
//            snake.moveUp();
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT){
//            snake.moveLeft();
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
//            snake.moveRight();
        }
        repaint();
    }

    public void keyReleased(KeyEvent e) {
        logger.info("SnakeField.keyPressed ",e.getKeyChar());
    }
}
