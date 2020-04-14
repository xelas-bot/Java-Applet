/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package physicsgame;

import java.awt.Color;
import java.awt.Graphics;




public class Hpaddle implements Paddles {

    double y, yVel;
    boolean upAccel, downAccel;
    int player, x;
    ball b1;
    int ballY;
    int ballVel;
    
    public Hpaddle (int player){
        upAccel = false; downAccel = false;
        y = 210; yVel=0;
        if (player == 1){
            x=20; 
        } else {
            x=900;
        }
        
    }
    
    
    
    
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, (int)y, 20, 80);
        
    }

    @Override
    public void move() {
        if (upAccel){
            yVel -= 1;
        } else if (downAccel){
            yVel += 1;
        } else if (!downAccel && !upAccel){
            yVel *= 0.3;
        }
        
        y += yVel;
        
        if (y < 0){
            y=0;
        }
        
        if (y > 420){
            y=420;
        }
        
    }

    @Override
    public int getY() {
       return (int)y;
    }
    
    
    public void setUpaccel(boolean input){
        upAccel = input;
        
    }
    
      public void setDownaccel(boolean input){
        downAccel = input;
        
    }
      
      public void aiUpdate(ball b){
          
          
          ballY = b.getYC();
          ballVel = b.getYvel();
          
          y=ballY-40;
          
        
          
          
          
          
          
          
          
          
      }
      
      
      
    
}
