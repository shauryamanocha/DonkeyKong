import greenfoot.*;

/**
 * Write a description of class Barrel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barrel extends Actor
{   
    Vector speed;
    public Barrel(){
        speed = new Vector(0,0);
    }

    public int getXPos(){
        return getX();   
    }

    public int getYPos(){
        return getY();   
    }

    public void act() 
    {   
        if(this.getX() == 180 && this.getY() == 120){
        }
        else {
            Mario mario = (Mario)getOneIntersectingObject(Mario.class);
            if(isAtEdge() || mario!=null){
                this.setLocation(180,120);
                if(mario!=null){
                    mario.lives--;   
                }
            }else{

                Floor touching = (Floor)getOneIntersectingObject(Floor.class);
                if(touching!=null){
                    speed.y = 0;
                    if(touching.dir == Floor.RollDirection.RIGHT){
                        speed.x = 2;
                        turn(8);
                    }else{
                        speed.x = -2;   
                        turn(-8);
                    }
                }else{
                    speed.y++;
                    speed.x = 0;
                }
                setLocation(getX()+(int)speed.x,getY()+(int)speed.y);
            }
        }
    }
}