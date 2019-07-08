import Controller from "../libs/Controller.js";
import Request from '../libs/Request.js'

class TodoController extends Controller {

  clickTodo(id) {
    //设置文件夹的可见性
    
    let index
    for(let i=1;i<this.model.data.todos.length;i++){
        if(this.model.data.todos[i].id==id){
          index=i
          break
        }
    }
    
    if(this.model.data.todos[index].type==='dir'){
      if(this.model.data.todos[index].dir_active===false){this.model.data.todos[index].dir_active=true}
      else this.model.data.todos[index].dir_active=false
      //设置文件夹内文件的可见性
      if(this.model.data.todos[index].dir_active===false){
        for(let i=index+1;i<this.model.data.todos.length&&this.model.data.todos[i].type!='dir';i++){
        this.model.data.todos[i].visible=false
        }
      }else{
          for(let i=index+1;i<this.model.data.todos.length&&this.model.data.todos[i].type!='dir';i++){
            this.model.data.todos[i].visible=true
        }
      }
    }
    this.model.update(data => ({
      ...data,
      activeTodoId: id,
      editing: false,
    }))
  }

  async addTodo() {
    //let name=prompt("请输入todo的标题",""); 
    //let content=prompt("请输入todo的内容",""); 
    const cntTime = new Date().getTime()
    let dirID
    let index
    for(let i=1;i<this.model.data.todos.length;i++){
      if(this.model.data.todos[i].id==this.model.data.activeTodoId){
        index=i
        break
      }
    }
    dirID=this.model.data.todos[index].dirID
    
    const response =await Request.post('/todo/add/'+dirID, {
      body: JSON.stringify({
      createTime: cntTime, 
      noticeTime: cntTime, 
      title: "标题", 
      content: "内容",
      }),
    })
    if(response.code!==0){
      alert("创建失败！请检查输入的标题和内容是否重复，是否为空")
      return 
    }
    this.model.data.todos.splice(index+1,0,{ 
      id: dirID+'.'+response.data.id, 
      createTime: cntTime, 
      noticeTime: cntTime, 
      title:"标题", 
      content:"内容",
      type:'file',
      dirID:dirID,
      dir_active:false,
      visible:true,
      fileID:response.data.id
    });
    
    this.model.update(data => ({
      ...data,
      activeTodoId: dirID+'.'+response.data.id, 
      editing: true,
      todos: [
        ...data.todos, 
      ]
    }))
  }

  async addDir() {
    //let name=prompt("请输入文件夹的名字",""); 
    const response =await Request.post('/folder/add', {
      body: JSON.stringify({
        name:"请输入名称"
      }),
    })
    if(response.code!==0){
      alert("创建失败！请检查是否有文件夹未命名，请命名后重试！")
      return 
    }
    this.model.data.activeTodoId=response.data.id
    this.model.update(data => ({
      ...data,
      activeTodoId: response.data.id,
      editing: true,
      todos: [
        ...data.todos, 
        { 
          id: response.data.id,
          title: "请输入名称", 
          type:'dir',
          dir_active:true,
          visible:true,
          editing: true,
          dirID:response.data.id
        }
      ]
    }))
  }

  //删除代办事项
  async delTodo(){
    let index
    for(let i=1;i<this.model.data.todos.length;i++){
      if(this.model.data.todos[i].id==this.model.data.activeTodoId){
        index=i
        break
      }
    }
    if(index===1){
      alert("无法删除默认文件夹")
      return 
    }
    if(this.model.data.todos[index].type==='dir'&&this.model.data.todos[index].dir_active===false){
      alert('你不能在文件夹折叠的时候删除文件夹，请先展开文件夹')
      return 
    }
    if(this.model.data.activeTodoId===1){
      alert('默认文件夹不能删除！');
      return
    }

    if(this.model.data.todos[index].type==='dir'){
      if(index!==this.model.data.todos.length-1&&this.model.data.todos[index+1].type==='file'){
        alert("文件夹非空，请清空后再删除!")
        return
      }
      const response =await Request.post('/folder/del', {
        body: JSON.stringify({
          name:this.model.data.todos[index].title
        }),
      })

      if(response.code!==0){
        alert('删除失败')
        return
      }
    }
    
    else if(this.model.data.todos[index].type==='file'){
      const response =await Request.get('/todo/del/'+this.model.data.todos[index].fileID,JSON.stringify({
      }))
      if(response.code!==0){
        alert('删除失败')
        return
      }
    }


    for(let i=1;i<this.model.data.todos.length;i++){
      if(this.model.data.todos[i].id==this.model.data.activeTodoId){
        this.model.data.todos.splice(i,1)
      }
    }
    this.model.update(data => ({
      ...data,
      activeTodoId: 0,
    }))
  }

