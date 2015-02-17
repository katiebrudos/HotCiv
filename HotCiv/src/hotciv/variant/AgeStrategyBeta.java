package hotciv.variant;

import hotciv.framework.AgeStrategy;

public class AgeStrategyBeta implements AgeStrategy{

public AgeStrategyBeta(){}; 

	@Override
	public int incrementAge(int age) {
		if(age >= -4000 && age < -100) {
			return 100;
		} 
		else if(age == -100) {
			return 99; 
		}
		else if(age == -1) {
			return 2; 
		}
		else if(age == 1) {
			return 49; 
		}
		else if(age >= 50 && age < 1750) {
			return 50; 
		}
		else if(age >= 1750 && age < 1900) {
			return 25;  
		}
		else if(age >= 1900 && age < 1970) {
			return 5; 
		}
		else{
			return 1; 
		}
	}
}
