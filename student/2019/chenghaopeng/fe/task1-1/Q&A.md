1. why we need to install the module 'chalk' but 'fs' has the immunity
    
    因为fs是nodejs的核心模块，而chalk是一个可选的插件

2. why 'node .' and 'npm run start' means the same in this project

    package.json里定义了'start'脚本为'node .'

3. what's promise and async-await

    promise是用于处理异步的同步操作，解决回调问题。

    async修饰一个函数，表示这个函数是async函数，这类函数里可以有await用来等待promise返回结果才会继续执行

4. what should we take into consideration when use 'The Minimax Algorithm'

    分数的计算方式、搜索的层数