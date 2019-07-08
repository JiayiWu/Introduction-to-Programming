# Answers

## 1.Fetch

fetch是基于promise,代替XMLHttpRequest,用来异步跨网获取资源的接口。可以使用promise的then，catch，简洁方便。


## 2.Callback and Promise
在异步执行中，promise更好，因为它可以避免回调的魔鬼嵌套，将执行代码和结果处理代码清楚地分离开，更为简洁，甚至可以伪装成同步的样子。

## 3.HTTP & HTTP Status Code
HTTP，超文本传输协议。由请求（Request）（如这次用到的POST，GET）和响应（Response）（包括状态码和请求的资源）组成。
200, ok，请求成功
400，Bad Request，语法错误，理解不能
401, 请求未经授权
403, 收到请求，但是我拒绝  提供服务
404, 请求资源不存在
500， 服务器未知错误
第一位是2表示成功，4为客户端错误，5为服务器端错误。

## 4.more
data结构有点让人难受，todo、文件夹都有一个user，data自己还有一个user，之后应该会调整。
id的设置让人更难受，因为前后端选择了每次只传输改变部分，而不是每次都整体更新，于是todo删除时不适宜重新递增分配todo的id，也就是id会不断增加，有恒心的话或许可以让它溢出（？）
体会到沟通好接口的重要性。