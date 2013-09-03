package com.appbuilder.block;


public class Contact {

	/**
	 * @param args
	 */
	private String address;
	private String phone;
	private String website;
	private String email;
    private String url;
    
    public void setAddresss(String ads){
    	address = ads;
    }
    public String getAddress(){
    	return address;
    }
    
    public void setPhone(String pho){
    	phone = pho;
    }
    public String getPhone(){
    	return phone;
    }
    
    public void setWebsite(String web){
    	website = web;
    }
    public String getWebsite(){
    	return website;
    }
    
    public void setEmail(String em){
    	email = em;
    }
    public String getEmail(){
    	return email;
    }
    
    public void setURL(String ul){
    	url = ul;
    }
    public String getURL(){
    	return url;
    }
    
}
