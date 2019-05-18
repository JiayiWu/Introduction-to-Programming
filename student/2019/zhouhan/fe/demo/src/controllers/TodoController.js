import Controller from "../libs/Controller.js";
import Model from "../libs/Model.js";

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
      activeTodoId: nextId,
      todos: [...data.todos, { id: nextId, title: '请输入标题', content: '请输入内容' }]
    }))
    
  }


  editTodo(){
    const content = this.model.data.todos
    this.model.update(data => ({
      ...data,
      editTF:true
    }))
  }

  saveTodo(){
    let target
    let {todos,activeTodoId}=this.model.data
    for (let i = 0 ; i < todos.length ; i++){
        if (todos[i].id==activeTodoId){
            target = todos[i]
        }
    }
    let input1=document.getElementById('title')
    target.title=input1.value.trim()
    let input2=document.getElementById('content')
    target.content=input2.value.trim()
    this.model.update(data => ({
      ...data,
      editTF:false
    }))
    alert('save successfully!')
  }
}
export default TodoController