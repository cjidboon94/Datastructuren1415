import java.lang.*
import java.util.*

public abstract class CollectionTimer {
    public static final int[] DEFAULT_MUTATIONS
    private Random elemGen
    
    CollectionTimer(){};
    CollectionTimer(long elemGenSeed){};
    
    public abstract void addElement(Integer elem)
    public abstract void removeElement()
    public abstract int getSize()
    public abstract boolean isEmpty()
    public void insert(int amount)
    public boolean extract(int amount)
    public long time()
    public long time(int[] mutations)
}
