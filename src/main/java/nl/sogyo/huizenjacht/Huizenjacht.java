package nl.sogyo.huizenjacht;

public class Huizenjacht {
	private static final int MAX_AANTAL_GEWENSTE_OPLOSSINGEN = 20;

	public static void main(String[] args) {
		int oplossing = 0;
		
		long huisnummer = 1;
		while (oplossing < MAX_AANTAL_GEWENSTE_OPLOSSINGEN) {
			double laatstHuisnummer = (-1 + Math.sqrt(1 + 8 * huisnummer
					* huisnummer)) / 2;

			if (Math.floor(laatstHuisnummer) == laatstHuisnummer) {
				oplossing++;
				System.out.println(String.format("%d: %d %d", oplossing, huisnummer,
						(long) Math.floor(laatstHuisnummer)));
			}
			
			huisnummer++;
		}
	}
}
