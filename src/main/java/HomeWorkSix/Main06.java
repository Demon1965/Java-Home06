package HomeWorkSix;
import java.util.ArrayList;
import java.util.Scanner;
public class Main06 {
    public class Laptop {
        private static int ID = 0;
        private int IDLaptop;
        private String brand;
        private int RAM;
        private double diagonal;
        private String color;
        private int cost;
        public String getBrand() {
            return brand;
        }
        public int getRAM() {
            return RAM;
        }
        public double getDiagonal() {
            return diagonal;
        }
        public String getColor() {
            return color;
        }
        public int getCost() {
            return cost;
        }
        public Laptop() {
            ID++;
            this.IDLaptop = ID;
            this.brand = (String) ParametersLaptop.getRandomValue("brand");
            this.RAM = (Integer) ParametersLaptop.getRandomValue("RAM");
            this.diagonal = (Double) ParametersLaptop.getRandomValue("diagonal");
            this.color = (String) ParametersLaptop.getRandomValue("color");
            this.cost = (Integer) ParametersLaptop.getRandomValue("cost");
        }
        public String toString() {
            return "Laptop {" +
                    "IDLaptop = " + IDLaptop + '\t' +
                    "brand = '" + brand + '\'' + '\t' +
                    "RAM = " + RAM + '\t' +
                    "diagonal = " + diagonal + '"' + '\t' +
                    "color = '" + color + '\'' + '\t' +
                    "cost = " + cost +
                    '}';
        }
    }
    public class ParametersLaptop {
        public static Object getRandomValue(String nameArray) {
            switch (nameArray) {
                case "brand":
                    String[] brand = {"Dell", "HP", "Lenovo", "Apple", "Acer", "MSurface", "Asus"}; // бренд
                    return brand[(int) (Math.random() * brand.length)];
                case "RAM":
                    int[] RAM = new int[]{2, 4, 6, 8, 16, 32, 64};                                           // оперативная память
                    return RAM[(int) (Math.random() * RAM.length)];
                case "diagonal":
                    double[] diagonal = new double[]{10.1, 11.6, 12.5, 13.3, 14.1, 15.6, 17.3, 18.4};       // диагональ
                    return diagonal[(int) (Math.random() * diagonal.length)];
                case "color":
                    String[] color = new String[]{"red", "green", "blue", "gold", "silver", "orange", "black"};      // цвет ноутбука
                    return color[(int) (Math.random() * color.length)];
                case "cost":
                    int [] cost = new int[]{48_000, 50_000, 55_000, 60_000, 80_000, 100_000,
                            150_000, 200_000, 250_000, 300_000, 330_000}; // стоимость
                    return cost[(int) (Math.random() * cost.length)];
            }
            return -1;
        }

    }



