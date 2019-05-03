class Component {
  
  /**
   * @type {HTMLDivElement}
   */
  container
  /**
   * @type {Model}
   */
  model

  /**
   * 
   * @param {HTMLDivElement} container 
   * @param {*} controller 
   * @param {Model} model 
   */
  constructor(container, model) {
    this.container = container
    this.model = model
    //渲染函数（不OVERRIDE会报错，这种方法真的厉害）
    this.model.subscribe(() => {
      const html = this.render()
      this.container.innerHTML = html
    })
  }

  render() {
    throw new Error('lifecycle function render should be overrided')
  }
}

export default Component