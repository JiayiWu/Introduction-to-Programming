import Detail from '../libs/Detail.js'
class TodoDetail extends Detail{
    render(todo){
        const {title,content,createTime,id}=todo[0]
        return `
			<br>
            <center >${title}</center><br>
            <div class='createTime'>创建日期：${createTime}</div><br>
            <div class='content'>${content}</div><br>
            <button type='button' onclick='TodoController.editMode(${id},"${title}","${content}")'>编辑</button>
        `
    }
}
export default TodoDetail