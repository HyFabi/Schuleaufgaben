package at.maurutschek.rekursionen.liederbaum.data;

public class LiederBaum {
	LiederBaumKnoten root;

	public LiederBaum(Lied l) {
		this.root = new LiederBaumKnoten(l);
	}

	public LiederBaum() {
		this.root = null;
	}

	public boolean vorhanden(Lied l) throws Exception {
		if (l == null)
			throw new Exception();
		if (this.root == null)
			return false;
		return vorhanden(this.root, l);
	}

	private boolean vorhanden(LiederBaumKnoten lbk, Lied l) {
		if (lbk.getLied().equals(l))
			return true;
		if (lbk.getLinks() != null)
			return vorhanden(lbk.getLinks(), l);
		if (lbk.getRechts() != null)
			return vorhanden(lbk.getRechts(), l);
		return false;
	} 

	public boolean add(Lied l) throws Exception {
		if (l == null)
			throw new Exception();
		if (vorhanden(l))
			return false;
		if (this.root == null)
			this.root = new LiederBaumKnoten(l);
		return add(this.root, l);
	}

	private boolean add(LiederBaumKnoten lbk, Lied l) {
		if (lbk.getLied().getTitel().compareTo(l.getTitel()) > 0) {
			if (lbk.getLinks() != null)
				return add(lbk.getLinks(), l);
			lbk.setLinks(new LiederBaumKnoten(l));
			return true;
		}
		if (lbk.getLied().getTitel().compareTo(l.getTitel()) < 0) {
			if (lbk.getRechts() != null)
				return add(lbk.getRechts(), l);
			lbk.setRechts(new LiederBaumKnoten(l));
			return true;
		}
		return false;
	}

	public void ausgeben() throws Exception {
		if (this.root == null)
			throw new Exception();
		ausgeben(this.root);
	}

	private void ausgeben(LiederBaumKnoten lbk) {
		if (lbk.getLinks() != null)
			ausgeben(lbk.getLinks());
		if (lbk.getRechts() != null)
			ausgeben(lbk.getRechts());
		System.out.println(lbk.getLied().toString());
	}

	public long sumLiederLaenge() throws Exception {
		if (this.root == null)
			throw new Exception();
		return sumLiederLaenge(this.root, 0);
	}

	private long sumLiederLaenge(LiederBaumKnoten lbk, long x) {
		if (lbk.getLinks() != null)
			x = sumLiederLaenge(lbk.getLinks(), x);
		if (lbk.getRechts() != null)
			x = sumLiederLaenge(lbk.getRechts(), x);
		x += lbk.getLied().getLaenge();
		return x;
	}
}
