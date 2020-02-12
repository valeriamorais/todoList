# Projeto de Exemplo de uso de Sring Boot com React
Este exemplo tem como objetivo criar um aplicativo de tarefas com a opção de incluir, deletar e alterar tarefas e sub tarefas.

#### Backlog
- eu como usuário desejo cadastrar tarefas
- eu como usuário desejo remover tarefas
- eu como usuário desejo alterar tarefas
- eu como usuário desejo visualizar as tarefas criadas.
- eu como usuário desejo cadastrar sub tarefas
- eu como usuário desejo remover sub tarefas
- eu como usuário desejo alterar sub tarefas
- eu como usuário desejo visualizar as sub tarefas criadas.


### Protótipo

Tela Tarefas
![prototipo-todolist](https://user-images.githubusercontent.com/44953877/74271220-46f97300-4ceb-11ea-84ff-b1ed01d7922c.png)

Tela Sub Tarefas
![prototipo-todoList02](https://user-images.githubusercontent.com/44953877/74272197-fa169c00-4cec-11ea-9a24-7e73fb4a9679.png)

### Arquitetura

A aplicação está dividida em camadas (MVC)

Model - Spring
View - React 
Controller - Spring

Para esse exemplo, foi criado microserviços com suas próprias camadas: Model, Controller e Repository.

O front-end usando React está dentro da página index.html, que chama o Spring RESTful endpoint que gera um JSON da aplicação na View.
