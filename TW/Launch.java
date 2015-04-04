/* Loïc Boyeldieu - 2015 */
/* Here you can change the names of the input file or outputfile */

import java.util.List;
import java.util.ArrayList;
import java.io.File;

public class Launch{
	
	public static void main(String[] args){
		
		File F = new File("in.csv");
		DataDao DD = new DataDao(F);
		
		List <TriangleMatrix> mList = new ArrayList<TriangleMatrix>();
		InfosFromData IFD = new InfosFromData(DD,  mList);	
		
		IFD.constructAllMatrix();
		IFD.transformMatrix();
		
		FileHelper.writeFile(IFD, "out.csv");
		
	}	
	
	
	
	
	
}