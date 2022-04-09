package Obj;

import java.awt.*;

public class Ball {
    private int ballposX;
    private int ballposY;
    private int ballXdir;
    private int ballYdir;
    private final int hitboxWidth;
    private final int hitboxHeight;

    public Ball(int hitboxWidth,  int hitboxHeight) {

        this.hitboxWidth = hitboxWidth;
        this.hitboxHeight = hitboxHeight;

        initBall();
        stopBall();
    }

    public void initBall(){
        ballposX = 350;
        ballposY = 530;
    }

    public void stopBall() {
        ballXdir = -0;
        ballYdir = -0;
    }

    public void startBall(){
        do{
            ballXdir = (int) Math.round(Math.floor(Math.random()*(6-(-6)+1)+(-6)));
        }while(ballXdir <=1 && ballXdir >=-1);

        ballYdir = -6;
    }

    public void move(){
        ballposX += ballXdir;
        ballposY += ballYdir;

        if (ballposX < 0) {
            ballXdir = -ballXdir;
        }
        if (ballposY < 0) {
            ballYdir = -ballYdir;
        }
        if (ballposX > 670) {
            ballXdir = -ballXdir;
        }
    }

    public boolean intersects(Rectangle rect){
        return new Rectangle(getBallPosX(), getBallPosY(), hitboxWidth, hitboxHeight).intersects(rect);
    }

    public void draw(Graphics2D g){
        g.setColor(Color.GREEN);
        g.fillOval(ballposX, ballposY, hitboxWidth, hitboxHeight);
    }

    public int getBallXDir(){
        return ballXdir;
    }
    public int getBallYDir(){
        return ballYdir;
    }
    public int getBallPosX(){
        return ballposX;
    }
    public int getBallPosY(){
        return ballposY;
    }

    public void setBallXDir(int value){
        ballXdir = value;
    }
    public void setBallYDir(int value){
        ballYdir = value;
    }

}
