package org.tju.cn;
public class Money {
	
	public static String IsCoincident(int money) {
		
		int temp = 0;
		
		if(money >= 0) {
			
			int money_div_50 = money / 50;
			money = money % 50;
			int money_div_20 = money / 20;
			money = money % 20;
			int money_div_10 = money / 10;
			money = money % 10;
			int money_div_5 = money / 5;
			money = money % 5;
			int money_div_1 = money / 1;
			
			if(money_div_50 < 2 && money_div_20 < 2 && money_div_10 < 2 && money_div_5 < 3 && money_div_1 < 4) {
				
				temp = 1;
				
			}
			else {
				
				temp = 0;
				
			}
			
		}
		else {
			
			temp = -1;
			
		}
		
		if(temp == 1) {
			return "Coincident";
		}
		else if(temp == 0){
			return "Not Coincident";
		}
		else {
			return "Not existed";
		}
		
	}
	
}
