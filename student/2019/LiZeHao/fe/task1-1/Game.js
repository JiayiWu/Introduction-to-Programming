const readline = require('readline')
const clear = require('clear')
const chalk = require('chalk')

const Sign = require('./enums/Sign')

class Game {

  constructor(player = Sign.O) {
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
     * @todo print those sign that decide who wins in orange color, for example
     * XOX
     * OO
     * XO
     * you show color index 1,4,7 in orange to indicate that these three makes player O as winner
     */
    const winner = this.checkWinner()
    if (winner || this.round === 9) {
      this.isEnd = true
      if (winner) {
        /**
         * @todo judge who wins and log it
         */
        if(winner==Sign.O&&this.userPlayer==Sign.O)console.log('you win')
        else if(winner==Sign.X&&this.userPlayer==Sign.X)console.log('you win')
        else console.log('you lose')
      } else {
        console.log('A draw.')
      }
    }
  }

  /**
   * @todo return the winner Sign.O or Sign.X or null
   * before it is implemented, the game will not run well
   */
  checkWinner() {
  //行
  if(this.board[0]==this.board[1]&&this.board[1]==this.board[2]&&this.board[0]==Sign.O)return Sign.O;
  if(this.board[3]==this.board[4]&&this.board[4]==this.board[5]&&this.board[3]==Sign.O)return Sign.O;
  if(this.board[6]==this.board[7]&&this.board[7]==this.board[8]&&this.board[6]==Sign.O)return Sign.O;

  if(this.board[0]==this.board[1]&&this.board[1]==this.board[2]&&this.board[0]==Sign.X)return Sign.X;
  if(this.board[3]==this.board[4]&&this.board[4]==this.board[5]&&this.board[3]==Sign.X)return Sign.X;
  if(this.board[6]==this.board[7]&&this.board[7]==this.board[8]&&this.board[6]==Sign.X)return Sign.X;
  //列
  if(this.board[0]==this.board[3]&&this.board[6]==this.board[3]&&this.board[0]==Sign.O)return Sign.O;
  if(this.board[1]==this.board[4]&&this.board[4]==this.board[7]&&this.board[1]==Sign.O)return Sign.O;
  if(this.board[2]==this.board[5]&&this.board[5]==this.board[8]&&this.board[2]==Sign.O)return Sign.O;

  if(this.board[0]==this.board[3]&&this.board[3]==this.board[6]&&this.board[0]==Sign.X)return Sign.X;
  if(this.board[1]==this.board[4]&&this.board[4]==this.board[7]&&this.board[1]==Sign.X)return Sign.X;
  if(this.board[2]==this.board[5]&&this.board[5]==this.board[8]&&this.board[2]==Sign.X)return Sign.X;
  //对角线
  if(this.board[0]==this.board[4]&&this.board[4]==this.board[8]&&this.board[0]==Sign.O)return Sign.O;
  if(this.board[2]==this.board[4]&&this.board[4]==this.board[6]&&this.board[2]==Sign.O)return Sign.O;

  if(this.board[0]==this.board[4]&&this.board[4]==this.board[8]&&this.board[0]==Sign.X)return Sign.X;
  if(this.board[2]==this.board[4]&&this.board[4]==this.board[6]&&this.board[2]==Sign.X)return Sign.X;
  
  if(this.round!=9)return 0;
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