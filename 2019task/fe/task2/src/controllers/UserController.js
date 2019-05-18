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
    if (formData['password'] !== formData['repassword']) {
      alert('两次输入密码不一致！')
      return
    }
    const response = await Request.post('/user/account', {
      body: JSON.stringify({
        email: formData.email,
        password: formData.password
      }),
    })
    // 注册成功的判定由前后端商议
    if (response.code === 200) {
      console.log('register success')
      // 提示注册成功并且跳转到登录，也可以做成注册后自动登录
    } else {
      // 处理错误
      alert(response.data)
    }
    return
  }
  login() {
    // 获取界面表达数据，请求接口，如果登录成功则关闭弹窗并进入系统
    // 进入系统后，需要向后端获取todolist并修改model
    // 需要调用todoController.fetchTodoList
  }
}

export default UserController