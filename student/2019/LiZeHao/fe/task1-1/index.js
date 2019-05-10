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
     * @todo add an End action to exit the game(have done)
     */
    const { action } = await inquirer.prompt([{
      name: 'action',
      type: 'list',
      message: 'Game menu:',
      choices: [GameMenu.PlayAsO, GameMenu.PlayAsX, GameMenu.Record, GameMenu.Exit]
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
        var Owin=0;
        var Xwin=0;
        var draw=0;
        var Oround=0;
        var Xround=0;
        var allround;
        var allwin;
        //0是平局 1是O赢 2是O输 3是X赢 4是X输
        for(var i=0;i<record.length;i++){
          if(record.charAt(i)=='0')draw=draw+1;
          else if(record.charAt(i)=='1'){Owin++;Oround++}
          else if(record.charAt(i)=='2'){Oround++}
          else if(record.charAt(i)=='3'){Xwin++;XOround++}
          else if(record.charAt(i)=='4'){Xround++}
        }
        allround=Oround+Xround
        allwin=Owin+Xwin
        if(Xround==0)Xround++;
        if(Oround==0)Oround++;
        console.log(Owin+' win / '+Oround+' round as player O,win rate '+(Owin/Oround*100).toFixed(2)+'%')
        console.log(Xwin+' win / '+Xround+' round as player X,win rate '+(Xwin/Xround*100).toFixed(2)+'%')
        console.log(allwin+' win / '+allround+' round as total,win rate is '+(allwin/allround*100).toFixed(2)+'%')
        break;

      case GameMenu.Exit:
        process.exit();
        /**
         * @todo log your game record like the example below:
         * 47 win / 100 round as player O, win rate 47.00%
         * 3 win / 20 round as player X, win rate 15.00%
         * 50 win / 120 round as total, win rate is 41.67%
         */
        //(have done)
        break;
      default:
        break;
    }
  }
}

main()