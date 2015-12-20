package ch.makery.address.model;

import org.apache.poi.ss.formula.functions.FinanceLib;

import base.RateDAL;
import ch.makery.address.view.MortgageController;
import domain.RateDomainModel;

public class Rate extends RateDomainModel {
	


	public static double getPayment(int NumberOfPayments) {
		int NumberofPeriods = 0;
		double PresentValue = 0.0;
		double FutureValue = 0.0;
		boolean Type = false; 
		
		double InterestRate = (RateDAL.getRate(MortgageController.CreditScore))/12;
		double payment = FinanceLib.pmt(InterestRate,NumberofPeriods, PresentValue, FutureValue, Type);
				
		
		return payment;
		
	}

	
	
	
}
