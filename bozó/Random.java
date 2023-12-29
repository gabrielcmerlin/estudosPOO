
/*
Feito pelos alunos:
Gabriel da Costa Merlin 12544420
Mateus Bernal Leffeck 13673318
*/
package com.mycompany.bozo;

// @author delamaro
import java.util.Calendar;

public class Random {
	private long p = 2147483648L;
	private long m = 843314861;
	private long a = 453816693;
	
	
	private long xi = 1023;


	public double getRand() {
		xi = (a + m * xi) % p;
		double d = xi;
		//System.out.println(d + " " + xi + " " + d / p);
		return d / p;
	}
	
	public int getIntRand(int max)
	{
		double d = getRand() * max;
		return (int) d;
	}

	public void setSemente(int semente) {
       xi = semente;		
	}

	public Random(int k)
	{
		xi = k;
	}
	
	public Random() {
		xi = Calendar.getInstance().getTimeInMillis() % p;
	}
	
	@Override
	public String toString() {
		return xi + "";
	}
	
	static public void main(String args[]) {
		Random rd = new Random(5);
		Random rd2 = new Random();
		String s = rd.toString();
		//System.out.println(rd);
		//System.out.println(rd2);
		//int k = rd.getIntRand(100);
		//System.out.println(rd);
		for (int i = 0; i < 10; i++)
			System.out.println(rd.getRand() + " ");

	}
}
