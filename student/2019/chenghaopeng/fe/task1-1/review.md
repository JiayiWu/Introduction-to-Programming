### 代码
整体很清晰，吹毛求疵的话：  
1.index.js那段可以再可读一点，switch中Record的重复代码比较多，最后的if判断位置也不太好  
2.runner.js中difficulty是不是应该放在构造函数的入参中  
3.game.js中简单难度的写法不太合适，随机数不应该在整个棋盘中产生  
4.game.js中printBoard和printWinner重复耦合  

### Q&A
ok