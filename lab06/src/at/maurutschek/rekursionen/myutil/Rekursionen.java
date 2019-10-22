package at.maurutschek.rekursionen.myutil;

import java.io.File;

/**
 * 
 * @author spamm
 *
 */
public class Rekursionen {

	/**
	 * 
	 * @param dir
	 * @param tabs
	 */
	public void listFiles(File dir, String tabs) {
		if (!dir.exists())
			return;
		System.out.println(tabs + dir.getName());
		if (dir.isDirectory()) {
			tabs += "\t";
			for (File f : dir.listFiles())
				listFiles(f, tabs);
		}
	}

	/**
	 * 
	 * @param dir
	 * @return
	 */
	public long getGroesse(File dir) {
		return getGroesse(dir, 0);
	}

	/**
	 * 
	 * @param dir
	 * @param groesse
	 * @return
	 */
	public long getGroesse(File dir, long groesse) {
		if (dir.isFile())
			return dir.length();
		if (dir.isDirectory()) {
			for (File f : dir.listFiles())
				groesse += getGroesse(f, groesse);
			return groesse;
		}
		return 0;
	}

	/**
	 * 
	 * @param a
	 * @param s
	 * @return
	 */
	public boolean binSuche(int[] a, int s) {
		return binSuche(0, a.length, a, s);
	}

	/**
	 * 
	 * @param l
	 * @param r
	 * @param ar
	 * @param s
	 * @return
	 */
	public boolean binSuche(int l, int r, int[] ar, int s) {
		if (ar[(r + l) / 2] == s) {
			System.out.println(s + " Gefunden an Stelle: " + (r + l) / 2);
			return true;
		}
		if (r - l == 1) {
			System.out.println(s + " nicht gefunden!");
			return false;
		}
		if (s > ar[(r + l) / 2])
			return binSuche((r + l) / 2, r, ar, s);
		if (s < ar[(r + l) / 2])
			return binSuche(l, (r + l) / 2, ar, s);
		return false;
	}
}
