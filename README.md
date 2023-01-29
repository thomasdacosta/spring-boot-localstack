# Spring Boot com Localstack

Vamos criar uma aplicação com Spring Boot que funciona com os recursos do LocalStack e da AWS. Iremos mostrar passo a passo como criar e configurar a aplicação do ZERO.

![](https://img.youtube.com/vi/Vlmjw5nifOo/0.jpg)

## Video do YouTube:

[Vídeo do YouTube](https://www.youtube.com/watch?v=Vlmjw5nifOo)

## Capítulos do Video:

00:00 Introdução<br/>
00:31 O que é o Spring Cloud?<br/>
01:31 Qual versão usar do Spring Cloud em seu projeto Spring Boot?<br/>
03:01 Qual versão usar do Spring Cloud AWS em seu projeto Spring Boot?<br/>
03:41 Criando o projeto com Spring Initializr<br/>
05:46 Gerando o projeto e descompactando<br/>
06:19 Abrindo o projeto na IDE<br/>
08:15 Incluindo as dependências do Spring Cloud e Spring Cloud AWS<br/>
11:16 Incluindo a dependência do AWS Parameter Store<br/>
12:45 Criando o arquivo bootstrap.yml<br/>
15:20 Ajustando o application.properties<br/>
15:53 Incluindo o profile localstack para a inicialização do Spring Boot<br/>
16:55 O que é um profile no Spring Boot?<br/>
17:52 Criando o docker-compose.yml do LocalStack<br/>
19:09 Inicializando o LocalStack<br/>
21:03 Criando a configuração do Parameter Store no LocalStack<br/>
24:44 Executando a aplicação<br/>
26:55 Criando a classe de configuração<br/>
29:31 Criando a classe Controller<br/>
32:33 Executando a aplicação para o teste final<br/>
33:24 Executando o teste no Insomnia<br/>
34:43 EASTER EGG!!!!<br/>

## Passo a Passo para criar e configurar o projeto

- Gerar projeto no Spring Initialzr
  - Nome: spring-boot-localstack
- Incluir dependência do Spring Cloud AWS:
```
<dependency>
    <groupId>io.awspring.cloud</groupId>
    <artifactId>spring-cloud-aws-dependencies</artifactId>
    <version>${spring.cloud-aws}</version>
    <type>pom</type>
    <scope>import</scope>
</dependency>
```
- Incluir versão do Spring Cloud AWS no properties:
```
<spring.cloud-aws>2.4.2</spring.cloud-aws>
```
- Incluir dependência do Spring Cloud AWS Starter:
```
<dependency>
    <groupId>io.awspring.cloud</groupId>
    <artifactId>spring-cloud-starter-aws</artifactId>
</dependency>
```        
- Incluir dependência do Spring Cloud Starter Bootstrap:
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-bootstrap</artifactId>
</dependency>
```
- Incluir dependência do Parameter Store:
```
<dependency>
    <groupId>io.awspring.cloud</groupId>
    <artifactId>spring-cloud-starter-aws-parameter-store-config</artifactId>
</dependency>
```
- Incluir bootstrap.yml:
```
spring:
  application:
    name: spring-boot-localstack
---
spring:
  config:
    activate:
      on-profile: localstack
aws:
  paramstore:
    enabled: true
    endpoint: http://localhost:4566
```
- Atualizar application.properties:
```
### Server
server.port=8080

### Log
logging.file.path=@logs.path@
logging.path=@logs.path@

### Proxy
proxy.host=
proxy.port=
proxy.enabled=

### Spring
server.error.whitelabel.enabled=false
spring.mvc.throw-exception-if-no-handler-found=true
spring.web.resources.add-mappings=false
management.endpoints.web.exposure.include=health, info

### Info
info.app.name=@artifactId@
info.app.version=@version@
info.app.description=@name@
info.app.contact=thomasdacosta@gmail.com
info.app.ip=${spring.cloud.client.ip-address}
info.app.profile=${spring.profiles.active}

### AWS
s3.bucket=awslocalstack
```
- Adicionar na inicialização o profile do localstack
- Incluir docker-compose.yml do LocalStack na aplicação:
```
version: "3.8"

services:
  localstack:
    container_name: "${LOCALSTACK_DOCKER_NAME-localstack_main}"
    image: localstack/localstack
    ports:
      - "127.0.0.1:4566:4566"            # LocalStack Gateway
      - "127.0.0.1:4510-4559:4510-4559"  # external services port range
    environment:
      - DEBUG=${DEBUG-}
      - LAMBDA_EXECUTOR=${LAMBDA_EXECUTOR-}
      - DOCKER_HOST=unix:///var/run/docker.sock
    volumes:
      - "${LOCALSTACK_VOLUME_DIR:-./volume}:/var/lib/localstack"
      - "/var/run/docker.sock:/var/run/docker.sock"
```
- Inicializar LocalStack
- Incluir diretório de log no pom.xml:
```
<logs.path>./logs</logs.path>
```
- Criar uma configuração no Parameter Store:
```
@echo off
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/spring-boot-localstack_localstack/helloWorld" --value "Hello World Parameter Store" --type String
```
- Executar aplicação
- Criar classe para obter configuração do Parameter Store
- Criar classe de Controller
- Executar aplicação
- Executar no Insomnia

---
Thomás da Costa - [https://thomasdacosta.com.br](https://thomasdacosta.com.br)
