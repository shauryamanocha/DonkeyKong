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
    long timeSincePrevJump = 0;
    long timeSinceThisJump = 0;
    int maxRunSpeed = 2;
    int imgScaleFactor = 2;
    
    public Mario(){
        idle.scale(idle.getWidth()*imgScaleFactor,idle.getHeight()*imgScaleFactor);
        idleFlipped.mirrorHorizontally();
        idleFlipped.scale(idle.getWidth(),idle.getHeight());

    }

    public void act() 
    {
        updateMovement();
        Floor currentFloor = (Floor)getOneIntersectingObject(Floor.class);
        Ladder currentLadder = (Ladder)getOneIntersectingObject(Ladder.class);
        boolean onLadder = isTouching(Ladder.class);
        if(currentFloor==null){
            if(!onLadder){
                speed.y++;
            }
        }else{
        speed.y = 0;
           if(currentFloor.getY()<= getY()+getImage().getHeight()/2 && getY()-getImage().getHeight()/2<= currentFloor.getBottomY() && !onLadder){
               setLocation(getX(),currentFloor.getBottomY()+getImage().getHeight()/2+1);
               }
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
                        if(System.currentTimeMillis() - timeSincePrevJump  > 2000){
                            this.score = score + 100;
                            getWorld().showText(""+score, 570,10);

                            timeSincePrevJump = System.currentTimeMillis();
                        }
                    }
                }
            }
        }
        
        if(System.currentTimeMillis() - timeSinceThisJump > 50 &&System.currentTimeMillis() - timeSinceThisJump < 300) {
            speed.y = 0;
        }

        if(running){
            dir = Greenfoot.isKeyDown("a")?-1:1;
            setImage(runAnimation.getCurrentFrame(imgScaleFactor, imgScaleFactor, dir==-1));
            speed.x = dir*maxRunSpeed;
        }else{
            speed.x = 0;
            setImage(dir==1?idle:idleFlipped);
        }

        if(jumping){
            timeSinceThisJump = System.currentTimeMillis();
            if(onLadder){
                speed.y = -2;   
            }else if(isTouching(Floor.class)){
                speed.y = -15;   
            }
        }else if(goingDown && onLadder){
            if(currentLadder.type!=Ladder.LADDER_TYPE.BOTTOM){
                speed.y = 2;
            }
        }else if(onLadder){
            speed.y = 0;   
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
