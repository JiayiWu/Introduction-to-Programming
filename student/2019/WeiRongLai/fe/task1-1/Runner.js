const Game = require('./Game')
const inquirer = require('inquirer')
const GameMenu = require('./enums/GameMenu')
const EasyGame=require ('./easyGame')

const Runner = {
  // 此处为什么不用async函数，而用成员变量？
  run: async (player) => {
    /**
     * @todo choose difficulty [Easy, Hard]
     */
    
      const { action } = await inquirer.prompt([{
        name: 'action',
        type: 'list',
        message: 'mode:',
        choices: [GameMenu.HardMode,GameMenu.EasyMode]
      }])
      let aGame;
      switch(action){
        case GameMenu.HardMode:
        aGame = new Game(player);
        break;
        case GameMenu.EasyMode:
        aGame = new easyGame(player);
        break;
        default:
        break;
      }
      while(true){
          await aGame.next()
          if(aGame.isEnd){
            break
          }
        }
  },
}

module.exports = Runner