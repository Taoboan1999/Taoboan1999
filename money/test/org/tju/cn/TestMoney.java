package org.tju.cn;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import org.tju.cn.Money;

@RunWith(Parameterized.class)
public class TestMoney {

	private Money mon;
	private int a;
	private String expected;

	public TestMoney(int a , String expected){
		this.a = a;
		this.expected = expected;
	}
	
	@Before
	public void setUp(){
		mon = new Money();
	}

	@Parameters
    public static Collection<Object[]> getData(){
    	return Arrays.asList(new Object[][]{
    		{-1,"Not existed"},//NOT EXISTED
    		{0,"Coincident"},//Specify 0 as the default
    		{3,"Coincident"},//3 one yuan coins
    		{4,"Not Coincident"},//Failure
    		{8,"Coincident"},//3 one yuan coins and 1 five yuan bill
    		{9,"Not Coincident"},//Failure
    		{13,"Coincident"},//3 one yuan coins and 2 five yuan bills
    		{14,"Not Coincident"},//Failure
    		{23,"Coincident"},//3 one yuan coins and 1 ten yuan£¬ 2 five yuan bills
    		{24,"Not Coincident"},//Failure
    		{43,"Coincident"},//3 one yuan coins and 1 twenty yuan£¬1 ten yuan£¬ 2 five yuan bills
    		{44,"Not Coincident"},//Failure
    		{93,"Coincident"},//3 one yuan coins and 1 50 yuan£¬1 twenty yuan£¬1 ten yuan£¬ 2 five yuan bills
    		});
    }

	@Test
	public void test() {
		assertEquals(this.expected,mon.IsCoincident(a));
	}

}
