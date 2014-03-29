import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperation {

	public String readFile(String filename) {
		String everything = "";
		try {
			BufferedReader br = new BufferedReader(
					new FileReader("src/Texts/"+ filename));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append('\n');
				line = br.readLine();
			}
			everything = sb.toString();
			br.close();

		} catch (Exception e) {
			return "file not exists";
		}
		return everything;
	}

	public void writeFile(String filename,String str) {
		try {
			File file = new File("src/Texts/"+ filename);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// true = append file
			FileWriter fileWritter = new FileWriter("src/Texts/" + file.getName(),
					false);

			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write(str);
			bufferWritter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
