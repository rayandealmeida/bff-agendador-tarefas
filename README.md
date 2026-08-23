# BFF Agendador de Tarefas

BFF desenvolvido em Java com Spring Boot para centralizar a comunicação entre os serviços do sistema de agendamento de tarefas.

Esse projeto faz parte do **Sistema Agendador de Tarefas** e funciona como ponto de entrada para as operações que precisam se comunicar com os outros microsserviços.

## O que ele faz

O BFF realiza a comunicação com os serviços de:

- Usuários
- Agendamento de tarefas
- Notificação por e-mail

A comunicação entre os serviços é feita utilizando **OpenFeign**.

Também existe uma rotina utilizando `@Scheduled` que verifica periodicamente as tarefas que estão próximas do horário definido pelo usuário.

Quando uma tarefa é encontrada, o sistema envia a notificação por e-mail e atualiza o status da tarefa para `NOTIFICADO`.

## Tecnologias

- Java
- Spring Boot
- Spring Cloud OpenFeign
- Spring Scheduling
- Swagger / OpenAPI
- Lombok

## Outros serviços

Esse projeto trabalha em conjunto com os seguintes repositórios:

- [Usuário](https://github.com/rayandealmeida/usuario)
- [Agendador de Tarefas](https://github.com/rayandealmeida/agendador-tarefas)
- [Notificação](https://github.com/rayandealmeida/notificacao)
- [BFF](https://github.com/rayandealmeida/bff-agendador-tarefas)

## Projeto completo

A documentação geral e a arquitetura do sistema estão disponíveis no repositório:

[Sistema Agendador de Tarefas](https://github.com/rayandealmeida/sistema-agendador-tarefas)
