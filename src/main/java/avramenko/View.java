package main.java.avramenko;

import java.util.Scanner;

public class View {

    public void menu() {
        System.out.println("1. Generate car list");
        System.out.println("2. Create car list");
        System.out.println("3. Exit");
    }

    public void subMenu(){
        System.out.println("1. Get list of cars of my brand");
        System.out.println("2. Get list of cars of my model which are used for more than N years");
        System.out.println("3. Get list of cars of my year that cost for more my price");
        System.out.println("4. Return to menu");
        System.out.println("5. Exit");
    }

    public void printMessage(Messages messages){
        switch(messages){
            case CHOOSE:
                System.out.println("Choose number: ");
                break;
            case ENTER_LENGTH:
                System.out.println("How many cars do you want to add? ");
                break;
            case ENTER_ID:
                System.out.print("Identification Number: ");
                break;
            case ENTER_YEAR:
                System.out.print("Year: ");
                break;
            case ENTER_BRAND:
                System.out.print("Brand: ");
                break;
            case ENTER_COLOR:
                System.out.print("Color: ");
                break;
            case ENTER_MODEL:
                System.out.print("Model: ");
                break;
            case ENTER_PRICE:
                System.out.print("Price, $: ");
                break;
            case ENTER_NUMBER:
                System.out.print("Number: ");
                break;
            case ENTER_BRAND_LONG:
                System.out.println("Enter name of brand: ");
                break;
            case ENTER_MODEL_LONG:
                System.out.println("Enter name of model: ");
                break;
            case ENTER_PRICE_LONG:
                System.out.println("Enter price: ");
                break;
            case ENTER_YEARS_LONG:
                System.out.println("Enter number of years: ");
                break;
            default:
                break;
        }
    }

    public int readNumber(int param) {
        int n;
        Scanner sc = new Scanner(System.in);
        do {
            while (!sc.hasNextInt()) {
                switch (param) {
                    case 1:
                        System.out.println("Not a number. Please, choose number from 1 to 3.");
                        sc.next();
                        break;
                    case 2:
                        System.out.println("Not a number. Please, choose number from 1 to 5.");
                        sc.next();
                        break;
                    case 3:
                        System.out.println("Not a number. Please, choose number from 1 to 10.");
                        sc.next();
                        break;
                    case 4:
                        System.out.println("Not a year. Please, choose year from 1918 to 2018.");
                        sc.next();
                        break;
                    case 5:
                        System.out.println("Not a number. Please, enter price from 0 to 1000000000.");
                        sc.next();
                        break;
                    default:
                        break;
                }
            }
            n = sc.nextInt();
        } while (n < 0);
        return n;
    }

    public String readString() {
        Scanner sc = new Scanner(System.in);
        String string = new String(sc.nextLine());
        return string;
    }


    public void printCar(Car[] cars) {
        System.out.println(" Identification Number |      Brand      |    Model    |  Year  |  Color  |  Number  |   Price, $   ");
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
