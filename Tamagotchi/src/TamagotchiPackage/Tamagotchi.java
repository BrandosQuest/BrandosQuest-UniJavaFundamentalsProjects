package TamagotchiPackage;

import java.util.Random;

/**
 * Classe tamagotchi, contiene la simulazione di un animaletto tamagotchi
 */
public class Tamagotchi {
    /**
     * Il nome del tamagotchi
     */
    private String nome;
    /**
     * Lo stato di vita del tamagotchi
     */
    private  int stato;
    /**
     * Il livello di soddisfazione affettiva del tamagotchi
     */
    private  int soddisfazioneAffettiva;
    /**
     * Il livello di sazietà del tamagotchi
     */
    private  int sazieta;
    /**
     * Il livello minimo di soddisfazione affettiva del tamagotchi
     */
    private final int LOWER_LIMIIT_SODDISFAZIONE_AFFETTIVA=0;
    /**
     * Il livello minimo di sazietà del tamagotchi
     */
    private final int LOWER_LIMIIT_SAZIETA=0;
    /**
     * Oggetto Random utile a vari metodi
     */
    private final Random random= new Random();

    /**
     * Metodo costruttore per la classe tamagotchi, dopo l'inizializzazione degli attributi chiama il metodo controllastato
     *
     * @param nome il nome dell'animaletto creato
     * @param soddisfazioneAffettiva  il valore di soddisfazione affettiva che le carezze andranno a modificare
     * @param sazieta  il valore di sazietà che i biscotti andranno a modificare
     */
    public Tamagotchi(String nome, int soddisfazioneAffettiva, int sazieta) {
        this.nome = nome;
        this.soddisfazioneAffettiva = soddisfazioneAffettiva;
        this.sazieta = sazieta;
        controllaStato();//1vivo
    }

    /**
     * Metodo con il quale l'utente può impartire un numero di carezze preciso al tamagotchi
     * Utile per il testing
     *
     * @param numCarezze numero di carezze
     */
    public void riceviCarezze(int numCarezze){

        if(soddisfazioneAffettiva>70){
            numCarezze= (int) (numCarezze*0.5);
        }

        soddisfazioneAffettiva=soddisfazioneAffettiva+numCarezze;
        sazieta = sazieta -(numCarezze/2);
        controllaStato();
    }

    /**
     * Metodo con il quale l'utente può impartire un numero di biscotti preciso al tamagotchi
     * Utile per il testing
     *
     * @param numBiscotti numero di biscotti
     */
    public void riceviBiscotti(int numBiscotti){

        if(sazieta >70){
            numBiscotti= (int) (numBiscotti*0.5);
        }

        sazieta = sazieta +(int)(0.1* sazieta *numBiscotti);
        soddisfazioneAffettiva= (int) (soddisfazioneAffettiva-((1/4)*(double)numBiscotti));
        controllaStato();
    }

    /**
     * Metodo con il quale l'utente può impartire carezze al tamagotchi
     */
    public void riceviCarezze(){
        final int UPPER_LIMIIT_SODDISFAZIONE_AFFETTIVA = 100;
        int numCarezze=random.nextInt(LOWER_LIMIIT_SODDISFAZIONE_AFFETTIVA, UPPER_LIMIIT_SODDISFAZIONE_AFFETTIVA);

        if(soddisfazioneAffettiva>70){
            numCarezze= (int) (numCarezze*0.5);
        }

        soddisfazioneAffettiva=soddisfazioneAffettiva+numCarezze;
        sazieta = sazieta -(numCarezze/2);
        controllaStato();
    }

    /**
     * Metodo con il quale l'utente può dare biscotti al tamagotchi
     */
    public void riceviBiscotti(){
        int numBiscotti= random.nextInt(LOWER_LIMIIT_SAZIETA, 10);

        if(sazieta >70){
            numBiscotti= (int) (numBiscotti*0.5);
        }

        sazieta = sazieta +(int)(0.1* sazieta *numBiscotti);
        soddisfazioneAffettiva= (int) (soddisfazioneAffettiva-((0.25)*(double)numBiscotti));
        controllaStato();
    }

