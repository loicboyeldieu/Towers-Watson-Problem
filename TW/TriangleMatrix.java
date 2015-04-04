public class TriangleMatrix{
	
	private float[][] matrix;
	private Integer originYear;
	private String name;
	
	
	public TriangleMatrix(int D, int O, String n){
		this.matrix = initMatrix(createMatrix(D));
		this.originYear = O;
		this.name = n;
	}
	
	public float[][] getMatrix(){
    	return this.matrix;	
    }
    
    public String getName(){
    	return this.name;
    }
    
    public void setMatrix(float[][] M){
		this.matrix = M;	
	}
	
	public void setName(String n){
		this.name = n;	
	}
	
	public float[][] createMatrix(int NbOfDevelopmentYear){
		float[][] M = new float[NbOfDevelopmentYear][];
		for (int i=0; i<M.length; i++){
			M[i]=new float[NbOfDevelopmentYear-i];	
		}
		return M;	
		
	}
	
	public float[][] initMatrix(float[][] M){
		int i, j;
		for(i=0; i<M.length; i++) {
			for(j=0; j<M[i].length; j++) {
				M[i][j]=0;
			}
		}
		return M;	
	}
	
	public float[][] addValueInMatrix(float[][] M, int L, int C, float value){
		M[L][C]=value;
		return M;	
	}
	
	
	public void displayMatrix(float[][] M){
		int i, j;
		for(i=0; i<M.length; i++) {
			for(j=0; j<M[i].length; j++) {
				System.out.print(M[i][j]+" ");
			}
			System.out.println();
		}	
	}
	
	public float[][] cumulativeMatrix(float[][] M){
		int i, j;
		for(i=0; i<M.length; i++) {
			for(j=0; j<M[i].length; j++) {
				if (j==0){
					
				}
				else{
					M[i][j]=M[i][j-1]+M[i][j];
				}
			}
			
		}
		return M;		
		
	}
	
	
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
	
	
	String convertToString(Float f) {
  		if (f.toString().endsWith(".0"))
     		return Integer.toString(f.intValue());
  		else
      		return f.toString();
	}
	
	
	
	
	
}