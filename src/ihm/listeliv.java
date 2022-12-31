
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
public class listeliv extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			
			TableView table = new TableView();
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
			table.getColumns().addAll(idCol,nomliv ,nomaut,type, datepub,resume,maisonpub,pathliv);
			String url6 = "jdbc:mysql://localhost:3306/projet";
			String user6 = "root";
			String passwd6 = "****";
			Connection cn6 = null;
			ObservableList listPr = FXCollections.observableArrayList();
			try { cn6 = DriverManager.getConnection(url6, user6, passwd6);
			if (cn6 != null) {
			Statement req = cn6.createStatement();
			ResultSet res = req.executeQuery("Select * from livre") ;
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
			Scene scene9 = new Scene(pALLPr, 1010, 420);
			primaryStage.setTitle("Liste livre");
			primaryStage.setScene(scene9);
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