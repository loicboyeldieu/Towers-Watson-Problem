/* Loïc Boyeldieu - 2015 */
/* This file get all the datas necessary to construct the matrix */

import java.util.List;
import java.util.ArrayList;
import java.io.File;

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
	
	
	
	/********************************************************************/
    // CONSTRUCTORS //
    /********************************************************************/
	
	private InfosFromData(){
		
	}
	
	public InfosFromData(DataDao D, List <TriangleMatrix> m){
		this.dataList = D.getAllDatas();
		this.productList = findDifferentProject();
		this.lowerYear = findLowerYear();
		this.higherYear = findHigherYear();
		this.NbOfDevelopmentYear = (this.higherYear - this.lowerYear) + 1;
		this.matrixList = m;
	}
	
	
	/********************************************************************/
    // USEFULL FONCTIONS TO GET INFORMATION FROM DATAS //
    /********************************************************************/
	
	/* This function return the list of the different products */
	public List<String> findDifferentProject(){
		List<String> L = new ArrayList<String>();
		for (DataType d : getDataList()){
			/* If we have already add the product we do nothing */
			if (L.contains(d.getProduct())){
			}
			/* else we have never met the product and we add it to the list */
			else{
				L.add(d.getProduct());
			}	
		}	
		return L;
	}
	
	
	/* This function returns the origin year, ie the lowest year */
	public Integer findLowerYear(){
		Integer y = Integer.MAX_VALUE;
		for (DataType d : getDataList()){
			if (d.getOriginYear()<y){
				y = d.getOriginYear();	
			}	
		}
		return y;	
	} 
	
	/* This function returns the origin year, ie the highest year */
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
	
	/* If you want to display the list of different product you can use this function*/
	/* useful to make tests */
	public void diplayListProduct(){
		for (String s : getProductList()){
			System.out.println(s);
		}	
	}
	
	
	/* This function create matrix and fill then with the datas, and then add it to the list */
	/* of matrix */
	public void constructAllMatrix(){	
		
		for (String s : getProductList()){
			
			TriangleMatrix tm = new TriangleMatrix(getNbOfDevelopmentYear(), getLowerYear(), s);
			
			/* Full the matrix using the datas */
			for (DataType d : getDataList()){
				
				/* For each data (ie line in the original file) we add the incremental value */
				/* in the right cell. */
				/* Example : Comp, 1990, 1993, 40.0 */
				/* If lower year of the file is 1990, then the line is 1990-1990 =0 */
				/* and the column is 1993 (development year) - 1990 (origin year of data) = 3 */   
				if (d.getProduct().equals(s)){
					tm.setMatrix(tm.addValueInMatrix(tm.getMatrix(), d.getOriginYear()-getLowerYear(), d.getDevelopmentYear()-d.getOriginYear(), d.getIncrementalValue()));	
				}	
			}	
			matrixList.add(tm);
		}
			
	}
	
	/* This function transform the List of Matrix to cumulativeMatrix*/
	public void transformMatrix(){
		for (TriangleMatrix tm : getMatrixList()){
			tm.cumulativeMatrix(tm.getMatrix());	
		}	
	}
	
	/* You can use this function to display all the matrix in the list */
	public void displayAllMatrix(){
		for (TriangleMatrix m : matrixList){
			m.displayMatrix(m.getMatrix());	
			System.out.println(m.transformMatrixToString(m.getMatrix()));
		}	
		
	}
	
	/* This function transform a matrix to the String output asked for the output file */
	public void finalMatrixToString(){
		
		for (TriangleMatrix m : matrixList){	
			System.out.println(m.transformMatrixToString(m.getMatrix()));
		}	
		
	}
	
	
}