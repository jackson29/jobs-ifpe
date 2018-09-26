class Pessoa {
    Garrafa garrafa;

    void abrirGarrafa() {
        this.garrafa.abrir();
    }

    void abrirGarrafa(Garrafa garrafa) {
        garrafa.abrir();
    }

    void fecharGarrafa() {
        this.garrafa.fechar();
    }

    void adicionarGarrafa(String cor) {
        this.garrafa = new Garrafa(cor);
    }
}

class Garrafa {
    String cor;
    boolean tampaFechada;

    Garrafa() {
        this.cor = "transparente";
        this.tampaFechada = true;
    }

    Garrafa(String cor) {
        this.cor = cor;
        this.tampaFechada = true;
    }

    void abrir() {
        this.tampaFechada = false;
    }

    void fechar() {
        this.tampaFechada = true;
    }
}

class App {
    public static void main(String[] args) {
        Pessoa ranieri = new Pessoa();
        ranieri.adicionarGarrafa("transparente");
        System.out.println("Cor da garrafa de ranieri: " + ranieri.garrafa.cor);
    }
}