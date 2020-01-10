import greenfoot.*;

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
        addFloors(3,1,3,2,1f);
        addObject(new DK(), 200, 150);
        addObject(new Mario(), 125, 500);
    }

    private void addFloors(int numFloors, int floorSegmentsPerLevel, int ladderLengths, int maxLadders, float ladderProbability){
        for(int i = 1;i<=numFloors;i++){
            int startX = -1;
            int endX = -1;
            int y = getHeight()-Ladder.getHeight()*i*ladderLengths;
            boolean floorsOverlap = true;
            for(int j = 0;j<floorSegmentsPerLevel;j++){
                int x = -1;
                if(i%2 == 0){
                    x = getWidth()-j*Floor.getWidth()-Floor.getWidth()/2;
                    startX = getWidth()-Floor.getWidth()/2;
                    endX = getWidth()-floorSegmentsPerLevel*Floor.getWidth()-Floor.getWidth()/2;
                }else{
                    x = j*Floor.getWidth()+Floor.getWidth()/2;
                    startX = Floor.getWidth()/2;
                    endX = floorSegmentsPerLevel*Floor.getWidth()+Floor.getWidth()/2;
                }
                addObject(new Floor(),x,y);
            }
            if(floorsOverlap){
                addLadders(startX,endX,y,ladderLengths,(endX-startX)/maxLadders,ladderProbability);
            }

        }
        addGroundFloors();
    }

    private void addLadders(int startX, int endX, int y, int segments, int spacing, float probability){
        for(int i = 0;i<(endX-startX)/spacing;i++){
            if(Math.random()<probability){
                for(int j = -1;j<segments-1;j++){
                    addObject(new Ladder(),startX+spacing*i,y+Ladder.getHeight()+j*Ladder.getHeight());
                }
            }
        }
    }

    private void addGroundFloors(){
        System.out.println(Floor.getWidth()+", "+getWidth());
        for(int i = 0;i<Math.ceil(getWidth()/(float)Floor.getWidth());i++){
            System.out.println(i);
            addObject(new Floor(),Floor.getWidth()/2+i*Floor.getWidth(),getHeight()-Floor.getHeight()/2); 
        }
    }
}
