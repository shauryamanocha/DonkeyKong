import greenfoot.*;

/**
 * Write a description of class Barrel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barrel extends Actor
{   
    Vector speed, pos;
    public Barrel(){
        speed = new Vector(0,0);
        pos = new Vector(100,100);
    }
    public void act() 
    {
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        } else{
          setLocation(getX(), getY() + 3);
          while(isTouching(Floor2.class))
          {
            setLocation(getX() - 3, getY() - 3);
            turn(-8);
          }
          while(isTouching(Floor.class))
          {
            setLocation(getX() + 3, getY() - 3);
            turn(8);
          }
       }
    }
}
 