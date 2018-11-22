package main.java.avramenko;

public class Controller {

    private int choice;
    private int length;
    private String brand;
    private String carModel;
    private int year = 0;
    private int price = 0;
    private Car[] result;
    private String identificationNumber;
    private String carColor;
    private String carNumber;

    public void startWorking() {
        View view = new View();
        Model model = new Model();
        Activities activities;

        activities = Activities.SHOW_MAIN_MENU;
        while (true) {
            switch (activities) {
                case SHOW_MAIN_MENU:
                    activities = showMainMenu(view);
                    break;
                case GENERATE_CAR_LIST:
                    activities = generateCarList(view, model);
                    break;
                case CREATE_CAR_LIST:
                    activities = createCarList(view, model);
                    break;
                case SHOW_SUBMENU:
                    activities = showSubMenu(view);
                    break;
                case GET_BRAND:
                    activities = getListOfCarsBrand(view, model);
                    break;
                case GET_MODEL:
                    activities = getListOfCarsYears(view, model);
                    break;
                case GET_YEAR:
                    activities = getListOfCarsPrice(view, model);
                    break;
                case EXIT:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    private static Activities convertChoiceToConstant(int choice) {
        switch (choice) {
            case 1:
                return Activities.GENERATE_CAR_LIST;
            case 2:
                return Activities.CREATE_CAR_LIST;
            case 3:
                return Activities.EXIT;
            case 4:
                return Activities.SHOW_SUBMENU;
            case 5:
                return Activities.GET_BRAND;
            case 6:
                return Activities.GET_MODEL;
            case 7:
                return Activities.GET_YEAR;
            case 8:
                return Activities.SHOW_MAIN_MENU;
            case 9:
                return Activities.EXIT;
        }
        return null;
    }

    private Activities showMainMenu(View view) {
        view.menu();
        view.printMessage(Messages.CHOOSE);
        do {
            choice = view.readNumber(1);
        } while (choice > 3);
        return convertChoiceToConstant(choice);
    }

    private Activities generateCarList(View view, Model model) {
        view.printMessage(Messages.ENTER_LENGTH);
        do {
            length = view.readNumber(3);
        } while (length > 10);
        view.printCar(model.createCars(length));
        return Activities.SHOW_SUBMENU;
    }

    private Activities createCarList(View view, Model model) {
        boolean isSuccessful = false;
        view.printMessage(Messages.ENTER_LENGTH);
        length = view.readNumber(3);
        for (int i = 0; i < length; i++) {
            view.printMessage(Messages.ENTER_ID);
            identificationNumber = view.readString();
            view.printMessage(Messages.ENTER_BRAND);
            brand = view.readString();
            view.printMessage(Messages.ENTER_MODEL);
            carModel = view.readString();
            view.printMessage(Messages.ENTER_YEAR);
            do {
                year = view.readNumber(4);
            } while (year > 2019);
            view.printMessage(Messages.ENTER_COLOR);
            carColor = view.readString();
            view.printMessage(Messages.ENTER_NUMBER);
            carNumber = view.readString();
            view.printMessage(Messages.ENTER_PRICE);
            do {
                price = view.readNumber(5);
            } while (price > 1000000001);
            Car car = new Car(identificationNumber, brand, carModel, year, carColor, carNumber, price);
            isSuccessful = model.addCars(car);
        }
        view.printCar(model.getCars());
        if (isSuccessful) {
            view.printMessage(Messages.SUCCESSFUL);
        } else {
            view.printMessage(Messages.SOMETHING_WRONG);
        }
        return Activities.SHOW_SUBMENU;
    }

    private Activities showSubMenu(View view) {
        view.subMenu();
        view.printMessage(Messages.CHOOSE);
        do {
            choice = view.readNumber(2);
        } while (choice > 5);
        return convertChoiceToConstant(choice + 4);
    }

    private Activities getListOfCarsBrand(View view, Model model) {
        view.printMessage(Messages.ENTER_BRAND_LONG);
        brand = view.readString();
        view.printCar(model.getListOfCarsBrand(brand));
        return Activities.SHOW_SUBMENU;
    }

    private Activities getListOfCarsYears(View view, Model model) {
        view.printMessage(Messages.ENTER_MODEL_LONG);
        carModel = view.readString();
        view.printMessage(Messages.ENTER_YEARS_LONG);
        do {
            year = view.readNumber(4);
        } while (year > 2019);
        view.printCar(model.getListOfCarsYears(carModel, year));
        return Activities.SHOW_SUBMENU;
    }

    private Activities getListOfCarsPrice(View view, Model model) {
        view.printMessage(Messages.ENTER_YEARS_LONG);
        do {
            year = view.readNumber(4);
        } while (year > 2019);
        view.printMessage(Messages.ENTER_PRICE_LONG);
        do {
            price = view.readNumber(5);
        } while (price > 1000000001);
        view.printCar(model.getListOfCarsPrice(year, price));
        return Activities.SHOW_SUBMENU;
    }

}