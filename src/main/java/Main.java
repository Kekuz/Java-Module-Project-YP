import java.util.Locale;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);//А вот тут я юзаю локаль, потмоу что моя Intellij idea принимает по умолчанию double c запятой -_-
        int personNumber;

        while (true){
            String checkPersonNumber;
            System.out.println("Введите кол-во человек: ");
            do {
                checkPersonNumber = scanner.next();
                if (!Numeric.isIntNumeric(checkPersonNumber)) System.out.println("Не пытайся меня обмануть, мне нужны только целые числа!\nВведите кол-во человек: ");
            } while (!Numeric.isIntNumeric(checkPersonNumber));

            if (Integer.parseInt(checkPersonNumber) == 1){
                System.out.println("Тебе не с кем делить счет, у тебя нет друзей.");
            }else if (Integer.parseInt(checkPersonNumber) <= 0){
                System.out.println("Попробуй еще раз, я же знаю что как минимум один человек есть.");
            }else{
                personNumber = Integer.parseInt(checkPersonNumber);
                System.out.println("Калькулятор создан.");
                break;
            }
        }

        Calculator calculator = new Calculator(personNumber);//Создаем мощный калькулятор продуктов
        while (true){
            System.out.println("Введите название товара и его стоимость: ");
            String productName = scanner.next();
            String productCost;
            do {
                productCost = scanner.next();
                if (!Numeric.isDoubleNumeric(productCost)) System.out.println("Ты опять хочешь обмануть меня!!! Вводи только цифры!");
            } while (!Numeric.isDoubleNumeric(productCost));
            Product product = new Product(productName, Math.abs(Double.parseDouble(productCost)));
            calculator.addProduct(product);
            System.out.println("Хотите ли вы добавить еще один товар?");
            String repeat = scanner.next();
            if (repeat.equalsIgnoreCase("Завершить")){
                calculator.getList();
                Formatter formatter = new Formatter(calculator);//Создаем мощный форматтер калькулятора
                formatter.formatPrint();
                break;
            }
        }
        scanner.close();
    }
}