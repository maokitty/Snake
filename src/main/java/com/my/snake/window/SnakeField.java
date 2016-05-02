package com.my.snake.window;

import com.my.snake.constant.Field;
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
    int[] snakeBody=new int[Field.FIELD_SIZE]; //snakeBody里面放的都是从头到尾所有身体所在的位置
    int[] playField=new int[Field.FIELD_SIZE];
    int snakeSize;
    int HEAD=0;
    int[] mov=new int[]{Field.LEFT,Field.RIGHT,Field.UP,Field.DOWN};
    int food=4*Field.ROW+4; //从0开始计数的
    public SnakeField(){
        snakeBody[HEAD]=0*Field.ROW+0;
        snakeSize=1;
        playFieldReset(snakeBody,snakeSize,playField);
        pencil=new Pencil(playField);
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
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            if (isMovePossible(snakeBody[HEAD],Field.DOWN)){
                snakeBody[HEAD]+=Field.DOWN;
                playFieldReset(snakeBody, snakeSize, playField);
            }
        } else if(e.getKeyCode() == KeyEvent.VK_UP){
            if (isMovePossible(snakeBody[HEAD],Field.UP)){
                snakeBody[HEAD]+=Field.UP;
                playFieldReset(snakeBody, snakeSize, playField);
            }
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if (isMovePossible(snakeBody[HEAD],Field.LEFT)){
                snakeBody[HEAD]+=Field.LEFT;
                playFieldReset(snakeBody, snakeSize, playField);
            }
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if (isMovePossible(snakeBody[HEAD],Field.RIGHT)){
                logger.info("before"+snakeBody[HEAD]);
                snakeBody[HEAD]+=Field.RIGHT;
                logger.info("after"+snakeBody[HEAD]);
                playFieldReset(snakeBody,snakeSize,playField);
            }
        }
        repaint();
    }

    private void playFieldReset(int []snakeBody,int pSize,int[] playField){
        for (int idx=0;idx<Field.FIELD_SIZE;idx++){
            if (idx == food){
                playField[idx]=Field.FOOD;
            }else if(isCellFree(idx,pSize,snakeBody)){
                playField[idx]=Field.SPACE;
            }else {
                playField[idx]=Field.SNAKE_BODY;
            }
        }
    }

    private boolean isCellFree(int idx,int pSize,int[]snakeBody){
        for (int body=0;body<pSize;body++){
            if (idx == snakeBody[body])
                return false;
        }
        return true;
    }
    /**
     *只确保不会出去游戏框row->[0-ROW_MAX] col [0-COL_MAX]
     * @param idx (idx%ROW,idx%COL)代表当前单元格在哪个位置 ,值一直都是head所在的位置
     * @param move 移动方向 取值是 Field.LEFT RIGHT UP DOWN
     * @return 往4个方向是否可以移动
     */
    private boolean isMovePossible(int idx,int move){
       switch(move){
           case Field.LEFT:
               if (idx%Field.COL >0) {
                   return true;
               }
               break;
           case Field.RIGHT:
               if (idx%Field.COL <  Field.COL -1) {
                   return true;
               }
               break;
           case Field.UP:
               if (idx/Field.ROW >0)
                   return true;
               break;
           case Field.DOWN:
               if (idx/Field.ROW <Field.ROW-1)
                   return true;
               break;
           default:return false;
       }
        return false;
    }

    public void keyReleased(KeyEvent e) {
    }
}
