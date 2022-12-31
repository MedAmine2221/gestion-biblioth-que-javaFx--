package application;
public class Livre {// Définition de la classe regroupant les infos d’un produit
int id;
String nomliv,nomaut,type,datepub,resume,maisonpub,pathliv;
public Livre(int id,String nomliv,String nomaut, String type, String datepub,String resume,String maisonpub,String pathliv) {
this.id = id;
this.nomliv = nomliv;
this.nomaut = nomaut;
this.type = type;
this.datepub = datepub;
this.resume = resume;
this.maisonpub = maisonpub;
this.pathliv = pathliv;
}
public int getId() {return id;}
public void setId(int id) {this.id = id;}

public String getNomliv() {return nomliv;}
public void setNomliv(String nomliv) {this.nomliv = nomliv;}

public String getNomaut() {return nomaut;}
public void setNomaut(String nomaut) {this.nomaut = nomaut;}

public String getType() {return type;}
public void setType(String type) {this.type = type;}

public String getDatepub() {return datepub;}
public void setDatepub(String datepub) {this.datepub = datepub;}

public String getResume() {return resume;}
public void setResume(String resume) {this.resume = resume;}

public String getMaisonpub() {return maisonpub;}
public void setMaisonpub(String maisonpub) {this.maisonpub = maisonpub;}

public String getPathliv() {return pathliv;}
public void setPathliv(String pathliv) {this.pathliv = pathliv;}
}
