import greenfoot.*;
public class AnimationPlayer {
    String dir;
    int frames;
    double speed;
    long time;
    long timeOffset = 0;
    public AnimationPlayer(String dir, int frames, double speed) {
        this.dir = dir;
        this.frames = frames;
        this.speed = speed;
    }

    public GreenfootImage getCurrentFrame(int scaleX, int scaleY, boolean mirrored){
        time = System.currentTimeMillis();
        String current = dir+getAnimIndex()+".png";
        GreenfootImage img = new GreenfootImage(current);
        img.scale(img.getWidth()*scaleX,img.getHeight()*scaleY);
        if(mirrored){
         img.mirrorHorizontally();   
        }
        return img;
    }
    public int getAnimIndex(){
        return (int)(speed*((double)(time-timeOffset))%frames);
    }
    public void resetTimer(){
        timeOffset = System.currentTimeMillis();
    }
}