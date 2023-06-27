package HomeWorkFive;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Main05 {
    public static void main(String[] args) {
        Integer useValue = 5439;
        System.out.println(romanNumber(useValue));
        //  phoneDirectory ();
    }

    public static void phoneDirectory () {
        System.out.println("\t\t\t\t\t\t USER INTERFACE\n" +
                "LIST OF FUNCTION:\t\t\t\t\t\tSAMPLE FUNCTION CALL:\n" +
                "1. add a subscriber (phone number):\t\tADD Ivanov 8 800 555 35 35\n" +
                "2. get subscriber numbers by name:\t\tGET Ivanov \n" +
                "3. delete a subscriber:\t\t\t\t\tREMOVE Ivanov\n" +
                "4. get the whole list:\t\t\t\t\tLIST\n" +
                "5. end the program:\t\t\t\t\t\tEXIT\n" );
        Map<String, LinkedList<String>> libery = new HashMap<>(10, 0.7f);
        String useString;
        Scanner scanner = new Scanner(System.in);
        while(true){
            useString = scanner.nextLine().trim().toString(); // чтение данных в переменную
            String [] data = arrayString(useString);          // преобразование строки в массив строк
            String command = data[0].toUpperCase();
            String name = data[1].toUpperCase();
            String phone = data[2].toUpperCase();
            switch (command) {
                case "ADD":
                    if (!libery.containsKey(name)) {
                        libery.put(name, new LinkedList<>());
                    }
                    if (phone != "") {
                        libery.get(name).add(phone);}
                    break;
                case "GET":
                    if (libery.containsKey(name)) {
                        System.out.printf("%s = %s\n", name, libery.get(name));
                    } else {
                        System.out.printf("Не найдена запись с фамилией %s\n", name);
                    }
                    break;
                case "LIST":
                    if (libery.isEmpty()) {
                        System.out.println("List is empty!\n");
                    } else {
                        StringBuilder printString = new StringBuilder();
                        for (var item : libery.entrySet()) {
                            printString.append(item.getKey() + " = " + item.getValue() + ", ");
                        }
                        printString.deleteCharAt(printString.length()-1);
                        printString.deleteCharAt(printString.length()-1);
                        System.out.println(printString);
                    }
                    break;
                case "REMOVE":
                    if (libery.containsKey(name)) {
                        System.out.printf("Delete %s = %s\n", name, libery.get(name));
                        libery.remove(name);
                    } else {
                        System.out.printf("Не найдена запись с фамилией %s\n", name);
                    }
                    break;
                case "EXIT":
                    scanner.close();
                    return;
                case "":
                    break;
                default:
                    System.out.println("Invalid command entered, please repeat: \n");
                    break;
            }
        }
    }

    public static String [] arrayString (String useString) {
        StringBuilder tempWord = new StringBuilder();
        int count = 0;
        int sizeArray = 3;
        String [] tempString = new String []{"","",""};
        for (int i = 0; i < useString.length(); i++) {
            Character symbol = useString.charAt(i);
            if (useString.charAt(i) == ' ') {
                if (!tempWord.toString().equals("")){
                    if (count < sizeArray - 1){
                        tempString[count] = (tempWord.toString());
                        tempWord.setLength(0);
                        count++;
                    } else {
                        tempString[count] += tempWord.append(" ").toString();
                        tempWord.setLength(0);
                    }
                }
            } else {
                tempWord.append(symbol);
            }
        }
        if(!tempWord.toString().replaceAll(" ","").equals("")) {
            tempString[count] += tempWord.toString();
        } else {
            tempString[count] = tempString[count].trim();
        }
        return tempString;
    }
    /*Написать метод, который переведет число из римского формата записи в арабский.
    /Например, MMXXI = 2022 LXXXVIII
    */
    public static StringBuilder romanNumber(Integer useValue) {
        Character[] compiler = {'I', 'V', 'X', 'L', 'C', 'D', 'M'}; // Alt + 773 (в текстовом формате)
        StringBuilder romanNumber = new StringBuilder();
        int remains;
        int overFife;
        Character one;
        Character five;
        Character ten;
        for (int i = 0; i < compiler.length - 2; i += 2) {
            remains = useValue % 10;
            one = compiler[i];
            five = compiler[i + 1];
            ten = compiler[i + 2];

            switch (remains) {
                case 0:
                    romanNumber.insert(0, "");
                    break;
                case 1:
                case 2:
                case 3:
                    for (int j = 0; j < remains; j++) {
                        romanNumber.insert(0, one);
                    }
                    break;
                case 4:
                    romanNumber.insert(0, five).insert(0, one);
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                    overFife = remains - 5;
                    for (int j = 0; j < overFife; j++) {
                        romanNumber.insert(0, one);
                    }
                    romanNumber.insert(0, five);
                    break;
                case 9:
                    romanNumber.insert(0, ten).insert(0, one);
                    break;
            }

            useValue = useValue / 10;
        }
        if (useValue != 0) {
            for (int i = 0; i < useValue; i++) {
                romanNumber.insert(0, compiler[compiler.length - 1]);
            }
        }
        return romanNumber;

    }

}

