package it.cinema.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "film")
@Entity
@NamedQuery(name = "findByRegista", query = "SELECT f FROM Film f where f.regista = :regista")
@NamedQuery(name = "findAll", query = "SELECT f FROM film f")
public class Film  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String titolo;
	private int anno;
	private String incasso;
	private String genere;	
	private String regista;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "titolo")
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	@Column(name = "anno")
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	@Column(name = "incasso")
	public String getIncasso() {
		return incasso;
	}
	public void setIncasso(String incasso) {
		this.incasso = incasso;
	}
	@Column(name = "genere")
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	@Column(name = "regista")
	public String getRegista() {
		return regista;
	}
	public void setRegista(String regista) {
		this.regista = regista;
	}
	
	

}
