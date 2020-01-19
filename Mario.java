import greenfoot.*;
public class Mario extends Actor
{
    Vector speed = new Vector(0,0);
    AnimationPlayer runAnimation = new AnimationPlayer("Animations/Mario/Running/frame",2,0.01);
    int lives = 3;
    boolean running = false, jumping = false, goingDown = false;
    GreenfootImage idle = new GreenfootImage("Animations/Mario/idle.png");
    GreenfootImage idleFlipped = new GreenfootImage("Animations/Mario/idle.png");
    int dir = 1;
    int score = 0;
    long timeSinceJump = 0;

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

        if(!isTouching(Floor.class)){
            for(int i = 0; i < 5; i++)
            {
                int bX = BackGround1.barrel[i].getX();
                int bY = BackGround1.barrel[i].getY();
                // had to use three if statements here because 1 if statement with and && wouldn't work
                if((Math.abs(bX-getX())<=20))
                {
                    if(Math.abs(Math.abs(bY)-Math.abs(getY())) <= 100){
                        if(System.currentTimeMillis() - timeSinceJump  > 2000){
                            this.score = score + 100;
                            getWorld().showText(""+score, 570,10);

                            timeSinceJump = System.currentTimeMillis();
                        }
                    }
                }
            }
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
        for(String w : jumpKeys){;
            if(Greenfoot.isKeyDown(w)){
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
}
