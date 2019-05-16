"use strict";
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
exports.__esModule = true;
var serverOrigin = "http://notebook.fivedreamer.com";
/**
 *
 * @param {string} url
 * @param {Object} queryParams
 */
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
// 默认包含cookie，content-type为json
var defaultInit = {
    credentials: 'include',
    headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json'
    },
    method: 'GET'
};
/**
 * @param {string} url
 * @param {FetchOption} options
 */
function myFetch(url, options) {
    var queryParams = options.queryParams, headers = options.headers;
    var requestUrl = getRequestUrl(url, queryParams);
    var f_headers = __assign({ 'Content-Type': 'application/json' }, headers);
    return fetch(requestUrl, __assign({}, defaultInit, options, f_headers));
}
/**
 *
 * @param {string} url
 * @param {GetOption} config
 */
function get(url, config) {
    return myFetch(url, __assign({ method: 'GET' }, config));
}
/**
 *
 * @param {string} url
 * @param {PostOption} config
 */
function post(url, config) {
    return myFetch(url, __assign({ method: 'POST' }, config));
}
// }
exports["default"] = {
    request: myFetch,
    get: get,
    post: post
};
