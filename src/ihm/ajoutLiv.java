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
public class ajoutLiv extends Application {
	@Override
	public void start(Stage primaryStage2) {
		try {
			Pane pane7 = new Pane();	
			Label labelivre = new Label("Enregistrer Livre");
			labelivre.setLayoutX(130);
			labelivre.setFont(new Font(35));
			VBox livre = new VBox();
			HBox nom = new HBox();
			Label labnom = new Label("nom livre : ");
			TextField textnom = new TextField();
			nom.getChildren().addAll(labnom,textnom);
			nom.setSpacing(79);
			textnom.setStyle("-fx-Border-Color:#43978D");
			HBox auteur = new HBox();
			Label labaut = new Label("nom de l'auteur : ");
			TextField textaut = new TextField();
			textaut.setStyle("-fx-Border-Color:#43978D");
			auteur.getChildren().addAll(labaut,textaut);
			auteur.setSpacing(44);
			HBox type = new HBox();
			Label latype = new Label("Type livre : ");
			TextField texttyp = new TextField();
			type.getChildren().addAll(latype,texttyp);
			type.setSpacing(77);
			texttyp.setStyle("-fx-Border-Color:#43978D");
			
			HBox date = new HBox();
			Label labdate = new Label("date de publication : ");
			TextField textdate = new TextField("AAAA-MM-JJ");
			date.getChildren().addAll(labdate,textdate);	
			date.setSpacing(25);
			textdate.setStyle("-fx-Border-Color:#43978D");
			textdate.textProperty().addListener(new ChangeListener<String>() {
	            @Override
	            public void changed(ObservableValue<? extends String> observable, String oldValue, 
	                String newValue) {
	                if (!newValue.contains("[0-9-]*")) {
	                	textdate.setText(newValue.replaceAll("[^[0-9-]]", ""));
	                }
	            }
	        });
			HBox resum� = new HBox();
			Label labresume = new Label("R�sum� de livre : ");
			TextArea textresum� = new TextArea();
			resum�.getChildren().addAll(labresume,textresum�);							
			resum�.setSpacing(43);
			textresum�.setStyle("-fx-Border-Color:#43978D");

			HBox maisonpub = new HBox();
			Label labmaison = new Label("Maison de publication : ");
			TextField textmaison = new TextField();
			maisonpub.getChildren().addAll(labmaison,textmaison);
			maisonpub.setSpacing(10);
			textmaison.setStyle("-fx-Border-Color:#43978D");

			FileChooser fileChooser = new FileChooser();
		    fileChooser.getExtensionFilters().addAll(
            new ExtensionFilter("Text Files", "*.pdf")
			         );
     		File selectedFile = fileChooser.showSaveDialog(primaryStage2);  
     		HBox btn =new HBox();
     		Button enr = new Button("ENREGISTRER");
     		Button annuler = new Button("ANNULER");
     		enr.setStyle("-fx-Background-color:#4A707A");
            annuler.setStyle("-fx-Background-color:#7697A0");
            btn.getChildren().addAll(enr,annuler);
            enr.setPrefSize(100, 50);
            annuler.setPrefSize(100, 50);
            btn.setSpacing(5);
			annuler.setOnAction(e->{
				textmaison.setText("");
				textresum�.setText("");
				textdate.setText("AAAA-MM-JJ");
				texttyp.setText("");
				textaut.setText("");
				textnom.setText("");
			});
			enr.setOnAction(e7->{
				if (selectedFile.getPath()!="null") {
				String url4 = "jdbc:mysql://localhost:3306/projet";
				String user4 = "root";
				String password4 = "****";
				Connection cn4 = null;
				try {
				cn4 = DriverManager.getConnection(url4, user4, password4);
				String nomliv = textnom.getText();
				String nomaut = textaut.getText();
				String typeliv = texttyp.getText();
				String datepubliv = textdate.getText();
				String resumliv = textresum�.getText();
				String maisonpubliv = textmaison.getText();
				String pathliv = selectedFile.getPath();
				String rqIn4="INSERT INTO livre (nomliv,nomaut,type,datepub,resume,maisonpub,pathliv)VALUES (?,?,?,?,?,?,?);";
				PreparedStatement ps4 = cn4.prepareStatement(rqIn4);
				ps4.setString(1, nomliv);
				ps4.setString(2, nomaut);
				ps4.setString(3, typeliv);
				ps4.setString(4, datepubliv);
				ps4.setString(5, resumliv);
				ps4.setString(6, maisonpubliv);
				ps4.setString(7, pathliv);
				int resultat2 = ps4.executeUpdate();
				if (resultat2!=0) {
					Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
					alert.setTitle("Alert !");
					alert.setHeaderText("livre ajouter avec succ�s.");
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
					if(cn4 != null) {
					try { cn4.close(); }
					catch (SQLException e5) { e5.printStackTrace(); }
					}
					}
				}
			});			
			livre.getChildren().addAll(nom,auteur,type,date,resum�,maisonpub);
			livre.setLayoutX(90);
			livre.setLayoutY(70);
			labelivre.setLayoutX(200);
			btn.setLayoutX(200);
			btn.setLayoutY(420);
			livre.setSpacing(5);
			pane7.setStyle("-fx-Background-Color:#C2C8C5");
			Scene scene7 = new Scene(pane7, 750, 480);
  			pane7.getChildren().addAll(labelivre,livre,btn);	
  			primaryStage2.setTitle("Ajouter livre");
			primaryStage2.setScene(scene7);
			primaryStage2.setResizable(false);
			primaryStage2.show();
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
/*				*/