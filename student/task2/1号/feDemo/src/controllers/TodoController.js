import Controller from "../libs/Controller.js";

class TodoController extends Controller {

  clickTodo(id) {
    //设置文件夹的可见性
    if(this.model.data.todos[id-1].type==='dir' && this.model.data.todos[id-1].dir_active===false)
    {this.model.data.todos[id-1].dir_active=true}
    else this.model.data.todos[id-1].dir_active=false
    //设置文件夹内文件的可见性
    if(this.model.data.todos[id-1].type==='dir' && this.model.data.todos[id-1].dir_active===false){
      for(let i=id;i<this.model.data.maxTodoId&&this.model.data.todos[i].type!='dir';i++){
        this.model.data.todos[i].visible=false
      }
    }else if(this.model.data.todos[id-1].type==='dir' && this.model.data.todos[id-1].dir_active===true){
      for(let i=id;i<this.model.data.maxTodoId&&this.model.data.todos[i].type!='dir';i++){
        this.model.data.todos[i].visible=true
      }
    }

    this.model.update(data => ({
      ...data,
      activeTodoId: id,
      editing: false,
    }))
  }

  addTodo() {
    const cntTime = new Date().getTime()
    this.model.data.todos.splice(this.model.data.activeTodoId,0,{ 
      id: this.model.data.activeTodoId + 1, 
      createTime: cntTime, 
      noticeTime: cntTime, 
      title: '请输入标题', 
      content: '请输入内容',
      type:'file',
      dir_active:false,
      visible:true
    });
    for(let i=this.model.data.activeTodoId+1;i<=this.model.data.maxTodoId;i++){
      this.model.data.todos[i].id+=1
    }
    this.model.update(data => ({
      ...data,
      maxTodoId: data.maxTodoId + 1,
      activeTodoId: data.activeTodoId + 1,
      editing: true,
      todos: [
        ...data.todos, 
      ]
    }))
  }

  addDir() {
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
          content: '请输入内容',
          type:'dir',
          dir_active:true,
          visible:true
        }
      ]
    }))
  }
  saveData(){
    //商议接口
  }
  //删除代办事项
  delTodo(){
    if(this.model.data.todos[this.model.data.activeTodoId-1].type==='dir'&&this.model.data.todos[this.model.data.activeTodoId-1].dir_active===false){
      alert('你不能在文件夹折叠的时候删除文件夹，请先展开文件夹')
      return 
    }
    if(this.model.data.activeTodoId===1){
      alert('默认文件夹不能删除！');
      return
    }
    let id=this.model.data.activeTodoId
    if(id===1)id=2
    this.model.data.todos.splice(this.model.data.activeTodoId-1,1)
    for(let i=this.model.data.activeTodoId-1;i<this.model.data.maxTodoId-1;i++){
      this.model.data.todos[i].id--
    }
    this.model.data.maxTodoId-=1
    this.model.update(data => ({
      ...data,
      activeTodoId: id-1,
    }))
  }
/*
  changeType(){
    if(this.model.data.todos[this.model.data.activeTodoId-1].type === 'dir'&&this.model.data.todos[this.model.data.activeTodoId-1].dir_active===false){
      alert('你不能在文件夹折叠的时候更换类型，请先展开文件夹')
      return 
    }
    if(this.model.data.todos[this.model.data.activeTodoId-1].type === 'file'){
      this.model.data.todos[this.model.data.activeTodoId-1].type='dir'
      this.model.data.todos[this.model.data.activeTodoId-1].dir_active=true
    }
    else this.model.data.todos[this.model.data.activeTodoId-1].type='file'
    this.model.update(data => ({
      ...data,
    }))
  }
*/
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

  fetchTodoList() {
    //从后端获取todolist
    /*
    const response = Request.post('/folder/all', {
      body: JSON.stringify({
      }),
    })

    for(let i=0;i<response.length;i++){
      this.model.data.todos.push(response[i])
      const responseFile = Request.get('/folder/all', {
        body: JSON.stringify({
        title:response[i].title
        }),
      })
      this.model.data.todos.concat(responseFile)
    }*/

  }
}
export default TodoController