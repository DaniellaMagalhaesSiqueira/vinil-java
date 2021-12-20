package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Artista;

public class ArtistaService {

	public List<Artista> findAll(){
		List<Artista>  list = new ArrayList<>();
		list.add(new Artista(1,"Roberto Carlos"));
		list.add(new Artista(2,"Erasmo Carlos"));
		list.add(new Artista(3,"Rita Lee"));
		list.add(new Artista(4,"Kid Abelha"));
		list.add(new Artista(5,"Los Hermanos"));
		return list;
	}
}
