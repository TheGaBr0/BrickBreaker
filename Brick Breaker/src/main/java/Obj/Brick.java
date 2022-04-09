package Obj;

import java.awt.*;

public class Brick {

    private final Color color;
    private final int x;
    private final int y;
    private final int bricksWidth;
    private final int bricksHeight;
    private boolean hit;

    public Brick(int x, int y, int bricksWidth, int bricksHeight, Color color){
        this.x = x;
        this.y = y;
        this.bricksHeight = bricksHeight;
        this.bricksWidth = bricksWidth;
        this.color = color;
        hit = false;
    }

    public void setHit(boolean value){
        hit = value;
    }

    public boolean getHit(){
        return hit;
    }

    public Color getColor(){
        return color;
    }

    public Rectangle getHitbox(){
        return new Rectangle(x * bricksWidth + 80, y * bricksHeight + 50, bricksWidth, bricksHeight);
    }


}
