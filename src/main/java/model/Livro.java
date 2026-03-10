package model;

public class Livro {
    private String titulo;
    private String autor;
    private int anoLancamento;
    private boolean disponivel;

    //Constructor
    public Livro(String titulo, String autor, int anoLancamento) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoLancamento = anoLancamento;
        this.disponivel = true;
    }
    
    //Methods
    public boolean emprestar() {
        if(this.disponivel) {
            this.disponivel = false;
            return true;
        }
        
        return false;
    }
    
    public boolean devolver() {
        if(!this.disponivel) {
            this.disponivel = true;
            return true;
        }
        return false;
    }
    
    //Getters and Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    
    
    
    
}
