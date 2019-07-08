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