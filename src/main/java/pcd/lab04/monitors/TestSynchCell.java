package pcd.lab04.monitors;

public class TestSynchCell {
		
	public static void main(String args[]){
		
		SynchCell cell = new SynchCell(); // Questo oggetto rappresenta la risorsa condivisa,
		// accessibile a tutti i thread (i tre Getter e il Setter)
		new Getter(cell).start(); // ogni istanza rappresenta un thread separato
		new Getter(cell).start(); // a ogni Getter viene passato come parametro la stessa
		// istanza di SynchCell. Qesto significa che tutti i thread Getter condivideranno
		// la stessa risorsa
		new Getter(cell).start();
		
		try {
			Thread.sleep(2000); // il thread principale esegue questa istruzione.
			// Il thread principale (quello che esegue il metodo main()) si mette quindi
			// in uno stato di attesa per 2 secondi.
		} catch (Exception ex){}
		new Setter(cell,303).start();
	}
}

/* Possibili sequenza di Output:
1) Sequenza in cui il Setter completa prima:
[getter] before getting
[getter] before getting
[getter] before getting
[setter] before setting
[setter] after setting
[getter] got value:303
[getter] got value:303
[getter] got value:303

2) Sequenza in cui i Getter leggono prima:
[getter] before getting
[getter] before getting
[getter] before getting
[setter] before setting
[getter] got value:303
[getter] got value:303
[getter] got value:303
[setter] after setting

3)
Sequenza mista (dipendente dall'interleaving):
[getter] before getting
[getter] before getting
[getter] before getting
[setter] before setting
[getter] got value:303
[setter] after setting
[getter] got value:303
[getter] got value:303

*/
