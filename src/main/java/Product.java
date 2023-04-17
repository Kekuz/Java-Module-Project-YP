public class Product {//Торвар цену которого необходимо разделить между друзьями
    private final String name;
    private final double cost;
    Product(String name, double cost){
        this.name = name;
        this.cost = cost;
    }
    public double getCost(){
        return this.cost;
    }
    public String getName(){
        return this.name;
    }
}
