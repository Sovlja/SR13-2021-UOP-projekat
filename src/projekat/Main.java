package projekat;

import Swing.prijavaSwing;
import Swing.registracijaSwing;

public class Main {
	public static void main(String[] args) {
			
		Biblioteka biblioteka = new Biblioteka();
		
		if (biblioteka.dobaviNeobrisaneAdmine().isEmpty()) {
			registracijaSwing.main(null);
		}
		else {
			prijavaSwing.main(null);			
		}
	}
}
