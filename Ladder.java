
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ladder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ladder extends Actor
{
    /**
     * Act - do whatever the Ladder wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static enum LADDER_TYPE{
     TOP,
     MIDDLE,
     BOTTOM
    }
    public LADDER_TYPE type;
    public Ladder(LADDER_TYPE type){
     GreenfootImage img = getImage();
     img.scale(img.getWidth()/3,img.getHeight()/3);
     setImage(img);
     this.type = type;
    }
    public void act() 
    {
        // Add your action code here.
    }    

    public static int getHeight(){
        return new Ladder(LADDER_TYPE.MIDDLE).getImage().getHeight();   
    }

    public static int getWidth(){
        return new Ladder(LADDER_TYPE.MIDDLE).getImage().getWidth();   
    }
}
