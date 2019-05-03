import Detail from '../libs/Detail.js'
class TodoDetail extends Detail{
    render(todo){
        const {title,content,createTime,id}=todo[0]
        return `
            <head>${title}</head>
            <div class='createTime'>${createTime}</div>
            <div class='content'>${content}</div>
            <button type='button' onclick='TodoController.editMode(${id})'>编辑</button>
        `
    }
}

export default TodoDetail