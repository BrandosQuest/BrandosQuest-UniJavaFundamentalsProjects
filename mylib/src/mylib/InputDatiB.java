package mylib;
import java.util.*;

/**
 * Public class with my personal utilities regarding user inputs
 *
 * @author Brando
 */
public class InputDatiB
{/*
	  private static Scanner lettore = creaScanner();
	  
	  private final static String ERRORE_FORMATO = "Attenzione: il dato inserito non e' nel formato corretto";
	  private final static String ERRORE_MINIMO= "Attenzione: e' richiesto un valore maggiore o uguale a ";
	  private final static String ERRORE_STRINGA_VUOTA= "Attenzione: non hai inserito alcun carattere";
	  private final static String ERRORE_MASSIMO= "Attenzione: e' richiesto un valore minore o uguale a ";
	  private final static String MESSAGGIO_AMMISSIBILI= "Attenzione: i caratteri ammissibili sono: ";

	  private final static char RISPOSTA_SI='S';
	  private final static char RISPOSTA_NO='N';
	*/

	/**
	 * Final scanner object used in many different methods to get the user input
	 */
	private static final Scanner scanner = new Scanner(System.in);
	/**
	 * Final String to display a common user input suggestion
	 */
	private static final String BADINPUTMESSAGE= "The input provided is not acceptable, try again";

	/**
	 * Method used to ask the user for a generic int
	 *
	 * @return the int entered by the user
	 */
	public static int nextInt(){
		int r= 0;
		boolean error=false;
		int tries=0;
		do {
			try {
				r = scanner.nextInt();
				error=false;
			} catch (Exception e) {
				System.out.println(BADINPUTMESSAGE);
				scanner.next();
				error=true;
				tries++;
			}
		} while (error && tries<3);
		return r;
	}

	/**
	 * Method used to ask the user for an int between two values
	 *
	 * @param min the lowest value of the interval accepted
	 * @param max the highest value of the interval accepted
	 *
	 * @return the int entered by the user
	 */
	public static int nextInt(int min, int max){
		int r= 0;
		boolean error=false;
		boolean OutOfRange=false;
		int tries=0;
		do {
			try {
				r = scanner.nextInt();
				error=false;
			} catch (Exception e) {
				System.out.println(BADINPUTMESSAGE);
				scanner.next();
				error=true;

			}

			if(r<min || r>max){
				OutOfRange=true;
				System.out.println(BADINPUTMESSAGE);
			}else {
				OutOfRange=false;
			}

			tries++;

			//} while (error && tries<3 && OutOfRange);
		} while ((error || OutOfRange) &&  tries<3);
		return r;
	}
	/**
	 * Method used to ask the user for an int bigger than a value
	 *
	 * @param min the lowest value of the interval accepted
	 * @param message the message displayed to the user
	 *
	 * @return the int entered by the user
	 */
	public static int nextInt(int min, String message){
		int r= 0;
		boolean error=false;
		boolean OutOfRange=false;
		int tries=0;
		do {
			System.out.println(message);
			try {
				r = scanner.nextInt();
				error=false;
			} catch (Exception e) {
				System.out.println(BADINPUTMESSAGE);
				scanner.next();
				error=true;

			}

			if(r<min){
				OutOfRange=true;
				System.out.println(BADINPUTMESSAGE);
			}else {
				OutOfRange=false;
			}

			tries++;

			//} while (error && tries<3 && OutOfRange);
		} while ((error || OutOfRange) &&  tries<3);
		return r;
	}
	/**
	 * Method used to ask the user for an int array
	 *
	 * @param length the length of the required array
	 * @param message the message displayed to the user
	 *
	 * @return the int array entered by the user
	 */
	public static int[] nextIntArray(int length, String message){
		System.out.println(message);
		int[] array= new int[length];
		boolean oneValueSkipped=false;

		for (int i = 0; i < length; i++) {
			boolean error=false;
			int tries=0;
			do {
				System.out.print("Enter the "+i+1+" integer: ");
				try {
					array[i] = scanner.nextInt();
					error=false;
				} catch (Exception e) {
					System.out.println(BADINPUTMESSAGE);
					scanner.next();
					error=true;
				}
				tries++;
			} while (error &&  tries<3);
			/*if (error){
				oneValueSkipped=true;			for when a single value is not added
			}*/
		}
		return array;
	}

