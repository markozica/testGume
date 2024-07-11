package testovi;

import static org.junit.Assert.*;

import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import gume.AutoGuma;
import gume.VulkanizerskaRadnja;

public class AutoGumaTest {

	public AutoGuma AG;

	@Rule
	public final TestRule timeout = Timeout.seconds(5);

	@BeforeClass
	public static void ProveriOperativniSistem() {
		Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	}

	@Rule
	public final ErrorCollector ec = new ErrorCollector();

	@Before
	public void init() {
		AG = new AutoGuma("Michelin", true, 18, 180, 40);
	}

	@Rule
	public final TestName name = new TestName();

	@Test
	public void getZimskaTest() {
		try {
			assertEquals("getZimskaTest", name.getMethodName());
		} catch (Throwable t) {
			ec.addError(t);
		}

		boolean ocekivaniRezultat = true;

		try {
			boolean stvarniRezultat = AG.getZimska();
			assertEquals(ocekivaniRezultat, stvarniRezultat);
		} catch (Throwable t) {
			ec.addError(t);
		}
	}

	@Test
	public void setZimskaTest() {
		assertEquals("setZimskaTest", name.getMethodName());
		boolean ocekivaniRezultat = true;
		boolean stvarniRezultat = AG.getZimska();
		try {
			assertEquals(ocekivaniRezultat, stvarniRezultat);
		} catch (Throwable t) {
			ec.addError(t);
		}

		AG.setZimska(false);
		ocekivaniRezultat = false;
		stvarniRezultat = AG.getZimska();
		try {
			assertEquals(ocekivaniRezultat, stvarniRezultat);
		} catch (Throwable t) {
			ec.addError(t);
		}
	}

	@Test(expected = RuntimeException.class)
	public void setPrecnikTest() {
		int ocekivaniRezultat = 18;
		int stvarniRezultat = AG.getPrecnik();
		assertEquals(ocekivaniRezultat, stvarniRezultat);

		AG.setPrecnik(10);
	}

	@Test(expected = RuntimeException.class)
	public void setPrecnikTest2() {
		int ocekivaniRezultat = 18;
		int stvarniRezultat = AG.getPrecnik();
		assertEquals(ocekivaniRezultat, stvarniRezultat);

		AG.setPrecnik(25);
	}

	@Test
	public void setPrecnikTest3() {
		int ocekivaniRezultat = 18;
		int stvarniRezultat = AG.getPrecnik();
		try {
			assertEquals(ocekivaniRezultat, stvarniRezultat);
		} catch (Throwable t) {
			ec.addError(t);
		}

		AG.setPrecnik(15);
		ocekivaniRezultat = 15;
		stvarniRezultat = AG.getPrecnik();
		try {
			assertEquals(ocekivaniRezultat, stvarniRezultat);
		} catch (Throwable t) {
			ec.addError(t);
		}

	}

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void setSirinaTest() {
		exception.expect(RuntimeException.class);
		exception.expectMessage("Sirina van opsega");
		int ocekivaniRezultat = 180;
		int stvarniRezultat = AG.getSirina();
		assertEquals(ocekivaniRezultat, stvarniRezultat);

		AG.setSirina(120);
	}

	@Test
	public void setSirinaTest2() {
		exception.expect(RuntimeException.class);
		exception.expectMessage("Sirina van opsega");
		int ocekivaniRezultat = 180;
		int stvarniRezultat = AG.getSirina();
		assertEquals(ocekivaniRezultat, stvarniRezultat);

		AG.setSirina(360);
	}

	@Test
	public void setSirinaTest3() {
		int ocekivaniRezultat = 180;
		int stvarniRezultat = AG.getSirina();
		assertEquals(ocekivaniRezultat, stvarniRezultat);

		AG.setSirina(250);
		ocekivaniRezultat = 250;
		stvarniRezultat = AG.getSirina();
		assertEquals(ocekivaniRezultat, stvarniRezultat);
	}

	@Test
	public void setVisinaTest() {

		int ocekivaniRezultat = 40;
		int stvarniRezultat = AG.getVisina();
		assertEquals(ocekivaniRezultat, stvarniRezultat);

		try {
			AG.setVisina(20);
		} catch (Throwable t) {
			Assume.assumeNoException(t);
		}
	}

	@Test
	public void setVisinaTest2() {

		int ocekivaniRezultat = 40;
		int stvarniRezultat = AG.getVisina();
		assertEquals(ocekivaniRezultat, stvarniRezultat);

		try {
			AG.setVisina(100);
		} catch (Throwable t) {
			Assume.assumeNoException(t);
		}
	}

