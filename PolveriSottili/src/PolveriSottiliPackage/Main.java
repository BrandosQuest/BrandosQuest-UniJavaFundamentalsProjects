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
     * @param args the parameters
     */
    public static void main(String[] args) {
        MenuB menu = new MenuB("Fine dust sensor application", new String[]{"quit", "evaluate a new week"});
        menu.printMenu();
        int choice= InputDatiB.nextInt();
        while (choice!=1){
            Week week = new Week(InputDatiB.nextInt(1799, "input the year of the week considered"),
                    InputDatiB.nextInt(1, 53),
                    InputDatiB.nextIntArray(7, "Input a dust particle value as an integer for 7 days"));
            System.out.println();
            menu.printMenu();
            choice= InputDatiB.nextInt();
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