    public class WorkArrayLaptop {
        public static void useSelect (ArrayList<Laptop> laptopList) {
            Scanner scanner = new Scanner(System.in);
            String useString;
            System.out.println("Выберете параметр поиска ноутбуков по: " + '\n' +
                    "бренду - введите ключевое слово - > \t\t\t brand" + '\n' +
                    "оперативной памяти - введите ключевое слово - >  RAM" + '\n' +
                    "диагонали экрана - введите ключевое слово - > \t diagonal" + '\n' +
                    "цвету ноутбука - введите ключевое слово - > \t color" + '\n' +
                    "стоимости - введите ключевое слово - > \t\t\t cost" );
            ArrayList<Laptop> laptopSearch = new ArrayList<>();
            while(true) {
                useString = scanner.nextLine().replaceAll(" ", "").toLowerCase();
                switch (useString) {
                    case "brand":
                        System.out.println("Введите наименование бренда согласно образцу, например -> Dell");
                        useString = scanner.nextLine().replaceAll(" ", "").toLowerCase();
                        laptopSearch.clear();
                        for (int i = 0; i < laptopList.size(); i++) {
                            if (laptopList.get(i).getBrand().toLowerCase().equals(useString)) {
                                laptopSearch.add(laptopList.get(i));
                            }
                        }
                        if (laptopSearch.size() == 0) {
                            System.out.println("Ноутбуков с такими параметрами нет!\n");
                        } else {
                            for (int i = 0; i < laptopSearch.size(); i++) {
                                System.out.println(laptopSearch.get(i));
                            }
                        }
                        System.out.println("Если удовлетворены результатом поиска, введите -> exit" + "\n" +
                                "Если не удовлетворены, введите параметр поиска");
                        break;
                    case "ram":
                        System.out.println("Введите минимальный размер оперативной памяти, например -> 2");
                        useString = scanner.nextLine().replaceAll(" ", "");
                        laptopSearch.clear();
                        Integer valueRam;
                        try {
                            valueRam = Integer.parseInt(useString);
                        } catch (Exception exception) {
                            System.out.println("Ноутбуков с такими параметрами нет!\n" +
                                    "Если удовлетворены результатом поиска, введите -> exit" + "\n" +
                                    "Если не удовлетворены, введите параметр поиска");
                            break;
                        }
                        for (int i = 0; i < laptopList.size(); i++) {
                            if (valueRam <= laptopList.get(i).getRAM()) {
                                laptopSearch.add(laptopList.get(i));
                            }
                        }
                        if (laptopSearch.size() == 0) {
                            System.out.println("Ноутбуков с такими параметрами нет!\n");
                        } else {
                            for (int i = 0; i < laptopSearch.size(); i++) {
                                System.out.println(laptopSearch.get(i));
                            }
                        }
                        System.out.println("Если удовлетворены результатом поиска, введите -> exit" + "\n" +
                                "Если не удовлетворены, введите параметр поиска");
                        break;
                    case "diagonal":
                        System.out.println("Введите минимальный размер диагонали экрана, например -> 15");
                        useString = scanner.nextLine().replaceAll(" ", "");
                        laptopSearch.clear();
                        Double valueDiagonal;
                        try {
                            valueDiagonal = Double.parseDouble(useString);
                        } catch (Exception exception) {
                            System.out.println("Ноутбуков с такими параметрами нет!\n" +
                                    "Если удовлетворены результатом поиска, введите -> exit" + "\n" +
                                    "Если не удовлетворены, введите параметр поиска");
                            break;
                        }
                        for (int i = 0; i < laptopList.size(); i++) {
                            if (valueDiagonal <= laptopList.get(i).getDiagonal()) {
                                laptopSearch.add(laptopList.get(i));
                            }
                        }
                        if (laptopSearch.size() == 0) {
                            System.out.println("Ноутбуков с такими параметрами нет!\n");
                        } else {
                            for (int i = 0; i < laptopSearch.size(); i++) {
                                System.out.println(laptopSearch.get(i));
                            }
                        }
                        System.out.println("Если удовлетворены результатом поиска, введите -> exit" + "\n" +
                                "Если не удовлетворены, введите параметр поиска");
                        break;
                    case "color":
                        System.out.println("Введите искомый цвет ноутбука, например -> green");
                        useString = scanner.nextLine().replaceAll(" ", "").toLowerCase();
                        laptopSearch.clear();
                        for (int i = 0; i < laptopList.size(); i++) {
                            if (laptopList.get(i).getColor().toLowerCase().equals(useString)) {
                                laptopSearch.add(laptopList.get(i));
                            }
                        }
                        if (laptopSearch.size() == 0) {
                            System.out.println("Ноутбуков с такими параметрами нет!\n");
                        } else {
                            for (int i = 0; i < laptopSearch.size(); i++) {
                                System.out.println(laptopSearch.get(i));
                            }
                        }
                        System.out.println("Если удовлетворены результатом поиска, введите -> exit" + "\n" +
                                "Если не удовлетворены, введите параметр поиска: ");
                        break;
                    case "cost":
                        System.out.println("Введите минимальную стоимость ноутбука, например -> 40_000");
                        useString = scanner.nextLine().replaceAll(" ", "");
                        laptopSearch.clear();
                        Integer valueCost;
                        try {
                            valueCost = Integer.parseInt(useString);
                        } catch (Exception exception) {
                            System.out.println("Ноутбуков с такими параметрами нет!\n" +
                                    "Если удовлетворены результатом поиска, введите -> exit" + "\n" +
                                    "Если не удовлетворены, введите параметр поиска");
                            break;
                        }
                        for (int i = 0; i < laptopList.size(); i++) {
                            if (valueCost <= laptopList.get(i).getCost()) {
                                laptopSearch.add(laptopList.get(i));
                            }
                        }
                        if (laptopSearch.size() == 0) {
                            System.out.println("Ноутбуков с такими параметрами нет!\n");
                        } else {
                            for (int i = 0; i < laptopSearch.size(); i++) {
                                System.out.println(laptopSearch.get(i));
                            }
                        }
                        System.out.println("Если удовлетворены результатом поиска, введите -> exit" + "\n" +
                                "Если не удовлетворены, введите параметр поиска");
                        break;
                    case "exit":
                        System.out.println("Завершена работа по сортировке ноутбуков");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Выбрана неверная команда, повторите...");
                        break;
                }
            }
        }
    }
}
