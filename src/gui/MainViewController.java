package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable{
	@FXML
	private MenuItem menuItemMusica;
	
	@FXML
	private MenuItem menuItemArtista;
	
	@FXML
	private MenuItem menuItemAlbum;

	@FXML
	private MenuItem menuItemSobre;
	
	@FXML
	public void onMenuItemMusicaAction() {
		System.out.println("onMusicaAction");
	}
	@FXML
	public void onMenuItemArtistaAction() {
		System.out.println("onArtistaAction");
		
	}
	@FXML
	public void onMenuItemAlbumAction() {
		System.out.println("onAlbumAction");
		
	}
	@FXML
	public void onMenuItemSobreAction() {
		loadView("/gui/Sobre.fxml");
		
	}
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}
	
	private synchronized void loadView(String absolutName) {
		try {			
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutName));
			VBox newVBox = loader.load();
			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
			
		}catch(IOException e) {
			Alerts.showAlert("IOException", "Erro ao carregar a página", e.getMessage(), AlertType.ERROR);
		}
	}

}
