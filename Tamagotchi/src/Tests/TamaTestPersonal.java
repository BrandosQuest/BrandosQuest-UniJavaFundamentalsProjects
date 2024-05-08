package Tests;

import static org.junit.Assert.*;

import TamagotchiPackage.Tamagotchi;
import org.junit.Test;


/**
 * Class used for testing of some functionalities of tamagotchi
 *
 * @author Brando
 */
public class TamaTestPersonal {
    /**
     * Method used to test death after too many randomly generated pets
     */
    @Test
    public void testTooManyRandomPets(){
        Tamagotchi t= new Tamagotchi("tama", 50, 30);
        while (t.getStato()!=0){
            System.out.println("soddisfazzione affettiva: "+ t.getSoddisfazioneAffettiva());
            t.riceviCarezze();
        }
        assertTrue(t.sonoMorto());
        System.out.println("\nMorto per :\nsoddisfazzione affettiva: "+ t.getSoddisfazioneAffettiva()+"\nsazietà: "+t.getSazieta());
        System.out.println("\n");
        assertTrue(t.getSoddisfazioneAffettiva()>100 || t.getSazieta()<=0);
    }

    /**
     * Method used to test death after too many randomly generated cookies
     */
    @Test
    public void testTooManyRandomCookies(){
        Tamagotchi t= new Tamagotchi("tama", 50, 30);
        while (t.getStato()!=0){
            System.out.println("Sazietà: "+ t.getSazieta());
            t.riceviBiscotti();
        }
        assertTrue(t.sonoMorto());
        System.out.println("\nMorto per :\nsoddisfazzione affettiva: "+ t.getSoddisfazioneAffettiva()+"\nsazietà: "+t.getSazieta());
        System.out.println("\n");
        assertTrue(t.getSoddisfazioneAffettiva()<=0 || t.getSazieta()>100);
    }
}
