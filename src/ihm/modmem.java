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
import javafx.scene.text.Font;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
public class modmem extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox pane03 = new VBox();	
			Label lab0 = new Label("modifier donn�es d'un membre");
			lab0.setLayoutX(130);
			lab0.setFont(new Font(35));
			HBox hbox00 = new HBox();
			Label lab01 = new Label("Id : ");
			TextField ttfd = new TextField();
			
			Button modifier = new Button("modifier");
			modifier.setStyle("-fx-Background-color:#4A707A");
			hbox00.getChildren().addAll(lab01,ttfd,modifier);
			hbox00.setSpacing(0);
			//########### modifier le membre ###################
			modifier.setOnAction(e4->{
			if(ttfd.getText()!="") {
				Stage stage00 = new Stage();
				VBox pane00 = new VBox();	
				VBox vbox333 = new VBox();
				HBox hbo = new HBox();
				Label labl2 = new Label("Nom : ");
				TextField ttfld = new TextField();
				hbo.getChildren().addAll(labl2,ttfld);
				hbo.setSpacing(92);
				HBox hbo2 = new HBox();
				Label labl3 = new Label("Pr�nom : ");
				TextField ttfld2 = new TextField();
				hbo2.getChildren().addAll(labl3,ttfld2);
				hbo2.setSpacing(78);
				HBox hbo3 = new HBox();
				Label labl4 = new Label("E-mail : ");
				TextField ttfld3 = new TextField();
				hbo3.getChildren().addAll(labl4,ttfld3);	
				hbo3.setSpacing(85);
				HBox hbo4 = new HBox();
				Label labl5 = new Label("gouvernement : ");
				ChoiceBox<String> cbo = new ChoiceBox<String>();
				cbo.getItems().add("sousse");
				cbo.getItems().add("monastire");
				cbo.getItems().add("mahdia");
				cbo.getItems().add("nabeul");
				cbo.getItems().add("tunis");	
				cbo.getItems().add("beja");
				cbo.getItems().add("jandouba");
				cbo.getItems().add("zaghouane");
				cbo.getItems().add("sidi bouzid");
				cbo.getItems().add("bizert");	
				cbo.getItems().add("kairouane");
				cbo.getItems().add("gabes");
				cbo.getItems().add("sfax");
				cbo.getItems().add("medenin");
				cbo.getItems().add("tozeur");	
				cbo.getItems().add("ben arous");
				cbo.getItems().add("gafsa");
				cbo.getItems().add("kebili");
				cbo.getItems().add("kasserine");
				cbo.getItems().add("kef");	
				cbo.getItems().add("manouba");
				cbo.getItems().add("siliana");
				cbo.getItems().add("tataouine");
				cbo.getItems().add("ariana  ");
				hbo4.getChildren().addAll(labl5,cbo);
				cbo.getSelectionModel().select("Null");
				hbo4.setSpacing(42);
				HBox hbo5 = new HBox();
				Label labl6 = new Label("adresse : ");
				TextField ttfld5 = new TextField();
				hbo5.getChildren().addAll(labl6,ttfld5);
				hbo5.setSpacing(78);
				HBox hbo6 = new HBox();
				Label labl7 = new Label("mot de passe  : ");
				PasswordField ttfld6 = new PasswordField();
				hbo6.getChildren().addAll(labl7,ttfld6);
				hbo6.setSpacing(45);
				HBox hbo7 = new HBox();
				Label labl8 = new Label("r�entrer mot de passe  : ");
				PasswordField ttfld7 = new PasswordField();
				hbo7.getChildren().addAll(labl8,ttfld7);
				RadioButton rbo1 = new RadioButton("client");
	            RadioButton rbo2 = new RadioButton("admin");
	            ToggleGroup tg = new ToggleGroup();
	            rbo1.setToggleGroup(tg);
	            rbo2.setToggleGroup(tg);
	            VBox vbo22 = new VBox(10);
	            vbo22.getChildren().addAll(rbo1,rbo2);
				HBox hbo33 = new HBox();
	            Button modifier2 = new Button ("Modifier");
	            Button annuler = new Button ("Annuler");
	            
	            hbo33.getChildren().addAll(modifier2,annuler);
	            annuler.setStyle("-fx-Background-color:#4A707A");
	            annuler.setPrefSize(100, 50);
	            modifier2.setStyle("-fx-Background-color:#7697A0");
	            modifier2.setPrefSize(100, 50);
	            modifier2.setStyle("-fx-Background-color:#4A707A");
	            annuler.setStyle("-fx-Background-color:#94B0B7");
	            annuler.setOnAction(e3->{
	            	ttfld6.setText("");
	            	ttfld7.setText("");
	            	ttfld5.setText("");
	            	ttfld2.setText("");
	            	ttfld3.setText("");
	            	ttfld.setText("");
	            });
	            modifier2.setOnAction(e2->{
					String url11 = "jdbc:mysql://localhost:3306/projet";
					String user11 = "root";
					String password11 = "****";
					Connection cn22 = null;
					try {
					cn22 = DriverManager.getConnection(url11, user11, password11);
					String nom = ttfld.getText();
					String prenom = ttfld2.getText();
					String mail = ttfld3.getText();
					String gouvernement = cbo.getSelectionModel().getSelectedItem().toString();
					String adresse = ttfld5.getText();
					String m2p = ttfld6.getText();
					String rm2p = ttfld7.getText();
					String accee = "";
					if (rbo1.isSelected()) {
						accee=rbo1.getText();	
					}
					else if (rbo2.isSelected()) {
						accee=rbo2.getText();	
					}
					String rqIn222="UPDATE utilisateur SET nom=?,prenom=?,mail=?,gouvernement=?,adresse=?,motpass=?,remotpass=?,accees=? WHERE id ="+ttfd.getText()+";";
					PreparedStatement ps333 = cn22.prepareStatement(rqIn222);
					ps333.setString(1, nom);
					ps333.setString(2, prenom);
					ps333.setString(3, mail);
					ps333.setString(4, gouvernement);
					ps333.setString(5, adresse);
					ps333.setString(6, m2p);
					ps333.setString(7, rm2p);
					ps333.setString(8, accee);
					int resultat333 = ps333.executeUpdate();
					if (resultat333!=0) {
						Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
						alert.setTitle("Alert !");
						alert.setHeaderText("Compte modifier avec succ�s.");
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
	            vbox333.getChildren().addAll(hbo,hbo2,hbo3,hbo4,hbo5,hbo6,hbo7,vbo22);	
      			Scene scene00 = new Scene(pane00, 290, 270);
      			stage00.setTitle("modifier donn�es de membre num ID : "+ttfd.getText());
				pane00.getChildren().addAll(vbox333,hbo33);
				stage00.setScene(scene00);
				pane00.setStyle("-fx-Background-Color:#C2C8C5");
				stage00.setResizable(false);
				stage00.show();
			
			}
			else if (ttfd.getText()==""){
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setTitle("Alert !");
				alert.setHeaderText("vous n'avez pas entrer l'id de membre a modifier veuillez verifier!");
				alert.showAndWait();	
			}
			});
  			Scene scene03 = new Scene(pane03, 500, 100);
  			primaryStage.setTitle("modifier donn�es membre");
			pane03.getChildren().addAll(lab0,hbox00);
			pane03.setStyle("-fx-Background-Color:#C2C8C5");
			primaryStage.setScene(scene03);
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
