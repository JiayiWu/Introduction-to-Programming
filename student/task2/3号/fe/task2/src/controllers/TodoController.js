import Controller from "../libs/Controller.js";

class TodoController extends Controller {


  clickTodo(id) {
    this.model.update(data => ({
      ...data,
      activeTodoId: id,
      editing: false
    }))
    console.log(id);
  }

  async addTodo() {
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
    console.log(this.model.data.activeTodoId);
    const currentData = this.model.data;
    const newTodoIndex = currentData.todos.findIndex(v => v.id == currentData.activeTodoId);
    const newTodo=currentData.todos[newTodoIndex];
    const response = await Request.post('/todolist/add', {
      body: JSON.stringify({
        id: newTodo.id,
        number:0,
        user:{
              id:newTodo.user.id,
              name:newTodo.user.name,
              password:newTodo.user.password,
              email:newTodo.user.email,
              logoUrl:newTodo.user.logoUrl
            },
        title: newTodo.title,
        content: newTodo.content,
        createTime: newTodo.createTime,
        noticeTime: newTodo.noticeTime,
        
      }),
    })
    if(response.code===0){
      console.log("data added")
    }
    else{
      console.log("data adding failed")
    }

  }

  editTodo() {
    this.model.update(data => ({
      ...data,
      editing: true
    }))
  }

  async delTodo(){
    const currentActiveTodoId= this.model.data.activeTodoId;
    //删到最后一个时
    if(this.model.data.todos.length===1){
      this.addTodo();
      this.model.data.todos.splice(0,1)
      this.model.update(data => ({
        ...data,
        todos:this.model.data.todos
        
      }))
    }

    //没删到最后一个
    const todoIndex = this.model.data.todos.findIndex(v => v.id == this.model.data.activeTodoId);
    this.model.data.todos.splice(todoIndex,1);
    this.model.update(data => ({
      ...data,
      editing: false,
      todos:this.model.data.todos,
      activeTodoId:data.todos[0].id
    }))

    const response = await Request.post(`/todolist/remove/${currentActiveTodoId}`);
    if(response.code===0){
      console.log("data deleted");
    }
    else{
      console.log("data deleting failed");
    }
  
  }

  async saveTodo() {
    const currentData = this.model.data;
    const saveTodoIndex = currentData.todos.findIndex(v => v.id == currentData.activeTodoId);
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

      const savedTodo=this.model.data.todos[saveTodoIndex];
      const response = await Request.post('/todolist/edit', {
        body: JSON.stringify({
          id:savedTodo.id,
          number:0,
          user:{
            id:savedTodo.user.id,
            name:savedTodo.user.name,
            password:savedTodo.user.password,
            email:savedTodo.user.email,
            logoUrl:savedTodo.user.logoUrl
          },
          title: savedTodo.title,
          content: savedTodo.content,
          createTime: savedTodo.createTime,
          noticeTime: savedTodo.noticeTime
        }),
      })
      if(response.code===0){
        console.log("data edited")
      }
      else{
        console.log("data editing failed")
      }
    }
  }

  async fetchTodoList() {
    const user=this.model.data.user;
    const response=await Request.get('/todolist/get',{
      body: JSON.stringify({
        id:user.id,
        name:user.name,
        password:null,
        email:user.email,
        logoUrl:user.logoUrl
      }),
    });
    if(response.code===0){
      console.log("data received");
      this.model.update(data=>({
        ...data,
        activeTodoId:1,
        // activeDirId: 0,
        maxTodoId:response.data.todoEntities.length,
        todos:response.data.todoEntities,
        // dirs:response.data.dirEntities
      }))
    }else{
      alert("获取列表失败")
    }
  }

  
}
export default TodoController