class Controller {
  /**
   * @type {Model}
   */
  model
  /**
   * 
   * @param {string} namespace 
   * @param {Model} model 
   */
  constructor(namespace, model) {
    this.model = model
    window[namespace] = this
  }
}

export default Controller