	@Test
	public void setVisinaTest3() {

		int ocekivaniRezultat = 40;
		int stvarniRezultat = AG.getVisina();
		assertEquals(ocekivaniRezultat, stvarniRezultat);

		AG.setVisina(50);
		ocekivaniRezultat = 50;
		stvarniRezultat = AG.getVisina();
		assertEquals(ocekivaniRezultat, stvarniRezultat);
	}

	@Test
	public void getMarkaModelTest() {
		String ocekivaniRezultat = "Michelin";
		String stvarniRezultat = AG.getMarkaModel();
		assertEquals(ocekivaniRezultat, stvarniRezultat);
	}

	@Test(expected = RuntimeException.class)
	public void setMarkaModelTest() {
		String ocekivaniRezultat = "Michelin";
		String stvarniRezultat = AG.getMarkaModel();
		assertEquals(ocekivaniRezultat, stvarniRezultat);

		AG.setMarkaModel(null);
	}

	@Test(expected = RuntimeException.class)
	public void setMarkaModelTest2() {
		String ocekivaniRezultat = "Michelin";
		String stvarniRezultat = AG.getMarkaModel();
		assertEquals(ocekivaniRezultat, stvarniRezultat);

		AG.setMarkaModel("A1");
	}

	@Test
	public void setMarkaModelTest3() {
		String ocekivaniRezultat = "Michelin";
		String stvarniRezultat = AG.getMarkaModel();
		assertEquals(ocekivaniRezultat, stvarniRezultat);

		AG.setMarkaModel("Pirelli");
		ocekivaniRezultat = "Pirelli";
		stvarniRezultat = AG.getMarkaModel();
		assertEquals(ocekivaniRezultat, stvarniRezultat);
	}

	@Test
	public void izracunajCenuTest() {
		double ocekivaniRezultat = (AG.getPrecnik() * 3 + AG.getSirina() + AG.getVisina()) * 28.53;
		double stvarniRezultat = AG.izracunajCenu();
		assertEquals(ocekivaniRezultat, stvarniRezultat, 0.001);
	}

	@Test
	public void povoljnaGuma() {
		assertFalse(AG.povoljnaGuma());
	}

	@Test
	public void povoljnaGuma2() {
		AG.setSirina(135);
		AG.setPrecnik(13);
		AG.setVisina(25);
		assertTrue(AG.povoljnaGuma());
	}

	@Test
	public void toStringTest() {
		String ocekivaniRezultat = "AutoGuma [markaModel=" + AG.getMarkaModel() + ", precnik=" + AG.getPrecnik()
				+ ", sirina=" + AG.getSirina() + ", visina=" + AG.getVisina() + "]";
		String stvarniRezultat = AG.toString();
		assertEquals(ocekivaniRezultat, stvarniRezultat);
	}
	
	@Test
	public void equalsTest1() {
		AutoGuma AG2 = new AutoGuma("Michelin", true, 18, 180, 40);
		assertTrue(AG.equals(AG2));
	}
	@Test
	public void equalsTest2() {
		VulkanizerskaRadnja VK = new VulkanizerskaRadnja();
		assertEquals(false, AG.equals(VK));
	}
	@Test
	public void equalsTest3() {
		AutoGuma AG2 = AG;
		assertTrue(AG.equals(AG2));
	}
	@Test
	public void equalsTest4() {
		AutoGuma AG2 = new AutoGuma(null, true, 18, 180, 40);
		assertFalse(AG.equals(AG2));
	}
	@Test
	public void equalsTest5() {
		AutoGuma AG2 = new AutoGuma(null, true, 18, 180, 40);
		AutoGuma AG3 = new AutoGuma(null, true, 18, 180, 40);
		assertTrue(AG2.equals(AG3));
	}
	@Test
	public void equalsTest6() {
		AutoGuma AG2 = new AutoGuma(null, true, 18, 180, 40);
		AutoGuma AG3 = new AutoGuma("Michelin", true, 18, 180, 40);
		assertFalse(AG2.equals(AG3));
	}
	@Test
	public void equalsTest7() {
		AutoGuma AG2 = new AutoGuma("Michelin", true, 19, 180, 40);
		assertFalse(AG.equals(AG2));
	}
	@Test
	public void equalsTest8() {
		AutoGuma AG2 = new AutoGuma("Michelin", true, 18, 185, 40);
		assertFalse(AG.equals(AG2));
	}
	@Test
	public void equalsTest9() {
		AutoGuma AG2 = new AutoGuma("Michelin", true, 18, 180, 35);
		assertFalse(AG.equals(AG2));
	}
}
