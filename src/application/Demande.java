package application;

public class Demande {
	
	String idbib,idutili,idliv,nomliv;
	public Demande(String idbib,String idutili,String idliv,String nomliv) {
	this.idbib = idbib;
	this.idutili = idutili;
	this.idliv = idliv;
	this.nomliv = nomliv;
	}
	public String getIdbib() {return idbib;}
	public void setIdbib(String idbib) {this.idbib = idbib;}
	
	public String getIdutili() {return idutili;}
	public void setIdtili(String idutili) {this.idutili = idutili;}
	
	public String getIdliv() {return idliv;}
	public void setIdliv(String idliv) {this.idliv = idliv;}

	public String getNomliv() {return nomliv;}
	public void setNomliv(String nomliv) {this.nomliv = nomliv;}
	}

