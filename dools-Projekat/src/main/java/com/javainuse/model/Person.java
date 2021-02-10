package com.javainuse.model;

public class Person
{
	public String pol;
	public int starost;
	public int visina;
	public double tezina;	
	public String nivo_aktivnosi;
	public String cilj;
	public double kcal;
	public double carbs;	//makrosi mogu da se smeste i u novu klasu
	public double protein;
	public double fat;
	public String trudnoca;
	public String trimestar;
	
	public String getPol() {
		return pol;
	}
	public int getStarost() {
		return starost;
	}
	public void setStarost(int starost) {
		this.starost = starost;
	}
	public int getVisina() {
		return visina;
	}
	public void setVisina(int visina) {
		this.visina = visina;
	}
	public double getTezina() {
		return tezina;
	}
	public void setTezina(double tezina) {
		this.tezina = tezina;
	}
	public String getNivo_aktivnosi() {
		return nivo_aktivnosi;
	}
	public void setNivo_aktivnosi(String nivo_aktivnosi) {
		this.nivo_aktivnosi = nivo_aktivnosi;
	}
	public String getCilj() {
		return cilj;
	}
	public void setCilj(String cilj) {
		this.cilj = cilj;
	}
	public double getKcal() {
		return kcal;
	}
	public void setKcal(double kcal) {
		this.kcal = kcal;
	}
	public double getCarbs() {
		return carbs;
	}
	public void setCarbs(double carbs) {
		this.carbs = carbs;
	}
	public double getProtein() {
		return protein;
	}
	public void setProtein(double protein) {
		this.protein = protein;
	}
	public double getFat() {
		return fat;
	}
	public void setFat(double fat) {
		this.fat = fat;
	}
	public void setPol(String pol) {
		this.pol = pol;
	}
	public String getTrudnoca() {
		return trudnoca;
	}
	public void setTrudnoca(String trudnoca) {
		this.trudnoca = trudnoca;
	}
	public String getTrimestar() {
		return trimestar;
	}
	public void setTrimestar(String trimestar) {
		this.trimestar = trimestar;
	}
	
	
	
}