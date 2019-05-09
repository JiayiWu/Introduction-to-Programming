const chalk = require('chalk')
const clear = require('clear')
const figlet = require('figlet')
const inquirer = require('inquirer')

const GameMenu = require('./enums/GameMenu')
const Sign = require('./enums/Sign')
const Recorder = require('./Recorder')
const Runner = require('./Runner')

clear()
console.log(
  chalk.green(
    figlet.textSync('Tic Tac Toe', { horizontalLayout: 'full' })
  )
)

async function main() {
  while (true) {
    /**
     * @todo add an End action to exit the game
     */
    const { action } = await inquirer.prompt([{
      name: 'action',
      type: 'list',
      message: 'Game menu:',
      choices: [GameMenu.PlayAsO, GameMenu.PlayAsX, GameMenu.Record]
    }])
    switch (action) {
      case GameMenu.PlayAsO:
        await Runner.run(Sign.O)
        break;
      case GameMenu.PlayAsX:
        await Runner.run(Sign.X)
        break;
      case GameMenu.Record:
        const record = Recorder.read()
        /**
         * @todo log your game record like the example below:
         * 47 win / 100 round as player O, win rate 47.00%
         * 3 win / 20 round as player X, win rate 15.00%
         * 50 win / 120 round as total, win rate is 41.67%
         */
        
        break;
      default:
        break;
    }
  }
}

main()