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
    public Heart(){
        GreenfootImage heart = getImage();
        heart.scale(50, 50);
        setImage(heart);
    }
    public void act() 
    {
        GreenfootImage heart = getImage();
        heart.scale(50, 50);
        int xPos = getX();
        
        if(xPos== 1340 && Mario.Lives == 2)
        {
            getWorld().removeObject(this);
        }
        
        if(xPos== 1395 && Mario.Lives == 1)
        {
            getWorld().removeObject(this);
        }
        
        if(xPos== 1450 && Mario.Lives == 0)
        {
            getWorld().removeObject(this);
        }
    }    
}
