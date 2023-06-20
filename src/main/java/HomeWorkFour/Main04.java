package HomeWorkFour;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main04 {


    public static void main04(String[] args) {
        /*
        Реализовать консольное приложение, которое:
        1. Принимает от пользователя и “запоминает” строки.
        2. Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
        3. Если введено revert, удаляет предыдущую введенную строку из памяти.
        4. Если введено exit, то программа завершается
> - ввод в консоль (stdin), < - вывод на консоль (stdout)
                > java
                > python
                > c#
> print
                < [c#, python, java]
> revert
                > print
                < [python, java]
> revert
                > revert
                > print
                < []
> revert -> throw new NoSuchElementException
         */
        Scanner useString = new Scanner(System.in);
        Deque<String> dQ = new LinkedList<>();

        System.out.println("Enter your string, please: ");

        while (true) {
            String temp = useString.nextLine().replaceAll(" ", "");
            if (temp.toLowerCase().equals("exit")) {
                break;
            } else if (temp.toLowerCase().equals("print")) {
                System.out.println(dQ);
            } else if (temp.toLowerCase().equals("revert")) {
                if (dQ.size() == 0) {
                    System.err.println("throw new NoSuchElementException");
                    continue;
                }
                System.out.printf("Revert removed element: %s\n", dQ.pollFirst());
            } else if (temp != "") {
                dQ.addFirst(temp);
            }
        }

        useString.close();

    }
}
