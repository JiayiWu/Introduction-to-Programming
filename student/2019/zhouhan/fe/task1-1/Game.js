const readline = require('readline')
const clear = require('clear')
const chalk = require('chalk')
const Recorder = require('./Recorder')
const GameMenu = require('./enums/GameMenu')
const Sign = require('./enums/Sign')
const figlet = require('figlet')
//let winnumAsX = JSON.parse(fs.readFileSync('recorde.txt')).winnumAsX
//let playAsX = JSON.parse(fs.readFileSync('recorde.txt')).playAsX
//let winnumAsO = JSON.parse(fs.readFileSync('recorde.txt')).winnumAsO
//let playAsO = JSON.parse(fs.readFileSync('recorde.txt')).playAsO
//let roundnum = JSON.parse(fs.readFileSync('recorde.txt')).roundnum

let winnumAsX =0
let playAsX = 0
let winnumAsO = 0
let playAsO = 0
let roundnum = 0

class Game {
  constructor(player = Sign.O,level = GameMenu.Easy) {
    this.level = level
    this.userPlayer = player
    this.aiPlayer = player === Sign.O ? Sign.X : Sign.O    
    this.nextPlayer = Sign.O
    this.round = 0
    this.isEnd = false
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
     * @todo print those sign that decide who wins in red color, for example
     * XOX
     * OO
     * XO
     * you show color index 1,4,7 in red to indicate that these three makes player O as winner
     */
    const winner = this.checkWinner()
    if (winner || this.round === 9) {
      this.isEnd = true
      if(this.userPlayer == Sign.O){
        playAsO+=1
      }
      else{
        playAsX+=1
      }
      if (winner) {
        this.printBoard()
        /**
         * @todo judge who wins and log it
         */
        if (this.nextPlayer===this.aiPlayer){
          console.log(chalk.yellow(
            figlet.textSync('you win!', { horizontalLayout: 'full' })
          ))
          if(this.userPlayer==Sign.O){
            winnumAsO+=1
          }
          else{
            winnumAsX+=1
          }
        }
        else{
          console.log(chalk.green(
            figlet.textSync('you lose!', { horizontalLayout: 'full' })
          ))
        }
      } else {
        console.log(chalk.white(
          figlet.textSync('Draw', { horizontalLayout: 'full' })
        ))
      }
      Recorder.save({winnumAsO,winnumAsX,playAsX,playAsO,roundnum})
    }
  }

  /**
   * @todo return the winner Sign.O or Sign.X or null
   * before it is implemented, the game will not run well
   */
  checkWinner() {
    for (let i=0;i<3;i++){
      if (this.board[i]==this.board[i+3]&&this.board[i]==this.board[i+6]){
        if(this.board[i]!=null){
          this.board[i]=chalk.keyword("orange")(this.board[i])
          this.board[i+3]=chalk.keyword("orange")(this.board[i+3])
          this.board[i+6]=chalk.keyword("orange")(this.board[i+6])
          return true
        }
      }
    }
    for (let i=0;i<7;i+=3){
      if (this.board[i]==this.board[i+1]&&this.board[i]==this.board[i+2]){
          if(this.board[i]!=null){
            this.board[i]=chalk.keyword("orange")(this.board[i])
            this.board[i+1]=chalk.keyword("orange")(this.board[i+1])
            this.board[i+2]=chalk.keyword("orange")(this.board[i+2])
            return true
          }
      }
    }
    if (this.board[0]==this.board[4]&&this.board[0]==this.board[8]){
      if(this.board[4]!=null){
        this.board[0]=chalk.keyword("orange")(this.board[0])
        this.board[4]=chalk.keyword("orange")(this.board[4])
        this.board[8]=chalk.keyword("orange")(this.board[8])
        return true
      }
    }
    if(this.board[2]==this.board[4]&&this.board[2]==this.board[6]){
      if(this.board[4]!=null){
        this.board[2]=chalk.keyword("orange")(this.board[2])
        this.board[4]=chalk.keyword("orange")(this.board[4])
        this.board[6]=chalk.keyword("orange")(this.board[6])
        return true
      }
    }
    return false
  }

  printBoard() {
    clear()
    let str = ''
    for (let i = 0; i < 9; i++) {
      const cur = this.board[i]
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
   * @todo move cursor to where robot place its sign
   */
  async robotPlay() {
    const [, nextPos] = this.generateScore()
    this.cursor=nextPos
    this.set(nextPos)
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
  generateScore() {
    
    const winner = this.checkWinner()
    if(this.level==GameMenu.Hard){
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
    else{
      for(let i=0;i<9;i++){
        if(this.board[i]==null){
          let score = this.nextPlayer === this.aiPlayer ? -Infinity : Infinity
          return[score, i]
        }
      }
    }
  }
}

module.exports = Game