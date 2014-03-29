import java.util.ArrayList;
import java.util.HashMap;

/**
 * PermutationCipher decrypt method
 * 
 * INPUT: ciphertext, key
 * 
 * OUTPUT: plaintext
 * 
 * @author haozheng
 * 
 */

public class PermutationCipher {

	public String decrypt(String ct, String key) {

		HashMap<Integer, Integer> hm = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < key.length(); i++) {
			int index = key.charAt(i) - '0';
			hm.put(index, i);
		}

		ArrayList<Character> al = new ArrayList<>();
		ArrayList<Integer> sl = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < ct.length(); i++) {

			if (ct.charAt(i) != ' ') {
				al.add(ct.charAt(i));
				count++;
				if (count == 5) {

					for (int j = 0; j < 5; j++) {

						for (int k = 0; k < sl.size(); k++) {

							if (sl.get(k) == j) {
								sb.append(' ');
							}
						}
						sb.append(al.get(hm.get(j + 1)));

					}
					count = 0;
					al.clear();
					sl.clear();
				}
			} else {
				sl.add(count);
			}
		}

		return sb.toString();

	}

}
