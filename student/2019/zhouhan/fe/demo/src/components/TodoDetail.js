// todo
import Component from "../libs/Component.js"

class TodoDetail extends Component {
  render() {
    const { activeTodoId,todos,editTF } = this.model.data
    let target
    for (let i = 0 ; i < todos.length ; i++){
        if (todos[i].id==activeTodoId){
            target = todos[i]
        }
    }
    let buttonEdit =`
        <button
            onclick='TodoController.editTodo()'
        >edit</button>`

    let buttonSave =`
        <button
                onclick='TodoController.saveTodo()'>save
        </button>`

    return `
    <div>
        <textarea id='title'
        style="width: 100%"
        ${editTF?"":"disabled='disabled'"}>
            ${target.title}
        </textarea>
    </div>

    <div>
        <textarea id='content'
        style="width: 100%"
        ${editTF?"":"disabled='disabled'"}>
            ${target.content}
        </textarea>
    </div>

    <div>
        ${target.createTime}
    </div>
    
    <div>
        ${editTF?buttonSave:buttonEdit}
    </div>
    `
  }
}

export default TodoDetail