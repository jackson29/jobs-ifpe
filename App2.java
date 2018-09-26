class Pessoa {
    private String nome;

    public Pessoa() {
        System.out.println("criando uma pessoa!");
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

class Usuario extends Pessoa {
    public Usuario() {
        System.out.println("criando um usuário =)");
    }
}

class App2 {
    public static void main(String[] args) {
        Pessoa laine = new Pessoa();
        System.out.println("--");
        Pessoa doidinho = new Pessoa();
        System.out.println("--");
        Pessoa arranhador = new Usuario();
    }
}