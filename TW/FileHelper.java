/* Loïc Boyeldieu - 2015 */
/* This file enables us to read a file line by line and to stock every line in a List */
/* Then we will use that to convert the data */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileHelper {


	/* This function read a file and returns the list of the lines of the file*/
	/* Then we will not work on the file anymore */
	public static List<String> readFile(File file) {
		
		
		if (file == null) {
			throw new IllegalArgumentException("Error : Your file cannot be null");
		}

		if (!file.exists()) {
			throw new IllegalArgumentException("The file " + file.getName() + " does not exist");
		}
		
		/* This will be our List containing the lines of the file */
		List<String> result = new ArrayList<String>();
		
		
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			/* Each time we read a line, we add it to our list of line */
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
	
	
	/* Function to write the final datas in the output file */
	public static void writeFile(InfosFromData I, String nameOutputFile){
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {

			fw = new FileWriter(nameOutputFile, false);
			bw = new BufferedWriter(fw);
			
			bw.write(I.getLowerYear() + "," + I.getNbOfDevelopmentYear()+"\n");
			for (TriangleMatrix m : I.getMatrixList()){	
				bw.write(m.transformMatrixToString(m.getMatrix())+"\n");
			}	

			bw.flush();
			System.out.println("File created");
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	
	}	
	
	
	/* This function can be used if you want to display the list */
	public static void displayList(List<String> L){
		int i=0;
		for (i=0; i<L.size();i++){
			System.out.println(i + " " + L.get(i));	
		}	
	} 
	
	

}
