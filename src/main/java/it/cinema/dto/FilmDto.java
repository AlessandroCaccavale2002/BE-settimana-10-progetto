package it.cinema.dto;

public class FilmDto {

	private int id;
	private String titolo;
    private int anno;
    private String regista;
    private String tipo;
    private String genere;
    private String incasso;

    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public int getAnno() {
        return anno;
    }
    public void setAnno(int anno) {
        this.anno = anno;
    }
    public String getRegista() {
        return regista;
    }
    public void setRegista(String regista) {
        this.regista = regista;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getGenere() {
    	return genere;
    }
    public void setGenere(String genere) {
    	this.genere = genere;
    }
    public String getIncasso() {
        return incasso;
    }
    public void setIncasso(String incasso) {
        this.incasso = incasso;
    }
}


