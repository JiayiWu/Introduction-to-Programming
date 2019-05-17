
declare interface QueryParams {
  queryParams?: object
}
declare type RequestOptions = QueryParams & RequestInit

declare type Response = {
  code: number,
  data: any
}
declare namespace Request {
  export function request(url: string, options: RequestOptions) : Response
  export function get(url: string, options: RequestOptions) : Response
  export function post(url: string, options: RequestOptions) : Response
}
export default Request