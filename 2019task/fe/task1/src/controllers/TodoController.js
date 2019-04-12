import Controller from "../libs/Controller.js";

class TodoController extends Controller {

  clickTodo(id) {
    this.model.update(data => ({
      ...data,
      activeTodoId: id
    }))
  }

  addTodo() {
    const nextId = new Date().valueOf()
    this.model.update(data => ({
      ...data,
      todos: [...data.todos, { id: nextId, title: '请输入标题', content: '请输入内容' }]
    }))
  }
}
export default TodoController