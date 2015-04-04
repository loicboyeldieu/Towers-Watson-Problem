/* Loïc Boyeldieu - 2015 */
/* Triangle matrix allows to gain memory as we do not use a full squared matrix */ 

public class TriangleMatrix{
	
	private float[][] matrix;
	private Integer originYear;
	private String name;
	
	
	/********************************************************************/
    // CONSTRUCTORS //
    /********************************************************************/
	
	private TriangleMatrix(){
		
	}
	
	public TriangleMatrix(int D, int O, String n){
		this.matrix = initMatrix(createMatrix(D));
		this.originYear = O;
		this.name = n;
	}
	
	/********************************************************************/
    // GETTERS //
    /********************************************************************/
	
	public float[][] getMatrix(){
    	return this.matrix;	
    }
    
    public String getName(){
    	return this.name;
    }
    
    /********************************************************************/
    // SETTERS //
    /********************************************************************/
    
    public void setMatrix(float[][] M){
		this.matrix = M;	
	}
	
	public void setName(String n){
		this.name = n;	
	}
	
	
	/********************************************************************/
    // MATRIXS FUNCTIONS //
    /********************************************************************/
	
	/* Create a triangle matrix with good dimensions */
	public float[][] createMatrix(int NbOfDevelopmentYear){
		float[][] M = new float[NbOfDevelopmentYear][];
		for (int i=0; i<M.length; i++){
			M[i]=new float[NbOfDevelopmentYear-i];	
		}
		return M;	
		
	}
	
	/* Fill a triangle Matrix with all value at 0 */
	/* Very usefull since some incremental values in the input data may have been */
	/* left out of the input file if they are zero */
	public float[][] initMatrix(float[][] M){
		int i, j;
		for(i=0; i<M.length; i++) {
			for(j=0; j<M[i].length; j++) {
				M[i][j]=0;
			}
		}
		return M;	
	}
	
	/* Enable us to add a value in the Matrix, returns the new Matrix */
	public float[][] addValueInMatrix(float[][] M, int L, int C, float value){
		M[L][C]=value;
		return M;	
	}
	
	/* If you want to display the Matrix */
	public void displayMatrix(float[][] M){
		int i, j;
		for(i=0; i<M.length; i++) {
			for(j=0; j<M[i].length; j++) {
				System.out.print(M[i][j]+" ");
			}
			System.out.println();
		}	
	}
	
	/* From a triangle Matrix, it calculates the cumulative Matrix and return it */
	public float[][] cumulativeMatrix(float[][] M){
		int i, j;
		for(i=0; i<M.length; i++) {
			for(j=0; j<M[i].length; j++) {
				/* If it is the first cell of the row then we do nothing */
				if (j==0){
					
				}
				/* else we add the current cell with the previous one */
				else{
					M[i][j]=M[i][j-1]+M[i][j];
				}
			}
			
		}
		return M;		
		
	}
	
	/* This function transform a triangle matrix in a String with the name first and then */
	/* the value of each cell separated by a coma */
	/* Useful to create the output file */
	public String transformMatrixToString(float[][] M){
		String r;
		r = getName();
		int i, j;
		for(i=0; i<M.length; i++) {
			for(j=0; j<M[i].length; j++) {
				r = r + ","+convertToString(M[i][j]);
			}
			
		} 	
		return r;
	}	
	
	/* Useful function that return a String corresponding to the int if the float ends with .0 */
	/* Exemple : 48.0 is returned 48 and 47.9 is returned 47.9 */
	String convertToString(Float f) {
		String result = "";
  		if (f.toString().endsWith(".0")){
     		result = Integer.toString(f.intValue());
  		}
  		else{
      		result = f.toString();
  		}
  		return result;
	}
	
	
	
	
	
}