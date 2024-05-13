# Git e GitHub

## Configurações básicas de usuário no Git

### Comando Padrão

```
git config
```

Permite visualizar e definir as variáveis de configuração do git. Existem 3 ambientes de configurações possíveis:

| Ambiente | Descrição |
| -------- | --------- |
| **global**| Configurações do usuário atual, ou seja, o usuário do sistema operacional. |
| **system** | Configurações do sistema operacional, ou seja, configuração que aborda todos os usuários do sistema. |
| **local** | Configurações do repositório local, ou seja, é necessario está no endereço do repositorio que deseja configurar no momento do comando.|

A partir daqui todos os comandos serão relacionados ao usuário, portanto, o uso do `global` em todos os comandos é necessário.

#### Definindo Nome de Usuário e E-Mail

```
git config --global user.name "nome_usuario"
```

```
git config --global user.email email@usuario.com
```
Para verificar as configurações atuais basta repetir o comando sem passar os parâmetro de definição:

```
git config --global user.name
git config --global user.email
```
Lembrando que para o uso com o **GitHub** essas configurações serão utilizadas como assinatura para os commits, por tanto, lembre-se de utilizar o nome de usuário e e-mail corretos.

#### Verificando e Definindo a Branch Padrão

Como convensão mais recente no uso do **Git** tem se usado o nome da *Branch padrão* como **main**, para verificar se a sua já está definida dessa maneira, basta executar o seguinte comando:

```
git config --global init.defaultBranch
```

Caso retornado o valor `master`, basta repetir o comando, agora colocando o parâmentro de definição `main` após o `.defaultBranch`, lembre-se de colocar o espaço antes, para que o git indentifique corretamente.

Para verificar todas as configurações atualmente definidas, use o seguinte comando:

```
git config --global --list
```
Lembre-se de utilizar o ambiente que deseja verificar, nesse caso foi utilizado o **global**, mas poderia ser **system** ou **local** e caso nada informado, será retornado todas as configurações independente de ambiente.

### Configurando Credenciais de Acesso

Para essa etapa é necessário de uma conta no **GitHub** para realizar as devidas configurações "também necessário a criação de um repositório privado". Por ele vai ser possível realizar todos os próximos comandos de maneira eficiente.

O **GitHub** permite algumas maneiras de autenticar acesso a repositórios, os mais usados são os Tokens e as chaves SSH. Para criação de Tokens use a seguinte documentação: [Criação de Tokens](https://docs.github.com/pt/authentication/keeping-your-account-and-data-secure/managing-your-personal-access-tokens) e para a criação de chaves SSH, utilize a seguinte documentação: [Gerando chave SSH](https://docs.github.com/pt/authentication/connecting-to-github-with-ssh/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent).

#### Token
A partir do Token gerado, utilizamos o seguinte comando, para salvar a credencial no sistema e evitar que seja necessário autenticar cada uma das próximas interações com o GitHub. Lembrando também que no momento de geração do **Token** é quando iremos definir quais acessos aquele token possuirá e por quanto tempo ele será válido. Após o uso do comando a próxima credencial utilizada será armazenada.

```
git config --global credential.helper store
```
Note, o ultimo parâmentro do comando é `store` que define que essa crendencial será armazenada pelo SO, contudo como também passamos o `--global` será disponível apenas para o usuário atual. 

Caso esteja utilizando um computador que não seja de uso pessoal e não queira armazernar essa credential após o uso do computador, é possível utilizar o parâmentro `cache` que irá apagar a credential a partir do fim da sessão.

Como se trata de uma credencial local, ela será mantida pelo gerenciador padrão do seu sistema, no caso do Windows é possível acessar pelo seguinte caminho:

Painel de Controle > Contas de Usuário > Gerenciador de Credenciais > Credenciais do Windows.

#### SSH

Todos os comandos que aqui agora serão demonstrados sobre a geração e gerenciamento de chaves SSH, também já foram explicados na documentação informada anteriormente, aqui apenas demonstrarei a maneira a qual entendi as suas utlizações, por tanto, serve como complemento caso não tenha entendido pela própria documentação.

Antes de explicar os comandos, faço uma breve explicação de como funciona chaves SSH. Principio básico de criptografia assimétrica onde se utiliza um par de chaves distintas: uma chave pública e uma chave privada. A chave pública é usada para criptografar dados, enquanto a chave privada é usada para descriptografar. Isso permite comunicações seguras sem que as partes precisem compartilhar suas chaves secretas. Para mais informações sobre criptografia MATA, Lucas fez um ótimo artigo de introdução sobre o tema: [Criptografia: entendendo as diferenças entre simétrica, assimétrica e homomórfica.](https://www.alura.com.br/artigos/criptografia-diferencas-simetrica-assimetrica-homomorfica)