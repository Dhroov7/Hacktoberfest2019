import java.util.Scanner;

public class Calculadora {
	
	public static double Soma(double x, double y) {
        	return x + y;
	}

	public static double Subtracao(double x, double y) {
		return x - y;
	}

	public static double Multiplicacao(double x, double y) {
		return x * y;
	}

	public static double Divisao(double x, double y) {
		return x / y;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 
		String operacao = input.next();
		
		if (operacao.equals("+")) {
        		double num1 = input.nextDouble();
			double num2 = input.nextDouble();
        		System.out.println("RESULTADO: " + Soma(num1, num2));
    		
		} else if (operacao.equals("-")) {
        		double num1 = input.nextDouble();
			double num2 = input.nextDouble();
        		System.out.println("RESULTADO: " + Subtracao(num1, num2));
    		
		} else if (operacao.equals("*")) {
        		double num1 = input.nextDouble();
			double num2 = input.nextDouble();
        		System.out.println("RESULTADO: " + Multiplicacao(num1, num2));
    		
		} else if (operacao.equals("/")) {
        		double num1 = input.nextDouble();
			double num2 = input.nextDouble();
			if (num2 == 0) {
          			System.out.println("ERRO");
        		} else {
          			System.out.println("RESULTADO: " + Divisao(num1, num2));
        }

    		} else {
      			System.out.println("ENTRADA INVALIDA");
    		}
	}
}
