import java.util.Scanner;

class Comparador {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Produto p1 = new Produto();
        Produto p2 = new Produto();

        System.out.println("Produto 1:");
        System.out.print("Nome: ");
        p1.nome = scan.nextLine();
        System.out.print("Embalagem: ");
        p1.embalagem = scan.nextLine();
        System.out.print("Peso: ");
        p1.peso.valor = scan.nextDouble();
        p1.peso.unidade = scan.nextLine();
        System.out.print("Preço: ");
        p1.preco = scan.nextDouble();

        scan.nextLine(); // gambiarra triste!

        System.out.println("Produto 2:");
        System.out.print("Nome: ");
        p2.nome = scan.nextLine();
        System.out.print("Embalagem: ");
        p2.embalagem = scan.nextLine();
        System.out.print("Peso: ");
        p2.peso.valor = scan.nextDouble();
        p2.peso.unidade = scan.nextLine();
        System.out.print("Preço: ");
        p2.preco = scan.nextDouble();

        double cxb1 = p1.custoXbeneficio();
        double cxb2 = p2.custoXbeneficio();

        if (cxb1 < cxb2) {
            System.out.println("É melhor comprar o produto 1, na embalagem " + p1.embalagem + " com " + p1.peso.valor + p1.peso.unidade);
        } else {
            System.out.println("É melhor comprar o produto 2, na embalagem " + p2.embalagem + " com " + p2.peso.valor + p2.peso.unidade);
        }

    }
}