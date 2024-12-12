# LabSeqExercise
A robust REST API built with Java and Spring Boot to calculate and retrieve values of the LabSeq sequence.

# Nome do Projeto

Uma breve descrição do que seu projeto faz e qual problema ele resolve.

## Tecnologias Utilizadas

- **Java** 
- **Spring Boot** 
- **Docker**
- **Angular** 

## Pré-requisitos

Antes de começar, você precisará ter instalado em sua máquina:

- [Docker](https://docs.docker.com/get-docker/)
- [Git](https://git-scm.com/downloads)
- IDE (Intellij ou VSCode)

## Clonando o Repositório

Clone este repositório para sua máquina local usando o seguinte comando:

```bash
git clone https://github.com/lucasrissy/LabSeqExercise.git
cd LabSeqExercise

Antes de construir a imagem Docker, você precisa gerar um arquivo JAR da aplicação. Para isso, execute o seguinte comando na raiz do projeto:
bash
mvn clean package

Apos isso, para construir a imagem Docker do seu projeto, execute o seguinte comando na raiz do projeto (onde está localizado o Dockerfile):
docker build -t nome_da_imagem .

docker run -d -p 8080:8080 nome_da_imagem

A aplicação ela está situada na seguinta porta
http://localhost:4200

