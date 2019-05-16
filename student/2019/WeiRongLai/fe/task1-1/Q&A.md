# Q & A

（可以参考[note.md](note.md)文件中的关于介绍）
1. >**Q**:why we need to install the module 'chalk' but 'fs' has the immunity

    **A**:安装chalk模块能改变字体的颜色，有效的区分对弈双方，fs是用来读写文件的。fs是node自带的包，chalk是需要通过npm包管理系统从官网上下载下来才能用的。（此处的immunity是指免除的意思吗？网上查的意思感觉都不太对，题目没理解好,不好意思。）

2. >**Q**:why 'node .' and 'npm run start' means the same in this project

    **A**:本文件中的**package.json**的**script**下写有"**start：node .**",使用npm run start时，创建一个shell，并在其中执行脚本命令，此处执行"node .",所以一样。

3. >**Q**:what's promise and async-await

    **A**:promise和async-awiat都是用来异步处理的。async是一个异步函数，通过awiat处理返回的promise对象。promise用来解决回调地狱的问题，通过链式调用，方便的处理异常状态等。

4. >what should we take into consideration when use 'The Minimax Algorithm'
    **A**:应该有合理的估值函数，同时考虑到算法的执行效率，必要时使用Alpha-beta剪枝(此处的算法暂未研究透彻)

# 个人问题
1.[Game.js](Game.js)中160行中promise对象的参数resolve是什么函数？
2.[Game.js](Game.js)中168行handleuserkey函数的第一个参数是什么？
3.[Game.js](Game.js)中initOnFirstRound函数的process是node中的模块吧，为什么不用导入？是默认运行的吗？
4.promise的理解不够深刻怎么办？