## Q&A
#### Q1:What is fetch?
A1:Fetch API 提供了一个 JavaScript接口，用于**访问和操纵HTTP管道的部分**，例如请求和响应。它还提供了一个全局 fetch()方法，该方法提供了一种**简单，合理的方式来跨网络异步获取资源**。这种功能以前是使用  XMLHttpRequest实现的。Fetch提供了一个更好的替代方法，可以很容易地被其他技术使用，例如 Service Workers。Fetch还提供了单个逻辑位置来定义其他HTTP相关概念，例如CORS和HTTP的扩展。
例如:
```js
fetch('http://example.com/movies.json')
  .then(function(response) {
    return response.json();
  })
  .then(function(myJson) {
    console.log(myJson);
  });
```
#### Q2:Callback and promise, which is preferred when it comes to async operation?
A2：Callback、Promise、async/await的对比如下图所示
![](https://pic1.zhimg.com/80/v2-be8f674422c9f30ffeaee88477ad2c84_hd.png)

我认为Promise会更好一些。callback来控制异步的方式虽然非常简单，但也过于原始。在实际的使用中代码的逻辑顺序和业务的顺序是不相同的，错误控制基本靠手动检查err参数。而到了 Promise 中这种情况好了很多，通过链式调用，Promise 可以直接在 then 中返回一个新的 Promise 来将异步操作串联起来，也有了统一的catch来做错误处理。美中不足的是，你仍然需要传递一个回调函数给 then，通过 then 来串联虽然保证了至少代码顺序上和真正的逻辑顺序一致，但和同步代码的差别仍然很大。
#### Q3:Figure out those concepts: HTTP, HTTP Status Code (200, 401, 403, 404, 500).
A3:Http(HyperText Transfer Protocol)被称为**超文本传输协议**,是一种用于分布式、协作式和超媒体信息系统的应用层协议。HTTP是万维网的数据通信的基础。HTTP是一个客户端（用户）和服务端（网站）之间请求和应答的标准，通常使用TCP协议。通过使用网页浏览器、网络爬虫或者其它的工具，客户端发起一个HTTP请求到服务器上指定端口（默认端口为80）。我们称这个客户端为用户代理程序（user agent）。应答的服务器上存储着一些资源，比如HTML文件和图像。我们称这个应答服务器为源服务器（origin server）。在用户代理和源服务器中间可能存在多个“中间层”，比如代理服务器、网关或者隧道（tunnel）。
以下为HTTP状态码的含义：
- **200:OK**
请求已成功，请求所希望的响应头或数据体将随此响应返回。实际的响应将取决于所使用的请求方法。在GET请求中，响应将包含与请求的资源相对应的实体。在POST请求中，响应将包含描述或操作结果的实体。
- **401:Unauthorized（RFC 7235）**
类似于403 Forbidden，401语义即“未认证”，即用户没有必要的凭据。该状态码表示当前请求需要用户验证。该响应必须包含一个适用于被请求资源的WWW-Authenticate信息头用以询问用户信息。客户端可以重复提交一个包含恰当的Authorization头信息的请求。如果当前请求已经包含了Authorization证书，那么401响应代表着服务器验证已经拒绝了那些证书。如果401响应包含了与前一个响应相同的身份验证询问，且浏览器已经至少尝试了一次验证，那么浏览器应当向用户展示响应中包含的实体信息，因为这个实体信息中可能包含了相关诊断信息。
- **403:Forbidden**
服务器已经理解请求，但是拒绝执行它。与401响应不同的是，身份验证并不能提供任何帮助，而且这个请求也不应该被重复提交。如果这不是一个HEAD请求，而且服务器希望能够讲清楚为何请求不能被执行，那么就应该在实体内描述拒绝的原因。当然服务器也可以返回一个404响应，假如它不希望让客户端获得任何信息。
- **404:Not Found**
日常生活中很常见的情况,即请求失败，请求所希望得到的资源未被在服务器上发现，但允许用户的后续请求。没有信息能够告诉用户这个状况到底是暂时的还是永久的。假如服务器知道情况的话，应当使用410状态码来告知旧资源因为某些内部的配置机制问题，已经永久的不可用，而且没有任何可以跳转的地址。404这个状态码被广泛应用于当服务器不想揭示到底为何请求被拒绝或者没有其他适合的响应可用的情况下。
- **500:Internal Server Error**
通用错误消息，服务器遇到了一个未曾预料的状况，导致了它无法完成对请求的处理。没有给出具体错误信息。
#### Q4:What are the bad/unsatisfying/disturbing parts of this frontend project(for example, why writing just one global css file instead of one for each), and advice on how to improve it or avoid it, or what would you like? list what you have gotten in mind. (not a question, it’s a discussion)
A4：I will come back to do this part when I begin the project.Wait for me!















