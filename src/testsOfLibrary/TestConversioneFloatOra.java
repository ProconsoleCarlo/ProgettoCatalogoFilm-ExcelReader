package testsOfLibrary;

public class TestConversioneFloatOra {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double durata = new Double(0.0778587962962963);
		double ore = durata*24;
		int oreInt = (int)ore;
		double minuti = (ore-oreInt)*60;
		int minutiInt = (int)minuti;
		int secondi = (int)((minuti-minutiInt)*60);
		System.err.println(oreInt+":"+minutiInt+":"+secondi);
	}

}
