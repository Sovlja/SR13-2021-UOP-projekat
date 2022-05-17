package projekat;

public class mainKlasa {

	public static void main(String[] args) {
		Biblioteka biblioteka = new Biblioteka();
		biblioteka.ucitajAdministratore();
		biblioteka.ucitajBibliotekare();
		System.out.println(biblioteka.getBibliotekari());
		System.out.println(biblioteka.getAdmini());
		biblioteka.upisiAdministratore();
		biblioteka.upisiBibliotekare();
		biblioteka.upisiBibliotekare();
		
	}

}
