/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gameplay;

import Levels.Level1;
import Levels.Level2;
import Levels.Level3;
import Levels.LevelGeneric;
import Obj.Ball;
import Obj.Brick;
import Obj.Paddle;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

    private boolean play = false;
    private int score = 0;
    private int totalbricks;
    private Timer Timer;
    private int delay = 8;
    private int currentMap = 0;
    private boolean gameOver = false;

    private LevelGeneric map;

    private Ball ball;
    private Paddle paddle;

    public GamePlay() {

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        initializeGameplay();

        Timer = new Timer(delay, this);
        Timer.start();

    }

    public void initializeGameplay(){
        score=0;
        currentMap = 0;
        map = new Level1(3, 7);
        ball = map.getBall();
        paddle = map.getPaddle();
        totalbricks = map.getTotalBlocks();
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(1, 1, 692, 592);

        map.draw((Graphics2D) g);

        g.setColor(Color.white);
        g.setFont(new Font("serif", Font.BOLD, 25));
        g.drawString("" + score, 590, 30);

        if (gameOver) {

            g.setColor(Color.red);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("    Game Over Score: " + score, 190, 300);

            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("   Press Enter to Restart", 190, 340);


        }
        if (totalbricks == 0) {

            g.setColor(Color.red);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Level Completed: " + score, 190, 300);

            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Press Enter to start next level", 190, 340);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Timer.start();

        if (play) {

            ball.move();
            checkCollisions(map);
            checkEndgame();

            repaint();
        }
    }

    public void checkCollisions(LevelGeneric mapGeneric){

        Rectangle brickHitbox;

        if (ball.intersects(paddle.getHitbox())) {
            ball.setBallYDir(-ball.getBallYDir());
        }

        for (Brick[] bricks : mapGeneric.getMap()) {
            for(Brick brick : bricks){
                if (!brick.getHit()) {

                    brickHitbox = brick.getHitbox();

                    if (ball.intersects(brickHitbox)) {

                        brick.setHit(true);
                        totalbricks--;
                        score += 5;

                        if (ball.getBallPosX() + 19 <= brickHitbox.x || ball.getBallPosY() + 1 >= brickHitbox.x + mapGeneric.getBricksWidth()) {
                            ball.setBallXDir(-ball.getBallXDir());
                        } else {
                            ball.setBallYDir(-ball.getBallYDir());
                        }
                    }
                }
            }
        }
    }

    public void checkEndgame(){
        if (ball.getBallPosY() > 570){
            play = false;
            gameOver = true;
        }
        if(totalbricks == 0){
            play = false;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(!gameOver){
                if(!play){
                    ball.startBall();
                    play = true;
                }

                if (paddle.getX() >= 575 + paddle.getOffSet()) {
                    paddle.setX(575 + paddle.getOffSet());
                } else {
                    paddle.moveRight();
                }
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {

            if(!gameOver){
                if(!play){
                    ball.startBall();
                    play = true;
                }

                if (paddle.getX() <= 10) {
                    paddle.setX(10);
                } else {
                    paddle.moveLeft();
                }
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_COMMA) {
            nextLevel();
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (gameOver) {
                gameOver = false;
                initializeGameplay();
            }else{
                if(totalbricks==0)
                    nextLevel();
            }
            repaint();
        }
    }

    public void nextLevel(){
        currentMap++;
        play = false;

        switch (currentMap) {
            case 1 -> {
                map = new Level2(9, 14);
            }
            case 2 -> {
                map = new Level3(18, 28);
            }
        }

        ball = map.getBall();
        paddle = map.getPaddle();
        totalbricks = map.getTotalBlocks();
        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
