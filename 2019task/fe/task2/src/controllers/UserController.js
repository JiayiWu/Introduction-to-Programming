import Controller from "../libs/Controller.js";
import Request from '../libs/Request.js'

class UserController extends Controller {
  switchMode() {
    this.model.update(data => ({
      ...data,
      isRegister: !data.isRegister
    }))
  }
  async register() {
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
      })
    })
    if (response.code === 200) {
      console.log('regist success')
      // 成功后处理
    } else {
      alert(response.code)
    }
    return
  }
  login() {

  }
}

export default UserController