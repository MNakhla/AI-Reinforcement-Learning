public class Operator {  
    String name;

    public Operator(String name){
        this.name=name;
    }
    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}  