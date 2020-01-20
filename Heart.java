import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heart extends Actor
{
    /**
     * Act - do whatever the Heart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int index;
    Mario mario;
    public Heart(int index,Mario mario){
        GreenfootImage heart = getImage();
        heart.scale(50, 50);
        setImage(heart);
        this.index = index;
        this.mario = mario;
    }
    public void act() 
    {
        if(mario.lives<=index){
         getWorld().removeObject(this);
        }
        
        if(mario.lives <= 0){
            Greenfoot.setWorld(new GameOver());
      
        
    }    
}
}
