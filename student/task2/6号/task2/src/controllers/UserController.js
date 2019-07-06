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
  getLoginFormData(){
    const form = document.getElementById('loginForm')
    const formInputs = [...form.getElementsByTagName('input')]
    let formData = {}
    formInputs.forEach((input) => {
      const name = input.getAttribute('name')
      formData[name] = input.value
    })
    return formData
  }
  async register() {
    console.log(todoController.fetchTodoList)
    const formData=this.getLoginFormData()
    if (formData['password'] !== formData['repassword']) {
      alert('两次输入密码不一致！')
      return
    }
    const response = await Request.post('/user/account', {
      body: JSON.stringify({
        email: formData.email,
        password: formData.password,
        name: formData.email
      }),
    })
    // 注册成功的判定由前后端商议
    if (response.code === 0) {
      console.log('register success')
      // 提示注册成功并且跳转到登录，也可以做成注册后自动登录
      alert('注册成功，自动登陆');
      // this.switchMode();
      this.login();
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
    const formData=this.getLoginFormData()
    const responce=await Request.post('/session/create',{
      body:JSON.stringify({
        email:formData.email,
        password:formData.password
      }),
    });
    if(responce.code===0){
      console.log('登陆成功');
      console.log('todoController.fetchTodoList')
      todoController.fetchAccountInfo()
      // todoController.fetchTodoList()
      // this.switchMode()
    }else{
      alert('登陆失败');
    }
  }
  async logout(){
    const responce=await Request.post('/session/destroy');
    if(responce.code==0){
      console.log('logoutSuccess')
      this.model.update(data=>({
        ...data,
        user:null
      }))
    }else{
      alert("登出失败")
    }
  }
}

export default UserController