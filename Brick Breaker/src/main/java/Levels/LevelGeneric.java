/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import Obj.Ball;
import Obj.Brick;
import Obj.Paddle;

import java.awt.*;

public abstract class LevelGeneric {
    protected Brick[][] map;
    protected int row;
    protected int col;
    protected int bricksWidth;
    protected int bricksHeight;
    protected int totalBlocks;
    protected Ball ball;
    protected Paddle paddle;

    public LevelGeneric(int row , int col){
        map = new Brick[row][col];
        this.row = row;
        this.col = col;
        totalBlocks = row*col;
        bricksWidth = 540/col;
        bricksHeight = 150/row;
    }

    public void draw(Graphics2D g) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (!map[i][j].getHit()) {
                    g.setColor(map[i][j].getColor());
                    g.fillRect(j * bricksWidth + 80, i * bricksHeight + 50, bricksWidth, bricksHeight);

                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j * bricksWidth + 80, i * bricksHeight + 50, bricksWidth, bricksHeight);

                }
            }

        }

        paddle.draw(g);
        ball.draw(g);
    }

    public int getTotalBlocks() {
        return totalBlocks;
    }

    public Brick[][] getMap(){
        return map;
    }

    public int getBricksWidth(){
        return bricksWidth;
    }

    public Ball getBall(){
        return ball;
    }

    public Paddle getPaddle(){
        return paddle;
    }

    protected abstract void BrickPlacer();

}
