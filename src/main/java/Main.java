import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);//А вот тут я юзаю локаль, потмоу что моя Intellij idea принимает по умолчанию double c запятой -_-
        int personNumber;

        while (true) {
            int checkPersonNumber;
            System.out.println("Введите кол-во человек: ");
            if (scanner.hasNextInt()) {//По умному проверяем что ввел пользователь
                checkPersonNumber = scanner.nextInt();
                 if (checkPersonNumber == 1) {
                    System.out.println("Тебе не с кем делить счет, у тебя нет друзей.");
                } else if (checkPersonNumber <= 0) {
                    System.out.println("Попробуй еще раз, я же знаю что как минимум один человек есть.");
                } else {
                    personNumber = checkPersonNumber;
                    System.out.println("Калькулятор создан.");
                    break;
                }
            } else {
                scanner.skip(".*\n");// Без этой штуки при вводе букв сканнер выпадает в бесконечный цикл при ошибке.
                System.out.println("Не пытайся меня обмануть, мне нужны только целые числа!");
            }
        }

        Calculator calculator = new Calculator(personNumber);//Создаем мощный калькулятор продуктов
        boolean flag = true;//флаг для правильного вывода сообщения в консоль  при ошибке

        while (true) {
            if (flag) System.out.println("Введите название товара и его стоимость: ");//Этот иф и флаг нужны потому что, если productCost не прошел, то наш поток все равно
            else System.out.println("Введите ТОЛЬКО СТОИМОСТЬ товара: ");// запомнит productName и, в таком случае, вывод в консоль будет неправильный -_-
            flag = false;
            String productName = scanner.next();
            if (scanner.hasNextDouble()) {
                double productCost = scanner.nextDouble();

                flag = true;
                Product product = new Product(productName, Math.abs(productCost));
                calculator.addProduct(product);
                System.out.println("Хотите ли вы добавить еще один товар?");
                String repeat = scanner.next();
                if (repeat.equalsIgnoreCase("Завершить")) {
                    calculator.getList();
                    Formatter formatter = new Formatter(calculator);//Создаем мощный форматтер калькулятора
                    formatter.formatPrint();
                    break;
                }
            } else {
                System.out.println("Ты опять хочешь обмануть меня!!! Вводи только цифры!");
            }
        }
        scanner.close();
    }
}