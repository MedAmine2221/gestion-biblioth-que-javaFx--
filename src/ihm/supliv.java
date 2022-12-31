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
public class supliv extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox vboxsupp = new VBox();
			HBox pane04 = new HBox();	
			TextField supliv = new TextField();
			Button supprimerliv = new Button("Supprimer");
			Label suplivre = new Label("Supprimer Livre");
			suplivre.setFont(new Font(25));

			pane04.getChildren().addAll(supliv,supprimerliv);
			vboxsupp.getChildren().addAll(suplivre,pane04);
			supprimerliv.setStyle("-fx-Background-color:#94B0B7");
			supprimerliv.setOnAction(e8->{
				String url444 = "jdbc:mysql://localhost:3306/projet";
				String user444 = "root";
				String password444 = "****";
				Connection cn444 = null;
				try {
				cn444 = DriverManager.getConnection(url444, user444, password444);
				String rqIn444="DELETE FROM livre WHERE id ="+supliv.getText()+";";
				PreparedStatement ps444 = cn444.prepareStatement(rqIn444);
				int resultat444 = ps444.executeUpdate();
				if (resultat444!=0) {
					Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
					alert.setTitle("Alert !");
					alert.setHeaderText("livre supprimer avec succ�s.");
					alert.showAndWait();	
				}
				} catch (SQLException e6) {
				e6.printStackTrace();
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setTitle("Alert !");
				alert.setHeaderText("Veuillez verifier L'ID du livre !");
				alert.showAndWait();
				}
				finally {
					if(cn444 != null) {
					try { cn444.close(); }
					catch (SQLException e6) { e6.printStackTrace(); }
					}
					}
			});
				Scene scene04 = new Scene(vboxsupp, 300, 100);
				primaryStage.setTitle("supprimer livre");
				primaryStage.setScene(scene04);
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
