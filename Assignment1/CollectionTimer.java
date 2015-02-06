import java.lang.*
import java.util.*

public abstract class CollectionTimer extends Assignment1 {
    public static final int[] DEFAULT_MUTATIONS = { 10000, -10000};
    
    //Abstract statements for the QueueTimer and ListTimer classes
    public abstract void addElement(Integer elem);
    public abstract void removeElement();
    public abstract int getSize();
    public abstract boolean isEmpty();

    private Random elemGen;
    
    CollectionTimer(){
        elemgen = Random(0);
    }
    
    CollectionTimer(long elemGenSeed){
        elemgen = Random(elemGenSeed);
    }
    

    
    public void insert(int amount){
        
    }
    
    public boolean extract(int amount){
        
    }
        
    public long time(){
        //return elapsed time in milliseconds
    }
    
    public long time(int[] mutations){
        //return elapsed time in milliseconds
    }
}
