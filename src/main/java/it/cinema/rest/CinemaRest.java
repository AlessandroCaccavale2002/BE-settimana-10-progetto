package it.cinema.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import it.cinema.dao.CinemaDao;
import it.cinema.dto.FilmDto;
import it.cinema.entity.Film;

@RestController
@RequestMapping("/cinema")
@Api(value = "Applicazione film", tags = "descrizione")
public class CinemaRest {
	

	CinemaDao cinemadao;

	public CinemaDao getCinemadao() {
		if(cinemadao == null) {
			cinemadao = new CinemaDao();
		}
		return cinemadao;
	}

	@GetMapping
	@ApiOperation(value = "Trova tutti i film",
	produces = "application/json",
	response = Film.class, responseContainer = "List")
	public ResponseEntity<List<Film>> listDiFilm(){
	try {
		return new ResponseEntity<List<Film>>(getCinemadao().trovaTutti(), HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<List<Film>>((List<Film>)null, HttpStatus.METHOD_NOT_ALLOWED);
	}
}
		
	@GetMapping("/byregista")
	@ApiOperation(value = "trova per regista",
	produces = "application/json",
	response = Film.class, responseContainer = "List")
	public ResponseEntity<List<Film>> trovaRegista(@RequestParam String regista){
		try {
			return new ResponseEntity<List<Film>>(getCinemadao().trovaRegista(regista), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Film>>((List<Film>)null, HttpStatus.METHOD_FAILURE);		
	}
	}
	
	@PostMapping
	@ApiOperation(value = "inserimento nuovo film",
	consumes = "application/json")
	public ResponseEntity<String> aggiungiFilm(@RequestBody FilmDto filmDto){
		try {
			String incasso = BCrypt.hashpw(filmDto.getIncasso(), BCrypt.gensalt());
			Film film = new Film();
			film.setTitolo(filmDto.getTitolo());
			film.setRegista(filmDto.getRegista());
			film.setAnno(filmDto.getAnno());
			film.setGenere(filmDto.getGenere());
			film.setIncasso(incasso);
			cinemadao.aggiungiFilm(film);
			return new ResponseEntity<String>("Inserimento avvenuto", HttpStatus.OK);
		
		}catch (Exception e) {
			return new ResponseEntity<String>("Aggiornamneto avvenuto", HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(
			value = "Elimina Film")
	public ResponseEntity<String> deleteFilm(@PathVariable int id) {
		try {
			getCinemadao().elimina(id);
			return new ResponseEntity<String>("Eliminazione avvenuta con successo!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Eliminazione NON avvenuta", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "aggiorna un film",
	consumes = "application/json")
	public ResponseEntity<String> aggiorna(@RequestBody FilmDto filmdto, @PathVariable int id){
		try {
			Film film = new Film();
			String incasso = BCrypt.hashpw(filmdto.getIncasso(), BCrypt.gensalt());
			film.setTitolo(filmdto.getTitolo());
			film.setRegista(filmdto.getRegista());
			film.setAnno(filmdto.getAnno());
			film.setGenere(filmdto.getGenere());
			film.setIncasso(incasso);
			return new ResponseEntity<String>("Aggiornamento avvenuto", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Aggiornamento NON avvenuto", HttpStatus.METHOD_FAILURE);
		}
	}
	}

	
	
	
	
	

	
	
		
	
