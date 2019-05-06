import Controller from "../libs/Controller.js";

class TodoController extends Controller {
  clickTodo(id) {
    this.model.update(data => ({
      ...data,
      activeTodoId: id
    }))
  }

  addTodo() {
    const now=new Date().toDateString()
    const nextId = new Date().valueOf()
    this.model.update(data => ({
      ...data,
      todos: [...data.todos, { id: nextId, title: '请输入标题', content: '请输入内容',createTime:now}]
    }))
  }

  editMode(edit_id,title,content){
    const Detail=document.querySelector('#TodoDetail')
    const id=edit_id
    Detail.innerHTML=`
      <form>
        标题<br>
        <input type="text" id="edit_title" value=${title}><br>
        内容<br>
        <textarea cols=100 rows="20" id="edit_content">${content}</textarea><br>
        <input type="button" value='保存' onclick='TodoController.save(${id})'>
        <input type="button" value='取消' onclick="TodoController.cancel()">
      </form>
    `
  }

  save(edit_id){
    const new_title=document.getElementById("edit_title").value
    const new_content=document.getElementById("edit_content").value
    const modifyTime=new Date().toDateString()
    
    this.model.update(data => ({
      ...data,
      todos:data.todos.map(todo=>({
        title:todo.id===edit_id?new_title:todo.title,
        content:todo.id===edit_id?new_content:todo.content,
        id:todo.id,
        createTime:todo.createTime
      }))
    }))
  }

  cancel(){
    this.model.update(data => data)
  }
}
export default TodoController