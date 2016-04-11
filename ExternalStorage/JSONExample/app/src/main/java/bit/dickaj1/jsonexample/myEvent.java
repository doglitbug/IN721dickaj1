package bit.dickaj1.jsonexample;

/**
 * Created by Arron on 8/04/2016.
 */
public class myEvent {
    String name;
    String description;

    public myEvent(String name, String description){
        this.name=name;
        this.description=description;
    }

    @Override
    public String toString(){
        return name;
    }

    /**
     * Get the myEvents description
     * @return Description string
     */
    public String getDescription(){
        return description;
    }
}