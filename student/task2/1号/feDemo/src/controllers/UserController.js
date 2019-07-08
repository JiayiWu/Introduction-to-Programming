import Controller from "../libs/Controller.js";
import Request from '../libs/Request.js'
import { todoController } from "../index.js";

class UserController extends Controller {
  switchMode() {
    this.model.update(data => ({
      ...data,
      isRegister: !data.isRegister
    }))
  }
  async register() {
    console.log(todoController.fetchTodoList)
    const form = document.getElementById('loginForm')
    const formInputs = [...form.getElementsByTagName('input')]
    let formData = {}
    formInputs.forEach((input) => {
      const name = input.getAttribute('name')
      formData[name] = input.value
    })

    if(formData['email'] === ''){
      alert('请输入邮箱地址！')
      return 
    }

    //TODO：匹配邮箱是否符合邮箱格式
    function IsEmail(str) {
      var reg=/^\w+@[a-zA-Z0-9]{2,10}(?:\.[a-z]{2,4}){1,3}$/;
      return reg.test(str);
    }

    if(IsEmail(formData['email']) !== true){
      alert('输入的邮箱地址不符合格式！')
      return 
    }

    if(formData['password'] === ''){
      alert('请输入密码！')
      return 
    }
    if (formData['password'] !== formData['repassword']) {
      alert('两次输入密码不一致！')
      return
    }
    const response = await Request.post('/user/account', {
      body: JSON.stringify({
        email: formData.email,
        password: formData.password,
        name:formData.email,
        logoUrl:" "
      }),
    })
    
    if (response.code === 0) {
      console.log('register success')
      alert('注册成功！')
      this.model.update(data => ({
        ...data,
        isRegister: !data.isRegister
      }))
      // 提示注册成功并且跳转到登录，也可以做成注册后自动登录
    } else {
      // 处理错误
      alert(response.data)
    }
    return
  }

  async login() {
    // 获取界面表达数据，请求接口，如果登录成功则关闭弹窗并进入系统
    // 进入系统后，需要向后端获取todolist并修改model
    // 需要调用todoController.fetchTodoList
    let formData = {}
    const form = document.getElementById('loginForm')
    const formInputs = [...form.getElementsByTagName('input')]
    formInputs.forEach((input) => {
      const name = input.getAttribute('name')
      formData[name] = input.value
    })
    //修改以下请求
    const response =await Request.post('/session/create', {
      body: JSON.stringify({
        email: formData.email,
        password: formData.password
      }),
    })
    if(response.code === 0){
      TodoController.fetchTodoList()
      this.model.update(data => ({
        ...data,
        user: formData['email'],
        userId:response.data.id
      }))
    }
    else{
      alert("账号或密码错误，或账号未注册，请检查！")
    }
    
  }
}

export default UserController