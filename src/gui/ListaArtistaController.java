package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Artista;

public class ListaArtistaController implements Initializable{

	@FXML
	private TableView<Artista> tabelaArtista;
	
	@FXML
	private Button btNovo;
	
	@FXML
	private TableColumn<Artista, Long> colunaId;
	
	@FXML
	private TableColumn<Artista, String> colunaNome;
	
	
	@FXML
	public void onBtNovoAction() {
		System.out.println("OnBtNovoAction");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle resources) {
		initializeNode();
		
	}

	private void initializeNode() {
		
		colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));		
		colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		
		Stage stage = (Stage) Main.getMainScene().getWindow();	
		tabelaArtista.prefHeightProperty().bind(stage.heightProperty());
	}

}
