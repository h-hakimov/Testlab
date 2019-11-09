
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Action implements Comparable<Action>{
    private String name;
    private String param;
    private String description;

    /**
     *
     */
    public Action(){};

    /**
     *
     * @param name
     * @param param
     * @param descr
     */
    public Action(String name, String param, String descr){
        this.name = name;
        this.param = param;
        description = descr;
    }
    
    /**
     *
     * @return Name of action
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name Name of action
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return Parameter of action
     */
    public String getParam() {
        return param;
    }

    /**
     *
     * @param param Parameter of action
     */
    public void setParam(String param) {
        this.param = param;
    }

    /**
     *
     * @return Description of action
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param discription Description of action
     */
    public void setDiscription(String discription) {
        this.description = discription;
    }
    
    public String toString(){
        return name + " " + param + " " + description;
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(name, param, description);
    }
    
    @Override
    public int compareTo(Action act){
        return (hashCode() - act.hashCode());
    }
}
