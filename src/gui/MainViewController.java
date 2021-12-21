package gui;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

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
import model.services.ArtistaService;

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
		//segundo parâmetro é uma função para inicializar o controlador
		loadView("/gui/ListaArtistas.fxml", (ListaArtistaController controller) -> {
			controller.setArtistaService(new ArtistaService());
			controller.updateTableView();
		});
		
	}

	@FXML
	public void onMenuItemAlbumAction() {
		System.out.println("onAlbumAction");
		
	}
	@FXML
	public void onMenuItemSobreAction() {
		loadView("/gui/Sobre.fxml", x ->{});
		
	}
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}
	
	private synchronized <T> void loadView(String absolutName, Consumer<T> initializeAction) {
		try {			
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutName));
			VBox newVBox = loader.load();
			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
			T controller = loader.getController();
			initializeAction.accept(controller);
			
			
		}catch(Exception e) {
			System.out.println(e);
			Alerts.showAlert("IOException", "Erro ao carregar a página", e.getMessage(), AlertType.ERROR);
		}
	}
	


}
