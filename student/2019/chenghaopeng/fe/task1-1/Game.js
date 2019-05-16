const readline = require('readline')
const clear = require('clear')
const chalk = require('chalk')

const Sign = require('./enums/Sign')
const DifficultyMenu = require('./enums/DifficultyMenu')

class Game {

  constructor(player = Sign.O) {
    this.userPlayer = player
    this.aiPlayer = player === Sign.O ? Sign.X : Sign.O
    
    this.nextPlayer = Sign.O
    this.round = 0
    this.isEnd = false
    this.board = Array(9).fill(null)
    this.cursor = 4

    this.userWinned = false
    this.difficulty = DifficultyMenu.Easy
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

    const winner = this.checkWinner()
    if (winner || this.round === 9) {
      this.isEnd = true
      if (winner) {
        this.printWinner()
        if (winner === this.userPlayer) {
          this.userWinned = true
          console.log('you win!')
        }
        else {
          console.log('you lose!')
        }
      } else {
        console.log('A draw.')
      }
    }
  }

  getWinnerPos() {
    for (let i=0; i<3; ++i) {
      if (this.board[i*3] === this.board[i*3+1] && this.board[i*3+1] === this.board[i*3+2] && this.board[i*3] != null) {
        return [i*3, i*3+1, i*3+2]
      }
      if (this.board[i] === this.board[i+3] && this.board[i+3] === this.board[i+6] && this.board[i] != null) {
        return [i, i+3, i+6]
      }
    }
    if (this.board[4] != null) {
      if (this.board[0] === this.board[4] && this.board[4] === this.board[8]) {
        return [0, 4, 8]
      }
      if (this.board[2] === this.board[4] && this.board[4] === this.board[6]) {
        return [2, 4, 6]
      }
    }
    return null
  }

  checkWinner() {
    let winnerPos = this.getWinnerPos()
    if (winnerPos) return this.board[winnerPos[0]]
    return null
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

  printWinner() {
    clear()
    let winnerPos = this.getWinnerPos()
    let str = ''
    for (let i = 0; i < 9; i++) {
      const cur = this.board[i]
      if (cur != null) {
        str += winnerPos.includes(i) ? chalk.rgb(255, 97, 0)(cur) : cur === this.userPlayer ? chalk.green(cur) : chalk.red(cur) 
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

  async robotPlay() {
    let nextPos = Math.floor(Math.random() * 9)
    if (this.difficulty === DifficultyMenu.Hard) {
      [, nextPos] = this.generateScore()
    }
    else {
      while (this.board[nextPos] != null) {
        nextPos = Math.floor(Math.random() * 9)
      }
    }
    this.set(nextPos)
    this.cursor = nextPos
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