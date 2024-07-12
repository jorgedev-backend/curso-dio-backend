# Introdução a Java

## Sintaxe

### Tipos Pimitivos

Tipo|Tamanho|Faixa|Valor Padrão|
|--|--|--|--|
|**Inteiros**|
|byte|1 byte|-128 a 127|0|
|short:|2 bytes|-32.768 a 32.767|0|
|int|4 bytes|-2.147.483.648 a 2.147.483.647|0|
|long|8 bytes|-9.223.372.036.854.775.808 a 9.223.372.036.854.775.807|0L|
|**Reais**|
|float|4 bytes|-3,4028E + 38 a 3,4028E + 38|0.0f|
|double|8 bytes|-1,7976E + 308 a 1,7976E + 308|0.0d|
|**Lógico**|
|boolean|1 bit|true / false |false|
|**Literais**|
|char|2 bytes|'\u0000' (ou 0) a '\uffff' (ou 65.535)|'\u0000' (ou 0)|

*O tipo char armazena caracteres Unicode.*

### Operadores

**Atribuição** é representado pelo símbolo de igualdade `=` .

|Simbolo|Função|
|:-------:|------|
|**Aritméticos**|
|`+`|Adição.|
|`-`|Subtração.|
|`*`|Multiplicação.|
|`/`|Divisão.|
|`%`|Modulo "Resto da Divisão".|
|Unários|
|`++`|Incrementa o valor em 1 unidade.|
|`--`|Decrementa o valor em 1 unidade.|
|`-`|Nega um número ou expressão aritmética.|
|`!`|Nega o valor de uma expressão booleana.|
|Relacionais|
|`==`|Verifica a igualdade.|
|`!=`|Verifica a diferença.|
|`>`|Verifica maior que.|
|`>=`|Verificar maior ou igual.|
|`<`|Verificar menor que.|
|`<=`|Verifiar menor ou igual.|

#### Lógicos
`&&`  Operador Lógico "E"

`||` Operador Lógico "OU"

#### Ternário

`? :` >> (Condicional `?` Retorno para Verdadeiro `:` Retorno para Falso).