import greenfoot.*;

/**
 * Write a description of class Floor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor extends Actor
{
    /**
     * Act - do whatever the Floor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    static enum RollDirection{
     LEFT,
     RIGHT,
     NONE
    }
    RollDirection dir;
    public Floor(RollDirection dir){
       this.dir = dir;
    }
    public void act() 
    {
        // Add your action code here.
    }
    public int getTopY(){
     return getY() - getImage().getHeight()/2;   
    }
    public int getBottomY(){
        return getY() + getImage().getHeight()/2;
    }
}
