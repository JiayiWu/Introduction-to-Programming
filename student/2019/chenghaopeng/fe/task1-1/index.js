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
    const { action } = await inquirer.prompt([{
      name: 'action',
      type: 'list',
      message: 'Game menu:',
      choices: [GameMenu.PlayAsO, GameMenu.PlayAsX, GameMenu.Record, GameMenu.Exit]
    }])
    let res = false;
    switch (action) {
      case GameMenu.PlayAsO:
        res = await Runner.run(Sign.O)
        break;
      case GameMenu.PlayAsX:
        res = await Runner.run(Sign.X)
        break;
      case GameMenu.Record:
        const record = Recorder.read()
        let str = ""
        str += record.Owin + " win / " + record.Otot + " round as player O"
        if (record.Otot > 0) {
          str += ", win rate " + (record.Owin/record.Otot*100).toFixed(2) + "%"
        }
        str += "\n"
        str += record.Xwin + " win / " + record.Xtot + " round as player X"
        if (record.Xtot > 0) {
          str += ", win rate " + (record.Xwin/record.Xtot*100).toFixed(2) + "%"
        }
        str += "\n"
        str += (record.Owin+record.Xwin) + " win / " + (record.Otot+record.Xtot) + " round as total"
        if (record.Otot+record.Xtot > 0) {
          str += ", win rate " + ((record.Owin+record.Xwin)/(record.Otot+record.Xtot)*100).toFixed(2) + "%"
        }
        console.log(str)
        break;
      case GameMenu.Exit:
        process.exit();
        break;
      default:
        break;
    }
    if (action === GameMenu.PlayAsO || action === GameMenu.PlayAsX) {
      const record = Recorder.read()
      if (action === GameMenu.PlayAsO) {
        record.Otot++;
        if (res === true) {
          record.Owin++;
        }
      }
      else {
        record.Xtot++;
        if (res === true) {
          record.Xwin++;
        }
      }
      Recorder.save(record)
    }
  }
}

main()