public class Calculator {//содержащит логику добавления и подсчёта товаров.
    private double totalCost;
    private String productList = ""; //Тут бы массив заюзать, но мы вроде как не проходили их
    private final int personNumber;

    Calculator(int personNumber){
        this.personNumber = personNumber;
    }
    public void getList(){
        System.out.println("Добавленные товары:\n" + productList);
    }

    public double costForOne(){
        return totalCost / personNumber;
    }
    public void addProduct(Product product){
        totalCost += product.getCost();
        productList += product.getName() + "\n";
        System.out.println("Товар успешно добавлен!");
    }

}
