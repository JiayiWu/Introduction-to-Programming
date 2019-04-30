import Controller from "../libs/Controller.js";

class TodoController extends Controller {

  clickTodo(id) {
    this.model.update(data => ({
      ...data,
      activeTodoId: id,
      editing: false
    }))
  }

  addTodo() {
    const cntTime = new Date().getTime()
    this.model.update(data => ({
      ...data,
      maxTodoId: data.maxTodoId + 1,
      activeTodoId: data.maxTodoId + 1,
      editing: true,
      todos: [...data.todos, { id: data.maxTodoId + 1, createTime: cntTime, noticeTime: cntTime, title: '请输入标题', content: '请输入内容' }]
    }))
  }

  editTodo() {
    this.model.update(data => ({
      ...data,
      editing: true
    }))
  }

  saveTodo() {
    this.model.update(data => {
      const id = data.activeTodoId - 1
      data.todos[id] = {...data.todos[id], title: document.getElementById("EditTitle").value, noticeTime: new Date(document.getElementById("EditNoticeTime").value).getTime(), content: document.getElementById("EditContent").value}
      data.editing = false
      return data
    })
  }
}
export default TodoController