package it.cinema.dao;

import java.util.List;

import it.cinema.entity.Film;

public interface ICinemaDao {
	
	public void aggiungiFilm(Film film);
    public void aggiorna(Film f);
    public void elimina(int id);
    public List<Film> trovaTutti();
    public List<Film> trovaRegista(String regista);
		
	}


