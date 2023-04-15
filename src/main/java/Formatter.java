public class Formatter {//содержащит метод получения слова рубль в правильном падеже и метод для округления.
    private final Calculator calculator;
    Formatter(Calculator calculator){
        this.calculator = calculator;
    }
    public void formatPrint(){
        System.out.println("Каждый из компании должен заплатить " + String.format("%.2f", calculator.costForOne()) + trueEndingRub(calculator.costForOne()));
    }
    private String trueEndingRub(double cost){// 1 рубль 2, 3, 4 рубля 5, 6, 7, 8, 9, 0 рублей
        int intCost = (int) Math.floor(cost);
        if (intCost % 10 == 1)
            return " рубль.";
        else  if (intCost % 10 == 2 || intCost % 10 == 3 || intCost % 10 == 4)
            return " рубля.";
        else return " рублей.";
    }
}
