# Desafio Tinnova
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