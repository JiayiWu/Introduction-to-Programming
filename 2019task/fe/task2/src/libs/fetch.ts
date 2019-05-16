const serverOrigin = "http://notebook.fivedreamer.com"
interface InitOption {
  headers?: HeadersInit,
  mode?: RequestMode,
  credentials?: RequestCredentials,
  cache?: RequestCache,
  redirect?: RequestRedirect,
}

interface FetchOption extends InitOption {
  method: string,
  queryParams?: Object, /* GET 参数 */
  body?: BodyInit, /* POST body */
  
}

interface GetOption extends InitOption {
  queryParams?: Object,
}

interface PostOption extends InitOption {
  body?: BodyInit
}
/**
 * 
 * @param {string} url
 * @param {Object} queryParams 
 */
const getRequestUrl = (url, queryParams) => {
  let requestUrl = serverOrigin + url
  if (queryParams) {
    let queryString = ''
    for (let k in queryParams) {
      queryString += `${k}=${queryParams[k]}&`
    }
    queryString = queryString.slice(0, -1)
    requestUrl += `?${queryString}`
  }
  return requestUrl
}
// 默认包含cookie，content-type为json

  const defaultInit = {
    credentials: 'include' as RequestCredentials,
    headers: {
      'Content-Type': 'application/json',
      'Accept': 'application/json'
    },
    method: 'GET'
  }

  /**
   * @param {string} url
   * @param {FetchOption} options
   */
  function myFetch(url: string, options: FetchOption) {
    const {
      queryParams, headers,
    } = options
    let requestUrl = getRequestUrl(url, queryParams)
    const f_headers = {
      'Content-Type': 'application/json',
      ...headers
    }
    return fetch(requestUrl, {
      ...defaultInit,
      ...options,
      ...f_headers
    })
  }

  /**
   * 
   * @param {string} url 
   * @param {GetOption} config 
   */
  function get(url: string, config: GetOption) {
    return myFetch(url, {
      method: 'GET',
      ...config
    })
  }

  /**
   * 
   * @param {string} url 
   * @param {PostOption} config 
   */
  function post (url: string, config: PostOption) {
    return myFetch(url, {
      method: 'POST',
      ...config
    })
  }
// }
export default {
  request: myFetch,
  get,
  post,
}