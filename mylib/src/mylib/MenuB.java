package mylib;
/*
Questa classe rappresenta un menu testuale generico a piu' voci
Si suppone che la voce per uscire sia sempre associata alla scelta 0 
e sia presentata in fondo al menu

*/

import java.util.ArrayList;
import java.util.Collections;

/**
 * Public class with my personal utilities regarding menus display
 *
 * @author Brando
 */
public class MenuB
{
    /**
     * Title of this menu
     */
    private String title;
    /**
     * List of option on my menu
     */
    private ArrayList<String> options = new ArrayList<String>();

    /**Constructor for a menu
     * @param title the title of the menu
     * @param options the options of my menu
     */
    public MenuB(String title, String [] options) {
        this.title = title;
        Collections.addAll(this.options, options);
    }

    /**Method to add an option to the list on my menu
     * @param option The option to add
     */
    public void addOption(String option){
        options.add(option);
    }

    /**
     * The print of the menu
     */
    public void printMenu(){
        System.out.println("--"+title.toUpperCase());
        for (int i = 0; i < options.size(); i++) {
            System.out.println(i+1+") "+options.get(i));
        }
        System.out.println("--"+title.toUpperCase());
    }
    /**
     * The print of the menu Plus Quit option
     */
    public void printMenuPlusQuit(){
        System.out.println("--"+title.toUpperCase());
        for (int i = 0; i < options.size(); i++) {
            System.out.println(i+1+") "+options.get(i));
        }
        System.out.println(0+") "+"Quit");
        System.out.println("--"+title.toUpperCase());
    }
 /* final private static String CORNICE = "--------------------------------";
  final private static String VOCE_USCITA = "0\tEsci";
  final private static String RICHIESTA_INSERIMENTO = "Digita il numero dell'opzione desiderata > ";

  private String titolo;
  private String [] voci;*/

/*
  public MyMenuB(String titolo, String [] voci)
  {
	this.titolo = titolo;
	this.voci = voci;
  }

  public int scegli ()
  {
	stampaMenu();
	return InputDatiB.leggiIntero(RICHIESTA_INSERIMENTO, 0, voci.length);
  }
		
  public void stampaMenu ()
  {
	System.out.println(CORNICE);
	System.out.println(titolo);
	System.out.println(CORNICE);
    for (int i=0; i<voci.length; i++)
	 {
	  System.out.println( (i+1) + "\t" + voci[i]);
	 }
    System.out.println();
	System.out.println(VOCE_USCITA);
    System.out.println();
  }
		*/
}

