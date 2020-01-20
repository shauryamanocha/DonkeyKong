import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stars here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stars extends Actor
{
    /**
     * Act - do whatever the Stars wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void star() 
    {
       
       
        
        }
     
    
    public void act() 
    {
        GreenfootImage star = getImage();
       star.scale(20,20);
        setImage(star);
        
      Mario mario = (Mario)getOneIntersectingObject(Mario.class);
        if(isAtEdge() || mario!=null){
            getWorld().removeObject(this);
            if(mario!=null){
             mario.lives++;   
            }
    }
}

}
