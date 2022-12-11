# Projeto Final - SISALERTACONSULTA

## Introdução

O príncipal objetivo deste projeto é gerenciar consultas e exames médicos, onde a pessoa pode cadastrar toda a sua fámilia e ter um acesso rápido as consultas e exames que ainda estão por vir.

![página principal do sistema de consulta médica.](/image/sisalertaindex.png)

## Projeto

O projeto foi desenvolvido com spring framework e thymeleaf.

### Dependencias do Projeto

* JDK
* mariadb (banco de dados)
* Maven
    * webjars jquery
    * webjars bootstrap
    * springframework
    * thymeleaf
    * h2database
    * mariadb jdbc
    
### Configuração para conexão no banco de dados relacional

* Adicionar dependências (Spring Data JPA, H2, MariaDB JDBC Driver)
* Configurar a conexão da aplicação com o banco de dados no arquivo application.properties

###### Exemplo: 

`
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.datasource.url=jdbc:mariadb://localhost:3306/sisalertaconsulta
spring.datasource.username=SECRETO
spring.datasource.password=ULTRA_SECRETO
`

### Executar a aplicação

* Baixar extesao Spring Boot Dashboard no VSCODE.

![Instalar extensao Spring Boot  Dashboard no VSCODE.](/image/sample.png)

* Acionar Spring Boot Dashboard no menu lateral.

![Acionar Spring Boot Dashboard no menu lateral.](/image/sample.png)

* Clicar no icone de Play do lado do nome sisalertaconsulta.

![Clicar no icone de Play do lado do nome sisalertaconsulta.](/image/sample.png)