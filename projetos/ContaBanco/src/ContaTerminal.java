import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        int numeroConta;
        String agencia;
        String nomeCliente;
        double saldo;

        System.out.print("Por favor, digite o número da conta: ");
        numeroConta = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Por favor, agora digite qual a agencia: ");
        agencia = scanner.next();
        scanner.nextLine();

        System.out.print("Por favor, agora digite o nome do(a) clinte: ");
        nomeCliente = scanner.nextLine();

        System.out.print("Por favor, para finalizar, digite o saldo da conta: ");
        saldo = scanner.nextDouble();

        scanner.close();

        System.out.println("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco," +
                " sua agencia é " + agencia + ", conta " + numeroConta + " e seu saldo " + saldo + " já está disponível para saque.");
    }
}
