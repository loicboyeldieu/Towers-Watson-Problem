/* Loïc Boyeldieu - 2015 */
/* This file describe a data that we can find in the initial file */

public class Data implements DataType{
	
	private String product;
	private Integer originYear;
	private Integer developmentYear;
	private Float incrementalValue;
	
	/********************************************************************/
    // GETTERS //
    /********************************************************************/
	
	public String getProduct(){	
		return this.product;
	}
	
	public Integer getOriginYear(){	
		return this.originYear;
	}
	
	public Integer getDevelopmentYear(){	
		return this.developmentYear;
	}
	
	public Float getIncrementalValue(){	
		return this.incrementalValue;
	}
	
	/********************************************************************/
    // SETTERS //
    /********************************************************************/
	
	public void setProduct(String p){
		this.product = p;	
	}
	
	public void setOriginYear(Integer y){
		this.originYear = y;	
	}
	
	public void setDevelopmentYear(Integer y){
		this.developmentYear = y;	
	}
	
	public void setIncrementalValue(Float i){
		this.incrementalValue = i;	
	}
	
}