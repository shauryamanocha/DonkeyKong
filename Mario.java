import greenfoot.*;
public class Mario extends Actor
{
    int speed;
    String Marioimage = "mariopixelCopy.png";
    long lastTime;
    public static int Lives;
    
    public Mario() {  
      Lives = 3;
    }
    
    public void act() 
    {
        speed = speed + 1;
        if(isTouching(Ladder.class))
        {
            speed = 0;
            if(Greenfoot.isKeyDown("up"))
                {
                    speed = - 8;
                }
            if(Greenfoot.isKeyDown("down"))
                {
                    speed = + 8;
                }
        }
        setLocation( getX(), getY() + speed);
        getWorld().showText("Lives : "+ Lives +"",1430, 60);
        if(isTouching(Barrel.class))
        {
            removeTouching(Barrel.class);
            Lives = Lives - 1;
        }
        if(Lives == 0)
        {
            getWorld().showText("GAME OVER", 750, 600);
            Greenfoot.stop();
        }
        if(speed <= 0)
        {
            while(isTouching(Floor.class)&!isTouching(Ladder.class))
            {
                speed = 0;
                setLocation(getX(), getY() + 1);
            }
        }
        if(speed > 0)
        {
            while(isTouching(Floor.class))
            {
                if(isTouching(Ladder.class))
                {
                    
                }
                else{
                    speed = 0;
                    setLocation(getX(), getY() - 1);
                    if(Greenfoot.isKeyDown("up"))
                    {
                        speed = - 27;
                    }
                }
            }
        }    
        if(Greenfoot.isKeyDown("left"))
        {
            move(-5);
            /*if(System.currentTimeMillis() - lastTime > 500 && Marioimage.equals("mariopixelCopy.png"))
            {
                Marioimage = "marioleft.png";
                setImage("marioleft.png");
                lastTime = System.currentTimeMillis();
            } else {
                if(System.currentTimeMillis() - lastTime > 500)
                {
                    Marioimage = "mariopixelCopy.png";
                    setImage("mariopixelCopy.png");
                    lastTime = System.currentTimeMillis();
                }
            } */
            
           
            setImage("mariopixelCopy.png");
            while(isTouching(Floor.class))
            {
               move(1);
            } 
        } else {
            if(Greenfoot.isKeyDown("right"))
            {
               move(5);
               setImage("mariopixel.png");
                while(isTouching(Floor.class))
                {
                  move(-1);
               }
            } else{
                setImage("mario-big.png");
            }
        }
        if(Greenfoot.isKeyDown("down"))
        {
            
            speed = 50;
        }
    } 
}