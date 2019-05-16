import Controller from "../libs/Controller.js";
import m_axios from '../libs/fetch.js'

class UserController extends Controller {
  switchMode() {
    this.model.update(data => ({
      ...data,
      isRegister: !data.isRegister
    }))
  }
  async register() {
    const form = document.getElementById('form')
    const formInputs = [...form.getElementsByTagName('input')]
    let formData = {}
    formInputs.forEach((input) => {
      const name = input.getAttribute('name')
      formData[name] = input.value
    })
    if (formData['password'] !== formData['repassword']) {
      // 提示错误信息并返回
      return
    }
    const response = await m_axios.post('/user/account', {
      body: JSON.stringify({
        email: formData.email,
        password: formData.password
      })
    })
    if (response.code === 200) {
      console.log('regist success')
    } else {
      // 提示错误信息
    }
    return
  }
  login() {

  }
}

export default UserController