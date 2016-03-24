package test;

import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // создаём объект класса Scanner
        int i = 2;
        System.out.print("Введите целое число: ");
        if (sc.hasNextInt()) { // возвращает истинну если с потока ввода можно считать целое число
            i = sc.nextInt(); // считывает целое число с потока ввода и сохраняем в переменную
            System.out.println(i * 2);
        } else {
            String s = sc.nextLine();
            System.out.println("Вы ввели не целое число, a " + s);
        }
    }
}
     class Main2 {
        public static   void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            double  i = sc.nextDouble(); // если ввести букву s, то случится ошибка во время исполнения
            System.out.println(i/3);
        }


    }

class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu Options\n");
            System.out.println("(1) - do this");
            System.out.println("(2) - quit");

            System.out.print("Please enter your selection:\t");
            int selection = scanner.nextInt();

            if (selection == 1) {
                System.out.println("Enter a sentence:\t");
                String sentence = scanner.nextLine();

                System.out.print("Enter an index:\t");
                String index = scanner.nextLine();

                System.out.println("\nYour sentence:\t" + sentence);
                System.out.println("Your index:\t" + index);
            }
            else if (selection == 2) {
                break;
            }
        }
    }
}
