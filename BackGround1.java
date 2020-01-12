import greenfoot.*;
import java.util.ArrayList;

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
        addFloors(3,2,3,2,0.35f);
        addObject(new DK(), 200, 150);
        addObject(new Mario(), 125, 500);
    }

    private void addFloors(int numFloors, int floorSegmentsPerLevel, int ladderLengths, int maxLadders, float ladderProbability){
        for(int i = 1;i<=numFloors;i++){
            int y = getHeight()-Ladder.getHeight()*i*ladderLengths;
            int x1 = floorSegmentsPerLevel*Floor.getWidth()-Ladder.getWidth()/2;
            int x2 = getWidth()-floorSegmentsPerLevel*Floor.getWidth()+Ladder.getWidth()/2;
            for(int j = 0;j<floorSegmentsPerLevel;j++){
                int x = -1;
                if(i%2 == 0){
                    x = getWidth()-j*Floor.getWidth()-Floor.getWidth()/2;
                }else{
                    x = j*Floor.getWidth()+Floor.getWidth()/2;
                }
                addObject(new Floor(),x,y+10*j);
            }
            if(x1>x2){
                addLadders(x1,x2,y,ladderLengths,maxLadders,ladderProbability);
            }
        }
        addGroundFloors();
    }

    private void addLadders(int x1, int x2, int y, int segments, int numLadders, float probability){
        ArrayList<Vector> positions = new ArrayList<Vector>();
        for(int i = 0;i<numLadders;i++){
            if(Math.random()<probability){
                Vector current = new Vector(x2+(float)Math.random()*(x1-x2),y);
                if(positions.size() == 0){
                    for(int j = 0;j<segments;j++){
                        addObject(new Ladder(),(int)current.x,(int)current.y+Floor.getHeight()*j);
                    }
                    positions.add(current.copy());
                }else{
                    boolean hasPlaced = false;
                    while(!hasPlaced){
                        current = new Vector(x2+(float)Math.random()*(x1-x2),y);
                        for(Vector v : positions){
                            if(current.dist(v)>Ladder.getWidth()*2){
                                hasPlaced = true;
                            }
                        }
                        if(hasPlaced){
                            positions.add(current.copy());
                            for(int j = 0;j<segments;j++){
                                addObject(new Ladder(),(int)current.x,(int)current.y+Floor.getHeight()*j);
                            }
                        }
                    }
                }
            }
        }
    }

    private void addGroundFloors(){
        for(int i = 0;i<Math.ceil(getWidth()/(float)Floor.getWidth());i++){
            addObject(new Floor(),Floor.getWidth()/2+i*Floor.getWidth(),getHeight()-Floor.getHeight()/2); 
        }
    }
}
