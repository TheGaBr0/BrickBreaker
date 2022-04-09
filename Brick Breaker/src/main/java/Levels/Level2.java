package Levels;

import Obj.Ball;
import Obj.Brick;
import Obj.Paddle;

import java.awt.Color;

public class Level2 extends LevelGeneric {

    public Level2(int row, int col) {
        super(row, col);

        ball = new Ball(15, 15);
        paddle = new Paddle(70, 8, 320, 30);

        BrickPlacer();
    }

    @Override
    protected void BrickPlacer(){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if(i%2 == 0)
                    map[i][j] = new Brick(j, i, bricksWidth, bricksHeight, Color.yellow);
                else
                    map[i][j] = new Brick(j, i, bricksWidth, bricksHeight, Color.pink);

            }
        }
    }


}
