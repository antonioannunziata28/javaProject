package it.betacom.main;

public class ContoCorrente {

	private Correntista correntista;
	private double saldoOperativo;
	private double importoOperazione;
	
	
	
	
	
	public ContoCorrente(Correntista correntista) {
		
		this.correntista = correntista;
		this.saldoOperativo = saldoCorrentista(correntista);
		this.importoOperazione = importoOperazione;
		
		
	}

	
	
	private double saldoCorrentista(Correntista correntista) {
		
		saldoOperativo += correntista.getBonus();
		
		return saldoOperativo;
	}
	
	public double getSaldo() {
		
		return saldoOperativo;
	}
	
	public double prelievo(double importoOperazione) {
		
		if(importoOperazione > 0 && importoOperazione <= saldoOperativo) {
			saldoOperativo -= importoOperazione;
			System.out.println("Grazie " + correntista.name + " hai prelevato €" + importoOperazione);
			System.out.println("Ora il tuo saldo ammonta a €" + saldoOperativo);
		}else {
			System.out.println("Ci dispiace ma non disponi dei fondi sufficienti per effettuare questa operazione");
		}
		
		return saldoOperativo;
	}
	
	
	
	public void versamento(double importoOperazione) {
		if(importoOperazione > 0) {
			this.saldoOperativo += importoOperazione;
			System.out.println("Grazie " + correntista.name + " hai versato €" + importoOperazione);
			System.out.println("Ora il tuo saldo ammonta a €" + saldoOperativo);
		}else {
			System.out.println("Ci dispiace ma la somma indicata non è valida. Operazione non consentita!");
		}
		
	}

}


