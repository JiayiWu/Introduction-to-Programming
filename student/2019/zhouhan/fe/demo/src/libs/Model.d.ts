interface Todo {
  id: number | string
  title: string
  content?: string
  createTime?: number
  updateTime?: number
}
interface ModelData {
  todos: Array<Todo>
  activeTodoId: number,
  editTF: boolean
}
interface SubscribeFn {
  (data: ModelData): void 
}
interface UpdateFn {
  (data: ModelData): ModelData 
}

declare class Model {

  readonly data: ModelData
  private subscribeFns: Array<SubscribeFn>

  update: (fn: UpdateFn) => void

  subscribe: (fn: SubscribeFn) => void
}