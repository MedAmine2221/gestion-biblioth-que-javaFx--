package application;
import java.io.File;
import java.sql.*;
import java.time.LocalDate;
import java.util.Calendar;
import javafx.scene.control.MenuItem;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import application.Demande;
import application.Livre;
import application.Produit;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import ihm.*;
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = new Pane();
			Image img = new Image( "C:\\Users\\lenovo\\Downloads\\bibb.jpg");
	        BackgroundImage bImg = new BackgroundImage(img,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
	        Background bGround = new Background(bImg);
	        root.setBackground(bGround);
			Label lab0 = new Label("Bienvenue chez biblioth�que");
	        lab0.setLayoutX(40);
	        lab0.setLayoutY(100);
	        lab0.setFont(new Font(40));
	        
			Label lab = new Label("LOGIN");
	        lab.setLayoutX(235);
	        lab.setLayoutY(140);
	        lab.setFont(new Font(50));
	        lab.setTextFill(Color.web("WHITE"));
	        lab0.setTextFill(Color.web("WHITE"));
	        TextField mail = new TextField();
	        Label lbl = new Label("E-mail : ");
	        lbl.setFont(new Font(25));
	        lbl.setLayoutX(50);
	        lbl.setLayoutY(230);
            mail.setLayoutX(250);
            mail.setLayoutY(235);
	        PasswordField pass0 = new PasswordField();
	        TextField pass = new TextField();
	        pass.setVisible(false);
	        Label lbl1 = new Label("Mot de pass : ");
		    lbl1.setLayoutX(50);
            lbl1.setLayoutY(270);
	        lbl1.setFont(new Font(25));
		    pass0.setLayoutX(250);
            pass0.setLayoutY(275);
		    pass.setLayoutX(250);
            pass.setLayoutY(275);
            lbl.setTextFill(Color.web("WHITE"));
            lbl1.setTextFill(Color.web("WHITE"));
	        CheckBox passvisible = new CheckBox("Afficher mot de passe");
	        passvisible.setLayoutX(210);
	        passvisible.setLayoutY(305);
	        
	        passvisible.selectedProperty().addListener((ObservableValue<? extends Boolean>ov,Boolean old_val,Boolean new_val)->{
	        	if (passvisible.isSelected()) {
	        		pass.setText(pass0.getText());
	        		pass.setVisible(true);
	        		pass0.setVisible(false);
	        		return;
	        	}
        		pass0.setText(pass.getText());
        		pass0.setVisible(true);
        		pass.setVisible(false);
	        });
	        Button btn = new Button("ENTRER");
	        btn.setLayoutX(132);
	        btn.setLayoutY(360);
	        btn.setPrefSize(170,40);
	        btn.setFont(new Font(15));  
			btn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {	
				

					String url = "jdbc:mysql://localhost:3306/projet";
					String user = "root";
					String password = "*****";
					Connection cn = null;
					try {
						cn = DriverManager.getConnection(url, user, password);
						String rqIn="SELECT id,accees from utilisateur where mail='"+mail.getText()+"'and motpass='"+pass.getText()+"'or motpass='"+pass0.getText()+"';";
						PreparedStatement ps = cn.prepareStatement(rqIn);
						ResultSet resultat = ps.executeQuery();
						if (resultat.next()){	
							String test="admin@gmail.com";
							String test2="123456789";
							boolean verif00=mail.getText().compareTo(test)==0;
							//boolean verif02=pass.getText().compareTo(test2)==0;
							boolean verif03=pass0.getText().compareTo(test2)==0;
							System.out.println(verif00);
							//System.out.println(verif02);
							System.out.println(verif03);
//################################################## COMPTE admin ####################################################################################################################################								
								if(verif00 &&verif03) {									
								primaryStage.close();
								Stage stage3 = new Stage();
								HBox hbxtot=new HBox();
								VBox vbx = new VBox();
								Button btn = new Button("Ajouter livre");
								btn.setPrefSize(130, 60);
								Button btn1 = new Button("Ajouter membre");
								btn1.setPrefSize(130, 60);
								Button btn2 = new Button("liste livre");
								btn2.setPrefSize(130, 60);
								Button btn3 = new Button("liste membre");
								btn3.setPrefSize(130, 60);
								Button btn4 = new Button("modifier livre");
								btn4.setPrefSize(130, 60);
								Button btn5 = new Button("modifier membre");
								btn5.setPrefSize(130, 60);
								Button btn6 = new Button("supprimer livre");
								btn6.setPrefSize(130, 60);
								Button btn7 = new Button("supprimer membre");
								btn7.setPrefSize(130, 60);
								Button btn8 = new Button("contacter membres");
								btn8.setPrefSize(130, 60);
								btn.setStyle("-fx-Background-color:#DDDDDA");
								btn1.setStyle("-fx-Background-color:#DDDDDA");
								btn2.setStyle("-fx-Background-color:#C2C8C5");
								btn3.setStyle("-fx-Background-color:#C2C8C5");
								btn4.setStyle("-fx-Background-color:#94B0B7");
								btn5.setStyle("-fx-Background-color:#94B0B7");
								btn6.setStyle("-fx-Background-color:#7697A0");
								btn7.setStyle("-fx-Background-color:#7697A0");
								btn8.setStyle("-fx-Background-color:#4A707A");
								vbx.setSpacing(2);
								vbx.getChildren().addAll(btn,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8);
								VBox vbx2 = new VBox();
								Label lbl = new Label("vous pouvez trouver les membre et leur livre associer et inversement");
								lbl.setFont(new Font(15));
								
								Pane pane = new Pane();
								pane.setStyle("-fx-border-color:BLACK");
								HBox hboxrech = new HBox();
								TextField txt = new TextField();
								Button btnrech = new Button("Recherche Membre");
								btnrech.setStyle("-fx-Background-color:#94B0B7");
								btnrech.setOnAction(e77->{
									Stage stage04 = new Stage();
		
									TableView table = new TableView();
									//D�finition des colonnes de la table
									TableColumn id = new TableColumn("id"); 
									id.setCellValueFactory(new PropertyValueFactory<>("id"));
									TableColumn nom = new TableColumn("Nom");
									nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
									TableColumn prenom = new TableColumn("Prenom");
									prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
									TableColumn mail = new TableColumn("E-mail");
									mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
									TableColumn gouvernement = new TableColumn("Gouvernement");
									gouvernement.setCellValueFactory(new PropertyValueFactory<>("gouvernement"));
									TableColumn adresse = new TableColumn("Adresse");
									adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
									TableColumn motpass = new TableColumn("Mot de passe");
									motpass.setCellValueFactory(new PropertyValueFactory<>("motpass"));
									TableColumn remotpass = new TableColumn("Mot de passe");
									remotpass.setCellValueFactory(new PropertyValueFactory<>("remotpass"));
									TableColumn accees2 = new TableColumn("Accees");
									accees2.setCellValueFactory(new PropertyValueFactory<>("accees"));
		
									table.getColumns().addAll(id,nom ,prenom,mail, gouvernement,adresse,motpass,remotpass,accees2);
									//R�cup�rer la liste des produits de la base
									String url2 = "jdbc:mysql://localhost:3306/projet";
									String user2 = "root";
									String passwd2 = "****";
									Connection cn2 = null;
									ObservableList listPr = FXCollections.observableArrayList();
									try { cn2 = DriverManager.getConnection(url2, user2, passwd2);
									if (cn2 != null) {
									Statement req = cn2.createStatement();
									ResultSet res = req.executeQuery("Select * from utilisateur where id="+txt.getText()+";") ;
									Produit p = null;
									while(res.next()){// Activer le commit si la requ�te s'est ex�cut� sans pb
									//Cr�er un objet avec les infos de chaque produit trouv�
									p = new Produit(res.getInt(1), res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(9));
									//Ajouter le produit � la liste
									listPr.add(p);
									}
									}
									}catch (SQLException e) { e.printStackTrace(); }
									catch (Exception e) { e.printStackTrace(); }
									//Lier la liste des donn�es � la tableView
									table.setItems(listPr);
									VBox pALLPr = new VBox();
									pALLPr.getChildren().add(table);
									pALLPr.setPadding(new Insets(5,5,5,5));
									//Params de la fen�tre
					      			Scene scene04 = new Scene(pALLPr, 720, 350);
									stage04.setTitle("membre d'id"+txt.getText());
									stage04.setScene(scene04);
									stage04.setResizable(false);
									stage04.show();
								});
								hboxrech.getChildren().addAll(txt,btnrech);
								hboxrech.setLayoutX(10);
								hboxrech.setLayoutY(100);
								pane.setPrefSize(450, 235);
								pane.getChildren().addAll(hboxrech);		
								Pane pane2 = new Pane();
								pane2.setStyle("-fx-border-color:BLACK");
								HBox hboxrechliv = new HBox();
								TextField txt2 = new TextField();
								Button btnrechliv = new Button("Recherche Livre");
								btnrechliv.setStyle("-fx-Background-color:#94B0B7");
								btnrechliv.setOnAction(e88->{
									Stage stage04 = new Stage();
									TableView table = new TableView();
									TableColumn id = new TableColumn("Id"); 
									id.setCellValueFactory(new PropertyValueFactory<>("id"));
									TableColumn nomliv = new TableColumn("Nom du livre");
									nomliv.setCellValueFactory(new PropertyValueFactory<>("nomliv"));
									TableColumn nomaut = new TableColumn("Nom d'auteur");
									nomaut.setCellValueFactory(new PropertyValueFactory<>("nomaut"));
									TableColumn type = new TableColumn("Type du livre");
									type.setCellValueFactory(new PropertyValueFactory<>("type"));
									TableColumn datepub = new TableColumn("Date publication");
									datepub.setCellValueFactory(new PropertyValueFactory<>("datepub"));
									TableColumn resume = new TableColumn("R�sum�");
									resume.setCellValueFactory(new PropertyValueFactory<>("resume"));
									TableColumn maisonpub = new TableColumn("Maison de publication");
									maisonpub.setCellValueFactory(new PropertyValueFactory<>("maisonpub"));
									TableColumn pathliv = new TableColumn("Path du livre");
									pathliv.setCellValueFactory(new PropertyValueFactory<>("pathliv"));
									table.getColumns().addAll(id,nomliv ,nomaut,type, datepub,resume,maisonpub,pathliv);
									String url3 = "jdbc:mysql://localhost:3306/projet";
									String user3 = "root";
									String passwd3 = "****";
									Connection cn3 = null;
									ObservableList listPr = FXCollections.observableArrayList();
									try { cn3 = DriverManager.getConnection(url3, user3, passwd3);
									if (cn3 != null) {
									Statement req = cn3.createStatement();
									ResultSet res = req.executeQuery("Select * from livre where id="+txt2.getText()) ;
									Livre l = null;
									while(res.next()){
									l = new Livre(res.getInt(1), res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8));
								 	listPr.add(l);
									}
									}
									}catch (SQLException e66) { e66.printStackTrace(); }
									catch (Exception e66) { e66.printStackTrace(); }
									table.setItems(listPr);
									VBox pALLPr = new VBox();
									pALLPr.getChildren().add(table);
									pALLPr.setPadding(new Insets(5,5,5,5));
									
					      			Scene scene04 = new Scene(pALLPr, 720, 350);
									stage04.setTitle("livre d'id"+txt2.getText());
									stage04.setScene(scene04);
									stage04.setResizable(false);
									stage04.show();
								});		
								hboxrechliv.getChildren().addAll(txt2,btnrechliv);
								pane2.setPrefSize(450, 235);
								pane2.getChildren().addAll(hboxrechliv);
								hboxrechliv.setLayoutX(10);
								hboxrechliv.setLayoutY(100);
								vbx2.setSpacing(5);
								hbxtot.setSpacing(25);
								Button btn9 = new Button("D�connecter");
								btn9.setOnAction(e77->{
									stage3.close();
									primaryStage.show();
								});
								btn9.setPrefSize(100, 50);
								btn9.setStyle("-fx-Background-color:#4A707A");
								vbx2.getChildren().addAll(lbl,pane,pane2,btn9);
		
								hbxtot.getChildren().addAll(vbx2,vbx);
								vbx.setLayoutX(480);
						        
								Pane scene2 = new Pane();
//################################### BOUTON D'AJOUTER UN MEMBRE ##########################################################################################
								btn1.setOnAction(e->{
									ajouterMem ajou = new ajouterMem();
									ajou.start(primaryStage);
								});
//################################### BOUTON D'AJOUTER UN LIVRE ##########################################################################################
								btn.setOnAction(e->{
									
									ajoutLiv ajou = new ajoutLiv();
									ajou.start(primaryStage);
								});
//################################### BOUTON Liste des LIVREs ##########################################################################################
								btn2.setOnAction(e->{
									listeliv lis = new listeliv();
									lis.start(primaryStage);				
								});
//################################### BOUTON liste des MEMBREs ##########################################################################################
								btn3.setOnAction(e->{
									listemem liste = new listemem();
									liste.start(primaryStage);
								});
//################################### modifier donn�es livre ##########################################################################################
								btn4.setOnAction(e->{
									modliv mliv = new modliv();
									mliv.start(primaryStage);
								});
//################################### modifier donn�es membre ##########################################################################################
								btn5.setOnAction(e->{	
									modmem mod = new modmem();
									mod.start(primaryStage);	
								});
//#################################################suprimer livre############################################################################################# 
								btn6.setOnAction(e->{
									supliv sliv = new supliv();
									sliv.start(primaryStage);
								});
//#################################################suprimer membre############################################################################################# 
								btn7.setOnAction(e->{
									supmembre supmm = new supmembre();
									supmm.start(primaryStage);
								});
//#################################################Contacter##########################################################################################
								btn8.setOnAction(e->{
									contact cont = new contact();
									try {
										cont.init();
										cont.start(primaryStage);
										
									} catch (Exception e1) {
										e1.printStackTrace();
									}
								});
								
								scene2.getChildren().addAll(hbxtot);
								Scene secondScene = new Scene(scene2, 600, 558);
								stage3.setTitle(mail.getText()+" Bienvenue dans votre compte");
								stage3.setScene(secondScene);
								stage3.setResizable(false);
								stage3.show();	
								}
//################################################## COMPTE utilisateur ####################################################################################################################################								

								else {
									primaryStage.close();
									Stage st = new Stage();	
									BorderPane pMain = new BorderPane();
									pMain.setStyle("-fx-Background-color:#C2C8C5");
									pMain.setPrefHeight(600);
									
									MenuBar mBar = new MenuBar();
									mBar.setStyle("-fx-Background-color:#C2C8C5");
									Menu mProfil = new Menu("Profil"); 
									mBar.getMenus().add(mProfil);
									MenuItem affprof = new MenuItem("Afficher profil");
									affprof.addEventHandler(ActionEvent.ACTION,this);
									mProfil.getItems().add(affprof);
									
									Menu livre = new Menu("Livre"); 
									mBar.getMenus().add(livre);
									MenuItem biblio = new MenuItem("Bibliotheque");
									biblio.addEventHandler(ActionEvent.ACTION,this);
									livre.getItems().add(biblio);
										
									MenuItem demliv = new MenuItem("Demander livre");
									demliv.addEventHandler(ActionEvent.ACTION,this);
									livre.getItems().add(demliv);
									MenuItem anndem = new MenuItem("Annuler demande");
									anndem.addEventHandler(ActionEvent.ACTION,this);
									livre.getItems().add(anndem);
									Menu option = new Menu("Option"); 
									mBar.getMenus().add(option);
									MenuItem decon = new MenuItem("D�connecter");
									decon.addEventHandler(ActionEvent.ACTION,this);
									option.getItems().add(decon);
									MenuItem cont = new MenuItem("Contacter Admin");
									cont.addEventHandler(ActionEvent.ACTION,this);
									option.getItems().add(cont);				
									//
									Label labTitre = new Label("Gestion des formations");
									//Params de la fen�tre				
									pMain.setPadding(new Insets(50)); 
									pMain.setCenter(labTitre);
									VBox vBox = new VBox(mBar);
									vBox.getChildren().add(pMain);
									//Params de la fen�tre			
										affprof.setOnAction(e->{
											//stage000.close();
											Stage stage4 = new Stage();
											st.close();
											Pane pane4 = new Pane();	
											
											String url00 = "jdbc:mysql://localhost:3306/projet";
											String user00 = "root";
											String passwd00 = "****";
											Connection cn00 = null;
											try { cn00 = DriverManager.getConnection(url00, user00, passwd00);
											if (cn00 != null) {
											Statement req = cn00.createStatement();
											ResultSet res = req.executeQuery("Select * from utilisateur where mail='"+mail.getText()+"'and motpass='"+pass.getText()+"'or motpass='"+pass0.getText()+"';") ;
											while(res.next()){// Activer le commit si la requ�te s'est ex�cut� sans pb
											//Cr�er un objet avec les infos de chaque produit trouv�
											//Ajouter le produit � la liste
											
												
											HBox hbxnom = new HBox();
											Label labnom = new Label("Nom :");
											String nom=res.getString("nom");
											TextField nomlab = new TextField(nom);
											labnom.setFont(new Font(15));
											hbxnom.getChildren().addAll(labnom,nomlab);
											hbxnom.setSpacing(120);
											//nomlab.setDisable(true);
											
											HBox hbxprenom = new HBox();
											Label labprenom = new Label("Preom :");
											String prenom=res.getString("prenom");
											TextField prenomlab = new TextField(prenom);
											
											labprenom.setFont(new Font(15));
											hbxprenom.getChildren().addAll(labprenom,prenomlab);
											hbxprenom.setSpacing(107);
											//prenomlab.setDisable(true);
											Label lab = new Label("Bienvenue : "+nom+" "+prenom);
											lab.setFont(new Font(25));
											
											HBox hbxgouv = new HBox();
											Label labgouv = new Label("Gouvernement :");
											String gouver=res.getString("gouvernement");
											
											
											ChoiceBox<String> gouv = new ChoiceBox<String>();
											gouv.getItems().add("sousse");
											gouv.getItems().add("monastire");
											gouv.getItems().add("mahdia");
											gouv.getItems().add("nabeul");
											gouv.getItems().add("tunis");	
											gouv.getItems().add("beja");
											gouv.getItems().add("jandouba");
											gouv.getItems().add("zaghouane");
											gouv.getItems().add("sidi bouzid");
											gouv.getItems().add("bizert");	
											gouv.getItems().add("kairouane");
											gouv.getItems().add("gabes");
											gouv.getItems().add("sfax");
											gouv.getItems().add("medenin");
											gouv.getItems().add("tozeur");	
											gouv.getItems().add("ben arous");
											gouv.getItems().add("gafsa");
											gouv.getItems().add("kebili");
											gouv.getItems().add("kasserine");
											gouv.getItems().add("kef");	
											gouv.getItems().add("manouba");
											gouv.getItems().add("siliana");
											gouv.getItems().add("tataouine");
											gouv.getItems().add("ariana  ");
											gouv.getSelectionModel().select(gouver);										
											labgouv.setFont(new Font(15));
											hbxgouv.getChildren().addAll(labgouv,gouv);
											hbxgouv.setSpacing(52);
											//gouverlab.setDisable(true);
											
											HBox hbxmail = new HBox();
											Label labmail = new Label("E-mail :");					
											String em=res.getString("mail");
											TextField emlab = new TextField(em);	
											labmail.setFont(new Font(15));
											hbxmail.getChildren().addAll(labmail,emlab);
											hbxmail.setSpacing(109);
											//emlab.setDisable(true);
											
											HBox hbxadd = new HBox();
											Label labadd = new Label("Adresse :");			
											String adr=res.getString("adresse");
											TextField adresselab = new TextField(adr);
											labadd.setFont(new Font(15));
											hbxadd.getChildren().addAll(labadd,adresselab);
											hbxadd.setSpacing(97);
											//adresselab.setDisable(true);
											
											HBox hbxm2p = new HBox();
											Label labm2p = new Label("Mot de passe :");	
											String motpass=res.getString("motpass");
											TextField motpasslab = new TextField(motpass);
											labm2p.setFont(new Font(15));
											hbxm2p.getChildren().addAll(labm2p,motpasslab);
											hbxm2p.setSpacing(60);
											//motpasslab.setDisable(true);
											
											HBox hbxm2p2 = new HBox();
											Label labm2p2 = new Label("R�entrer mot de passe :");	
											String remotpass=res.getString("remotpass");
											TextField remotpasslab = new TextField(remotpass);
											labm2p2.setFont(new Font(15));
											hbxm2p2.getChildren().addAll(labm2p2,remotpasslab);
											hbxm2p2.setSpacing(0);
											//remotpasslab.setDisable(true);
											
											HBox hbxacc = new HBox();
											Label labacc = new Label("Acc�es:");
											String acc=res.getString("accees");
											TextField acclab = new TextField(acc);	
											labacc.setFont(new Font(15));
											hbxacc.getChildren().addAll(labacc,acclab);
											hbxacc.setSpacing(110);
											acclab.setDisable(true);
											Button btn = new Button("Modifier");
											Button btnann = new Button("Annuler");
											btnann.setOnAction(eg->{
												stage4.close();
											});
											int idval=res.getInt("id");
											btn.setOnAction(e99->{
												String url11 = "jdbc:mysql://localhost:3306/projet";
												String user11 = "root";
												String password11 = "****";
												Connection cn22 = null;
												try {
												cn22 = DriverManager.getConnection(url11, user11, password11);
												String nomprof = nomlab.getText();
												String prenomprof = prenomlab.getText();
												String mail = emlab.getText();
												String gouvernement = gouv.getSelectionModel().getSelectedItem().toString();
												String adresse = adresselab.getText();
												String m2p = motpasslab.getText();
												String rm2p = remotpasslab.getText();
												
												String rqIn222="UPDATE utilisateur SET nom=?,prenom=?,mail=?,gouvernement=?,adresse=?,motpass=?,remotpass=?,accees=? WHERE id ="+idval+";";
												PreparedStatement ps333 = cn22.prepareStatement(rqIn222);
												ps333.setString(1, nomprof);
												ps333.setString(2, prenomprof);
												ps333.setString(3, mail);
												ps333.setString(4, gouvernement);
												ps333.setString(5, adresse);
												ps333.setString(6, m2p);
												ps333.setString(7, rm2p);
												
												int resultat333 = ps333.executeUpdate();
												if (resultat333!=0) {
													Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
													alert.setTitle("Alert !");
													alert.setHeaderText("votre profil modifier avec succ�s.");
													alert.showAndWait();	
												}
												} catch (SQLException e6) {
												e6.printStackTrace();
												Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
												alert.setTitle("Alert !");
												alert.setHeaderText("Veuillez verifier votre formulaire !");
												alert.showAndWait();
												}
												finally {
													if(cn22 != null) {
													try { cn22.close(); }
													catch (SQLException e6) { e6.printStackTrace(); }
													}
													}
											});
											VBox vbx= new VBox();
											vbx.getChildren().addAll(lab,hbxnom,hbxprenom,hbxgouv,hbxmail,hbxadd,hbxm2p,hbxm2p2,hbxacc);
											vbx.setSpacing(10);										
											vbx.setLayoutX(150);
											vbx.setLayoutY(20);
											
											btn.setLayoutX(200);
											btn.setLayoutY(350);
											btn.setPrefSize(80,40);
											
											btnann.setLayoutX(290);
											btnann.setLayoutY(350);
											btnann.setPrefSize(80,40);
											
											pane4.getChildren().addAll(vbx,btn,btnann);
											}
											}
											}catch (SQLException e99) { e99.printStackTrace(); }
											
							      			Scene scene4 = new Scene(pane4, 600, 480);
											stage4.setTitle("Information detaill� sur votre profil");
											stage4.setScene(scene4);
											stage4.show();
										});
									
										biblio.setOnAction(e->{
											st.close();
											Stage stage6 = new Stage();
											
											
											Button btn = new Button();
											TableView table = new TableView();
											TableColumn refCol = new TableColumn("id");
											TableColumn reflivCol = new TableColumn("numero livre");
											TableColumn nomCol = new TableColumn("nom de livre");
										
											// Definir comment remplir une case de donn�e
											refCol.setCellValueFactory(new PropertyValueFactory<>("idbib"));
											reflivCol.setCellValueFactory(new PropertyValueFactory<>("idliv"));
											nomCol.setCellValueFactory(new PropertyValueFactory<>("nomliv"));
											
											// Trier selon la colonne moyenne
											
											table.getColumns().addAll(refCol,reflivCol, nomCol);
											
											
											String urlsql= "jdbc:mysql://localhost:3306/projet";
									  		String usersql = "root";
									  		String passwdsql = "****";
									  		Connection cnsql = null;
									  		ObservableList listPr = FXCollections.observableArrayList();
									  		try { cnsql = DriverManager.getConnection(urlsql, usersql, passwdsql);
									  		if (cnsql != null) {
									  			/*Statement reqsql = cnsql.createStatement();
										  		ResultSet ressql = reqsql.executeQuery("SELECT * from utilisateur where mail="+mail.getText()+";");*/
									  			String rqsql="SELECT id from utilisateur where mail='"+mail.getText()+"'and motpass='"+pass.getText()+"'or motpass='"+pass0.getText()+"';";
												PreparedStatement pssql = cnsql.prepareStatement(rqsql);
												ResultSet resultat2 = pssql.executeQuery();
									  			while(resultat2.next()){
										  			int verif=resultat2.getInt("id");
										  			
									  		Statement reqsql2 = cnsql.createStatement();
									  		ResultSet ressql2 = reqsql2.executeQuery("Select * from livclient where idutili="+verif) ;
									  		Demande dem = null;
									  		while(ressql2.next()){// Activer le commit si la requ�te s'est ex�cut� sans pb
									  		//Cr�er un objet avec les infos de chaque produit trouv�
									  		dem = new Demande(ressql2.getString(1),ressql2.getString(2),ressql2.getString(3), ressql2.getString(4));
									  		//Ajouter le produit � la liste
									  		listPr.add(dem);
									  		}
										  	}
									  		}
									  		}catch (SQLException e55) { e55.printStackTrace(); }
									  		//catch (Exception e55) { e55.printStackTrace(); }
									  		//Lier la liste des donn�es � la tableView
									  		table.setItems(listPr);
									  		VBox pALLF = new VBox();
									  		Button ouvrire = new Button ("ouvrire livre PDF");
									  		HBox hbxinf= new HBox();
									  		ComboBox formationsL = new ComboBox<String>();
									  		String urlsql7 = "jdbc:mysql://localhost:3306/projet";
									  		String usersql7 = "root";
									  		String passwdsql7 = "****";
									  		Connection cnsql7 = null;
									  		try { cnsql7 = DriverManager.getConnection(urlsql7, usersql7, passwdsql7);
									  		if (cnsql7 != null) {
									  		String rqsql77="SELECT id from utilisateur where mail='"+mail.getText()+"'and motpass='"+pass.getText()+"'or motpass='"+pass0.getText()+"';";
												PreparedStatement pssql77 = cnsql.prepareStatement(rqsql77);
												ResultSet resultatsql77 = pssql77.executeQuery();
									  			while(resultatsql77.next()){
										  			int verif7=resultatsql77.getInt("id");
									  		Statement reqsql7 = cnsql7.createStatement();
									  		ResultSet ressql7 = reqsql7.executeQuery("Select nom from livclient where idutili="+verif7) ;
											
									  			while(ressql7.next()){
									  				String titre=ressql7.getString("nom");
												   formationsL.getItems().add(titre);
												   }
												   }
												   }
												  }catch (Exception e66) { e66.printStackTrace(); }
									  		//TextField chomp = new TextField();
									  		Button info = new Button ("Plus d'information sur livre");
									  	
									  		hbxinf.getChildren().addAll(formationsL,info,ouvrire);
									  	
									  		ouvrire.setOnAction(new EventHandler<ActionEvent>(){
									  		//Stage stage444 = new Stage();
									  			
									  		 @Override
									            public void handle(ActionEvent event) {
									  			String urlsql70 = "jdbc:mysql://localhost:3306/projet";
										  		String usersql70 = "root";
										  		String passwdsql70 = "****";
										  		Connection cnsql70 = null;
										  		try { cnsql70 = DriverManager.getConnection(urlsql70, usersql70, passwdsql70);
										  		if (cnsql70 != null) {
										  		String rqsql70="SELECT pathliv from livre where nomliv='"+formationsL.getSelectionModel().getSelectedItem().toString()+"';";
													PreparedStatement pssql77 = cnsql70.prepareStatement(rqsql70);
													ResultSet resultatsql77 = pssql77.executeQuery();
										  			while(resultatsql77.next()){
									                File pdfFile = new File(resultatsql77.getString("pathliv"));
									                getHostServices().showDocument(pdfFile.toURI().toString());
									            }
										  		}
										  		}catch (Exception e66) { e66.printStackTrace(); }
									  		 }
									  		});
									  		info.setOnAction(einf->{
									  			
												
												Stage stage444 = new Stage();
									  			TableView tableinfo = new TableView();
												TableColumn idCol = new TableColumn("id"); 
												idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
												TableColumn nomliv = new TableColumn("Nom du livre");
												nomliv.setCellValueFactory(new PropertyValueFactory<>("nomliv"));
												TableColumn nomaut = new TableColumn("Nom d'auteur");
												nomaut.setCellValueFactory(new PropertyValueFactory<>("nomaut"));
												TableColumn type = new TableColumn("Type du livre");
												type.setCellValueFactory(new PropertyValueFactory<>("type"));
												TableColumn datepub = new TableColumn("Date publication");
												datepub.setCellValueFactory(new PropertyValueFactory<>("datepub"));
												TableColumn resume = new TableColumn("R�sum�");
												resume.setCellValueFactory(new PropertyValueFactory<>("resume"));
												TableColumn maisonpub = new TableColumn("Maison de publication");
												maisonpub.setCellValueFactory(new PropertyValueFactory<>("maisonpub"));
												TableColumn pathliv = new TableColumn("Path du livre");
												pathliv.setCellValueFactory(new PropertyValueFactory<>("pathliv"));
												tableinfo.getColumns().addAll(idCol,nomliv ,nomaut,type, datepub,resume,maisonpub,pathliv);
												String url6 = "jdbc:mysql://localhost:3306/projet";
												String user6 = "root";
												String passwd6 = "****";
												Connection cn6 = null;
												ObservableList listliv = FXCollections.observableArrayList();
												try { cn6 = DriverManager.getConnection(url6, user6, passwd6);
												if (cn6 != null) {
												Statement req = cn6.createStatement();
												ResultSet res = req.executeQuery("Select * from livre where nomliv ='"+formationsL.getSelectionModel().getSelectedItem().toString()+"';") ;
												Livre l = null;
												while(res.next()){
												l = new Livre(res.getInt(1), res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8));
											 	listliv.add(l);
												}
												}
												}
												catch (Exception e66) { e66.printStackTrace(); }
												tableinfo.setItems(listliv);
												VBox pALLliv = new VBox();
												pALLliv.getChildren().add(tableinfo);
												pALLliv.setPadding(new Insets(5,5,5,5));
												Scene scene9 = new Scene(pALLliv, 1010, 420);
												stage444.setTitle("Votre Biblioth�que");
												stage444.setScene(scene9);
												stage444.show();	
									  		});
											
											pALLF.getChildren().addAll(table,hbxinf);
											pALLF.setPadding(new Insets(5,5,5,5));	
											
							      			Scene scene6 = new Scene(pALLF, 600, 480);
											stage6.setTitle("Votre Biblioth�que");
											stage6.setScene(scene6);
											stage6.show();
										});
										demliv.setOnAction(e->{
											//stage000.close();
											Stage stage8 = new Stage();
											Pane pane8 = new Pane();	
											ComboBox cbxliv= new ComboBox<String>();
											String urlsql9 = "jdbc:mysql://localhost:3306/projet";
									  		String usersql9 = "root";
									  		String passwdsql9 = "****";
									  		Connection cnsql9 = null;
									  		try { cnsql9 = DriverManager.getConnection(urlsql9, usersql9, passwdsql9);
									  		if (cnsql9 != null) {
									  			
									  			Statement reqsql9 = cnsql9.createStatement();
										  		ResultSet ressql9 = reqsql9.executeQuery("Select * from livre") ;
												Statement reqsql99 = cnsql9.createStatement();
										  		ResultSet ressql99 = reqsql99.executeQuery("SELECT id from utilisateur where mail='"+mail.getText()+"'and motpass='"+pass.getText()+"'or motpass='"+pass0.getText()+"';");
										  		
										  		int verif=0;
										  		
										  		while(ressql99.next()){
										  			verif=ressql99.getInt("id");
										  		}	
										  		while(ressql9.next()){
										  			String titre=ressql9.getString("nomliv");
										  			cbxliv.getItems().add(titre);
										  	
													}
									  			int verifliv=0;
							      	  			
									  			Statement req777 = cnsql9.createStatement();
									  			ResultSet res777 = req777.executeQuery("Select id from livre where nomliv='"+cbxliv.getSelectionModel().getSelectedItem()+"';");
										  		while(res777.next()){
											  			 verifliv=res777.getInt("id"); 
											  			 }
								
										  	
									  		TextField idutili = new TextField(""+verif);
									  		idutili.setDisable(true);
									  		Button btn = new Button("Enregistrer Demande");
									  		HBox hbxx=new HBox();
									  		hbxx.getChildren().addAll(cbxliv,idutili,btn);
									  		pane8.getChildren().addAll(hbxx);	
									  		btn.setOnAction(e10->{
									  			String url77 = "jdbc:mysql://localhost:3306/projet";
												String user77 = "root";
												String password77 = "****";
												Connection cn77 = null;
												try {
												cn77 = DriverManager.getConnection(url77, user77, password77);
												Statement req7777 = cn77.createStatement();
									  			ResultSet res7777 = req7777.executeQuery("Select id from livre where nomliv='"+cbxliv.getSelectionModel().getSelectedItem()+"';");
										  		int verifliv2=0;
									  			while(res7777.next()){
											  			 verifliv2=res7777.getInt("id"); 
											  			 }
												String idu = idutili.getText();
												String idl = ""+verifliv2;
												String nomliv= cbxliv.getSelectionModel().getSelectedItem().toString();
												

												String rqIn77="INSERT INTO livclient(idutili,idliv,nom)VALUES (?,?,?);";
												PreparedStatement ps77 = cn77.prepareStatement(rqIn77);
												ps77.setString(1, idu);
												ps77.setString(2, idl);
												ps77.setString(3, nomliv);
												
												int resultat5 = ps77.executeUpdate();
												if (resultat5!=0) {
													Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
													alert.setTitle("Alert !");
													alert.setHeaderText("Demande enregistrer avec succ�s.");
													alert.showAndWait();	
												}
												} catch (SQLException e5) {
												e5.printStackTrace();
												Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
												alert.setTitle("Alert !");
												alert.setHeaderText("Veuillez verifier votre livre !");
												alert.showAndWait();
												}
												finally {
													if(cn77 != null) {
													try { cn77.close(); }
													catch (SQLException e5) { e5.printStackTrace(); }
													}
													}
									  		});
									
									  		}
									  		
									  		
									  		}
									  		catch (Exception e66) { e66.printStackTrace(); }
									  		finally {
												if(cnsql9 != null) {
												try { cnsql9.close(); }
												catch (SQLException e5) { e5.printStackTrace(); }
												}
												}
									  		Scene scene8= new Scene(pane8, 400, 40);
											stage8.setTitle("Demander Livre");
											stage8.setScene(scene8);
											stage8.show();
										});
										anndem.setOnAction(e->{
											//stage000.close();
											Stage stage9 = new Stage();
											Pane pane9 = new Pane();	
											
											ComboBox cbxliv= new ComboBox<String>();
											String urlsql9 = "jdbc:mysql://localhost:3306/projet";
									  		String usersql9 = "root";
									  		String passwdsql9 = "****";
									  		Connection cnsql9 = null;
									  		try { cnsql9 = DriverManager.getConnection(urlsql9, usersql9, passwdsql9);
									  		if (cnsql9 != null) {
									  			
									  			Statement reqsql9 = cnsql9.createStatement();
										  		ResultSet ressql9 = reqsql9.executeQuery("Select * from livre") ;
												Statement reqsql99 = cnsql9.createStatement();
										  		ResultSet ressql99 = reqsql99.executeQuery("SELECT id from utilisateur where mail='"+mail.getText()+"'and motpass='"+pass.getText()+"'or motpass='"+pass0.getText()+"';");
										  		
										  		int verif=0;
										  		
										  		while(ressql99.next()){
										  			verif=ressql99.getInt("id");
										  		}	
										  		while(ressql9.next()){
										  			String titre=ressql9.getString("nomliv");
										  			cbxliv.getItems().add(titre);
										  	
													}
									  			int verifliv=0;
							      	  			
									  			Statement req777 = cnsql9.createStatement();
									  			ResultSet res777 = req777.executeQuery("Select id from livre where nomliv='"+cbxliv.getSelectionModel().getSelectedItem()+"';");
										  		while(res777.next()){
											  			 verifliv=res777.getInt("id"); 
											  			 }
								
										  	
									  		TextField idutili = new TextField(""+verif);
									  		idutili.setDisable(true);
									  		Button btn = new Button("Annuler Demande");
									  		HBox hbxx=new HBox();
									  		hbxx.getChildren().addAll(cbxliv,idutili,btn);
									  		pane9.getChildren().addAll(hbxx);	
									  		btn.setOnAction(e10->{
									  			String url77 = "jdbc:mysql://localhost:3306/projet";
												String user77 = "root";
												String password77 = "****";
												Connection cn77 = null;
												try {
												cn77 = DriverManager.getConnection(url77, user77, password77);
												Statement req7777 = cn77.createStatement();
									  			ResultSet res7777 = req7777.executeQuery("Select id from livre where nomliv='"+cbxliv.getSelectionModel().getSelectedItem()+"';");
										  		int verifliv2=0;
									  			while(res7777.next()){
											  			 verifliv2=res7777.getInt("id"); 
											  			 }
										  		
												String idu = idutili.getText();
												
												String nomliv= cbxliv.getSelectionModel().getSelectedItem().toString();
												

												String rqIn77="DELETE from livclient where nom='"+nomliv+"'and idutili="+idu+";";
												PreparedStatement ps77 = cn77.prepareStatement(rqIn77);
												
												int resultat5 = ps77.executeUpdate();
												if (resultat5!=0) {
													Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
													alert.setTitle("Alert !");
													alert.setHeaderText("Demande annuler avec succ�s.");
													alert.showAndWait();	
												}
												} catch (SQLException e5) {
												e5.printStackTrace();
												Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
												alert.setTitle("Alert !");
												alert.setHeaderText("Veuillez verifier votre livre !");
												alert.showAndWait();
												}
												finally {
													if(cn77 != null) {
													try { cn77.close(); }
													catch (SQLException e5) { e5.printStackTrace(); }
													}
													}
									  		});
									
									  		}
									  		
									  		
									  		}
									  		catch (Exception e66) { e66.printStackTrace(); }
									  		finally {
												if(cnsql9 != null) {
												try { cnsql9.close(); }
												catch (SQLException e5) { e5.printStackTrace(); }
												}
												}
											
							      			Scene scene9 = new Scene(pane9, 400, 40);
											stage9.setTitle("Annuler demande");
											stage9.setScene(scene9);
											stage9.show();
										});
										decon.setOnAction(e->{
											st.close();
										});
										cont.setOnAction(e->{
											st.close();
											contser serveur = new contser();
											try {
												serveur.init();
												serveur.start(primaryStage);
												
											} catch (Exception e1) {
												e1.printStackTrace();
											}
											
										});
								
						      			Scene sc = new Scene(vBox, 600, 480);
										st.setTitle("Bienvenue"+" "+"dans votre biblioth�que");
										st.setScene(sc);
										st.setResizable(false);
										st.show();	
								}

							}
						else{
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Alert !");
					alert.setHeaderText("Mot de passe ou email incorrect veuillez verifiez votre compte!");
					alert.showAndWait();
					}
							}catch (SQLException e6) {
								e6.printStackTrace();
								Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
								alert.setTitle("Alert !");
								alert.setHeaderText("Erreur au niveau de syntax!");
								alert.showAndWait();
								}
								finally {
									if(cn != null) {
									try { cn.close(); }
									catch (SQLException e6) { e6.printStackTrace(); }
									}
									}
						}
				});
//#########################################################################################################################################################################################
	        Button btn2 = new Button("Enregistrer");
	        btn2.setLayoutX(320);
	        btn2.setLayoutY(360);
	        btn2.setPrefSize(170, 40);
	        btn2.setFont(new Font(15));
//################################################### FENETRE DE CREATION D'UN NOUVEAU COMPTE ######################################################################################################################################
	        btn2.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					Enregistrer enrg = new Enregistrer();
					enrg.start(primaryStage);
					
				}
			}); 	        
	        root.getChildren().addAll(lab0,lab,lbl,lbl1,pass0,pass,mail,passvisible,btn,btn2);
			Scene scene = new Scene(root,600,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Biblioth�que en ligne");
			primaryStage.setResizable(false);
			
			
			
			primaryStage.show();			
					}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
