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
public class modliv extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox pane02 = new VBox();	
			pane02.setSpacing(10);
			Label labmodliv = new Label("modifier donn�es d'un Livre");
			labmodliv.setTextFill(Color.web("#7697A0"));
			labmodliv.setLayoutX(130);
			labmodliv.setFont(new Font(35));
			HBox hbox23 = new HBox();
			HBox hbomod = new HBox();
			Label labid = new Label("Id : ");
			labid.setFont(new Font(15));
			TextField idtext = new TextField();
			hbomod.getChildren().addAll(labid,idtext);
			hbomod.setSpacing(0);
			Button modifierliv = new Button("modifier livre");
			modifierliv.setStyle("-fx-Background-color:#4A707A");
			hbox23.getChildren().addAll(hbomod,modifierliv);						
			modifierliv.setOnAction(e10->{
			if(idtext.getText()!="") {
				
				Stage stage09 = new Stage();
				VBox pane09 = new VBox();	
				pane09.setSpacing(10);
				Label labelivremod = new Label("Modifier Livre");
				labelivremod.setLayoutX(130);
				labelivremod.setFont(new Font(35));
				VBox livremod = new VBox();
				HBox nommod = new HBox();
				String url00 = "jdbc:mysql://localhost:3306/projet";
				String user00 = "root";
				String passwd00 = "****";
				Connection cn00 = null;
				try { cn00 = DriverManager.getConnection(url00, user00, passwd00);
				if (cn00 != null) {
				Statement req = cn00.createStatement();
				ResultSet res = req.executeQuery("Select * from livre where id="+idtext.getText()+";") ;
				while(res.next()){
				Label labnommod = new Label("nom livre : ");
				TextField textnommod = new TextField();
				textnommod.setText(res.getString("nomliv"));
				nommod.getChildren().addAll(labnommod,textnommod);
				nommod.setSpacing(97);
				textnommod.setStyle("-fx-Border-Color:#4A707A");
				HBox auteurmod = new HBox();
				Label labautmod = new Label("nom de l'auteur : ");
				TextField textautmod = new TextField();
				textautmod.setText(res.getString("nomaut"));
				auteurmod.getChildren().addAll(labautmod,textautmod);
				auteurmod.setSpacing(61);
				textautmod.setStyle("-fx-Border-Color:#4A707A");
				HBox typemod = new HBox();
				Label latypemod = new Label("Type livre : ");
				TextField texttypmod = new TextField();
				texttypmod.setText(res.getString("type"));

				typemod.getChildren().addAll(latypemod,texttypmod);
				typemod.setSpacing(95);
				texttypmod.setStyle("-fx-Border-Color:#4A707A");

				HBox datemod = new HBox();
				Label labdatemod = new Label("date de publication : ");
				TextField textdatemod = new TextField("AAAA-MM-JJ");
				texttypmod.setStyle("-fx-Border-Color:#4A707A");
				textdatemod.setText(res.getString("datepub"));
				datemod.getChildren().addAll(labdatemod,textdatemod);	
				datemod.setSpacing(45);
				textdatemod.setStyle("-fx-Border-Color:#4A707A");

				textdatemod.textProperty().addListener(new ChangeListener<String>() {
		            @Override
		            public void changed(ObservableValue<? extends String> observable, String oldValue, 
		                String newValue) {
		                if (!newValue.contains("[0-9-]*")) {
		                	textdatemod.setText(newValue.replaceAll("[^[0-9-]]", ""));
		                }
		            }
		        });
				HBox resum�mod = new HBox();
				Label labresumemod = new Label("R�sum� de livre : ");
				TextArea textresum�mod = new TextArea();
				resum�mod.getChildren().addAll(labresumemod,textresum�mod);							
				resum�mod.setSpacing(62);
				textresum�mod.setStyle("-fx-Border-Color:#4A707A");
				textresum�mod.setText(res.getString("resume"));
				HBox maisonpubmod = new HBox();
				Label labmaisonmod = new Label("Maison de publication : ");
				TextField textmaisonmod = new TextField();
				maisonpubmod.getChildren().addAll(labmaisonmod,textmaisonmod);
				maisonpubmod.setSpacing(30);
				textmaisonmod.setStyle("-fx-Border-Color:#4A707A");
				textmaisonmod.setText(res.getString("maisonpub"));
				HBox hboxmod = new HBox();
	            Button mod = new Button ("Modifier");
	            Button annuler = new Button ("Annuler");
	            hboxmod.getChildren().addAll(mod,annuler);
	            hboxmod.setSpacing(5);
	    
	            mod.setPrefSize(100, 50);
	            annuler.setPrefSize(100, 50);
	            mod.setStyle("-fx-Background-color:#4A707A");
	            annuler.setStyle("-fx-Background-color:#4A707A");
	            annuler.setOnAction(e3->{
	            	textnommod.setText("");
	            	textautmod.setText("");
	            	texttypmod.setText("");
	            	textdatemod.setText("");
	            	textresum�mod.setText("");
	            	textmaisonmod.setText("");
	            });
	            mod.setOnAction(e11->{
					String url8 = "jdbc:mysql://localhost:3306/projet";
					String user8 = "root";
					String password8 = "****";
					Connection cn10 = null;
					try {
					cn10 = DriverManager.getConnection(url8, user8, password8);
					String nomlivmod = textnommod.getText();
					String nomautmod = textautmod.getText();
					String typelivmod = texttypmod.getText();
					String datepublivmod = textdatemod.getText();
					String resumlivmod = textresum�mod.getText();
					String maisonpublivmod = textmaisonmod.getText();
					String rqIn111="UPDATE livre SET nomliv=?,nomaut=?,type=?,datepub=?,resume=?,maisonpub=? WHERE id ="+idtext.getText()+";";								
					PreparedStatement ps110 = cn10.prepareStatement(rqIn111);
					ps110.setString(1, nomlivmod);
					ps110.setString(2, nomautmod);
					ps110.setString(3, typelivmod);
					ps110.setString(4, datepublivmod);
					ps110.setString(5, resumlivmod);
					ps110.setString(6, maisonpublivmod);	
					int resultat110 = ps110.executeUpdate();
					if (resultat110!=0) {
						Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
						alert.setTitle("Alert !");
						alert.setHeaderText("livre d'ID : "+idtext.getText()+" a modifi� avec succ�s.");
						alert.showAndWait();	
					}
					} catch (SQLException e111) {
					e111.printStackTrace();
					Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
					alert.setTitle("Alert !");
					alert.setHeaderText("Veuillez verifier votre formulaire !");
					alert.showAndWait();
					}
					finally {
						if(cn10 != null) {
						try { cn10.close(); }
						catch (SQLException e111) { e111.printStackTrace(); }
						}
						}
				});
	            livremod.getChildren().addAll(nommod,auteurmod,typemod,datemod,resum�mod,maisonpubmod);							
      			Scene scene09 = new Scene(pane09, 700, 450);
      			
				stage09.setTitle("modifier donn�es de livre num ID : "+idtext.getText());
				pane09.getChildren().addAll(labelivremod,livremod,hboxmod);
				
				pane09.setStyle("-fx-Background-Color:#C2C8C5");
				stage09.setScene(scene09);
				stage09.setResizable(false);
				stage09.show();
				
			}
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
				}
			else if (idtext.getText()==""){
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setTitle("Alert !");
				alert.setHeaderText("vous n'avez pas entrer l'id de livre a modifier veuillez verifier!");
				alert.showAndWait();	
			}
			});
  			Scene scene02 = new Scene(pane02, 450, 100);

  			primaryStage.setTitle("modifier donn�es livre");
			pane02.getChildren().addAll(labmodliv,hbox23);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene02);
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
