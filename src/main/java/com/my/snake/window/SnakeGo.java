package com.my.snake.window;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liwangchun on 16/4/16.
 */
public class SnakeGo {
    static {
        PropertyConfigurator.configure("./src/main/resources/log4j.properties");
    }
    private static Logger logger= LoggerFactory.getLogger(SnakeGo.class);
    public static void main(String[] args) {
        new SnakeField();
    }
}
