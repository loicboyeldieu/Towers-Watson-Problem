import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class FileTW implements FileReader{

	public final static List<Character> AVAILABLE_SEPARATORS = Collections.unmodifiableList(new ArrayList<Character>(Arrays.asList(',', ';', '|')));

	public final static char DEFAULT_SEPARATOR = ',';
	
	private File file;
    private List<String> lines;
    private List<String[]> data;
    private String[] titles;
    private char separator;
    
    
    /********************************************************************/
    // CONSTRUCTORS //
    /********************************************************************/
    
    public FileTW(File file){
    	if (file == null) {
            throw new IllegalArgumentException("The file cannot be null");
        }
        this.file = file;
    	this.separator = DEFAULT_SEPARATOR;
    	init();
    }
    
    
    public FileTW(File file, char separator){
    	if (file == null) {
            throw new IllegalArgumentException("The file cannot be null");
        }
        this.file = file;

        if(!isValidSeparator(separator)) {
            throw new IllegalArgumentException("separator is not acepted, use - ; | ");
        }
        this.separator = separator;
    	init();
    			
    }
    
    
    /********************************************************************/
    // GETTERS AND SETTERS //
    /********************************************************************/    
    
	public String[] getTitles() {
        return this.titles;
    }

	
	public List<String[]> getData() {
		return this.data;
	}
    
    public char getSeparator(){
    	return this.separator;	
    }
    
    
    public void init(){
    	
    	/* We take every line of the specified file */
    	lines = FileHelper.readFile(file);
		
	
        data = new ArrayList<String[]> (lines.size());
        String sep = new Character(getSeparator()).toString();
        
        /* first is used to find headings */
        boolean first = true;
        
        
        for (String line : lines) {
            
            /* First we just delete all spaces in each line of the file */
			line = line.replaceAll("\\s", "");
            
            /* We ignore comments or empty line because they contain no data */
            /* Here we could add a condition to accept line that have as many terms as headings */
            if ((line.length() == 0)||(line.startsWith("#"))){
                // We just ignore the line
            }
			else{
				
				/* We use the split function to separate each data seperated by the separator*/
				String[] oneData = line.split(sep);
				
				/* We know that the first wanted line is headings*/
				/* so we add the data to the titles' tab*/ 
				if (first) {
                	titles = oneData;
                	first = false;
            	} else {
                	data.add(oneData);
            	}
            	
			}
            
            
        }
        
    }
    
    
    /********************************************************************/
    // USEFUL FUNCTIONS //
    /********************************************************************/
    
    /* tells us if a separator is valid */
    private boolean isValidSeparator(char separator) {
        return AVAILABLE_SEPARATORS.contains(separator);
    }
    
    
    /* Function that removes spaces */
    /* We may not need it since we used the replaceAll */
    public static String removeSpace(String str){
		String ret = "";
		int i=0;
		for (i=0; i<str.length(); i++){
			if (str.charAt(i)==' '){
			}
			else{
				ret=ret+str.charAt(i);
			}
				
		}
		return ret;		
	}
	
	/* simply display all the data you get from the file */
    public void displayData(){
    	for (String[] linesD : data){
    		for (String D : linesD){
    			System.out.println(D);
    		}
    	} 	
    }
    
    /* simply display all the headings of the file */
    public void displayTitles(){
    	for (String s : getTitles()){
    		System.out.println(s);	
    	}	
    }
    
   
	
}
