/*
* https://elearning.unibs.it/mod/assign/view.php?id=383839&action=editsubmission
*
* https://elearning.unibs.it/pluginfile.php/835755/mod_resource/content/1/Tamagotchi.pdf
* */


package TamagotchiPackage;


import mylib.InputDatiB;

/**
 * Classe principale del progetto Tamagotchi, contiene il metodo static main per l'avvio del programma
 */
public class Main {
    /**
     * Metodo main,
     * contiene le chiamate ai metodi necessari all'avvio, il saluto e la creazione di un tamagotchi, e il suo ciclo di vita
     *
     * @param args parametro...
     */
    public static void main(String[] args) {

        salutoIniziale();

        Tamagotchi t = creaTamagotchi();

        System.out.println(t);

        while (t.getStato() != 0) {
            System.out.println("* MENU TAMAGOTCHI");
            System.out.println("* 1) dai carezze");
            System.out.println("* 2) dai biscotti");
            System.out.println("* 0) esci");
            System.out.println("* MENU TAMAGOTCHI");

            int azione = InputDatiB.nextInt();

            switch (azione) {
                case 1:
                    t.riceviCarezze();
                    break;
                case 2:
                    t.riceviBiscotti();
                    break;
                case 0:
                    t.setStato(0);
                    break;
                default:
                    System.out.println("input non accettabile, ritentare");
                    break;
            }


            System.out.println();
            System.out.println(t);
            System.out.println();
        }

    }

    /**
     * metodo che stampa il saluto iniziale al player
     */
    private static void salutoIniziale() {
        System.out.println();
        System.out.println("Ciaoooo a tuttiii");
        System.out.println("Buon gioco!!!");
        System.out.println();
    }

    /**
     * Metodo di creazione del tamagotchi, tramite lettura dei parametri vitali dall'utente.
     * Controlla che i valori vitali siano accettabili.
     *
     * @return Il riferimento all'oggetto tamagotchi creato
     */
    private static Tamagotchi creaTamagotchi() {
        System.out.println("* CREAZIONE TAMAGOTCHI");
        System.out.println("* inserisci nome:");
        String nome = InputDatiB.nextString();
        System.out.println("* inserisci soddisfazione affettiva:");
        int sa = InputDatiB.nextInt(0, 100);
        System.out.println("* inserisci sazietà:");
        int s = InputDatiB.nextInt(0, 100);
        System.out.println("* CREAZIONE TAMAGOTCHI");
        System.out.println();

        Tamagotchi t = new Tamagotchi(nome, sa, s);

        if (!(nome != null && sa != 0 && s != 0)) {
            System.out.println("malfunzionamento sulla creazione di tamagotchi, arresto");
            System.exit(0);
        }
        return t;
    }
}