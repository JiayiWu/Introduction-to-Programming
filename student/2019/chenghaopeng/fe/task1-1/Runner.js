const inquirer = require('inquirer')

const Game = require('./Game')
const DifficultyMenu = require('./enums/DifficultyMenu')

const Runner = {
  run: async (player) => {
    const game = new Game(player)
    const { difficulty } = await inquirer.prompt([{
      name: 'difficulty',
      type: 'list',
      message: 'Choose difficulty:',
      choices: [DifficultyMenu.Easy, DifficultyMenu.Hard]
    }])
    game.difficulty = difficulty
    while (true) {
      await game.next()
      if (game.isEnd) {
        break
      }
    }
    return game.userWinned
  },
}

module.exports = Runner