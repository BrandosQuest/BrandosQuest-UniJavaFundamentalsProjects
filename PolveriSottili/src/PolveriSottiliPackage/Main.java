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
        MenuB menu = new MenuB("Fine dust sensor application", new String[]{"quit", "evaluate a new week"});
        menu.printMenu();

        int choice= InputDatiB.nextInt();

        while (choice!=1){
            Week week = new Week(InputDatiB.nextInt(1799, "input the year of the week considered(after 1800)"),
                    InputDatiB.nextInt(1, 53, "input the number of the week considered, between 1 and 53"),
                    InputDatiB.nextIntArray(7, "Input a dust particle value as an µg/m^3 integer for 7 days"));
            System.out.println(week.toString());

            checkWeekDustLevels(week);

            menu.printMenu();
            choice= InputDatiB.nextInt();
        }


    }
    private static void checkWeekDustLevels(Week week){
        if(week.getMaxDustLevel()>=75){
            System.out.println("Warning: found highest value of fine dust particle of "+week.getMaxDustLevel());
        }
        if(week.getMeanDustLevel()>=50){
            System.out.println("Warning: mean of fine dust particle in the week exceeds 50 µg/m^3 at the value of "+week.getMeanDustLevel());
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