import greenfoot.*;
public class Mario extends Actor
{
<<<<<<< HEAD
    Vector speed = new Vector(0,0);
    AnimationPlayer runAnimation = new AnimationPlayer("Animations/Mario/Running/frame",2,0.01);
    int lives = 3;
    boolean running = false, jumping = false;
    GreenfootImage idle = new GreenfootImage("Animations/Mario/idle.png");
    public Mario(){
        idle.scale(idle.getWidth()*2,idle.getHeight()*2);
    }

    public void act() 
    {
        updateMovement();
        System.out.println(speed.toString());
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
                    speed.y = -15;
                }
            }else{
                System.out.println("not on floor");   
            }
        } else if(!running   && !jumping){
            setImage(idle);
        }

        if(isTouching(Floor.class)){
            Floor floor = (Floor)getOneIntersectingObject(Floor.class);
            System.out.printf("y: %d, fy: %d",getY(),floor.getY());
            if(getY()<floor.getY()){
                speed.y = 0;
                setLocation(getX(),floor.getTopY()-getImage().getHeight()/2+1);
            }else{
                speed.y = 1; 
                setLocation(getX(),floor.getBottomY()+getImage().getHeight()/2);
            }
        }else{
            speed.y++;
        }
        setLocation((int)(getX()+speed.x), (int)(getY()+speed.y));
    }

    private void updateMovement(){
        String[] runKeys = new String[]{"a","d"};
        String[] jumpKeys = new String[]{"w"};
        running = false;
        jumping = false;
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
    }
=======
    int speed;
    String Marioimage = "mariopixelCopy.png";
    long lastTime;
    public static int Lives = 3;
    public void act() 
    {
        speed = speed + 1;
        setLocation( getX(), getY() + speed);
        getWorld().showText("Lives : "+ Lives +"",1430, 90);
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
        if(speed > 0)
        {
            while(isTouching(Floor.class))
            {
                speed = 0;
                setLocation(getX(), getY() - 1);
                if(Greenfoot.isKeyDown("up"))
                {
                    speed = - 27;
                }
            }
        }
        if(speed <= 0)
        {
            while(isTouching(Floor.class))
            {
                speed = 0;
                setLocation(getX(), getY() + 1);
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
