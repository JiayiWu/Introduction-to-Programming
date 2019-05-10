const fs = require('fs')

const Recorder = {
  save: (info) => {

    /**
     * @todo save your game info
     */
    var t = fs.readFileSync('recorder.txt');
    fs.writeFileSync('recorder.txt',t+info)

    // fs.writeFileSync
  },
  read: () => {
    /**
     * @todo read your game info and return it
     */

    // fs.existsSync
    // fs.readFileSync
    return fs.readFileSync('recorder.txt')+''
  }
}

module.exports = Recorder