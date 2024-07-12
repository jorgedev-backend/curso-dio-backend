# Projetos Concluídos

## Conta Banco

Desafio proposto: 

1.  Criar um novo projeto ContaBanco
2.  Criar uma classe ContaTerminal
3.  Declarar os seguintes atributos 
  
|Atributo|Tipo|Exemplo|
|--------|----|-------| 
|Numero|Inteiro|1021|
|Agencia|Texto|067-8|
|Nome Cliente|Texto|MARIO ANDRADE|
|Saldo|Decimal|237.48|

- Numero: optei por usar `int` com o nome de `numeroConta`, que me pareceu mais coerente.
- Agencia: optei por usar `String` e mantive o nome `agencia`.
- Nome Cliente: optei por `String` novamente e com o nome de `nomeCliente`.
- Saldo: optei por usar `double` e mantive o nome `saldo`.

### Problema Enfrentado

Acabei por ter um problema com uso do Scanner devido ao método nextInt() não consomir a nova linha após o número. 
Para corrigir isso, adicionei uma chamada extra a nextLine() logo após nextInt() para consumir a nova linha pendente o mesmo foi realizado para next().

Também foi adicionado uma pequena trativa de erro dentro da inserção de dado do tipo `double`, utilizando uma condição de não inserção de um tipo `double`: 
``` Java
while (!scanner.hasNextDouble()){
    System.out.println("Entrada inválida. Por favor, insira um número válido para o saldo.");
    scanner.next();
    System.out.print("Por favor, para finalizar, digite o saldo da conta: ");
}
```
O uso do `scanner.next()` consome uma entrada inválida caso seja passado.