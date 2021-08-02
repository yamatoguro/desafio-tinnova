# Desafio Tinnova

## Exercícios
Para execução de cada exercício, com excessão do [Veículos](#veiculos), deve se executar a classe Main.java presente na raíz do repositório. Está presente um menu simples na console que finaliza a execução do programa ao receber a opção 0.

- [Eleição](#eleicao)
- [Bubble Sort](#bubble)
- [Fatorial](#fatorial)
- [Múltiplos](#multiplos)
- [Veículos](#veiculos)

## Eleição <a name = "eleicao"></a>
Uma classe que verifica uma eleição conforme os dados recebidos, são 4 parâmetros recebidos, sendo eles Total de eleitores, votos em branco, votos válidos e votols nulos, e retorna um cálculo de percentual de cada um dos tipos de votos em relação ao total de eleitores.

## Bubble Sort <a name = "bubble"></a>
Uma classe que organiza um vetor conforme o algoritmo Bubble Sort, já amplamente documentado e validado.

## Fatorial <a name = "fatorial"></a>
Uma classe que calcula o fatorial do número recebido, cálculo feito de forma recursiva.

## Múltiplos <a name = "multiplos"></a>
Uma classe que calcula a soma de todos os múltiplos de 3 e 5 menores que o valor recebido.

## Aplicação Veículos <a name = "veiculos"></a>
## Conteúdos
- [Funcionalidades](#about)
- [Endpoints](#endpoints)
- [Considerações](#consideracoes)

## Sobre <a name = "about"></a>
A aplicação consiste no controle de veículos em uma concessionária (suponho), o usuário pode cadastrar, atualizar, pesquisar e excluir veículos. Para tanto o usuário consulta através de uma lista e os cadastra ou edita através de um formulário simples. A deleção e a seleção do veículo a ser modificado acontece por meio de um botão presente na listagem.

## Endpoints <a name = "endpoints"></a>
Também podem ser verificados e testados através do Swagger 2 presente no contexto /swagger-ui.html
```
VeiculoController
├─@method GET /veiculos
│    └─@return Obter todos os veículos
│
├─@method GET /veiculos/{id}
│    └─@return Obter um veiculo por ID
│
├─@method GET /veiculos/find
│    └─@param termo de pesquisa
│    └─@return Obter veículos em que o termo aparece no modelo, marca ou descrição
│
├─@method POST /veiculos
│    └─@return Inserir um novo veiculo
│
├─@method PUT /veiculos/{id}
│    └─@param ano (obrigatório)
│    └─@param descricao (obrigatório)
│    └─@param id (obrigatório)
│    └─@param marca (obrigatório)
│    └─@param modelo (obrigatório)
│    └─@param vendido (obrigatório)
│    └─@return Alterar todos os dados de um veiculo
│
├─@method PATCH /veiculos/{id}
│    └─@param ano
│    └─@param descricao
│    └─@param id (obrigatório)
│    └─@param marca
│    └─@param modelo
│    └─@param vendido
│    └─@return Alterar alguns os dados de um veiculo
│
└─@method DELETE /veiculos/{id}
    └─@param id (obrigatório)
    └─@return Excluir um veiculo
```
## Considerações <a name = "consideracoes"></a>

### Compile & Run

Para gerenciamento das dependências foi usado o Maven, API desenvolvida em Spring Boot e frontend em Angular.
Para executar a aplicação não será necessário um banco de dados instalado na máquina, a aplicação cuida disso através do H2.
Para o back-end os comandos necessários para execução serão:
```
~/desafio-tinnova/desafio-tinnova-back$ mvn clean install
~/desafio-tinnova/desafio-tinnova-back$ mvn spring-boot:run
```
Para o front-end os comandos necessários para execução serão:
```
~/desafio-tinnova/desafio-tinnova-front$ npm install
~/desafio-tinnova/desafio-tinnova-front$ npm start
```

### Uso

#### Cadastro e Edição

O cadastro e a edição acontecem por meio de um formulário simples com os campos que podem ser editados pelo usuário

```
veiculo
• Marca - String
• Modelo - String
• Ano - Integer
• Descrição - String
• Vendido - Boolean
```

#### Deleção

Para excluir um veiculo basta clicar no botão presente na listagem

### Considerações Finais
#### O desafio foi feito no tempo livre entre faculdade e trabalho, por isso demorou a ser concluído, mas houveram algumas dificuldades conceituais como os totalizadores que foram pedidos na tela inicial, questões de folha de estilo no front e passagem de parâmetros para o back, mas vencidas estas dificuldades o desafio se encontra concluído. Apenas uma observação sobre o que não foi feito, a correção de nomes de marcas e veículos não está validada em momento algum da aplicação. Infelizmente fiquei sem ideias para fazer tal coisa, chegando ao ponto de ter um enum de quase 4200 entradas para tal, mas acabei desistindo por consumir mais tempo que as partes de fato complexas na aplicação. Agradeço a oportunidade.
---

- Iago Faria dos Reis
- oiago@hotmail.com
- +55 61 99935-4110