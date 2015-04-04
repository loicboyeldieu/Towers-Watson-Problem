/* Loïc Boyeldieu - 2015 */
/* This file is our Data Access Object to Data from file because it is better to avoid 
to work directly with the file */

import java.util.List;
import java.util.ArrayList;
import java.io.File;

public class DataDao implements DataDaoType{
	
	
	private File file;
	private FileTW filetw;
	
	/********************************************************************/
    // CONSTRUCTORS //
    /********************************************************************/
    
    /* The idea is to have a private constructor so you are forced to use the constructor that */
    /* ask for a file in parameter */
    
	private DataDao() {
        super();
    }

    public DataDao(File file) {
        super();
        this.file = file;
        this.filetw = new FileTW(file);
    }
    
    /********************************************************************/
    // GETTERS AND SETTERS //
    /********************************************************************/
    
    public FileTW getFileTW(){
    	return this.filetw;	
    }
    
    public void setFileTW(FileTW F){
    	this.filetw = F;	
    }
    
    
    /********************************************************************/
    // USEFULL FUNCTIONS //
    /********************************************************************/
    
    
	/* getAllDatas() convert all the datas from the file to a list of objects of type Data */
	
	public List<DataType> getAllDatas(){
		
		List<DataType> datastw = new ArrayList<DataType>();
		List<String[]> data = getFileTW().getData();
		for (String[] oneData : data){
			DataType myData = transformToDataObject(oneData);
			datastw.add(myData);	
		}
		
		return datastw;	
	}	
	
	public DataType transformToDataObject(String[] oneData){
		Data myData = new Data();
		
		myData.setProduct(oneData[0]);
		myData.setOriginYear(Integer.parseInt(oneData[1]));
		myData.setDevelopmentYear(Integer.parseInt(oneData[2]));
		myData.setIncrementalValue(Float.parseFloat(oneData[3]));	
		
		return myData;
	}
	
	
	
	
}