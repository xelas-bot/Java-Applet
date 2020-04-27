/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package physicsgame;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Shrey Patel
 */
public class ball {
double xVel, yVel, x, y;


public ball(){
    x = 500;
    y=250;
    
    xVel=2;
    yVel=2;
}

public void checkPaddleCollision(Hpaddle g, Hpaddle h){
    if (x <= 165){
        if (y >=g.getY() && y <= g.getY()+80){
            xVel = -xVel;
        }
    } else if(x >= 840){
        if (y >=h.getY() && y <= h.getY()+80){
            xVel = -xVel;
        }
    }
     
    
    
    
}



public void draw (Graphics g){
    g.setColor(Color.WHITE);
    g.fillOval((int)x-10, (int)y-10, 20, 20);
}


public void move(){
    x+=xVel;
    y+=yVel;
    
    if (y<10){
        yVel= -yVel;
    }
    
    if(y>490){
        yVel = - yVel;
    }
    
    
}

public int getX(){
    return (int)x;
}

public int getYC(){
    return (int)y;
}       
      
public int getYvel(){
    
    return (int)yVel;
}
    
    
}
