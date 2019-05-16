const fs = require('fs')

const Recorder = {
  save: (info) => {
    fs.writeFileSync("record", JSON.stringify(info))
  },
  read: () => {
    let fileExists = fs.existsSync("record")
    if (fileExists) {
      let data = fs.readFileSync("record")
      return JSON.parse(data)
    }
    return {"Owin": 0, "Otot": 0, "Xwin": 0, "Xtot": 0}
  }
}

module.exports = Recorder