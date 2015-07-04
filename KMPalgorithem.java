public class KMPalgorithem {

	public static void main(String[] args) {
		String txt = "ABABDABACDABABCABAB", pat = "ABABCABAB";
		int m = pat.length();
		int[] lps = new int[m];
		generateLPS(lps,pat);
		SearchPat(txt, pat, lps);
	}
	private static void SearchPat(String txt, String pat, int[] lps) {
		if (txt != null && txt != "" && pat != null) {
			if (pat != "" && txt.length() >= pat.length()) {
				for (int i = 0, j = 0; i < txt.length(); i++) {
					if (txt.charAt(i) == pat.charAt(j)) {
						j++;
						if (j == pat.length()) {
							System.out.println("Pattern '"+pat+ "' matched at index "
									+ (i - j + 1));
							while (j != 0) {
								j = lps[j - 1];
								if (txt.charAt(i) == pat.charAt(j)) {
									j++;
									break;
								}
							}
						}
					} else {
						while (j != 0) {
							j = lps[j - 1];
							if (txt.charAt(i) == pat.charAt(j)) {
								j++;
								break;
							}
						}

					}

				}
			}

		}
	}
	private static void generateLPS(int[] lps, String pat) {
		if (pat != null && pat != "" && pat.length() > 1) {
			int j = 0;
			int i = 1;
			while (i < pat.length()) {
				if (pat.charAt(i) == pat.charAt(j)) {
					lps[i++] = ++j;
				} else {
					j = 0;
					i++;
				}
			}
		}
	}
}
