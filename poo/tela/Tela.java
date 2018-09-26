class Tela {
    float brilho;
    boolean ligada;
}

class Celular {
    // ...
    Botao botao;
    Tela tela;

    void ligarTela() {
        this.tela.luz = 100;
        this.tela.ligado = true;
    }

    void desligarTela() {
        this.tela.luz = 0;
        this.tela.ligado = false;
    }
}

class Botao {
    Celular celularPai;

    void pressionar() {
        if (this.celularPai.tela.ligado == true) {
            this.celularPai.desligarTela();
        } else {
            this.celularPai.ligarTela();
        }
    }
}

class App {
    public static void main(String args[]) {
        Celular c;
        c.botao.pressionar();
    }
}