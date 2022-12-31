package ihm;
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
public class ajouterMem extends Application {
	@Override
	public void start(Stage primaryStage1) {
		try {

VBox vbox = new VBox();
									Label label = new Label("Enregistrer membre");
									label.setTextFill(Color.web("#43978D"));
									HBox hbox = new HBox();
									Label label2 = new Label("Nom : ");
									TextField textfield = new TextField();
									hbox.getChildren().addAll(label2,textfield);
									hbox.setSpacing(92);
									textfield.setStyle("-fx-Border-Color:#43978D");
									HBox hbox2 = new HBox();
									Label label3 = new Label("Pr�nom : ");
									TextField textfield2 = new TextField();
									textfield2.setStyle("-fx-Border-Color:#43978D");
									hbox2.getChildren().addAll(label3,textfield2);
									hbox2.setSpacing(78);
									HBox hbox3 = new HBox();
									Label label4 = new Label("E-mail : ");
									TextField textfield3 = new TextField();
									textfield3.setStyle("-fx-Border-Color:#43978D");
									hbox3.getChildren().addAll(label4,textfield3);	
									hbox3.setSpacing(85);
									HBox hbox4 = new HBox();
									Label label5 = new Label("gouvernement : ");
									ChoiceBox<String> cbox = new ChoiceBox<String>();
									cbox.getItems().add("sousse");
									cbox.getItems().add("monastirecli");
									cbox.getItems().add("mahdia");
									cbox.getItems().add("nabeul");
									cbox.getItems().add("tunis");	
									cbox.getItems().add("beja");
									cbox.getItems().add("jandouba");
									cbox.getItems().add("zaghouane");
									cbox.getItems().add("sidi bouzid");
									cbox.getItems().add("bizert");	
									cbox.getItems().add("kairouane");
									cbox.getItems().add("gabes");
									cbox.getItems().add("sfax");
									cbox.getItems().add("medenin");
									cbox.getItems().add("tozeur");	
									cbox.getItems().add("ben arous");
									cbox.getItems().add("gafsa");
									cbox.getItems().add("kebili");
									cbox.getItems().add("kasserine");
									cbox.getItems().add("kef");	
									cbox.getItems().add("manouba");
									cbox.getItems().add("siliana");
									cbox.getItems().add("tataouine");
									cbox.getItems().add("ariana  ");
									hbox4.getChildren().addAll(label5,cbox);
									cbox.getSelectionModel().select("Null");
									cbox.setStyle("-fx-Background-Color:#43978D");
									hbox4.setSpacing(42);
									HBox hbox5 = new HBox();
									Label label6 = new Label("adresse : ");
									TextField textfield5 = new TextField();
									hbox5.getChildren().addAll(label6,textfield5);
									textfield5.setStyle("-fx-Border-Color:#43978D");
									hbox5.setSpacing(78);
									HBox hbox6 = new HBox();
									Label label7 = new Label("mot de passe  : ");
									PasswordField textfield6 = new PasswordField();
									hbox6.getChildren().addAll(label7,textfield6);
									textfield6.setStyle("-fx-Border-Color:#43978D");
									hbox6.setSpacing(45);
									HBox hbox7 = new HBox();
									Label label8 = new Label("r�entrer mot de passe  : ");
									PasswordField textfield7 = new PasswordField();
									hbox7.getChildren().addAll(label8,textfield7);
									textfield7.setStyle("-fx-Border-Color:#43978D");
									RadioButton rbox1 = new RadioButton("client");
						            RadioButton rbox2 = new RadioButton("admin");
						            ToggleGroup tg = new ToggleGroup();
						            rbox1.setToggleGroup(tg);
						            rbox2.setToggleGroup(tg);
						            VBox vbox22 = new VBox(10);
						            vbox22.getChildren().addAll(rbox1,rbox2);
									HBox hbox33 = new HBox();
						            Button enregistrer = new Button ("Enregistrer");
						            Button annuler = new Button ("Annuler");
						            hbox33.getChildren().addAll(enregistrer,annuler);
						            enregistrer.setStyle("-fx-Background-color:#4A707A");
						            annuler.setStyle("-fx-Background-color:#7697A0");
						            enregistrer.setPrefSize(100, 50);
						            annuler.setPrefSize(100, 50);
						            hbox33.setSpacing(5);
						            annuler.setOnAction(e3->{
						            	textfield6.setText("");
						            	textfield7.setText("");
						            	textfield5.setText("");
						            	textfield2.setText("");
						            	textfield3.setText("");
						            	textfield.setText("");
						            	
						            });
						            enregistrer.setOnAction(e2->{
						            	String url5 = "jdbc:mysql://localhost:3306/projet";
										String user5 = "root";
										String password5 = "****";
										Connection cn5 = null;
										try {
										cn5 = DriverManager.getConnection(url5, user5, password5);
										String nom = textfield.getText();
										String prenom = textfield2.getText();
										String mail = textfield3.getText();
										String gouvernement = cbox.getSelectionModel().getSelectedItem().toString();
										String adresse = textfield5.getText();
										String m2p = textfield6.getText();
										String rm2p = textfield7.getText();
										String accee = "";
										if (rbox1.isSelected()) {
											accee=rbox1.getText();	
										}
										else if (rbox2.isSelected()) {
											accee=rbox2.getText();	
										}
										String rqIn5="INSERT INTO utilisateur(nom,prenom,mail,gouvernement,adresse,motpass,remotpass,accees)VALUES (?,?,?,?,?,?,?,?);";
										PreparedStatement ps5 = cn5.prepareStatement(rqIn5);
										ps5.setString(1, nom);
										ps5.setString(2, prenom);
										ps5.setString(3, mail);
										ps5.setString(4, gouvernement);
										ps5.setString(5, adresse);
										ps5.setString(6, m2p);
										ps5.setString(7, rm2p);	
										ps5.setString(8, accee);	
										int resultat5 = ps5.executeUpdate();
										if (resultat5!=0) {
											Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
											alert.setTitle("Alert !");
											alert.setHeaderText("Compte creer avec succ�s.");
											alert.showAndWait();	
										}
										} catch (SQLException e5) {
										e5.printStackTrace();
										Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
										alert.setTitle("Alert !");
										alert.setHeaderText("Veuillez verifier votre formulaire !");
										alert.showAndWait();
										}
										finally {
											if(cn5 != null) {
											try { cn5.close(); }
											catch (SQLException e5) { e5.printStackTrace(); }
											}
											}
									});
						            vbox.getChildren().addAll(hbox,hbox2,hbox3,hbox4,hbox5,hbox6,hbox7,vbox22);	
									vbox.setSpacing(5);
						            Pane pane8 = new Pane();	
									label.setLayoutX(130);
									vbox.setLayoutX(90);
									vbox.setLayoutY(70);
									hbox33.setLayoutX(170);
									hbox33.setLayoutY(330);
									label.setFont(new Font(35));
									pane8.getChildren().addAll(label,vbox,hbox33);	
									pane8.setStyle("-fx-Background-Color:#C2C8C5");
					      			Scene scene8 = new Scene(pane8, 500, 400);
					      			primaryStage1.setTitle("Ajouter un membre");
									primaryStage1.setScene(scene8);
									primaryStage1.setResizable(false);
									primaryStage1.show();
					}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
/**/