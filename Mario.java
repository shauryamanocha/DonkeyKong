import greenfoot.*;
public class Mario extends Actor
{
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
}
