import Component from "../libs/Component.js"

class TodoList extends Component {
  //用model的数据重写HTML（map函数，箭头函数用的很妙）
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
                <div class='time'>${todo.createTime}</div>
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