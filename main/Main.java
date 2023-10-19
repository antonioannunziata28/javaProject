package it.betacom.main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Benvenuto!");
		System.out.println(" ");
		System.out.println("Inserisci il tuo nome utente");
		String name = scanner.nextLine();
		
		
		System.out.println("Ora inserisci la tua data di nascita, così verifichiamo a quanto ammonta il tuo bonus di benvenuto");
		System.out.println("La data deve avere questo formato dd/MM/yyyy");
		
		while(true) {
		try {
			String since = scanner.nextLine();
			Correntista correntista = new Correntista(name, since);
			System.out.println("Ciao " + correntista.name + " il tuo bonus ammonta a €" + correntista.getBonus());
			
			ContoCorrente contoCorrente = new ContoCorrente(correntista);
			System.out.println(correntista.name + " il tuo saldo contabile ora ammonta a: €" + contoCorrente.getSaldo());
			while (true) {
				System.out.println("Se vuoi effettuare altre operazioni digita Si altrimenti digita No per terminare");
				String resolve = scanner.nextLine();
				
				if(resolve.equalsIgnoreCase("no")) {
					System.out.println("Grazie " + correntista.name + " torna presto a trovarci");
					break;
				}else if (resolve.equalsIgnoreCase("si")) {
					System.out.println("Vuoi effettuare un prelievo o un versamento? Scrivi prelievo o versamento");
					String resolveOperation = scanner.nextLine();
					
					if(resolveOperation.equals("prelievo")) {
						System.out.println("Inserisci l'importo desiderato");
						
						try {
							double importoOperazione = Double.parseDouble(scanner.nextLine());
							contoCorrente.prelievo(importoOperazione);
						} catch(Exception e) {
							System.out.println("Inserisci un valore numerico");
						}
						
						
					} else if(resolveOperation.equals("versamento")) {
						System.out.println("Inserisci l'importo desiderato");
						
						try {
							double importoOperazione = Double.parseDouble(scanner.nextLine());
							contoCorrente.versamento(importoOperazione);
						} catch(Exception e) {
							System.out.println("Inserisci un valore numerico");
						}
						
						
					} else {
						System.out.println("La tua scelta non è valida");
					}
				}else {
					System.out.println("Ci dispiace, la tua scelta non risulta valida. Ti preghiamo di riprovare");
				}
				
			}
		} catch(Exception e) {
			System.out.println("Inserisci una data valida");
		}
	}
}
}


