package Obj;

import java.awt.*;

public class Paddle {
    private int x;
    private int hitboxHeight;
    private int hitboxWidth;
    private int offSet;

    public Paddle(int hitboxWidth,  int hitboxHeight, int x, int offSet){

        this.hitboxWidth = hitboxWidth;
        this.hitboxHeight = hitboxHeight;
        this.offSet = offSet;
        this.x = x;
    }

    public void draw(Graphics2D g){
        System.out.println(x);
        g.setColor(Color.yellow);
        g.fillRect(x, 550, hitboxWidth, hitboxHeight);
    }

    public void moveLeft(){
        x -= 30;
    }

    public void moveRight(){
        x += 30;
    }

    public int getX(){
        return x;
    }

    public Rectangle getHitbox(){
        return new Rectangle(x, 550, hitboxWidth, hitboxHeight);
    }

    public int getOffSet(){
        return offSet;
    }

    public void setX(int value){
        x = value;
    }

}
