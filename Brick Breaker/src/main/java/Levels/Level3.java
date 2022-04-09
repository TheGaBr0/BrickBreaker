package Levels;

import Obj.Ball;
import Obj.Brick;
import Obj.Paddle;

import java.awt.Color;

public class Level3 extends LevelGeneric {

    public Level3(int row, int col) {
        super(row, col);

        ball = new Ball(12, 12);
        paddle = new Paddle(60, 8, 325, 40);

        BrickPlacer();
    }

    @Override
    protected void BrickPlacer(){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if(i%2 == 0 && j%3 != 0)
                    map[i][j] = new Brick(j, i, bricksWidth, bricksHeight, Color.lightGray);
                else
                    map[i][j] = new Brick(j, i, bricksWidth, bricksHeight, Color.darkGray);
            }
        }
    }
}
