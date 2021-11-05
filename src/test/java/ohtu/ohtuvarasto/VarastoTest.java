package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void lisaaminenEiMeneYli() {
	varasto.lisaaVarastoon(varasto.getTilavuus() + 1);
	assertEquals(varasto.getTilavuus(), varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenEiVoiLiikaa() {
 	Double saatuMaara = varasto.otaVarastosta(1);
	assertEquals(varasto.getSaldo(), saatuMaara, vertailuTarkkuus);

   }

	
   @Test
   public void otaNegatiivinenMaara() {
 	Double saatuMaara = varasto.otaVarastosta(-1);
	assertEquals(0.0, saatuMaara, vertailuTarkkuus);
  }

   @Test
   public void testaaKonstruktoriNeg() {
	Varasto varastoUseless = new Varasto(-10);
	assertEquals(0.0, varastoUseless.getTilavuus(), vertailuTarkkuus);
  }

  @Test
  public void toStringTest() {
	String palautus = varasto.toString();
	assertEquals("saldo = " + varasto.getSaldo() + ", vielä tilaa " + varasto.paljonkoMahtuu(), palautus);
 }



  @Test
  public void negativinenLisays() {
	Double saldo = varasto.getSaldo();
	varasto.lisaaVarastoon(-1);
	assertEquals(saldo, varasto.getSaldo(), vertailuTarkkuus);

  }


  @Test
  public void konstruktoriKaksiArgumenttia() {
	Varasto testVarasto = new Varasto(10, 10);
	assertEquals(10, testVarasto.getTilavuus(), vertailuTarkkuus);
	assertEquals(10, testVarasto.getSaldo(), vertailuTarkkuus);

	testVarasto = new Varasto(-10, -10);
        assertEquals(0.0, testVarasto.getTilavuus(), vertailuTarkkuus);
        assertEquals(0.0, testVarasto.getSaldo(), vertailuTarkkuus);

	testVarasto = new Varasto(10, 11);
        assertEquals(10, testVarasto.getSaldo(), vertailuTarkkuus);
  }











}
