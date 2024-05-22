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
	 * Method used to ask the user for a generic int, 3 tries, it checks for errors in the conversion to int
	 *
	 * @param defaultValue the value returned in case of a fail in getting the right input
	 * @return the int entered by the user or the default value in case of a fail
	 */
	public static int nextInt(int defaultValue){
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
		if(tries==3){
			return defaultValue;
		}
		return r;
	}

	/**
	 * Method used to ask the user for an int between two values, 3 tries, it checks for errors in the conversion to int
	 *
	 * @param min the lowest value of the interval accepted
	 * @param max the highest value of the interval accepted
	 * @param message The message to be displayed to the user
	 *
	 * @return the int entered by the user or the lowest value in case of a fail
	 */
	public static Integer nextInt(int min, int max, String message){
		Integer r= null;
		boolean error=false;
		boolean OutOfRange=false;
		int tries=0;

		do {
			System.out.println(message);
			r=null;
			try {
				r = scanner.nextInt();
				error=false;
				if(r<min || r>max){
					OutOfRange=true;
					System.out.println(BADINPUTMESSAGE);
				}else {
					OutOfRange=false;
				}
			} catch (Exception e) {
				System.out.println(BADINPUTMESSAGE);
				scanner.next();
				error=true;
			}
			tries++;
		} while ((error || OutOfRange) &&  tries<3);

		if (tries==3){
			System.out.println("WARNING: OUT OF TRIES, VALUE SET TO SMALLEST OPTION: "+min);
			return min;
		}

		return r;
	}
	/**
	 * Method used to ask the user for an int between two values, 3 tries, it checks for errors in the conversion to int
	 *
	 * @param min the lowest value of the interval accepted
	 * @param max the highest value of the interval accepted
	 *
	 * @return the int entered by the user or the lowest value in case of a fail
	 */
	public static Integer nextInt(int min, int max){
		Integer r= null;
		boolean error=false;
		boolean OutOfRange=false;
		int tries=0;

		do {
			r=null;
			try {
				r = scanner.nextInt();
				error=false;
				if(r<min || r>max){
					OutOfRange=true;
					System.out.println(BADINPUTMESSAGE);
				}else {
					OutOfRange=false;
				}
			} catch (Exception e) {
				System.out.println(BADINPUTMESSAGE);
				scanner.next();
				error=true;
			}
			tries++;
		} while ((error || OutOfRange) &&  tries<3);

		if (tries==3){
			System.out.println("WARNING: OUT OF TRIES, VALUE SET TO SMALLEST OPTION: "+min);
			return min;
		}

		return r;
	}
	/**
	 * Method used to ask the user for an int between two values, 3 tries, it checks for errors in the conversion to int, if it fails it returns the default value
	 *
	 * @param min the lowest value of the interval accepted
	 * @param max the highest value of the interval accepted
	 * @param defaultValue the default value in case of a fail
	 *
	 * @return the int entered by the user or the default value in case of a fail
	 */
	public static Integer nextInt(int min, int max, int defaultValue){
		Integer r= null;
		boolean error=false;
		boolean OutOfRange=false;
		int tries=0;

		do {
			r=null;
			try {
				r = scanner.nextInt();
				error=false;
				if(r<min || r>max){
					OutOfRange=true;
					System.out.println(BADINPUTMESSAGE);
				}else {
					OutOfRange=false;
				}
			} catch (Exception e) {
				System.out.println(BADINPUTMESSAGE);
				scanner.next();
				error=true;
			}
			tries++;
		} while ((error || OutOfRange) &&  tries<3);

		if (tries==3){
			System.out.println("WARNING: OUT OF TRIES, VALUE SET TO DEFAULT OPTION: "+defaultValue);
			return defaultValue;
		}

		return r;
	}
	/**
	 * Method used to ask the user for an int bigger than a value, 3 tries, it checks for errors in the conversion to int
	 *
	 * @param min the lowest value of the interval accepted
	 * @param message the message displayed to the user
	 *
	 * @return the int entered by the user or the lowest value in case of a fail
	 */
	public static Integer nextInt(int min, String message){
		Integer r= null;
		boolean error=false;
		boolean OutOfRange=false;
		int tries=0;

		do {
			System.out.println(message);
			r=null;
			try {
				r = scanner.nextInt();
				error=false;
				if(r<min){
					OutOfRange=true;
					System.out.println(BADINPUTMESSAGE);
				}else {
					OutOfRange=false;
				}
			} catch (Exception e) {
				System.out.println(BADINPUTMESSAGE);
				scanner.next();
				error=true;
			}
			tries++;
		} while ((error || OutOfRange) &&  tries<3);

		if (tries==3){
			System.out.println("WARNING: OUT OF TRIES, VALUE SET TO SMALLEST OPTION: "+min);
			return min;
		}
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

		for (int i = 0; i < length; i++) {
			boolean error=false;
			int tries=0;
			do {
				System.out.print("Enter the "+(i+1)+" integer: ");
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
			if (tries==3){
				System.out.println("WARNING: OUT OF TRIES, VALUE SET TO DEFAULT OPTION: "+0);
				array[i]=0;
			}
		}
		return array;
	}

	/**
	 * Method used to ask the user for an int array of positive numbers
	 *
	 * @param length the length of the required array
	 * @param message the message displayed to the user
	 *
	 * @return the int array entered by the user or 0 in the position in witch there's been a fail
	 */
	public static int[] nextPositiveIntArray(int length, String message){
		System.out.println(message);
		int[] array= new int[length];
		boolean OutOfRange=false;

		for (int i = 0; i < length; i++) {
			boolean error=false;
			int tries=0;
			do {
				System.out.print("Enter the "+(i+1)+"° integer: ");
				try {
					array[i] = scanner.nextInt();
					error=false;
					if(array[i]<0){
						OutOfRange=true;
						System.out.println(BADINPUTMESSAGE);
					}else {
						OutOfRange=false;
					}
				} catch (Exception e) {
					System.out.println(BADINPUTMESSAGE);
					scanner.next();
					error=true;
				}
				tries++;
			} while ((error || OutOfRange) &&  tries<3);
			if (tries==3){
				System.out.println("WARNING: OUT OF TRIES, VALUE SET TO DEFAULT OPTION: "+0);
				array[i]=0;
			}
		}
		return array;
	}
	/**
	 * Method used to ask the user for a String
	 *
	 * @return the String entered by the user, single word
	 */
	public static String nextString(){
		return scanner.next();
	}
	/**
	 * Method used to ask the user for a String after displaying a message
	 *
	 * @return the String entered by the user,  single word
	 */
	public static String nextString(String message){
		System.out.println(message);
		return scanner.next();
	}
	/**
	 * Method used to ask the user for a String after displaying a message
	 *
	 * @return the String entered by the user, whole line, ignores empty strings
	 */
	public static String nextStringLine(String message){
		System.out.println(message);
		String s;
		do {
			s = scanner.nextLine();
		} while (s.isEmpty());
		return s;
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
