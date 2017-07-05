package spring.aop.helloworld;

public class Main {

	public static void main(String[] args) {
		
//		ArithmeticCalculator atithmeticCalculator = null;
//		atithmeticCalculator = new ArithmeticCalculatorLoggingImpl();
		
		ArithmeticCalculator target = new ArithmeticCalculatorImpl(); 
		ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
		
		System.out.println(proxy.getClass());
		int result = proxy.add(1, 2);
		System.out.println("-->"+result);
		
		result = proxy.div(4, 2);
		System.out.println("-->"+result);
	}

}
