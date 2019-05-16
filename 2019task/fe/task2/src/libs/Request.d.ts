
declare interface InitOption {
  headers?: HeadersInit,
  mode?: RequestMode,
  credentials?: RequestCredentials,
  cache?: RequestCache,
  redirect?: RequestRedirect,
}

declare interface FetchOption extends InitOption {
  method: string,
  queryParams?: Object, /* GET 参数 */
  body?: BodyInit, /* POST body */
  
}

declare interface GetOption extends InitOption {
  queryParams?: Object,
}

declare interface PostOption extends InitOption {
  body?: BodyInit
}