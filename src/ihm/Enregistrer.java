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
import application.Main;
public class Enregistrer extends Application {
	@Override
	public void start(Stage primaryStage1) {
		try {
				
				
					//Stage stage1 = new Stage();
					//primaryStage.close();
					VBox vbx = new VBox();
					Label lbl = new Label("Enregistrez Vous !");
					lbl.setTextFill(Color.web("#43978D"));
					lbl.setFont(new Font(30));
			        lbl.setLayoutX(90);
			        lbl.setLayoutY(10);
			        HBox hbx1 = new HBox();
			        Label lbl1 = new Label("Nom : ");
					TextField txt1 = new TextField();
					hbx1.getChildren().addAll(lbl1,txt1);
					hbx1.setSpacing(92);
					txt1.setStyle("-fx-Border-Color:#43978D");
					HBox hbx2 = new HBox();
					Label lbl2 = new Label("Pr�nom : ");
					TextField txt2 = new TextField();
					hbx2.getChildren().addAll(lbl2,txt2);
					hbx2.setSpacing(78);
					txt2.setStyle("-fx-Border-Color:#43978D");
					HBox hbx3 = new HBox();
					Label lbl3 = new Label("E-mail : ");
					TextField txt3 = new TextField();
					hbx3.getChildren().addAll(lbl3,txt3);	
					hbx3.setSpacing(85);
					txt3.setStyle("-fx-Border-Color:#43978D");
					HBox hbx4 = new HBox();
					Label lbl4 = new Label("gouvernement : ");
					ChoiceBox<String> cbx = new ChoiceBox<String>();
					cbx.getItems().add("sousse");
					cbx.getItems().add("monastire");
					cbx.getItems().add("mahdia");
					cbx.getItems().add("nabeul");
					cbx.getItems().add("tunis");	
					cbx.getItems().add("beja");
					cbx.getItems().add("jandouba");
					cbx.getItems().add("zaghouane");
					cbx.getItems().add("sidi bouzid");
					cbx.getItems().add("bizert");	
					cbx.getItems().add("kairouane");
					cbx.getItems().add("gabes");
					cbx.getItems().add("sfax");
					cbx.getItems().add("medenin");
					cbx.getItems().add("tozeur");	
					cbx.getItems().add("ben arous");
					cbx.getItems().add("gafsa");
					cbx.getItems().add("kebili");
					cbx.getItems().add("kasserine");
					cbx.getItems().add("kef");	
					cbx.getItems().add("manouba");
					cbx.getItems().add("siliana");
					cbx.getItems().add("tataouine");
					cbx.getItems().add("ariana  ");
					hbx4.getChildren().addAll(lbl4,cbx);
					cbx.getSelectionModel().select("Null");
					hbx4.setSpacing(42);
					cbx.setStyle("-fx-Background-Color:#43978D");
					HBox hbx5 = new HBox();
					Label lbl5 = new Label("adresse : ");
					TextField txt5 = new TextField();
					hbx5.getChildren().addAll(lbl5,txt5);
					hbx5.setSpacing(78);
					txt5.setStyle("-fx-Border-Color:#43978D");
					HBox hbx6 = new HBox();
					Label lbl6 = new Label("mot de passe  : ");
					PasswordField txt6 = new PasswordField();
					hbx6.getChildren().addAll(lbl6,txt6);
					hbx6.setSpacing(45);
					txt6.setStyle("-fx-Border-Color:#43978D");
					HBox hbx7 = new HBox();
					Label lbl7 = new Label("r�entrer mot de passe  : ");
					PasswordField txt7 = new PasswordField();
					hbx7.getChildren().addAll(lbl7,txt7);
					txt7.setStyle("-fx-Border-Color:#43978D");
					Button enregistrer = new Button ("Enregistrer");
					enregistrer.setStyle("-fx-Background-color:#D46C4E");
					Button login = new Button ("<==");
					login.setStyle("-fx-Background-color:#D46C4E");
					login.setOnAction(e55->{
						primaryStage1.close();
						
						Main ma = new Main();
						ma.start(primaryStage1);
					});
					enregistrer.setOnAction(e->{
						String url = "jdbc:mysql://localhost:3306/projet";
						String user = "root";
						String password = "****";
						Connection cn = null;
						try {
						cn = DriverManager.getConnection(url, user, password);
						String nom = txt1.getText();
						String prenom = txt2.getText();
						String mail = txt3.getText();
						String gouvernement = cbx.getSelectionModel().getSelectedItem().toString();
						String adresse = txt5.getText();
						String m2p = txt6.getText();
						String rm2p = txt7.getText();
						String rqIn="INSERT INTO utilisateur(nom,prenom,mail,gouvernement,adresse,motpass,remotpass,accees)VALUES (?,?,?,?,?,?,?,'client');";
						PreparedStatement ps = cn.prepareStatement(rqIn);
						ps.setString(1, nom);
						ps.setString(2, prenom);
						ps.setString(3, mail);
						ps.setString(4, gouvernement);
						ps.setString(5, adresse);
						ps.setString(6, m2p);
						ps.setString(7, rm2p);	
						int resultat = ps.executeUpdate();
						if (resultat!=0) {
							Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
							alert.setTitle("Alert !");
							alert.setHeaderText("Compte creer avec succ�s.");
							alert.showAndWait();	
						}
						} catch (SQLException e2) {
						e2.printStackTrace();
						Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
						alert.setTitle("Alert !");
						alert.setHeaderText("Veuillez verifier votre formulaire !");
						alert.showAndWait();
						}
						finally {
							if(cn != null) {
							try { cn.close(); }
							catch (SQLException e2) { e2.printStackTrace(); }
							}
							}
						});
			        vbx.getChildren().addAll(hbx1,hbx2,hbx3,hbx4,hbx5,hbx6,hbx7);
			        vbx.setLayoutX(65);
			        vbx.setLayoutY(60);
			        vbx.setSpacing(10);
			        enregistrer.setPrefSize(100,40);
			        enregistrer.setLayoutX(160);
			        enregistrer.setLayoutY(350);
					Pane scene1 = new Pane();
					scene1.getChildren().addAll(lbl,vbx,enregistrer,login);
					scene1.setStyle("-fx-Background-Color:#F9E07F");
					Scene secondScene = new Scene(scene1, 400, 400);
					primaryStage1.setTitle("Cr�er un compte");
					primaryStage1.setScene(secondScene);
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
