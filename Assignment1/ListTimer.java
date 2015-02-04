import java.util.*
import java.lang.*

public class ListTimer extends Collectiontimer {
    private List<Integer> list;
    
    public ListTimer(List<Integer> list){ };
    public ListTimer(List<Integer> list, long elemGenSeed){ };
    public ListTimer(List<Integer>, Long elemGenSeed){ };
    
    public void addElement(Integer elem){
            list.add(elem);
    }
    
    public void removeElement(){
        try{
            list.remove(0);
        }catch(UnsupportedOperationException)
    }
    
    public int getSize(){
        return list.size();
    }
    
    public boolean isEmpty(){
        return list.isEmpty();
    }
}
