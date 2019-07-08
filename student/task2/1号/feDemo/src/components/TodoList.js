import Component from "../libs/Component.js"

class TodoList extends Component {
  render() {
    const { data } = this.model
    return `
      <header>待办清单</header>
      <ol>
        ${data.todos.map(todo => {
          if(todo.visible === false||todo.id===0)return
          else return `
            <li 
              class='todo ${todo.type==='file'?'file':'dir'} ${todo.visible === true ? '' : 'non-visible'} ${(todo.dir_active===true&&todo.type==='dir') ? 'dir_active' : (data.activeTodoId == todo.id ? 'active' : '')}'
              onclick='TodoController.clickTodo(${todo.id})'
            >
              <div>
                <div class='title'>${todo.title}</div>
                <div class='time'>${(todo.type==='title')?(new Date(todo.createTime).toISOString().split("T")[0]):''}</div>
              </div>
              <div class='content'>${todo.type === 'dir' ? 'dir' : todo.content}</div>
            </li>
          `
        }).join('')}
      </ol>
      <footer><p onclick='TodoController.addTodo()'>新建文件</p>/<p onclick='TodoController.addDir()'>新建文件夹</p></footer>
    `
  }
}
export default TodoList