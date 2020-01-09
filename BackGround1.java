import greenfoot.*;

/**
 * Write a description of class BackGround1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackGround1 extends World
{

    /**
     * Constructor for objects of class BackGround1.
     * 
     */
    public BackGround1()
    {    
        super(600, 600, 1); 
        addObject(new DK(), 200, 150);

        addObject(new Mario(), 125, 500);
        addObject(new Floor(Floor.RollDirection.NONE),125,600);
        addObject(new Floor(Floor.RollDirection.NONE),250,500);
    }
}
