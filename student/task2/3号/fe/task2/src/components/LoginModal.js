import Component from "../libs/Component.js"

class LoginModal extends Component {
  render() {
    const { data } = this.model
    if (data.user) { console.log(data.user); return '' }
    return `
      <div class="ModalWrapper">
        <div class="Modal">
          <header><span>T</span>odo</header>
          <form id="loginForm">
            <div><label>邮箱</label><div><input name="email"/></div></div>
            <div><label>密码</label><div><input name="password" type="password"/></div></div>
            ${data.isRegister ? `<div><label>确认密码</label><div><input name="repassword" type="password"/></div></div>` : ''}
          </form>
          <footer>
            <button onclick='UserController.switchMode()'>${data.isRegister ? '我要登录' : '我要注册'}</button>
            <button onclick=${data.isRegister ? 'UserController.register()' : 'UserController.login()'}>${data.isRegister ? '注册' : '登录'}</button>
          </footer>
        </div>
      </div>
    `
  }
}

export default LoginModal