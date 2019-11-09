
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

    public Action(){};
    public Action(String name, String param, String descr){
        this.name = name;
        this.param = param;
        description = descr;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getDescription() {
        return description;
    }

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
