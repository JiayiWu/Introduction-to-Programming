import Controller from "../libs/Controller.js";
import Request from '../libs/Request.js'
const json=
  {
    "todos": [
      {
        "id": 1,
        "title": "欢迎1",
        "content": "欢迎1",
        "createTime": 15563047071230,
        "noticeTime": 1556374707123
      },
      {
        "id": 2,
        "title": "欢迎2",
        "content": "欢迎2",
        "createTime": 1556304707123,
        "noticeTime": 1556374707123
      }
    ],
    "activeTodoId": 1,
    "maxTodoId": 2,
    "editing": false,
    
    "user": "09876",
    "isRegister": true
  }

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
      todos: [
        ...data.todos, 
        { 
          id: data.maxTodoId + 1, 
          createTime: cntTime, 
          noticeTime: cntTime, 
          title: '请输入标题', 
          content: '请输入内容' 
        }
      ]
    }))
  }

  editTodo() {
    this.model.update(data => ({
      ...data,
      editing: true
    }))
  }

  saveTodo() {
    const currentData = this.model.data
    const saveTodoIndex = currentData.todos.findIndex(v => v.id == currentData.activeTodoId)
    if (saveTodoIndex >= 0 && currentData.todos[saveTodoIndex]) {
      this.model.update(data => ({
        ...data,
        editing: false,
        todos: data.todos.map((v, i) => i != saveTodoIndex ? v : ({
          ...v,
          title: document.getElementById("EditTitle").value, 
          noticeTime: new Date(document.getElementById("EditNoticeTime").value).getTime(), 
          content: document.getElementById("EditContent").value
        }))
      }))
    }
  }

  deleteTodo(){
    const currentData = this.model.data
    const deleteTodoIndex= currentData.todos.findIndex(v => v.id == currentData.activeTodoId);
    const newActiveTodoId=deleteTodoIndex+1>currentData.maxTodoId?currentData.maxTodoId-1:deleteTodoIndex+1;
    const newTodos=currentData.todos
    .filter(todo=>todo.id-1!==deleteTodoIndex)
    .map((v, i) =>({
      ...v,
      id:i+1
    }))
    this.model.update(data=>({
      ...data,
      maxTodoId:data.maxTodoId-1,
      activeTodoId: newActiveTodoId,
      todos:newTodos
    }))
  }

  async fetchTodoList() {
    //todo
    const response=await Request.get('/session/info');
    if(response.code==0){
      console.log("getResponseSuccess");

      this.model.update(data=>(
        json
      ))
    }else{
      console.log("getResponseFail");
      alert("获取列表失败")
    }
  }
}
export default TodoController