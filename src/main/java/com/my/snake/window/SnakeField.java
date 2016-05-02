package com.my.snake.window;

import com.my.snake.constant.Field;
import com.my.snake.util.Pencil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * Created by liwangchun on 16/4/16.
 */
public class SnakeField extends JFrame implements KeyListener{
    private static final Logger logger= LoggerFactory.getLogger(SnakeField.class);
    private Pencil pencil=null;
    int[] snakeBody=new int[Field.FIELD_SIZE+1]; //snakeBody里面放的都是从头到尾所有身体所在的位置
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
                makeMove(snakeBody,playField,Field.DOWN);
            }
        } else if(e.getKeyCode() == KeyEvent.VK_UP){
            if (isMovePossible(snakeBody[HEAD],Field.UP)){
                makeMove(snakeBody,playField,Field.UP);
            }
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if (isMovePossible(snakeBody[HEAD],Field.LEFT)){
                makeMove(snakeBody,playField,Field.LEFT);
            }
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if (isMovePossible(snakeBody[HEAD],Field.RIGHT)){
               makeMove(snakeBody,playField,Field.RIGHT);
            }
        }
        repaint();
    }

    private void makeMove(int[] snakeBody,int[] playField,int step){
        if (snakeBody[HEAD]+step!=food){
            shiftSnakeBody(snakeBody,snakeSize);//每个的坐标都是紧挨着的
            snakeBody[HEAD]+=step;
            playField[snakeBody[HEAD]]=Field.SNAKE_BODY;
            playField[snakeBody[snakeSize]]=Field.SPACE;
            playFieldReset(snakeBody, snakeSize, playField);
        }else{
            snakeSize+=1;
            Field.SCORE+=1;
            playField[food]=Field.SNAKE_BODY;
            shiftSnakeBody(snakeBody,snakeSize);
            snakeBody[HEAD]+=step;
            food=newFood(snakeSize,snakeBody);
            playFieldReset(snakeBody, snakeSize, playField);
        }
    }

    private int newFood(int snakeSize,int[]snakeBody){
        int food=-1;
        boolean cellFree=false;
        while (!cellFree){
            int col=new Random().nextInt(Field.COL);
            int row=new Random().nextInt(Field.ROW);
            food=row*Field.ROW+col;
            cellFree=isCellFree(food,snakeSize,snakeBody);
        }
        return food;
    }

    /**
     * 保证0的下标一直是蛇头
     * @param snakeBody
     * @param snakeSize
     */
    private void shiftSnakeBody(int[]snakeBody,int snakeSize){
        for (int i=snakeSize;i>0;i--){
            snakeBody[i]=snakeBody[i-1];
        }
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
        if (playField[idx+move] == Field.SNAKE_BODY) //蛇身不可以穿越
            return false;
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
