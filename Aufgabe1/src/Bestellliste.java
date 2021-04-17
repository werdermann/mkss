import java.util.ArrayList;

public class Bestellliste {
	private ArrayList<IProdukt> produkte = new ArrayList<>();

	private IProduktFactory[] produktFactories;

	public void setProduktFactories(IProduktFactory[] produktFactories) {
		this.produktFactories = produktFactories;
	}

	public void menuloop() {
		int eingabe;
		do {
			System.out.println("Was wollen Sie machen?");
			System.out.println("(0) Bestellung beenden");

			int counter = 1;

			for(IProduktFactory factory: produktFactories) {
				System.out.println("(" + counter + ") " + factory.getName() + " bestellen");
				counter++;
			}

			eingabe = Eingabe.leseInt();

			if(eingabe == 0) {
				break;
			} else {
				int eingabeWert = 1;
				for(IProduktFactory factory: produktFactories) {
					if(eingabe == eingabeWert) {
						IProdukt neuesProdukt = factory.createIProdukt();
						produkte.add(neuesProdukt);
					}
					eingabeWert++;
				}
				if(eingabe > produktFactories.length) {
					System.out.println("ung�ltig" );
					break ;
				}
			}
		} while(eingabe != 0);
		bestellungSortieren() ;
		bestellungBeenden() ;
	}
	
	private void bestellungSortieren() {
		for(int i = 0; i<produkte.size()-1; i++) {
			for(int j = 0; j<produkte.size()-1; j++) {
				if( produkte.get(j + 1) != null &&
					produkte.get(j + 1).gibPreis ()< produkte.get(j).gibPreis()) {
					IProdukt temp = produkte.get(j + 1);
					produkte.set(j + 1, produkte.get(j));
					produkte.set(j, temp);
				}
			}
		}
	}

	private void bestellungBeenden() {
		int sum = 0;
		for (IProdukt produkt : produkte) {
			System.out.print(produkt.ausgeben() + " = ");
			System.out.println(preisAufbereiten(produkt.gibPreis()));
			sum += produkt.gibPreis();
		}
		System.out.println("Gesamtsumme: "+preisAufbereiten(sum));
	}

	private String preisAufbereiten(int preisInCent) {
		return (preisInCent / 100) + "." + (preisInCent % 100 < 10 ? "0" : "")
			+ preisInCent % 100 + " EUR";
	}
}
	