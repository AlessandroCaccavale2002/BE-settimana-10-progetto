package it.cinema.dao;

import java.util.List;
import it.cinema.entity.Film;


public class CinemaDao implements ICinemaDao {
	
	@Override
	public void aggiorna(Film f) {}

	@Override
	public void elimina(int id) {}

	@Override
	public List<Film> trovaTutti() {
		return null;}

	@Override
	public List<Film> trovaRegista(String regista) {
		return null;}

	@Override
	public void aggiungiFilm(Film film) {}

}
