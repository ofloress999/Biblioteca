package controllers;

import java.util.ArrayList;
import java.util.List;
import model.Emprestimo;
import model.Livro;
import model.Usuario;

public class BibliotecaController {
    private List<Livro> livros;
    private List<Usuario> usuarios;
    private List<Emprestimo> emprestimos;
    
    //Constructor
    public BibliotecaController() {
        livros = new ArrayList<>();
        usuarios = new ArrayList<>();
        emprestimos = new ArrayList<>();
    }
    
    
    //Methods
    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }
    
    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
    
    public boolean emprestarLivro(Livro livro, Usuario usuario) {
        if(livro.emprestar()) {
            Emprestimo emprestimo = new Emprestimo(livro, usuario);
            emprestimos.add(emprestimo);
            return true;
        }
        return false;
    }
    
    public boolean devolverLivro(Emprestimo emprestimo) {
        if(!emprestimo.isDevolvido()) {
            emprestimo.marcarComoDevolvido();
            emprestimo.getLivro().devolver();
            return true;
        }
        return false;
    }
    
    //Getters and Setters
    public List<Livro> getLivros() {
    return livros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
    

}
