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

Antes de explicar os comandos, faço uma breve explicação de como funciona chaves SSH. Principio básico de criptografia assimétrica onde se utiliza um par de chaves distintas: uma chave pública e uma chave privada. A chave pública é usada para criptografar dados, enquanto a chave privada é usada para descriptografar. Isso permite comunicações seguras sem que as partes precisem compartilhar suas chaves secretas. Para mais informações sobre criptografia: MATA, Lucas fez um ótimo artigo de introdução sobre o tema: [Criptografia: entendendo as diferenças entre simétrica, assimétrica e homomórfica.](https://www.alura.com.br/artigos/criptografia-diferencas-simetrica-assimetrica-homomorfica)

Antes de começarmos a gerar as chaves, vamos verificar se já existem chaves presentes no usuário. 

Abra o Git Bash:

*Prefira abrir diretamente pelo S.O. e não por uma pasta, isso irá garantir que ele seja aberto diretamente na pasta home do usuário.*
```
ls -a ~/.ssh
```
Esse comando vai permitir que verifiquemos na pasta home do usuário se há arquivos de chaves mesmo que estejam ocultos. Caso existam, alguns dos seguintes arquivos irão ser retornandos ao usuário:

- id_rsa.pub
- id_ecdsa.pub
- id_ed25519.pub

Considerando que você não recebeu nenhum retorno, a próxima etapa seria:
```
ssh-keygen -t ed25519 -C "email@usuario.com"
```
Esse comando vai permitir gerar um conjunto de chave SSH, e também vai ser possivel especificar qual o algoritmo usado para isso, nesse caso foi passado o parâmetro **-t** que permite especificar. Também foi passado o parâmetro **-C** que utilizado para adicionar um comentário, que nesse caso foi usado para identificar o proprietário da chave.

Ao executar o comando irão ser solicitados algumas informações, elas são: O local para armazenamento das chaves (como convenção as chaves ficam na pasta home do usuário); Passphrase que seria algo semelhante a uma senha.

```
eval "$(ssh-agent -s)"
```
Usado para inciar o ssh-agent, que é um gerenciador de chaves privadas SSH que facilita o processo de autenticação sem a necessidade de digitar a senha da chave privada repetidamente.

```
ssh-add ~/.ssh/id_ed25519
```
Esse comando vai permitir que adicionemos a chave que foi gerada anteriomente ao **ssh-agent** para isso é necessário informar o endereço da chave, então caso não tenha deixado no diretorio padrão, basta informa o endereço correto. Lembrando que agora também será solicitado o passphrase que você informou antes para as chaves. 

Por fim, basta colocar a chave publica na sua conta do **GitHub** para isso acesse o arquivo da chave, então se tiver seguido todos os passos até aqui ela estará no seguinte endereço: **~/.ssh** e o nome do arquivo: **id_ed25519.pub**. Você pode utilizar o programa **Concatenate** via terminal pelo próprio git bash para acessar esse conteúdo, nesse caso basta usar o seguinte comando:
```
cat ~/.ssh/id_ed25519.pub
```
Copie todo o conteúdo e cole no **GitHub**. Caso não tenha achado, o caminho é o seguinte: Settings -> SSH and GPG keys -> New SSH key. Coloque o nome da chave mantenha a opção de **Authentication Key** e cole o conteúdo na opção de key.

## Comandos básicos de Versionamento

### Criando e Clonando Repositórios

```
git init
```
Inicializa um repositório git na pasta atual.

```
git clone 'URL'
```
Clona repositório remoto **GitHub** usando a **URL**, ou seja, com o **HTTPS** ou **SSH**. (as aspas simples não são necessárias no comando, foram usadas apenas para indicar que a URL é algo mutável) Lembrando que para os repositórios privados vai ser necessário ter as credenciais de acesso respectiva. É possível também que no momento do comando seja alterado o nome da pasta que deseja colocar localmente no lugar do nome da pasta clone raiz, esse nome é colocado após um espaço depois da URL.
```
git remote add origin 'URL'
```
Define uma conexão entre um repositório local e um repositório remoto, o nome padrão para identificar essa conexão é **origin**.
```
git remote -v
```
Retorna os endereços de fetch e push de conexão do repositório atual.

### Gerenciando Alterações no Repositório Local

```
git status
```
Retorna qual o estados do arquivos no diretorio que foi executado o comando, para esses estados há uma lista abaixo explicando cada um deles:

#### Estados de Arquivos

- **Untracked**
(não é acompanhado pelo git)
- **Tracked**
(é acompanhado pelo git e possuirá "subestados")
  - **Unmodified**
  (não houve mudanças no arquivo desde da última versão)
  - **Modified**
  (houve mudanças no arquivo desde da última versão)
  - **Staged**
  (todas as mudanças foram registradas e o arquivo se encontra pronto para fazer commit)

Todos os estados anteriores servem para gerenciar os arquivos na hora de realizar um commit e os colocar em posição de fazer parte ou não desse commit e ainda ajudar a ter uma visão do que foi alterado.

```
git add nome_arquivo/nome_pasta
```
Usado para adicionar arquivos e pastas **untracked** e **modified** para **staged**. É possível usar o parâmentro " . " para adicionar tudo que estão nos estado citados anteriormente, lembrando que isso é válido para o diretório que foi executado o comando.

```
git commit -m"descrição do commit"
```
Cria um commit com os arquivos adicionandos a **Stage-area**, ou seja, todos os arquivos listado com o estado **staged**. O parâmetro " **-m** " é usado para permitir que seja adicionado a descrição ao commit.

```
git log
```
Retorna o histórico de commit realizados com data e autor.

Quando se trata do controle de arquivos para realização de commits dois arquivos são bastante utilizados, são eles: **.gitignore** usado para informar ao git quais arquivos e pastas devem ser ignorados quando for ser realizado uma verificação usando o *git status* e para realizar adição a lista de ignorados é necessario adicionar os endereços dentro do arquivo; O outro é **.gitkeep**, usado como convesão para a adição de pastas vazia no git, já que o git não rastreia pastas vazias, por tanto, cria-se esse arquivo dentro da pasta que deseja adicionar.