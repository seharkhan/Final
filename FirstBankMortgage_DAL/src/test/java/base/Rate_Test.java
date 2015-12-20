package base;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import domain.RateDomainModel;

public class Rate_Test {
	private static ArrayList<RateDomainModel> r1;
	
	@Test
	public void getRateTest() {
		double rate1 = RateDAL.getRate(600);
		assertTrue(rate1 == 5);
		
		double rate2 = RateDAL.getRate(650);
		assertTrue(rate2 == 4.5);
		
		double rate3 = RateDAL.getRate(700);
		assertTrue(rate3 == 4);
		
		double rate4 = RateDAL.getRate(750);
		assertTrue(rate4 == 3.75);
		
		double rate5 = RateDAL.getRate(800);
		assertTrue(rate5 == 3.5);
		

	}
	
	@Test
	public void getRatesTest() {

		r1 = RateDAL.getRates();
		
		assertTrue(r1.size() > 0);
	}
		

}