	/**
	 * Method used to ask the user for a String
	 *
	 * @return the String entered by the user
	 */
	public static String nextString(){
		return scanner.next();
	}
	/*
	  
 
	  private static Scanner creaScanner ()
	  {
	   Scanner creato = new Scanner(System.in);
	   creato.useDelimiter(System.getProperty("line.separator"));
	   return creato;
	  }
	  
	  public static String leggiStringa (String messaggio)
	  {
		  System.out.print(messaggio);
		  return lettore.next();
	  }
	  
	  public static String leggiStringaNonVuota(String messaggio)
	  {
	   boolean finito=false;
	   String lettura = null;
	   do
	   {
		 lettura = leggiStringa(messaggio);
		 lettura = lettura.trim();
		 if (lettura.length() > 0)
		  finito=true;
		 else
		  System.out.println(ERRORE_STRINGA_VUOTA);
	   } while (!finito);
	   
	   return lettura;
	  }
	  
	  public static char leggiChar (String messaggio)
	  {
	   boolean finito = false;
	   char valoreLetto = '\0';
	   do
	    {
	     System.out.print(messaggio);
	     String lettura = lettore.next();
	     if (lettura.length() > 0)
	      {
	       valoreLetto = lettura.charAt(0);
	       finito = true;
	      }
	     else
	      {
	       System.out.println(ERRORE_STRINGA_VUOTA);
	      }
	    } while (!finito);
	   return valoreLetto;
	  }
	  
	  public static char leggiUpperChar (String messaggio, String ammissibili)
	  {
	   boolean finito = false;
	   char valoreLetto = '\0';
	   do
	   {
	    valoreLetto = leggiChar(messaggio);
	    valoreLetto = Character.toUpperCase(valoreLetto);
	    if (ammissibili.indexOf(valoreLetto) != -1)
		 finito  = true;
	    else
	     System.out.println(MESSAGGIO_AMMISSIBILI + ammissibili);
	   } while (!finito);
	   return valoreLetto;
	  }
	  
	  
	  public static int leggiIntero (String messaggio)
	  {
	   boolean finito = false;
	   int valoreLetto = 0;
	   do
	    {
	     System.out.print(messaggio);
	     try
	      {
	       valoreLetto = lettore.nextInt();
	       finito = true;
	      }
	     catch (InputMismatchException e)
	      {
	       System.out.println(ERRORE_FORMATO);
	       String daButtare = lettore.next();
	      }
	    } while (!finito);
	   return valoreLetto;
	  }

	  public static int leggiInteroPositivo(String messaggio)
	  {
		  return leggiInteroConMinimo(messaggio,1);
	  }
	  
	  public static int leggiInteroNonNegativo(String messaggio)
	  {
		  return leggiInteroConMinimo(messaggio,0);
	  }
	  
	  
	  public static int leggiInteroConMinimo(String messaggio, int minimo)
	  {
	   boolean finito = false;
	   int valoreLetto = 0;
	   do
	    {
	     valoreLetto = leggiIntero(messaggio);
	     if (valoreLetto >= minimo)
	      finito = true;
	     else
	      System.out.println(ERRORE_MINIMO + minimo);
	    } while (!finito);
	     
	   return valoreLetto;
	  }

	  public static int leggiIntero(String messaggio, int minimo, int massimo)
	  {
	   boolean finito = false;
	   int valoreLetto = 0;
	   do
	    {
	     valoreLetto = leggiIntero(messaggio);
	     if (valoreLetto >= minimo && valoreLetto<= massimo)
	      finito = true;
	     else
	      if (valoreLetto < minimo)
	         System.out.println(ERRORE_MINIMO + minimo);
	      else
	    	 System.out.println(ERRORE_MASSIMO + massimo); 
	    } while (!finito);
	     
	   return valoreLetto;
	  }

	  
	  public static double leggiDouble (String messaggio)
	  {
	   boolean finito = false;
	   double valoreLetto = 0;
	   do
	    {
	     System.out.print(messaggio);
	     try
	      {
	       valoreLetto = lettore.nextDouble();
	       finito = true;
	      }
	     catch (InputMismatchException e)
	      {
	       System.out.println(ERRORE_FORMATO);
	       String daButtare = lettore.next();
	      }
	    } while (!finito);
	   return valoreLetto;
	  }
	 
	  public static double leggiDoubleConMinimo (String messaggio, double minimo)
	  {
	   boolean finito = false;
	   double valoreLetto = 0;
	   do
	    {
	     valoreLetto = leggiDouble(messaggio);
	     if (valoreLetto >= minimo)
	      finito = true;
	     else
	      System.out.println(ERRORE_MINIMO + minimo);
	    } while (!finito);
	     
	   return valoreLetto;
	  }

	  
	  public static boolean yesOrNo(String messaggio)
	  {
		  String mioMessaggio = messaggio + "("+RISPOSTA_SI+"/"+RISPOSTA_NO+")";
		  char valoreLetto = leggiUpperChar(mioMessaggio,String.valueOf(RISPOSTA_SI)+String.valueOf(RISPOSTA_NO));
		  
		  if (valoreLetto == RISPOSTA_SI)
			return true;
		  else
			return false;
	  }
*/
}
