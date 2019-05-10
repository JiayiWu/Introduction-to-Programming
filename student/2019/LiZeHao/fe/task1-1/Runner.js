const Game = require('./Game')
const Mode = require('./enums/Mode')
const inquirer = require('inquirer')
const Runner = {
  run: async (player) => {
    /**
     * @todo choose difficulty [Easy, Hard]
     */
    const { action } = await inquirer.prompt([{
      name: 'action',
      type: 'list',
      message: 'Mode choose:',
      choices: [Mode.Playhard, Mode.Playeasy]
    }])
    switch (action){
      case Mode.Playhard:
        const game = new Game(player,1)
        while (true) {
        await game.next()
        if (game.isEnd) {
            break
          }
        }
        break
      case Mode.Playeasy:
        const game2 = new Game(player,2)
        while (true) {
        await game2.next()
        if (game2.isEnd) {
            break
          }
        }
        break
    }

    
  },
}

module.exports = Runner