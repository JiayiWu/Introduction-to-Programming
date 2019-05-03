import Model from './libs/Model.js'
import TodoList from './components/TodoList.js';
import TodoDetail from './components/TodoDetail.js';
import TodoController from './controllers/TodoController.js';


const model = new Model()

const todoController = new TodoController('TodoController', model)
const todoList = new TodoList(document.querySelector('#TodoList'), model)
const todoDetail = new TodoDetail(document.querySelector('#TodoDetail'), model)