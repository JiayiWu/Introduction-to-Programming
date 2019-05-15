const Game = require('./Game')
const fs = require('fs')
const inquirer = require('inquirer')
const GameMenu = require('./enums/GameMenu')

const Runner = {
  run: async (player) => {
    const { level } = await inquirer.prompt([{
      name: 'level',
      type: 'list',
      message: 'Game menu:',
      choices: [GameMenu.Easy,GameMenu.Hard]
    }])
    /**
     * @todo choose difficulty [Easy, Hard]
     */
    const game = new Game(player,level)
    while (true) {
      await game.next()
      if (game.isEnd) {
        break
      }
    }
  },
}

module.exports = Runner