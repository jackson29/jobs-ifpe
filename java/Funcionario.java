package app;

public class Funcionario extends Pessoa {
    
    public String funcao;

    Funcionario(Pessoa pessoa; String nome){
    	this.id = pessoa.id;
	    this.nome = pessoa.nome;
	    this.cpf = pessoa.cpf;
	    this.endereco = pessoa.endereco;
    	this.nome = nome;
    }
   Funcionario(int id; String nome; String cpf; Endereco endereco; String matri){
      this.numero = numero;
      this.nome = nome;
      this.cpf = cpf;
      this.endereco = endereco;
      this.matricula = matri;

   }
}