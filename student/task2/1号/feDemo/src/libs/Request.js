 /**
  * @typedef { Object } FetchExpand
  * @property { Object } queryParams
  * @property { Object } body
  * 
  * @typedef { RequestInit & FetchExpand } FetchOption
  */

/**
 * @typedef { Object } GetExpand
 * @property { Object } queryParams
 * 
 * @typedef { RequestInit & GetExpand } GetOption
 */

/**
 * @typedef { Object } PostExpand
 * @property { Object } body 
 * 
 * @typedef { RequestInit & PostExpand } PostOption
 */

const serverOrigin = "http://notebook.fivedreamer.com"

/**
 * 
 * @param { string } url
 * @param { object } queryParams 
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

// 默认包含cookie，content-type为json，方法为GET
const defaultInit = {
  credentials: 'include',
  headers: {
    'Content-Type': 'application/json',
    'Accept': 'application/json'
  },
  method: 'GET'
}

/**
 * @param { string } url
 * @param { RequestInit } options
 */
function myFetch(url, options) {
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
  }).then(res => res.json())
}

  /**
   * 
   * @param { string } url 
   * @param { GetOption } config
   */
  function get(url, config) {
    return myFetch(url, {
      method: 'GET',
      ...config
    })
  }

  /**
   * 
   * @param { string } url 
   * @param { PostOption } config 
   */
  function post (url, config) {
    return myFetch(url, {
      method: 'POST',
      ...config
    })
  }
/**
 * @typedef { Object } Request
 * @property {(url: string, option: FetchOption) => any} request
 */
const Request = {
  request: myFetch,
  get,
  post,
}
export default Request