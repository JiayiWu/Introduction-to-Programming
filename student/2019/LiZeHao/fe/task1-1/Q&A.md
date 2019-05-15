#### Q1.why we need to install the module 'chalk' but 'fs' has the immunity

A1:因为'chalk'模块属于Node.js中众多color模块的一种，本身并不自带。在我们执行'npm i'指令的时候，程序根据'package-lock'文件，把包下载安装好到node_modules文件夹里。而fs模块是Node.js本身自带的,直接引用即可。

#### Q2.why 'node .' and 'npm run start' means the same in this project

A2:npm 允许在`package.json`文件里面，使用`scripts`字段定义脚本命令。每当执行`npm run`，就会自动新建一个 Shell，在这个 Shell 里面执行指定的脚本命令。使用'npm run'命令，就可以像'node .'一样运行这段脚本。



#### Q3.what's promise and async-await

A3:promise对象表示异步操作的最终完成（或失败）及其结果值；异步等待指执行此操作时，暂停执行直到`Promise`解决。

#### Q4.what should we take into consideration when use 'The Minimax Algorithm'

A4:这是一个递归算法，所以要注意递归深度不宜太大，如棋盘不要过大，回合不要过多等。并且它适用于完美信息游戏，完美信息游戏中可以看到游戏中所有可能移动。譬如拼字游戏等非完美信息游戏则不是适用于此算法。