import Component from "../libs/Component.js"

class TodoList extends Component {
  render() {
    const { data } = this.model
    return `
      <header>Todo List</header>
      <ol>
        ${data.todos.map(todo => {
          return `
            <li 
              class='todo ${data.activeTodoId === todo.id ? 'active' : ''}'
              onclick='TodoController.clickTodo(${todo.id})'
            >
              <div>
                <div class='title'>${todo.title}</div>
                <div class='time'>${new Date(todo.createTime).toISOString().split("T")[0]}</div>
              </div>
              <div class='content'>${todo.content}</div>
            </li>
          `
        }).join('')}
      </ol>
      <button type='button' onclick='UserController.logout()'>LOGOUT</button>
      <footer onclick='TodoController.addTodo()'>+</footer>
    `
  }
}

export default TodoList