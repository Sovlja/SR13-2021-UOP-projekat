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
		System.out.println("TEST ČLAN:");
		biblioteka.učitajČlanove();
		System.out.println(biblioteka.getČlanovi());
		
		
		
	}

}
