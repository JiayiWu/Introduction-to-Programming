const fs = require('fs')

const Recorder = {
  save: (info) => {

    /**
     * @todo save your game info
     */

    fs.writeFileSync("record.json",JSON.stringify(info))
  },
  read: () => {

    /**
     * @todo read your game info and return it
     */

    if(fs.existsSync("record.json")){
      var {useOWin,useXWin,times,useOTimes,useXTimes}=JSON.parse(fs.readFileSync("record.json"))
      var oRate=useOTimes===0?0.00:(useOWin/useOTimes*100).toFixed(2)
      var xRate=useXTimes===0?0.00:(useXWin/useXTimes*100).toFixed(2)
      var totalTime=useXTimes+useOTimes
      var totalWin=useOWin+useXWin
      var totalRate=(totalWin/totalTime*100).toFixed(2)
      return {oRate,xRate,totalRate,useOTimes,useXTimes,totalTime,useXWin,useOWin,totalWin,times}
    }
  }
}

module.exports = Recorder