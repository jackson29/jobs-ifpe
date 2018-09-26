import java.util.Scanner;



class Moeda {
    int real;
    int centavo;

    public String toString() {
        return "R$" + this.real + "," + String.format("%02d", this.centavo);
    }
}

class OpMoeda {
    public static Moeda soma(Moeda m1, Moeda m2) {
        Moeda ret = new Moeda();
        ret.centavo = m1.centavo + m2.centavo;
        ret.real = m1.real + m2.real;
        if (ret.centavo >= 100) {
            ret.real++;
            ret.centavo -= 100;
        }

        return ret;
    }

    public static Moeda subtracao(Moeda m1, Moeda m2) {
        return null;
    }

    public static Moeda multiplicacao(Moeda m, int v) {
        return null;
    }
}

class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Valor 1:");
        Moeda m1 = new Moeda();
        m1.real = scan.nextInt();
        m1.centavo = scan.nextInt();

        System.out.println("Valor 2:");
        Moeda m2 = new Moeda();
        m2.real = scan.nextInt();
        m2.centavo = scan.nextInt();

        System.out.println("Soma dos valores: ");
        Moeda soma = OpMoeda.soma(m1, m2);
        System.out.println(soma);
    }
}