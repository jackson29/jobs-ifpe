class Produto {
    String nome;
    String embalagem;
    Peso peso;
    double preco;

    Produto() {
        // System.out.println("criando um produto!!");
        this.peso = new Peso();
    }

    Produto(String nome) {
        this.nome = nome;
        this.peso = new Peso();
    }

    double custoXbeneficio() {
        return this.preco / this.peso.valor;
    }
}