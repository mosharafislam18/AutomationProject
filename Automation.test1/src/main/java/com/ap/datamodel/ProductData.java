package com.ap.datamodel;

public class ProductData {
	
	private String productName;
	private String quantity;
	private String size;
	private String color;
	//getter and setter with encapsulation
	//private can be accesible within only the  same project
	//
	public String getProductName(){
		return productName;
	}
	public void setProductName(String productName){
		productName =this.productName;
	}
	
	public String getQuantity(){
		return quantity;
	}
	public void setQuantity(String quantity){
		quantity = this.quantity;
	}
	public String getSize(){
		return size;
	}
	public void setSize(String size){
		size = this.size;
	}
	public String getColor(){
		return color;
	}
	public void setColor(String color){
		color = this.color;
	}
	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		//hashcode returns a whole integer not decimal 
		// when it invokes on the same object more than once during execution
		//it should consistently return the same value without zdditional value/object
		result= prime * result + ((color==null)? 0 : color.hashCode());
		result= prime * result + ((productName==null)? 0 : productName.hashCode());
		result= prime * result + ((quantity==null)? 0 : quantity.hashCode());
		result= prime * result + ((size==null)? 0 : size.hashCode());
		return result;
	}
	
	@SuppressWarnings("unused")
	@Override
	public boolean equals(Object obj){
		if (this==obj)
			return true;
		if (this==null)
			return false;
		if(getClass()!=obj.getClass())
			return false;
		ProductData other = (ProductData) obj;
		if(color==null){
			if(other.color != null)
				return false;
		}else if (!color.equals(other.color))
			return false;
		if(productName==null){
			if(other.productName !=null)
				return false;
		}else if (!productName.equals(other.productName))
	{
			return false;
	}if(quantity==null)
	{
		if(other.quantity != null)
			return false;
	}else if (!quantity.equals(other.quantity))
	{
		return false;
	}if(size==null)
	{
		if(other.size !=null)
			return false;
	}else if (!size.equals(other.size))
	{
		return false;
	}
	return true;
	}
	@Override
	public String toString()
	{
		return "ProductData [ProductName=" + productName + ", quantity=" + quantity + ", size=" + size + ", color="+ color + "]";  
		
	}

}
