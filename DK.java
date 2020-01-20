import greenfoot.*;
public class DK extends Actor
{
    long lastTime;
    long danceTime;

    public void act() 
    {
        if(isTouching(Mario.class))
        {
            Greenfoot.setWorld(new Finish());

            Greenfoot.stop();
        }
        if(System.currentTimeMillis() - lastTime > 3000)
        {
            lastTime = System.currentTimeMillis();
            setImage("dkThrow.png");
            BackGround1.barrel[BackGround1.barrelcounter].setLocation(getX()+50, getY());
            BackGround1.barrelcounter = (BackGround1.barrelcounter + 1) % 5;
        }
        if(System.currentTimeMillis() - lastTime > 750)
        {
                setImage("dkNormal.png");
        }
        if((System.currentTimeMillis() - danceTime > 4000 && System.currentTimeMillis() - danceTime < 4250)||System.currentTimeMillis() - danceTime > 4500 && System.currentTimeMillis() - danceTime < 4750)
        {
                setImage("dkRightArm.png");
        }
        if((System.currentTimeMillis() - danceTime > 4250 && System.currentTimeMillis() - danceTime < 4500)||(System.currentTimeMillis() - danceTime > 4250 && System.currentTimeMillis() - danceTime < 4500))
        {
                setImage("dkLeftArm.png");
        }
        if(System.currentTimeMillis() - danceTime > 6000)
        {
            danceTime = System.currentTimeMillis();
        }    
    }
}
