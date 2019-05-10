const readline = require('readline')
const clear = require('clear')
const chalk = require('chalk')
const recorder=require('./Recorder')
const Sign = require('./enums/Sign')

class Game {

  constructor(player = Sign.O,mode = 1) {
    this.usermode=mode
    this.userPlayer = player
    this.aiPlayer = player === Sign.O ? Sign.X : Sign.O
    this.mywin = 0
    this.allround = 0 
    this.nextPlayer = Sign.O
    this.round = 0
    this.isEnd = false
    this.win = Array(9).fill(0)
    this.board = Array(9).fill(null)
    this.cursor = 4
  }

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
     * you show color index 1,4,7 in orange to indicate that these three makes player O as winner(have done)
     */
    //我用了白色= =因为chalk里没有橙色
    const winner = this.checkWinner()
    
    if (winner || this.round === 9) {
      this.isEnd = true
      if (winner) {
        /**
         * @todo judge who wins(have done) and log it
         */
        //0是平局 1是O赢 2是O输 3是X赢 4是X输 
        if(winner==Sign.O&&this.userPlayer==Sign.O){this.printBoard();this.mywin=this.mywin+1;this.allround =this.allround+1;recorder.save(1);console.log('you win');}
        else if(winner==Sign.X&&this.userPlayer==Sign.X){this.printBoard();this.mywin=this.mywin+1;this.allround =this.allround+1;recorder.save(3);console.log('you win');}
        else {this.printBoard();this.allround =this.allroun+1;console.log('you lose');if(this.userPlayer==Sign.O)recorder.save(2);else recorder.save(4);}
      } else {
        recorder.save(0);
        console.log('A draw.')
      }
    }
  }

  /**
   * @todo return the winner Sign.O or Sign.X or null
   * before it is implemented, the game will not run well(have done)
   */
  checkWinner() {
  //行
  if(this.board[0]==this.board[1]&&this.board[1]==this.board[2]&&this.board[0]==Sign.O){this.win[0]=1;this.win[1]=1;this.win[2]=1;return Sign.O;}
  if(this.board[3]==this.board[4]&&this.board[4]==this.board[5]&&this.board[3]==Sign.O){this.win[3]=1;this.win[4]=1;this.win[5]=1;return Sign.O;}
  if(this.board[6]==this.board[7]&&this.board[7]==this.board[8]&&this.board[6]==Sign.O){this.win[6]=1;this.win[7]=1;this.win[8]=1;return Sign.O;}

  if(this.board[0]==this.board[1]&&this.board[1]==this.board[2]&&this.board[0]==Sign.X){this.win[0]=1;this.win[1]=1;this.win[2]=1;return Sign.X;}
  if(this.board[3]==this.board[4]&&this.board[4]==this.board[5]&&this.board[3]==Sign.X){this.win[3]=1;this.win[4]=1;this.win[5]=1;return Sign.X;}
  if(this.board[6]==this.board[7]&&this.board[7]==this.board[8]&&this.board[6]==Sign.X){this.win[6]=1;this.win[7]=1;this.win[8]=1;return Sign.X;}
  //列
  if(this.board[0]==this.board[3]&&this.board[6]==this.board[3]&&this.board[0]==Sign.O){this.win[0]=1;this.win[3]=1;this.win[6]=1;return Sign.O;}
  if(this.board[1]==this.board[4]&&this.board[4]==this.board[7]&&this.board[1]==Sign.O){this.win[1]=1;this.win[4]=1;this.win[7]=1;return Sign.O;}
  if(this.board[2]==this.board[5]&&this.board[5]==this.board[8]&&this.board[2]==Sign.O){this.win[2]=1;this.win[5]=1;this.win[8]=1;return Sign.O;}

  if(this.board[0]==this.board[3]&&this.board[3]==this.board[6]&&this.board[0]==Sign.X){this.win[0]=1;this.win[3]=1;this.win[6]=1;return Sign.X;}
  if(this.board[1]==this.board[4]&&this.board[4]==this.board[7]&&this.board[1]==Sign.X){this.win[1]=1;this.win[4]=1;this.win[7]=1;return Sign.X;}
  if(this.board[2]==this.board[5]&&this.board[5]==this.board[8]&&this.board[2]==Sign.X){this.win[2]=1;this.win[5]=1;this.win[8]=1;return Sign.X;}
  //对角线
  if(this.board[0]==this.board[4]&&this.board[4]==this.board[8]&&this.board[0]==Sign.O){this.win[0]=1;this.win[4]=1;this.win[8]=1;return Sign.O;}
  if(this.board[2]==this.board[4]&&this.board[4]==this.board[6]&&this.board[2]==Sign.O){this.win[2]=1;this.win[4]=1;this.win[6]=1;return Sign.O;}

  if(this.board[0]==this.board[4]&&this.board[4]==this.board[8]&&this.board[0]==Sign.X){this.win[0]=1;this.win[4]=1;this.win[8]=1;return Sign.X;}
  if(this.board[2]==this.board[4]&&this.board[4]==this.board[6]&&this.board[2]==Sign.X){this.win[2]=1;this.win[4]=1;this.win[6]=1;return Sign.X;}
  
  return 0;
  }

  printBoard() {
    clear()
    let str = ''
    for (let i = 0; i < 9; i++) {
      const cur = this.board[i]
      if (cur == null) {
        str += this.cursor === i ? chalk.yellow('_') : ''
      } else {
      if(this.win[i]==0)str += this.cursor === i ? chalk.yellow(cur) : cur === this.userPlayer ? chalk.green(cur) : chalk.red(cur) 
      else {str += chalk.white(cur);}
      }
      str += '\t'
      if (i % 3 === 2 && i != 8) {
        str += '\n'
      }
    }
    console.log(str)
  }

  set(index) {
    if (this.board[index] != null) {
      return false
    }
    this.board[index] = this.nextPlayer
    this.round = this.round + 1
    this.nextPlayer = this.nextPlayer === Sign.O ? Sign.X : Sign.O
    return true
  }

  async userPlay() {
    return new Promise((resolve, reject) => {
      this.resolve = resolve
    })
  }

  handleUserKey(_, keyConfig) {
    if (this.nextPlayer != this.userPlayer) { return }
    const key = keyConfig.name
    if (key === 'k' || key === 'escape') {
      process.exit();
    } else {
      if (key == 'j' || key == 'space') {
        if (this.set(this.cursor)) {
          this.resolve()
          this.printBoard()
        }
      }
      
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
   * @todo move cursor to where robot place its sign(have done)
   */
  async robotPlay() {
   
    if(this.usermode==1)
    {const [, nextPos] = this.generateScore()
    this.set(nextPos)
    this.printBoard()
    this.cursor=nextPos}
    else 
    {const nextPos1 = this.easyplay()
    this.set(nextPos1)
    this.printBoard()
    this.cursor=nextPos1}
  }

  clone() {
    const newGame = new Game(this.userPlayer,this.usermode)
    newGame.board = [...this.board]
    newGame.round = this.round
    newGame.nextPlayer = this.nextPlayer
    return newGame
  }
  
  easyplay(){
    let nextplace=Math.floor(Math.random()*10/1);
    while(this.board[nextplace]!=null)nextplace=Math.floor(Math.random()*10/1);
    return nextplace
  }
  /**
   * generate score for setting position
   * @see The Minimax Algorithm
   */
  generateScore() {
    const winner = this.checkWinner()

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