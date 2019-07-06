import Component from "../libs/Component.js"

class TodoDetail extends Component{
  render(){
    const { data } = this.model
    if(data.user===null){
      return`
      <header>用户名:</header>
      `}
    if(data.activeTodoId===0){
      return`
      <header>用户名:${data.user}</header>
      `
    }
    const todo = data.todos[data.activeTodoId - 1]
    return `
      <header>用户名:${data.user}</header>
      <div class='details'>
        <div class='detail'>
        <p class='itemkey'>Type</p>
        <p>${todo.type}</p>
        </div>
        <div class='detail'>
          <p class='itemkey'>Title</p>
          ${
            data.editing?
            `<input id='EditTitle' class='EditText' type='text' value='${todo.title}'>`
            :`<p class='itemvalue'>${todo.title}</p>`
          }
        </div>
        <div class='detail'>
          <p class='itemkey'>CreateTime</p>
          <p class='itemvalue'>${new Date(todo.createTime).toString()}</p>
        </div>
        <div class='detail'>
          <p class='itemkey'>NoticeTime</p>
          ${
            data.editing?
            `<input id='EditNoticeTime' class='EditDateTime' type='datetime-local' value='${new Date(todo.noticeTime + 8 * 3600 * 1000).toISOString().split(".")[0]}'>`
            :`<p class='itemvalue'>${new Date(todo.noticeTime).toString()}</p>`
          }
        </div>
        <div class='detail'>
          <p class='itemkey'>${todo.type==='file' ? 'Content' : data.user}</p>
          ${
            todo.type==='file'?(
            data.editing?
            `<textarea id='EditContent' class='EditTextArea'>${todo.content}</textarea>`
            :`<p class='itemvalue'>${todo.content.replace(/\n/g, "<br>")}</p>`):`<a id='EditContent'></a>`
          }
        </div>
        <div><Button onclick='TodoController.delTodo()'>Delect</p></div>
      </div>
      ${
        data.editing?
        `<footer onclick='TodoController.saveTodo()'>Save</footer>`
        :`<footer onclick='TodoController.editTodo()'>Edit</footer>`
      }
    `
  }
}

export default TodoDetail