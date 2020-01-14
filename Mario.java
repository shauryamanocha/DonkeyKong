import greenfoot.*;
public class Mario extends Actor
{
<<<<<<< HEAD
    Vector speed = new Vector(0,0);
    AnimationPlayer runAnimation = new AnimationPlayer("Animations/Mario/Running/frame",2,0.01);
    int lives = 3;
    boolean running = false, jumping = false, goingDown = false;
    GreenfootImage idle = new GreenfootImage("Animations/Mario/idle.png");
    GreenfootImage idleFlipped = new GreenfootImage("Animations/Mario/idle.png");
    int dir = 1;
    public Mario(){
        idle.scale(idle.getWidth()*2,idle.getHeight()*2);
        idleFlipped.mirrorHorizontally();
        idleFlipped.scale(idle.getWidth(),idle.getHeight());
    }

    public void act() 
    {
        updateMovement();
        dir = speed.x!=0?(int)Math.signum(speed.x):dir;
        if(running){
            if(Greenfoot.isKeyDown("a")){
                setImage(runAnimation.getCurrentFrame(2,2,true));
                speed.x = -3;
            }else{
                setImage(runAnimation.getCurrentFrame(2,2,false));
                speed.x = 3;   
            }
        }else{
            speed.x = 0;   
        }
        if(jumping){
            if(isTouching(Floor.class)){
                Floor floor = (Floor)getOneIntersectingObject(Floor.class);
                if(getY()+getImage().getHeight()/2<=floor.getTopY()+1){
                    setLocation(getX(),getY()-10);
                    if(!isTouching(Ladder.class)){
                        speed.y = -15;
                    }
                }
            }
        } else if(!running   && !jumping){
            setImage(dir>0?idle:idleFlipped);
        }

        if(isTouching(Floor.class)){
            Floor floor = (Floor)getOneIntersectingObject(Floor.class);
            if(getY()<floor.getY() && !isTouching(Ladder.class)){
                speed.y = 0;
                setLocation(getX(),floor.getTopY()-getImage().getHeight()/2+1);
            }else if(!isTouching(Ladder.class)){
                speed.y = 1; 
                setLocation(getX(),floor.getBottomY()+getImage().getHeight()/2);
            }
        }else{
            if(isTouching(Ladder.class)){
                if(jumping){
                    speed.y = -2;
                }else if(goingDown){
                    speed.y = 2;
                }else{
                    speed.y = 0;
                }
            }else{
                speed.y++;
            }
        }
        setLocation((int)(getX()+speed.x), (int)(getY()+speed.y));
    }

    private void updateMovement(){
        String[] runKeys = new String[]{"a","d"};
        String[] jumpKeys = new String[]{"w"};
        String[] downKeys = new String[]{"s"};
        running = false;
        jumping = false;
        goingDown = false;
        for(String s : runKeys){
            if(Greenfoot.isKeyDown(s)){
                running = true;
                break;
            }
        }
        for(String s : jumpKeys){
            if(Greenfoot.isKeyDown(s)){
                jumping = true;
                break;
            }
        }
        for(String s : downKeys){
            if(Greenfoot.isKeyDown(s)){
                goingDown = true;
                break;
            }
        }
    }
=======
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
>>>>>>> master
}
