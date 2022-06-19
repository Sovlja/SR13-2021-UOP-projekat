package projekat;

public class mainKlasa {

	public static void main(String[] args) {
		
		Biblioteka biblioteka = new Biblioteka();
		System.out.println("TEST ADMIN:");
		biblioteka.ucitajAdministratore();
		System.out.println(biblioteka.getAdmini());
		
		
		System.out.println("");
		System.out.println("TEST BIBLIOTEKAR:");
		biblioteka.ucitajBibliotekare();
		System.out.println(biblioteka.getBibliotekari());
		
		
		System.out.println("");
		System.out.println("TEST ŽANR:");
		biblioteka.učitajŽanrove();
		System.out.println(biblioteka.getŽanrKnjige());
		
		System.out.println("");
		System.out.println("TEST TIP ČLANARINE:");
		biblioteka.učitajTipČlanarine();
		System.out.println(biblioteka.getTipČlanarine());
		
		System.out.println("");
		System.out.println("TEST KNJIGE:");
		biblioteka.učitajKnjige();
		System.out.println(biblioteka.getKnjige());
		
		System.out.println("");
		System.out.println("TEST PRIMERAK KNJIGE:");
		biblioteka.učitajPrimerkeKnjiga();
		System.out.println(biblioteka.getPrimerakKnjige());
		
		System.out.println("");
		System.out.println("TEST ČLAN:");
		biblioteka.učitajČlanove();
		System.out.println(biblioteka.getČlanovi());
		
		System.out.println("");
		System.out.println("TEST IZNAJMLJIVANJE:");
		biblioteka.učitajIznajmljivanje();
		System.out.println(biblioteka.getIznajmljivanje());
	}
}
