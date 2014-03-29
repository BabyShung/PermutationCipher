public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileOperation op = new FileOperation();
		PermutationCipher pc = new PermutationCipher();

		final String key = "14523";// the key is from cryptanalysis

		// read from plaintext1.txt
		String ciphertext = op.readFile("permutation_sp.txt");
		String plaintext = pc.decrypt(ciphertext, key);

		System.out.println("ciphertext is : " + ciphertext);
		System.out.println("plaintext is : " + plaintext);

		// write the decrypttext into decrypttext1.txt
		op.writeFile("permutation_sp_decrypt.txt", plaintext);

	}

}
