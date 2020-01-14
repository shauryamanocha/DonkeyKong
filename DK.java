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
            getWorld().addObject(new Barrel(), getX()+50, getY());
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

        if(System.currentTimeMillis() - lastTime > 2500)
        {
            lastTime = System.currentTimeMillis();
            //getWorld().addObject(new Barrel(), getX(), getY());

        }
    }    
}
