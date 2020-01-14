public class Vector{
    float x,y,z;
    public Vector(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(){
        this(0,0,0);
    }

    public Vector(float x, float y){
        this(x,y,0);
    }

    static Vector Randomize2D(){
        return new Vector((float)Math.random(), (float)Math.random());
    }

    public void add(Vector v){
        this.x+=v.x;
        this.y+=v.y;
        this.z+=v.z;
    }

    public void set(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void set(float x, float y){
        set(x,y,this.z);
    }

    public String toString(){
        return String.format("%f,%f,%f",x,y,z);   
    }

    public float dist(Vector v){
        float dx = Math.abs(v.x-x);
        float dy = Math.abs(v.y-y);
        float dxy = (float)Math.sqrt(dx*dx+dy*dy);
        return dxy;
    }

    public Vector copy(){
        return new Vector(x,y);   
    }
}