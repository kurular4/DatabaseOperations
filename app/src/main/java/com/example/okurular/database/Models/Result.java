package com.example.okurular.database.Models;

public class Result{
	private String soyad;
	private String id;
	private String isim;

	public void setSoyad(String soyad){
		this.soyad = soyad;
	}

	public String getSoyad(){
		return soyad;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setIsim(String isim){
		this.isim = isim;
	}

	public String getIsim(){
		return isim;
	}

	@Override
 	public String toString(){
		return 
			"Result{" + 
			"soyad = '" + soyad + '\'' + 
			",id = '" + id + '\'' + 
			",isim = '" + isim + '\'' + 
			"}";
		}
}
