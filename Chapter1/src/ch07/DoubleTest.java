package ch07;

public class DoubleTest {

	public static void main(String[] args) {
		double dNum = 3.14;
		float fNum = 3.14f;
		
		double dnum = 1;
		
		for(int i = 0; i<10000; i++) {
			dnum = dnum + 0.1;
		}
		System.out.println(dnum);
	}

}
