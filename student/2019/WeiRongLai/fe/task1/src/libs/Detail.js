class Detail{
    //借用学长的代码
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
      //每次调用get函数得到新的activeId
      const html = this.render(this.model.getActiveTodo())
      this.container.innerHTML = html
    })
  }

  render(todo) {
    throw new Error('lifecycle function render should be overrided')
  }


  
}

export default Detail