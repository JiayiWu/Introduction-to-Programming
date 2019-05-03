import Controller from "../libs/Controller.js";

class TodoController extends Controller {
  //更新model的activeTodoId
  clickTodo(id) {
    this.model.update(data => ({
      ...data,
      activeTodoId: id
    }))
  }
  //增加model的todo
  addTodo() {
    const now=new Date().toDateString()
    const nextId = new Date().valueOf()
    this.model.update(data => ({
      ...data,
      todos: [...data.todos, { id: nextId, title: '请输入标题', content: '请输入内容',createTime:now}]
    }))
  }

  //进入编辑模式
  editMode(edit_id){
    const Detail=document.querySelector('#TodoDetail')
    const id=edit_id
    Detail.innerHTML=`
      <form>
        Title<br>
        <input type="text" id="edit_title"><br>s
        Content<br>
        <textarea cols=50 id="edit_content"></textarea><br>
        <input type="button" value='save' onclick='TodoController.save(${id})'>
        <input type="button" value='cancel' onclick="TodoController.cancel()">
      </form>
    `
  }

  //保存数据
  save(edit_id){
    const new_title=document.getElementById("edit_title").value
    const new_content=document.getElementById("edit_content").value
    const modifyTime=new Date().toDateString()
    //map返回新的array，原array不变
    
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

  //取消编辑
  cancel(){
    this.model.update(data => data)
  }
}
export default TodoController