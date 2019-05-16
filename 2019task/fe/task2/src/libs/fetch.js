var __assign = (this && this.__assign) || function () {
    __assign = Object.assign || function(t) {
        for (var s, i = 1, n = arguments.length; i < n; i++) {
            s = arguments[i];
            for (var p in s) if (Object.prototype.hasOwnProperty.call(s, p))
                t[p] = s[p];
        }
        return t;
    };
    return __assign.apply(this, arguments);
};
var serverOrigin = "http://notebook.fivedreamer.com";
var getRequestUrl = function (url, queryParams) {
    var requestUrl = serverOrigin + url;
    if (queryParams) {
        var queryString = '';
        for (var k in queryParams) {
            queryString += k + "=" + queryParams[k] + "&";
        }
        queryString = queryString.slice(0, -1);
        requestUrl += "?" + queryString;
    }
    return requestUrl;
};
var defaultInit = {
    credentials: 'include',
    headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json'
    },
    method: 'GET'
};
function myFetch(url, options) {
    var queryParams = options.queryParams, headers = options.headers;
    var requestUrl = getRequestUrl(url, queryParams);
    var f_headers = __assign({ 'Content-Type': 'application/json' }, headers);
    return fetch(requestUrl, __assign({}, defaultInit, options, f_headers));
}
function get(url, config) {
    return myFetch(url, __assign({ method: 'GET' }, config));
}
function post(url, config) {
    return myFetch(url, __assign({ method: 'POST' }, config));
}
export default {
    request: myFetch,
    get: get,
    post: post
};
