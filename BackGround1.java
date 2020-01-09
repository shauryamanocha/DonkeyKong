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
        addObject(new DK(), 200, 150);
        addObject(new Mario(), 125, 500);
        addFloors(3,2,150);
    }

    private void addFloors(int numFloors, int floorSegmentsPerLevel, int floorSpacing){
        for(int i = 1;i<=numFloors;i++){
            if(i%2 == 0){
                for(int j = 0;j<floorSegmentsPerLevel;j++){
                    addObject(new Floor(),getWidth()-j*Floor.getWidth()-Floor.getWidth()/2,getHeight()-floorSpacing*i);
                }
            }else{
                for(int j = 0;j<floorSegmentsPerLevel;j++){
                    addObject(new Floor(),j*Floor.getWidth()+Floor.getWidth()/2,getHeight()-floorSpacing*i);
                }
            }
        }
        addGroundFloors();
    }

    private void addGroundFloors(){
        System.out.println(Floor.getWidth()+", "+getWidth());
        for(int i = 0;i<Math.ceil(getWidth()/(float)Floor.getWidth());i++){
            System.out.println(i);
            addObject(new Floor(),Floor.getWidth()/2+i*Floor.getWidth(),getHeight()-Floor.getHeight()/2); 
        }
    }
}
