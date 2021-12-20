package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Artista;
import model.services.ArtistaService;

public class ListaArtistaController implements Initializable{

	private ArtistaService service;
	
	@FXML
	private TableView<Artista> tabelaArtista;
	
	@FXML
	private Button btNovo;
	
	@FXML
	private TableColumn<Artista, Long> colunaId;
	
	@FXML
	private TableColumn<Artista, String> colunaNome;
	
	private ObservableList <Artista> obsArtista;
	
	@FXML
	public void onBtNovoAction() {
		System.out.println("OnBtNovoAction");
	}
	
	public void setArtistaService(ArtistaService service) {
		this.service = service;
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
	
	public void updateTableView() {
		if(service == null) {
			throw new IllegalStateException("Serviço não foi carregado");
		}
		List<Artista> list = service.findAll();
		obsArtista = FXCollections.observableArrayList(list);
		tabelaArtista.setItems(obsArtista);
	}

}
