package cn.com.sky.spi;

/**
 * spi机制
 */
public class TestSpi {

	public static void main(String[] args) {

		Spi spi = SpiFactory.getSpi("SPIA");
		System.out.println(spi.sayHello());

//		Spi spiB = SpiFactory.getSpi("SPIB");
//		System.out.println(spiB.sayHello());
	}

}
