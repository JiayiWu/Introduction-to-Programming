class Detail{
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
    this.model.subscribe(() => {
      const html = this.render(this.model.getActiveTodo())
      this.container.innerHTML = html
    })
  }
  render(todo) {
    throw new Error('lifecycle function render should be overrided')
  }
}

export default Detail