package model;

import java.time.LocalDate;

public class Emprestimo {

    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private boolean devolvido;

    //Constructor
    public Emprestimo(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucaoPrevista = dataEmprestimo.plusDays(15);
        this.devolvido = false;
    }

    //Getters and Setters
    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void marcarComoDevolvido() {
        devolvido = true;
    }
    
    //toString
    public String mostrarInformacoes() {
        return "Livro: " + livro.getTitulo() +
               "\nUsuário: " + usuario.getNome() +
               "\nData do empréstimo: " + dataEmprestimo +
               "\nDevolução prevista: " + dataDevolucaoPrevista +
               "\nDevolvido: " + (devolvido ? "Sim" : "Não");
    }
    
}