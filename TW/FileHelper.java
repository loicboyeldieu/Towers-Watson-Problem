import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {

	public static List<String> readFile(File file) {

		if (file == null) {
			throw new IllegalArgumentException("Error : Your file cannot be null");
		}

		if (!file.exists()) {
			throw new IllegalArgumentException("The file " + file.getName() + " does not exist");
		}

		List<String> result = new ArrayList<String>();

		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			for (String line = br.readLine(); line != null; line = br.readLine()) {
				result.add(line);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		return result;
	}
	
	
	public static void printList(List<String> L){
		int i=0;
		for (i=0; i<L.size();i++){
			System.out.println(i + " " + L.get(i));	
		}	
	} 
	

	public static void main(String[] args){
		File twfile = new File("in.csv");
		List<String> L = new ArrayList<String>();
		L = readFile(twfile);
		printList(L);
	}
	

	

	

}
