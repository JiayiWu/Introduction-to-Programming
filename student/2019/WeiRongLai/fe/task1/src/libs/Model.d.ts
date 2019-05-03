interface Todo {
  id: number | string
  title: string
  content?: string
  createTime?: string
  updateTime?: string
  noticeTime?: string
}
interface ModelData {
  todos: Array<Todo>
  activeTodoId: number
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