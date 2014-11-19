public class RSA {
	// Last 3 decryptions are: SYDE, DATA, UW	
	
	public static void main(String[] args) {

		int n = 329467;
		int p = 0;
		int q = 0;
		int d = 0;
		int e = 17;
		
		//Brute force to find p and q
		for(p = 1; p <= 998; p++){
			for (q = 1; q<= 999; q++){
				if(p * q == n && isPrime(p) && isPrime(q)){
					System.out.println("p is " + p + " and q is " + q);
					break;
				}
			}
			
			if(p * q == n && isPrime(p) && isPrime(q)){
				break;
			}
		}
		
		int phi = (571 - 1) * (577 - 1);
		
		//Brute force to find d
		for (d = 1; d <= 99999; d++){
			if ((d * e) % phi == 1){
				System.out.println("d is "  + d);
				break;
			}
		}
		
		//Decrypt
		decrypt(193024, d, n);
		decrypt(60175, d, n);
		decrypt(23168, d, n);
		decrypt(242798, d, n);
		decrypt(41304, d, n);
		decrypt(65142, d, n);
	}
	
	static boolean isPrime(int n) {
	    if (n%2==0){
	    	return false;
	    }
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	
	public static void decrypt(int encrypted, int privateKey, int n) {
		long decrypted = encrypted % n;
		for(int i=1; i<privateKey; i++){
			decrypted = (decrypted * encrypted) % n;
		}
		System.out.println("Encryption: " + encrypted + " & Decryption: " + decrypted);
	}
}