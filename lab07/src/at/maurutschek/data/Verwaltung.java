package at.maurutschek.data;

public class Verwaltung {

	private GeschaeftListKnoten root;
	
	public static void main(String[] args) {
		Verwaltung v = new Verwaltung();
		v.addGeschaeft(new BioLaden(" ", false, 1, 1));
		v.ausgeben();
		System.out.println();
	}

	
	public void addGeschaeft(Geschaeft g) {
		if(this.root == null) {
			this.root = new GeschaeftListKnoten(g);
			return;
		}
		GeschaeftListKnoten glk = this.root;
		while(glk.getNext() != null) {
			glk = glk.getNext();
		}
		
		glk.setNext(new GeschaeftListKnoten(g));
	}
	
	public int summeFoerderungen() {
		return (int) summeFoerderungen(this.root, 0);
	}
	
	private float summeFoerderungen(GeschaeftListKnoten glk, float ges) {
		if(glk.getNext() == null)
			return glk.getGeschaeft().getFoerderung();
		ges += glk.getGeschaeft().getFoerderung();
		return summeFoerderungen(this.root.getNext(), ges);
	}
	
	public void ausgeben() {
		
		ausgeben(this.root);
	}
	
	private void ausgeben(GeschaeftListKnoten glk) {
		glk.getGeschaeft().ausgeben();
		if(glk.getNext() == null)
			return;
		ausgeben(glk.getNext());
	}
	
}
