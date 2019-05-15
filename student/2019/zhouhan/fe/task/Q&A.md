（我都不知道改用什么语言回答）
#  why we need to install the module 'chalk' but 'fs' has the immunity：
    因为node.js自带了fs模块，而chalk则是第三方的插件，需要从外部安装导入。
# why 'node .' and 'npm run start' means the same in this project:
    因为在package.json中的script中预定义了start：'node .'
    运行项目使用npm run start,就相当于使用了'node .'来运行本文件夹的项目
# what's promise and async-await：
    promise：
            Promise 是异步编程的一种解决方案，比传统方案——回调函数和事件——更合理和更强大。它由社区最早提出和实现，ES6 将其写入了语言标准， 统一了用法，原生提供了 Promise 对象。
    async-await:
            async/await是一个用同步思维解决异步问题的方案（等结果出来之后，代码才会继续往下执行）
# what should we take into consideration when use 'The Minimax Algorithm':
    控制决策树深度？使用Alpha-Beta剪枝算法？