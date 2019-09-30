class CatalanNumber{

	static int getCatalan(int n) { 
		// Table to store results of subproblems 
		int ctln[] = new int[n + 2]; 

		// Initialize first two values in table 
		ctln[0] = 1; 
		ctln[1] = 1; 

		// Fill entries in ctln[], in recursive method 
		for (int i = 2; i <= n; i++) { 
			ctln[i] = 0; 
			for (int j = 0; j < i; j++) { 
				ctln[i] += ctln[j] * ctln[i - j - 1]; 
			} 
		} 

		// Returns last entry 
		return ctln[n]; 
	} 
 
	public static void main(String[] args) { 
		for (int i = 0; i < 10; i++) { 
			System.out.print(getCatalan(i) + " "); 
		} 
	} 
}