    /**
     * Metodo privato con il quale, dopo ogni cambio di stato delle sue variabili,
     * il tamagotchi controlla il suo stato
     */
    private void controllaStato(){
        final int SADNESS_LIMIIT_SODDISFAZIONE_AFFETTIVA = 30;
        final int SADNESS_LOWER_LIMIIT_SAZIETA = 30;
        final int SADNESS_UPPER_LIMIIT_SAZIETA = 90;

        final int UPPER_LIMIIT_SAZIETA = 100;
        if(soddisfazioneAffettiva>LOWER_LIMIIT_SODDISFAZIONE_AFFETTIVA && (sazieta >LOWER_LIMIIT_SAZIETA && sazieta < UPPER_LIMIIT_SAZIETA)){
            stato=1;
            if (soddisfazioneAffettiva<SADNESS_LIMIIT_SODDISFAZIONE_AFFETTIVA || (sazieta <SADNESS_LOWER_LIMIIT_SAZIETA || sazieta >SADNESS_UPPER_LIMIIT_SAZIETA)) {
                stato=2;
            }
        } else {
            stato=0;
        }
    }


    /**
     * Metodo con il quale si puo accedere allo stato del tamagotchi, per esempio per stabilire se è morto
     *
     * @return Lo stato del tamagotchi
     */
    public int getStato() {
        return stato;
    }

    /**
     * Metodo con il quale si puo simulare l'uccisione del tamagotchi nel caso l'utente finisca di giocare
     *
     * @param stato il valore che stato deve prendere
     */
    public void setStato(int stato) {
        this.stato = stato;
    }

    /**
     * Metodo con il quale si puo accedere alla soddisfazione affettiva del tamagotchi, per motivi di testing
     *
     * @return la soddisfazione affettiva
     */
    public int getSoddisfazioneAffettiva() {
        return soddisfazioneAffettiva;
    }

    /**
     * Metodo con il quale si puo accedere alla sazietà del tamagotchi, per motivi di testing
     *
     * @return la sazietà
     */
    public int getSazieta() {
        return sazieta;
    }

    /**
     * Metodo con il quale si puo avere accesso al valore della media pesata tra soddisfazione affettiva e sazietà,
     * per mostrare al player più facilmente lo stato del tamagotchi
     *
     * @return media pesata tra soddisfazione affettiva e sazietà
     */
    private int getGradoDiBenessere(){
        return ((sazieta *100)+(soddisfazioneAffettiva*100))/200;
    }

    /**
     * Metodo che mostra l'oggetto tamagotchi, con tutte le sue variabili in modo che l'utente possa valutare la prossima mossa
     *
     * @return una stringa composta da tutte le info necessarie
     */
    @Override
    public String toString() {
        StringBuffer tama=new StringBuffer();
        tama.append("****** TAMA ").append(nome.toUpperCase()).append(System.lineSeparator());
        switch (stato){
            case 1:
                tama.append("* ").append("VIVO E VEGETO").append(System.lineSeparator());
                break;
            case 2:
                tama.append("* ").append("TRISTINO, CATTIVO PADRONE").append(System.lineSeparator());
                break;
            case 0:
                tama.append("* ").append("TROPPO TARDI, È MORTO").append(System.lineSeparator());
                break;
            default:
                System.out.println("Stato del Tamagotchi non regolare");
                break;
        }
        tama.append("* ").append("soddistazione affettiva: ").append(soddisfazioneAffettiva).append(System.lineSeparator());
        tama.append("* ").append("sazietà: ").append(sazieta).append(System.lineSeparator());
        tama.append("* ").append("grado di benessere complessivo: ").append(getGradoDiBenessere()).append(System.lineSeparator());
        tama.append("****** TAMA ").append(nome.toUpperCase()).append(System.lineSeparator());
        return tama.toString();
    }

    /**
     * Metodo di testing per controllare lo stato del tamagotchi
     *
     * @return se tamagotchi è morto o meno
     */
    public boolean sonoMorto() {
        return stato == 0;
    }

    /**
     * Metodo di testing per controllare lo stato del tamagotchi
     *
     * @return se tamagotchi è triste o meno
     */
    public boolean sonoTriste() {
        return stato == 2;
    }

}
