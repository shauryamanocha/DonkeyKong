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
            /*while(isTouching(Floor.class))
            {
                //Floor collider = (Floor)getOneIntersectingObject(Floor.class);
                speed.set(-3,0);
                turn(-8);
            }*/
        }
        pos.add(speed);
        
    }
}
 