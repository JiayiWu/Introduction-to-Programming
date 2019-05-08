interface Todo {
  id: number | string
  title: string
  content?: string
  createTime?: number
  updateTime?: number
  noticeTime?: number
}
interface User {
  id: number | string
  name: string
  logoUrl: string
  email: string
  password?: string
}
interface ModelData {
  todos: Array<Todo>
  activeTodoId: number
  maxTodoId: number
  editing: boolean
  user?: User
  isRegister: boolean
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