# mba-gestao-conhecimento

1. [Descrição](#descrição)
2. [Início rápido](#início-rápido)
3. [Arquitetura da Solução](#arquitetura-da-solução)

## Descrição
|  [voltar](#mba-gestao-conhecimento)                      |

O mba-gestao-conhecimento é um projeto contendo os microsserviços que visa organizar a gestão de conhecimento dos colaboradores de TI do BB.

1. Crud de colaboradores que queiram fazer parte da gestão de conhecimentos.
2. Crud de cursos. 
3. Crud de trilhas.

## Início rápido
|  [voltar](#mba-gestao-conhecimento)                      |

Para rodar o projeto, execute os comandos dentro do diretorio criado para o projeto.

Execute o comando abaixo:
``` bash
docker compose-up          
```

Para checar o status da execução:

``` bash
docker-compose ps
```

## Arquitetura da Solução
|  [voltar](#mba-gestao-conhecimento)                      |

[Linguagem] Java 

[Service Dicovery] Eureka é o Service Discovery do Netflix que é usado no Server e no Cliente.

[Banco de dados] Versão 1 com Spring e Mysql e Versão 2 com MongoDB 

[Docker] Containers

[CI/CD] GitHub Actions para entrega contínua.


Swagger:
Gerenciamento de Trilhas - http://0.0.0.0:8010/swagger-ui/index.html#/
Gerenciamento de Cursos - http://0.0.0.0:8020/swagger-ui/index.html#/
Gerenciamento de Colaboradores - http://0.0.0.0:8030/swagger-ui/index.html#/

Spring Eureka - http://localhost:8761/


