package testovi;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import gume.AutoGuma;
import gume.VulkanizerskaRadnja;
@RunWith(Parameterized.class)
public class VulkanizerskaRadnjaPronadjiGumuParazmetrizedTest {
	private AutoGuma AG;
	private VulkanizerskaRadnja VR;
	@BeforeClass
	public static void ProveriOperativniSistem() {
		Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	}
	@Rule
	public final TestRule timeout = Timeout.seconds(5);
	public VulkanizerskaRadnjaPronadjiGumuParazmetrizedTest(AutoGuma AG) {
		this.AG = AG;
	}
	@Parameters
	public static Collection<Object[]> gume() {
		return Arrays.asList(new Object[][] {
			{new AutoGuma("Michelin", true, 18, 180, 40)},
			{new AutoGuma("Michelin", true, 18, 185, 45)},
			{new AutoGuma("Michelin", true, 18, 190, 40)},
			{new AutoGuma("Michelin", false, 19,170, 30)}
		});
	}
	@Before
	public void init() {
		VR = new VulkanizerskaRadnja();
	}
	@Test
	public void dodajGumuTest() {
		String marka = null;
		assertNull(VR.pronadjiGumu(marka));
	}
	@Test
	public void dodajGumuTest2() {
		assertFalse(VR.gume.contains(AG));
		VR.dodajGumu(AG);
		LinkedList<AutoGuma> gume = new LinkedList<AutoGuma>();
		gume.add(AG);
		assertEquals(gume, VR.pronadjiGumu("Michelin"));
	}
	@Test
	public void dodajGumuTest3() {
		assertFalse(VR.gume.contains(AG));
		VR.dodajGumu(AG);
		LinkedList<AutoGuma> gumes = new LinkedList<AutoGuma>();
		gumes.add(AG);
		assertNotEquals(gumes, VR.pronadjiGumu("Pireli - NotExistingModel"));
	}
	@After
	public void destroy() {
		VR = null;
	}

}
