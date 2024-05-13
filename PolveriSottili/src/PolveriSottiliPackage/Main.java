package PolveriSottiliPackage;

import mylib.InputDatiB;
import mylib.MenuB;


/**
 * The Main class of my project, polveri sottili, containing the runnable main method
 *
 * @author brando
 */
public class Main {
    /**
     * The runnable method of my project
     * @param args the parameters of the main method, where the execution starts
     */
    public static void main(String[] args) {
        MenuB menu = new MenuB("Fine dust sensor application", new String[]{"evaluate a new week"});
        menu.printMenuPlusQuit();

        int choice= InputDatiB.nextInt(-1);

        while (choice!=0){
            if (choice == 1){
                Week week = new Week(InputDatiB.nextInt(1800, "input the year of the week considered(after 1800)"),
                        InputDatiB.nextInt(1, 53, "input the number of the week considered, between 1 and 53"),
                        InputDatiB.nextPositiveIntArray(7, "Input a dust particle value as an µg/m^3 integer for 7 days"));
                System.out.println(week);

                week.checkWeekDustLevels();

                System.out.println();
                menu.printMenuPlusQuit();
            }else {
                System.out.println("Not an option, try again");
            }
            choice= InputDatiB.nextInt(-1);
        }
    }
}


/*
*
* Classe WEEK con Year, WEEKNUMBER(da 1 a 53), 7 values of fineDust
*
*
*
* */