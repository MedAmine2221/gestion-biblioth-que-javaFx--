package application;
public class Produit {// Définition de la classe regroupant les infos d’un produit
int id;
String nom,prenom,mail,gouvernement,adresse,motpass,remotpass,accees;
public Produit(int id,String nom,String prenom, String mail, String gouvernement,String adresse,String motpass,String remotpass,String accees) {
this.id = id;
this.nom = nom;
this.prenom = prenom;
this.mail=mail;
this.gouvernement = gouvernement;
this.adresse = adresse;
this.motpass = motpass;
this.remotpass = remotpass;
this.accees = accees;
}
public int getId() {return id;}
public void setId(int id) {this.id = id;}

public String getNom() {return nom;}
public void setNom(String nom) {this.nom = nom;}

public String getPrenom() {return prenom;}
public void setPrenom(String prenom) {this.prenom = prenom;}

public String getMail() {return mail;}
public void setMail(String mail) {this.mail = mail;}

public String getGouvernement() {return gouvernement;}
public void setGouvernement(String gouvernement) {this.gouvernement = gouvernement;}

public String getAdresse() {return adresse;}
public void setAdresse(String adresse) {this.adresse = adresse;}

public String getMotpass() {return motpass;}
public void setMotpass(String motpass) {this.motpass = motpass;}

public String getRemotpass() {return remotpass;}
public void setReotpass(String remotpass) {this.remotpass = remotpass;}

public String getAccees() {return accees;}
public void setAccees(String accees) {this.accees = accees;}

}
