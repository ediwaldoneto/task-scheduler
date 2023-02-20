Task Scheduler
Descrição
Esse é um projeto de exemplo de um agendador de tarefas em Java utilizando Spring Boot. Ele permite a criação de tarefas agendadas, que são executadas em horários específicos, além de registrar logs de execução das tarefas.

Tecnologias utilizadas
Java 11
Spring Boot 2.5.5
HikariCP 4.0.3
MySQL 8.0.27
Maven 3.8.3
Configuração do Banco de Dados
A aplicação utiliza o banco de dados MySQL. É necessário ter o servidor do banco de dados instalado e configurado. Para configurar a conexão com o banco, basta modificar as propriedades no arquivo application.properties.

Como executar o projeto
Para executar o projeto, basta clonar o repositório e executar o seguinte comando na raiz do projeto:

Copy code
mvn spring-boot:run
