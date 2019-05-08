const Game = require('./Game')

const Runner = {
  run: async (player) => {
    /**
     * @todo choose difficulty [Easy, Hard]
     */
    const game = new Game(player)
    while (true) {
      await game.next()
      if (game.isEnd) {
        break
      }
    }
  },
}

module.exports = Runner