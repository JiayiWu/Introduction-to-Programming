const fs = require('fs')

const Recorder = {
  save: (info) => {
    /**
     * @todo save your game info
     */
    fs.writeFileSync("./recorde.txt",JSON.stringify(info))
  },
  read: () => {
    if (!fs.existsSync("./recorde.txt")) {
      fs.writeFileSync("./recorde.txt",JSON.stringify({winnumAsO:0,winnumAsX:0,playAsX:0,playAsO:0,roundnum:0}))
    }
    /**
     * @todo read your game info and return it
     */
    let content = JSON.parse(fs.readFileSync('recorde.txt'))
    let playAsO = content.playAsO
    let playAsX = content.playAsX
    let winnumAsO = content.winnumAsO
    let winnumAsX = content.winnumAsX
    console.log(winnumAsO +" win /"+ playAsO +" round as player O, win rate "+ (playAsO===0? "0.00":((winnumAsO/playAsO)*100).toFixed(2))+" %")
    console.log(winnumAsX +" win /"+ playAsX +" round as player O, win rate "+ (playAsX===0? "0.00":((winnumAsX/playAsX)*100).toFixed(2))+" %")
    console.log((winnumAsO+winnumAsX) +" win /"+ (playAsO+playAsX) +" round as total, win rate "+(playAsO+playAsX===0?"0.00":((winnumAsO+winnumAsX)*100/(playAsO+playAsX)).toFixed(2))+" %")
    return {}
  },
  clean: () =>{
    fs.writeFileSync("./recorde.txt",JSON.stringify({winnumAsO:0,winnumAsX:0,playAsX:0,playAsO:0,roundnum:0}))
  }
}



module.exports = Recorder