
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
public class listemem extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane pane01 = new Pane();	
      		TableView table = new TableView();
      		TableColumn idCol = new TableColumn("id"); 
      		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
      		
      		TableColumn nom = new TableColumn("nom");
      		nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
      		
      		TableColumn prenom = new TableColumn("prenom");
      		prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
      		
      		TableColumn mail = new TableColumn("E-mail");
      		mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
      		
      		TableColumn gouvernement = new TableColumn("Gouvernement");
      		gouvernement.setCellValueFactory(new PropertyValueFactory<>("gouvernement"));
      		
      		TableColumn adresse = new TableColumn("Adresse");
      		adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
      		
      		TableColumn motpass = new TableColumn("Mot de passe");
      		motpass.setCellValueFactory(new PropertyValueFactory<>("motpass"));
      		
      		TableColumn accees8 = new TableColumn("Accees");
      		accees8.setCellValueFactory(new PropertyValueFactory<>("accees"));
      		table.getColumns().addAll(idCol,nom ,prenom,mail, gouvernement,adresse,motpass,accees8);
      		//R�cup�rer la liste des produits de la base
      		String url7 = "jdbc:mysql://localhost:3306/projet";
      		String user7 = "root";
      		String passwd7 = "****";
      		Connection cn7 = null;
      		ObservableList listPr = FXCollections.observableArrayList();
      		try { cn7 = DriverManager.getConnection(url7, user7, passwd7);
      		if (cn7 != null) {
      		Statement req = cn7.createStatement();
      		ResultSet res = req.executeQuery("Select * from utilisateur;") ;
      		Produit p = null;
      		while(res.next()){// Activer le commit si la requ�te s'est ex�cut� sans pb
      		//Cr�er un objet avec les infos de chaque produit trouv�
      		p = new Produit(res.getInt(1), res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(9));
      		//Ajouter le produit � la liste
      		listPr.add(p);
      		}
      		}
      		}catch (SQLException e55) { e55.printStackTrace(); }
      		catch (Exception e55) { e55.printStackTrace(); }
      		//Lier la liste des donn�es � la tableView
      		table.setItems(listPr);
      		VBox pALLPr = new VBox();
      		pALLPr.getChildren().add(table);
      		pALLPr.setPadding(new Insets(5,5,5,5));
      		//Params de la fen�tre
      		Scene sceneALLPr = new Scene(pALLPr,750,300);		      			
      		primaryStage.setTitle("Liste membre");
      		primaryStage.setScene(sceneALLPr);
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

/*		Stage stage01 = new Stage();
						*/