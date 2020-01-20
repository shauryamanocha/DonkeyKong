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
    Mario mario = new Mario();
    Heart[] hearts = new Heart[mario.lives];
    public static Barrel[] barrel = new Barrel[5];
    public static int barrelcounter = 0;
    public BackGround1()
    {    
        super(600, 600, 1); 

        addFloors(3,2,10,2,1.0f,0f);
        addObject(new DK(), 180, 120);

        addObject(mario, 125, 500);
        for(int i = 0; i < 5; i++){
            barrel[i] = new Barrel();
            addObject(barrel[i], 180, 120);
        }
        addObject(new DK(), 180, 120);        
        showText(""+mario.score, 570,10);
        for(int i = 0;i<hearts.length;i++){
            hearts[i] = new Heart(i,mario);
            addObject(hearts[i], 50*(i+1), 50);
        }
    }

    private void addFloors(int numFloors, int floorSegmentsPerLevel, int ladderLengths, int maxLadders, float ladderProbability, float brokenLadderProb){
        for(int i = 1;i<=numFloors;i++){
            int y = getHeight()-(Ladder.getHeight()*i*ladderLengths);
            int x1 = floorSegmentsPerLevel*Floor.getWidth()-Ladder.getWidth()/2;
            int x2 = getWidth()-floorSegmentsPerLevel*Floor.getWidth()+Ladder.getWidth()/2;
            Floor.RollDirection rollDir = Floor.RollDirection.NONE;
            for(int j = 0;j<floorSegmentsPerLevel;j++){
                int x = -1;
                if(i%2 == 0){
                    x = getWidth()-j*Floor.getWidth()-Floor.getWidth()/2;
                    rollDir = Floor.RollDirection.LEFT;
                }else{
                    x = j*Floor.getWidth()+Floor.getWidth()/2;
                    rollDir = Floor.RollDirection.RIGHT;
                }
                addObject(new Floor(rollDir),x,y);
            }
            if(x1>x2){
                addLadders(x1,x2,y-Floor.getHeight()/2,ladderLengths,maxLadders,ladderProbability,brokenLadderProb);
            }
        }
        addGroundFloors();
    }

    private void addLadders(int x1, int x2, int y, int segments, int numLadders, float probability,float brokenProbability){
        ArrayList<Vector> positions = new ArrayList<Vector>();
        for(int i = 0;i<numLadders;i++){
            if(Math.random()<probability){
                boolean broken = Math.random()<brokenProbability;
                int brokenIndex = -1;
                if(broken){
                    brokenIndex = (int)(Math.random()*(segments-1));
                }
                Vector current = new Vector(x2+(float)Math.random()*(x1-x2),y);
                if(positions.size() == 0){
                    for(int j = 0;j<segments;j++){
                        if(j == brokenIndex) break;
                        Ladder.LADDER_TYPE currentType = Ladder.LADDER_TYPE.MIDDLE;
                        if(j == 0) currentType = Ladder.LADDER_TYPE.TOP;
                        if(j == segments-1) currentType = Ladder.LADDER_TYPE.BOTTOM;
                        addObject(new Ladder(currentType),(int)current.x,(int)current.y+Ladder.getHeight()*j);
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
                                if(j == brokenIndex) break;
                                Ladder.LADDER_TYPE currentType = Ladder.LADDER_TYPE.MIDDLE;
                                if(j == 0) currentType = Ladder.LADDER_TYPE.TOP;
                                if(j == segments-1) currentType = Ladder.LADDER_TYPE.BOTTOM;
                                addObject(new Ladder(currentType),(int)current.x,(int)current.y+Ladder.getHeight()*j);
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
