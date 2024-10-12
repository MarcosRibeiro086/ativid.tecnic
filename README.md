Descrição Geral

O Gerenciador de Tarefas é uma aplicação web desenvolvida com JavaServer Faces (JSF) e JPA (Java Persistence API) para facilitar a criação, edição, remoção e visualização de tarefas. O sistema permite que os usuários gerenciem suas atividades diárias de forma organizada e eficiente, categorizando-as por título, descrição, responsável, prioridade e data de vencimento. O projeto é construído sobre o banco de dados PostgreSQL, onde os dados das tarefas são armazenados e gerenciados.

Principais Funcionalidades

Criar Tarefa: Os usuários podem adicionar novas tarefas, fornecendo informações essenciais como título, descrição, responsável, prioridade e data de vencimento.

Atualizar Tarefa: É possível editar os detalhes de uma tarefa existente, permitindo que as informações sejam atualizadas conforme necessário.

Remover Tarefa: Os usuários podem excluir tarefas que não são mais relevantes ou necessárias.

Listar Tarefas: A aplicação exibe uma lista de todas as tarefas registradas, com a opção de filtrar as tarefas com base em critérios específicos.

Marcar Tarefa como Concluída: Os usuários têm a capacidade de marcar uma tarefa como concluída, o que a retira da lista de tarefas ativas, permitindo um melhor gerenciamento das atividades.

Estrutura da Aplicação

A aplicação é dividida em várias partes principais:

Modelo (Model): Contém as classes que representam os dados e a estrutura do banco de dados (por exemplo, Task).

Acesso a Dados (DAO): Classes que gerenciam a interação com o banco de dados, fornecendo métodos para criar, ler, atualizar e excluir tarefas (por exemplo, TaskDAO).

Beans Gerenciados: Contêm a lógica da aplicação e interagem com a interface do usuário. Os beans são usados para manipular dados e responder às ações do usuário (por exemplo, TaskBean).

Páginas JSF: Contêm o código HTML e as marcações JSF que definem a interface do usuário. Elas utilizam componentes JSF para interagir com os beans gerenciados.

Endpoints da Aplicação

Embora a aplicação JSF não tenha endpoints REST convencionais como em uma API RESTful, podemos descrever as ações e interações principais que ocorrem na aplicação. Em vez de usar URLs de endpoints, a aplicação JSF utiliza páginas e ações que são mapeadas por meio de métodos nos beans gerenciados.

Ações e Correspondências
Página Inicial de Tarefas:

URL: /pages/tasks.xhtml
Ação: Carrega a lista de tarefas usando o método getTasks() do TaskBean e permite a criação de novas tarefas.
Criar Tarefa:

Ação: Ao preencher o formulário e enviar (submit), o método createTask() do TaskBean é chamado, o que salva a nova tarefa no banco de dados.
Editar Tarefa:

Ação: Quando um usuário escolhe editar uma tarefa, o método editTask(Task task) é chamado, carregando os dados da tarefa selecionada no formulário. Após edições, o método taskDAO.update(task) é chamado para persistir as mudanças.
Remover Tarefa:

Ação: O usuário pode excluir uma tarefa clicando em um botão de remoção. O método deleteTask(Task task) é chamado, que utiliza taskDAO.delete(task.getId()) para remover a tarefa do banco de dados.
Marcar como Concluída:

Ação: A tarefa pode ser marcada como concluída através de uma ação no botão na interface, que altera o estado completed da tarefa e atualiza o banco de dados.
