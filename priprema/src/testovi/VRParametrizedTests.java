package testovi;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ VulkanizerskaRadnjaDodajGumuParametrizedTest.class,
		VulkanizerskaRadnjaPronadjiGumuParazmetrizedTest.class })
public class VRParametrizedTests {

}
