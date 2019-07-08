import Component from "../libs/Component.js"

class TodoList extends Component {
  render() {
    const { data } = this.model
    return `
      <header>Todo List</header>
      <div class='logout' onclick='UserController.logout()'>logout</div>
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
      <footer onclick='TodoController.addTodo()'>+</footer>
    `
  }
}

export default TodoList
