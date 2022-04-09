package Levels;

import Obj.Ball;
import Obj.Brick;
import Obj.Paddle;

import java.awt.Color;

public class Level1 extends LevelGeneric {

    public Level1(int row, int col) {
        super(row, col);

        ball = new Ball(20, 20);
        paddle = new Paddle(100, 8, 310, 0);

        BrickPlacer();
    }

    @Override
    protected void BrickPlacer(){
        boolean red = true;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if(red)
                    map[i][j] = new Brick(j, i, bricksWidth, bricksHeight, Color.red);
                else
                    map[i][j] = new Brick(j, i, bricksWidth, bricksHeight, Color.orange);
                red = !red;
            }
        }
    }
}
