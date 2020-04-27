/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package physicsgame;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 *
 * @author Shrey Patel
 */
public class Tennis extends Applet implements Runnable, KeyListener {









    int WIDTH = 1000;
    int HEIGHT = 500;
        Thread thread;    
    Hpaddle p1;
    ball b1;
    Hpaddle p2;
    Graphics gfx;
    Image img;
    
    public void init(){
        this.resize(1000, 500);
        this.addKeyListener(this);
        p1 = new Hpaddle(1);
        b1 = new ball();
        p2= new Hpaddle(2);
        img = createImage(WIDTH, HEIGHT);
        gfx = img.getGraphics();
        thread = new Thread(this);
        thread.start();
    }
    
    
    public void paint (Graphics g){
        gfx.setColor(Color.BLUE);
        gfx.fillRect(0, 0, 1000, 500);
        
        if(b1.getX() < -10 || b1.getX()>1010 ){
            gfx.setColor(Color.GREEN);
            gfx.drawString("uh oh", 500, 250);
        }
        
        p1.draw(gfx);
        b1.draw(gfx);
        p2.draw(gfx);
        
        g.drawImage(img, 0, 0, this);
        
    }
   
    
    public void update (Graphics g){
        paint(g);
    }
    
    
    public void run(){
        for (;;){
            b1.checkPaddleCollision(p1, p2);
            p1.move();
            b1.move();
            
         
            p2.aiUpdate(b1);
            
            
            repaint();
            try{
                Thread.sleep(10);
             
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            
        }
    }

    
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        

    }

 
    public void keyPressed(KeyEvent e) {
        
        
                if (e.getKeyCode() == KeyEvent.VK_UP){
            p1.setUpaccel(true);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            p1.setDownaccel(true);
        }
        
    }

   
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            p1.setUpaccel(false);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            p1.setDownaccel(false);
            
        }
    }
    
    
    
    
    
}
