/*package Tests;

import static org.junit.Assert.*;

import ArchivioCDpackage.Archive;
import ArchivioCDpackage.CD;
import org.junit.Test;

import java.util.ArrayList;

public class ArchivioCdTest {
    @Test
    public void testAggiuntaCd() {
        ArrayList<CD> cds = new ArrayList<>();
        Archive archive = new Archive();
        cds.add(new CD(cds));
        cds.add(new CD(cds));
        archive.setCds(cds);
        assertEquals(2, archive.getCds().size());
    }
}*/

/*
package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArchivioCdTest {
	@Test
	public void testAggiuntaCd() throws Exception {
		final ArchivioCd archivio = new ArchivioCd();
		archivio.aggiungiCd(new Cd("Anime salve", "Fabrizio De Andrè"));
		archivio.aggiungiCd(new Cd("Storia di un impiegato", "Fabrizio De Andrè"));
		assertEquals(2, archivio.getNumeroCd());
	}
	
	@Test
	public void testRicercaTitoloPresente() throws Exception {
		final ArchivioCd archivio = new ArchivioCd();
		archivio.aggiungiCd(new Cd("Anime salve", "Fabrizio De Andrè"));
		archivio.aggiungiCd(new Cd("Storia di un impiegato", "Fabrizio De Andrè"));
		assertTrue(archivio.contiene("Anime salve"));
	}
	
	@Test
	public void testRicercaTitoloNonPresente() throws Exception {
		final ArchivioCd archivio = new ArchivioCd();
		archivio.aggiungiCd(new Cd("Anime salve", "Fabrizio De Andrè"));
		archivio.aggiungiCd(new Cd("Storia di un impiegato", "Fabrizio De Andrè"));
		assertFalse(archivio.contiene("La buona novella"));
	}
	
	@Test
	public void testEliminazioneCdPerTitolo() throws Exception {
		final ArchivioCd archivio = new ArchivioCd();
		archivio.aggiungiCd(new Cd("Anime salve", "Fabrizio De Andrè"));
		archivio.aggiungiCd(new Cd("Storia di un impiegato", "Fabrizio De Andrè"));
		assertEquals(2, archivio.getNumeroCd());
		archivio.eliminaCd("Anime salve");
		assertEquals(1, archivio.getNumeroCd());
		assertFalse(archivio.contiene("Anime salve"));
	}
}
*/
