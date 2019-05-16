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
        choices: [GameMenu.Mode[0],GameMenu.Mode[1]]
      }])
      switch(action){
        case GameMenu.Mode[0]:
        const hardGame = new Game(player)
        //每走一步，判断是否结束
        while (true) {
          await hardGame.next()
          if (hardGame.isEnd) {
            break
          }
        }
        break;
        case GameMenu.Mode[1]:
        const easyGame = new EasyGame(player)
        //每走一步，判断是否结束
        while(true){
          await easyGame.next()
          if(easyGame.isEnd){
            break
          }
        }
        break;
        default:
        break;
      }
  },
}

module.exports = Runner