package TestPackage;

public class TestPolveriSottili {

    @Test
    public void dieForZeroSatisfaction() throws Exception
    {
        final Tamagotchi tama = new Tamagotchi("Kira", 0, 50);
        assertTrue(tama.sonoMorto());
    }
}
