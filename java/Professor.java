package app;

public class Professor extends Pessoa {
   
    public Turma ArrayListe[];

    Professor(Pessoa pessoa; Turma ArrayListe[]){
    	this.id = pessoa.id;
	    this.nome = pessoa.nome;
	    this.cpf = pessoa.cpf;
	    this.endereco = pessoa.endereco;
    	this.ArrayListe = ArrayListe;

    }
    Professor(int id; String nome; String cpf; Endereco endereco; Turma ArrayListe){
    	this.id = pessoa.id;
    	this.nome = pessoa.nome;
    	this.cpf = pessoa.cpf;
    	this.Endereco = pessoa.endereco;
    	this.Turma ArrayListe = ArrayListe;
    }
    
    
}