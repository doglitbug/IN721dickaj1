package bit.dickaj1.topartists;

/**
 * Created by Arron on 13/04/2016.
 */
public class artist {
    private String name;
    private int listeners;

    public void artist(String name, int listeners){
        this.name=name;
        this.listeners=listeners;
    }

    @Override
    public String toString(){
        return name;
    }

    public int getListeners(){
        return listeners;
    }
}
