API de Veículos
A API de Veículos permite realizar operações CRUD (Create, Read, Update, Delete) em registros de veículos.

Requisitos para Testar a API:
 - git clone https://github.com/JoseJulioDev/apiveiculos.git 
 - Banco de Dados: Crie um banco de dados com o nome api-veiculos. Esta API utiliza PostgreSQL por padrão, mas você pode alterar as configurações no arquivo application.properties para um banco de dados de sua preferência. Caso altere, verifique se a configuração da entidade Veiculo está correta para essa mudança.
 - Instalação de Dependências: Execute o comando mvn clean install para baixar todas as dependências necessárias para iniciar a API.
 - Inicialização da API: Inicie a API. Ao iniciar, a tabela veiculo será criada automaticamente.
   
Swagger da api
 - http://localhost:8080/swagger-ui/index.html#/ 

Aqui está os endpoints da API:

  GET /veiculos: Retorna todos os veículos cadastrados.
  GET /veiculos/{id}: Retorna um veículo específico pelo ID.
  POST /veiculos: Cadastra um novo veículo.
  PUT /veiculos/{id}: Atualiza um veículo existente pelo ID.
  DELETE /veiculos/{id}: Exclui um veículo pelo ID.
  GET /veiculos/nao-vendidos: Retorna a quantidade de veículos não vendidos.
  GET /veiculos/por-decada: Retorna a quantidade de veículos agrupados por década.
  GET /veiculos/por-fabricante: Retorna a quantidade de veículos agrupados por fabricante.
  GET /veiculos/registrados-ultima-semana: Retorna os veículos registrados na última semana.

URL base da API: http://localhost:8080
