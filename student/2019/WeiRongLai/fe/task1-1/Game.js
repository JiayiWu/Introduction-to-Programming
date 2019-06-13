const readline = require('readline')
const clear = require('clear')
const chalk = require('chalk')
const fs = require('fs')

const Recorder = require('./Recorder')
const Sign = require('./enums/Sign')

class Game {

  constructor(player = Sign.O) {
    this.userPlayer = player
    this.aiPlayer = player === Sign.O ? Sign.X : Sign.O
    
    this.nextPlayer = Sign.O
    this.round = 0
    this.isEnd = false
    this.board = Array(9).fill(null)//此处的初始化值得学习
    this.cursor = 4
    this.times=0
    this.useOWin=0
    this.useOTimes=0
    this.useXTimes=0
    this.useXWin=0
  }

  //初始化棋盘，监听keypress事件
  initOnFirstRound() {
    readline.emitKeypressEvents(process.stdin)
    process.stdin.setRawMode(true);
    process.stdin.resume()
    process.stdin.on('keypress', this.handleUserKey.bind(this))
    this.printBoard()
  }

  async next() {
    if (this.round === 0) {
      this.initOnFirstRound()
    }
    if (this.nextPlayer === this.userPlayer) {
      await this.userPlay()
    } else {
      await this.robotPlay()
    }

    /**
     * @todo print those sign that decide who wins in orange color, for example
     * XOX
     * OO
     * XO
     * you show color index 1,4,7 in orange to indicate that these three makes player O as winner
     */
    const [winner,sign] = this.checkWinner()
    if (winner || this.round === 9) {
      this.isEnd = true
      if (winner) {
        /**
         * @todo judge who wins and log it
         */
        // sign.forEach(element => {
        //   this.board[element]=chalk.blue(winner)
        // });
        // clear();
        // this.printBoard();
        if(winner===this.aiPlayer){
          console.log("You lose.");
        }else{
          console.log("you win");
        }
      }else{
        console.log('A draw.')
      }
      //读取上次文件

      //此处或许可以在构造函数时读取，当作参数读入或许会更好
      var {useOWin,useXWin,times,useOTimes,useXTimes}=JSON.parse(fs.readFileSync("record.json"))
      this.useOTimes=useOTimes
      this.useOWin=useOWin
      this.useXWin=useXWin
      this.useXTimes=useXTimes
      this.times=times
      //尝试保存文件
      Recorder.save({
        useOWin:(winner===this.userPlayer && winner===Sign.O)?++this.useOWin:this.useOWin,
        useXWin:(winner===this.userPlayer && winner===Sign.X)?++this.useXWin:this.useXWin,
        times:++this.times,
        useOTimes:this.userPlayer===Sign.O?++this.useOTimes:this.useOTimes,
        useXTimes:this.userPlayer===Sign.X?++this.useXTimes:this.useXTimes,
      });
    }
  }

  /**
   * @todo return the winner Sign.O or Sign.X or null
   * before it is implemented, the game will not run well
   */
  checkWinner() {
    var winner=null;
    var sign=[];
    //检查行
    for(var i=0;i<7;i+=3){
      if(this.board[i]!==null && this.board[i]===this.board[i+1] && this.board[i]===this.board[i+2]){
        winner=this.board[i];
        sign=[i,i+1,i+2];
        break;
      }
    }
    //检查列
    for(var i=0;i<3;i++){
      if(this.board[i]!==null && this.board[i]===this.board[i+3] && this.board[i]===this.board[i+6]){
        winner=this.board[i];
        sign=[i,i+3,i+6];
        break;
      }
    }
    //检查对角线
    if(this.board[0]!=null && this.board[4]===this.board[0] && this.board[8]===this.board[0]){
      winner=this.board[0];
      sign=[0,4,8];
    }
    if(this.board[2]!=null && this.board[4]===this.board[2] && this.board[4]===this.board[6]){
      winner=this.board[2];
      sign=[2,4,6];
    }
    return [winner,sign];//返回胜者和胜利棋子的位置
  }

  printBoard() {
    clear()
    let str = ''
    let [winner,sign]=this.checkWinner();
    if(winner){
      sign.forEach(element => {
        this.board[element]=chalk.blue(winner);
      });
    }
    for (let i = 0; i < 9; i++) {
      const cur = this.board[i];
      //通过光标内容打印
      if (cur == null) {
        str += this.cursor === i ? chalk.yellow('_') : ''
      } else {
        str += this.cursor === i ? chalk.yellow(cur) : cur === this.userPlayer ? chalk.green(cur) : chalk.red(cur) 
      }
      str += '\t'
      if (i % 3 === 2 && i != 8) {
        str += '\n'
      }
    }
    console.log(str)
  }

  //设置下一棋子的种类，局数加一，返回是否成功设置棋子
  set(index) {
    if (this.board[index] != null) {
      return false
    }
    this.board[index] = this.nextPlayer
    this.round = this.round + 1
    this.nextPlayer = this.nextPlayer === Sign.O ? Sign.X : Sign.O
    return true
  }

  //此处没有处理reject
  //此处异步处理resolve函数究竟是啥
  async userPlay() {
    return new Promise((resolve, reject) => {
      this.resolve = resolve
    })
  }

  //此处的_参数什么意思？
  //通过键盘的输入，改变光标索引的位置
  handleUserKey(_, keyConfig) {
    if (this.nextPlayer != this.userPlayer) { return }//此处return可删去吧？
    const key = keyConfig.name
    if (key === 'k' || key === 'escape') {
      process.exit();
    } else {
      if (key == 'j' || key == 'space') {
        if (this.set(this.cursor)) {
          this.resolve()//此处的resolve函数是promise时传入的
          this.printBoard()
        }
      }
      
      //此处的算法
      const directionMap = {
        w: 6,
        s: 3,
        a: 8,
        d: 1,
        up: 6,
        down: 3,
        left: 8,
        right: 1,
      }
      const delta = directionMap[key]
      if (delta) {
        this.cursor += delta
        this.cursor %= 9
        clear()
        this.printBoard()
      }
    }
    
  }

  /**
   * @todo move cursor to where robot place its sign
   */
  async robotPlay() {
    const [, nextPos] = this.generateScore()//解构，得到下一步棋的位置
    this.set(nextPos)
    this.cursor=nextPos//改变光标的位置
    this.printBoard()
  }

  clone() {
    const newGame = new Game(this.userPlayer)
    newGame.board = [...this.board]
    newGame.round = this.round
    newGame.nextPlayer = this.nextPlayer
    return newGame
  }

  /**
   * generate score for setting position
   * @see The Minimax Algorithm
   */
  //通过极大极小算法计算下次位置
  generateScore() {
    const [winner,] = this.checkWinner()

    if (winner || this.round === 9) {
      if (winner) {
        return winner === this.aiPlayer ? [100 - this.round, -1] : [-100 + this.round, -1]
      }
      return [0, -1]
    }

    const avaliablePositions = this.board
      .map((value, index) => value == null ? index : null)
      .filter(v => v != null)
      .sort(() => Math.random() - 0.5)
    let score = this.nextPlayer === this.aiPlayer ? -Infinity : Infinity
    let nextPos = 0
    const checkCondition = (nextScore) => this.nextPlayer === this.aiPlayer ? nextScore > score : nextScore < score
    for (const pos of avaliablePositions) {
      const nextBoard = this.clone()
      nextBoard.set(pos)
      const [nextScore] = nextBoard.generateScore()
      if (checkCondition(nextScore)) {
        score = nextScore
        nextPos = pos
      }
    }
    return [score, nextPos]
  }
}

module.exports = Game