  editTodo() {
    this.model.update(data => ({
      ...data,
      editing: true
    }))
  }

  async saveTodo() {
    let index
    for(let i=1;i<this.model.data.todos.length;i++){
      if(this.model.data.todos[i].id==this.model.data.activeTodoId){
        index=i
        break
      }
    }
    const currentData = this.model.data
    const saveTodoIndex = currentData.todos.findIndex(v => v.id == currentData.activeTodoId)
    //需要检查
    
    const response =await Request.post('/todo/update/'+this.model.data.todos[index].fileID, {
      body: JSON.stringify({
        title: document.getElementById("EditTitle").value,
        noticeTime: new Date(document.getElementById("EditNoticeTime").value).getTime(), 
        content: document.getElementById("EditContent").value,
        createTime:this.model.data.todos[index].createTime
      }),
    })
    if(response.code!==0){
      alert('保存失败')
      return
    }
    if (saveTodoIndex >= 0 && currentData.todos[saveTodoIndex]) {
      this.model.update(data => ({
        ...data,
        editing: false,
        todos: data.todos.map((v, i) => i != saveTodoIndex ? v : ({
          ...v,
          title: document.getElementById("EditTitle").value, 
          content: document.getElementById("EditContent").value
        }))
      }))
    }
  }

  async saveDir() {
    let index
    for(let i=1;i<this.model.data.todos.length;i++){
      if(this.model.data.todos[i].id==this.model.data.activeTodoId){
        index=i
        break
      }
    }
    const currentData = this.model.data
    const saveTodoIndex = currentData.todos.findIndex(v => v.id == currentData.activeTodoId)
    //需要检查
    const response =await Request.post('/folder/update/'+this.model.data.todos[index].dirID, {
      body: JSON.stringify({
        name: document.getElementById("EditTitle").value,
      }),
    })
    if(response.code!==0){
      alert('保存失败')
      return
    }
    if (saveTodoIndex >= 0 && currentData.todos[saveTodoIndex]) {
      this.model.update(data => ({
        ...data,
        editing: false,
        todos: data.todos.map((v, i) => i != saveTodoIndex ? v : ({
          ...v,
          title: document.getElementById("EditTitle").value, 
          
        }))
      }))
    }
  }

  async fetchTodoList() {
    //从后端获取所有文件夹
    const response =await Request.get('/folder/all', JSON.stringify([{}]))
    
    //从后端获取todolist
    //alert(response.data)
    for(let i=0;i<response.data.length;i++){
      this.model.data.todos.push({
        id: response.data[i].id, 
        title: response.data[i].name, 
        content: '',
        type:'dir',
        dir_active:false,
        visible:true,
        dirID:response.data[i].id,
      })
      const response1 =await Request.get('/todo/'+response.data[i].id, JSON.stringify([{}]))
      for(let t=0;t<response1.data.length;t++){
      this.model.data.todos.push({ 
        id: response.data[i].id+'.'+response1.data[t].id, 
        createTime: response1.data[t].createTime, 
        noticeTime: response1.data[t].noticeTime, 
        title: response1.data[t].title, 
        content: response1.data[t].content,
        type:'file',
        dirID:response1.data[t].folderId,
        visible:false,
        fileID:response1.data[t].id
      });
      }
    }
    if(this.model.data.todos.length===1){
      const response =await Request.post('/folder/add', {
        body: JSON.stringify({
          name:"默认文件夹"
        }),
      })
      this.model.update(data => ({
        ...data,
        activeTodoId: response.data.id,
        editing: true,
        todos: [
          ...data.todos, 
          { 
            id: response.data.id,
            title: "默认文件夹", 
            type:'dir',
            dir_active:true,
            visible:true,
            editing: true,
            dirID:response.data.id
          }
        ]
      }))
    }
    this.model.update(data => ({
      ...data,
      maxTodoId:response.data.length
    }))
  }
}
export default TodoController