package ch06;

import java.util.Arrays;
import java.util.function.BinaryOperator;

class CompareString implements BinaryOperator<String> {
	@Override
	public String apply(String s1, String s2) {
		if(s1.getBytes().length >= s2.getBytes().length) return s1;
		else return s2;
	}
}
public class ReduceTest {
	public static void main(String[] args) {
		int[] ints = {1,2,3,4,5};
		System.out.println(Arrays.stream(ints).reduce(2, (a,b)->(a+b)));
		
		String greetings[] = {"�ȳ��ϼ���", "Hello", "Good morning", "�ݰ����ϴ�"};
		
		System.out.println(Arrays.stream(greetings).reduce("", (s1, s2)->{
			if(s1.getBytes().length >= s2.getBytes().length) return s1;
			else return s2;
		})
		);
		
		String str = Arrays.stream(greetings).reduce(new CompareString()).get();
		System.out.println(str);
	}
}
