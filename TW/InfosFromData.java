import java.util.List;
import java.util.ArrayList;
import java.io.File;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class InfosFromData{
	
	private List <DataType> dataList;
	private List <String> productList;
	private List <TriangleMatrix> matrixList;
	private Integer NbOfDevelopmentYear;
	private Integer lowerYear;
	private Integer higherYear;
	
	
	
	/********************************************************************/
    // GETTERS //
    /********************************************************************/
    
    public List<DataType> getDataList(){
    	return this.dataList;	
    }
    
    public List<String> getProductList(){
    	return this.productList;	
    }
    
    public Integer getNbOfDevelopmentYear(){
    	return this.NbOfDevelopmentYear;	
    }
    
    public Integer getLowerYear(){
    	return this.lowerYear;	
    }
    
    public Integer getHigherYear(){
    	return this.higherYear;	
    }
    
    public List <TriangleMatrix> getMatrixList(){
    	return this.matrixList;	
    }
    
        
    
    /********************************************************************/
    // SETTERS //
    /********************************************************************/
	
	
	public void setDataList(List<DataType> L){
		this.dataList = L;	
	}
	
	public void setProductList(List<String> L){
		this.productList = L;	
	}
	
	public void setNbOfDevelopmentYear(Integer y){
		this.NbOfDevelopmentYear = y;
	}
	
	public void setLowerYear(Integer y){
		this.lowerYear = y;
	}
	
	public void setHigherYear(Integer y){
		this.higherYear = y;
	}
	
	public void setMatrixList(List <TriangleMatrix> tm){
		this.matrixList = tm;	
	}
	
	
	
	
	public InfosFromData(DataDao D, List <TriangleMatrix> m){
		this.dataList = D.getAllDatas();
		this.productList = findDifferentProject();
		this.lowerYear = findLowerYear();
		this.higherYear = findHigherYear();
		this.NbOfDevelopmentYear = (this.higherYear - this.lowerYear) + 1;
		this.matrixList = m;
	}
	
	
	public List<String> findDifferentProject(){
		List<String> L = new ArrayList<String>();
		for (DataType d : getDataList()){
			if (L.contains(d.getProduct())){
			}
			else{
				L.add(d.getProduct());
			}	
		}	
		return L;
	}
	
	
	public Integer findLowerYear(){
		Integer y = Integer.MAX_VALUE;
		for (DataType d : getDataList()){
			if (d.getOriginYear()<y){
				y = d.getOriginYear();	
			}	
		}
		return y;	
	} 
	
	public Integer findHigherYear(){
		Integer y = Integer.MIN_VALUE;
		for (DataType d : getDataList()){
			if (d.getOriginYear()>y){
				y = d.getOriginYear();	
			}	
			if (d.getDevelopmentYear()>y){
				y = d.getDevelopmentYear();
			}
		}
		return y;		
	}
	
	
	public void diplayListProduct(){
		for (String s : getProductList()){
			System.out.println(s);
		}	
	}
	
	
	
	public void fillAllMatrix(){	
		
		for (String s : getProductList()){
			
			TriangleMatrix tm = new TriangleMatrix(getNbOfDevelopmentYear(), getLowerYear(), s);
			/* Full the matrix using the datas */
			for (DataType d : getDataList()){
				if (d.getProduct().equals(s)){
					tm.setMatrix(tm.addValueInMatrix(tm.getMatrix(), d.getOriginYear()-getLowerYear(), d.getDevelopmentYear()-d.getOriginYear(), d.getIncrementalValue()));	
				}	
			}	
			matrixList.add(tm);
		}
			
	}
	
	
	public void transformMatrix(){
		for (TriangleMatrix tm : getMatrixList()){
			tm.cumulativeMatrix(tm.getMatrix());	
		}	
	}
	
	public void displayAllMatrix(){
		for (TriangleMatrix m : matrixList){
			m.displayMatrix(m.getMatrix());	
			System.out.println(m.transformMatrixToString(m.getMatrix()));
		}	
		
	}
	
	public void finalMatrixToString(){
		
		for (TriangleMatrix m : matrixList){	
			System.out.println(m.transformMatrixToString(m.getMatrix()));
		}	
		
	}
	
	
	public void writeFile(){
		try {

			FileWriter fileWriter = new FileWriter("out.cvs", false);

			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(getLowerYear() + "," + getNbOfDevelopmentYear()+"\n");
			for (TriangleMatrix m : matrixList){	
				bufferedWriter.write(m.transformMatrixToString(m.getMatrix())+"\n");
			}	

			bufferedWriter.flush();
			bufferedWriter.close();
			System.out.println("Fichier créé");
		} catch (IOException ioe) {
			System.err
					.println("Erreur levée de type IOException au niveau de la méthode "
							+ "writeFile(...) : ");
			ioe.printStackTrace();
		}
	
	}
	
	public static void main(String[] args){
		File F = new File("in.csv");
		DataDao DD = new DataDao(F);
		List <TriangleMatrix> mList = new ArrayList<TriangleMatrix>();
		InfosFromData IFD = new InfosFromData(DD, mList);
			
		IFD.diplayListProduct();
		
		System.out.println("Lower Year : " + IFD.getLowerYear());
		System.out.println("Higher Year : " + IFD.getHigherYear());
		System.out.println("Nb Development Year : " + IFD.getNbOfDevelopmentYear());
		
		IFD.fillAllMatrix();
		//IFD.displayAllMatrix();
		IFD.transformMatrix();
		IFD.writeFile();
		
		
		
	}
	
	
}