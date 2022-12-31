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
public class supmembre extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane pane05 = new Pane();
			VBox vboxsup = new VBox();
			HBox supp = new HBox();
			Label supmembre = new Label("Supprimer Membre");
			supmembre.setFont(new Font(25));
			TextField sup = new TextField();
			Button supprimer = new Button("Supprimer");
			supprimer.setStyle("-fx-Background-color:#94B0B7");
			supprimer.setOnAction(e8->{
				String url666 = "jdbc:mysql://localhost:3306/projet";
				String user666 = "root";
				String password666 = "****";
				Connection cn666 = null;
				try {
				cn666 = DriverManager.getConnection(url666, user666, password666);
				String rqIn666="DELETE FROM utilisateur WHERE id ="+sup.getText()+";";
				PreparedStatement ps666 = cn666.prepareStatement(rqIn666);
				int resultat666 = ps666.executeUpdate();
				if (resultat666!=0) {
					Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
					alert.setTitle("Alert !");
					alert.setHeaderText("Compte supprimer avec succ�s.");
					alert.showAndWait();	
				}
				} catch (SQLException e6) {
				e6.printStackTrace();
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setTitle("Alert !");
				alert.setHeaderText("Veuillez verifier votre ID !");
				alert.showAndWait();
				}
				finally {
					if(cn666 != null) {
					try { cn666.close(); }
					catch (SQLException e6) { e6.printStackTrace(); }
					}
					}	
			});
  			supp.getChildren().addAll(sup,supprimer);
  			vboxsup.getChildren().addAll(supmembre,supp);
  			Scene scene05 = new Scene(pane05, 300, 100);
			pane05.getChildren().add(vboxsup);
			primaryStage.setTitle("supprimer membre");
			primaryStage.setScene(scene05);
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
