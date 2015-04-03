import java.util.List;
import java.util.ArrayList;
import java.io.File;

public class DataDao implements DataDaoType{
	
	
	private File file;
	private FileTW filetw;
	
	private DataDao() {
        super();
    }

    public DataDao(File file) {
        super();
        this.file = file;
        this.filetw = new FileTW(file);
    }
    
    
    public FileTW getFileTW(){
    	return this.filetw;	
    }
	
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