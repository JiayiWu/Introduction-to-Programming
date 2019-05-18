const Game=require('./Game')

class EasyGame extends Game{
    /**
     * @overriding
     */
    generateScore(){
        var nextPosition=Math.round(Math.random()*9)
        while(this.board[nextPosition]!==null){
            nextPosition=Math.round(Math.random()*9)
        }
        var score=0
        return [score , nextPosition]
    }
    /**
     * @overriding
     */
    async robotPlay() {
        var [, nextPos] = this.generateScore()//解构，得到下一步棋的位置
        this.set(nextPos)
        this.cursor=nextPos//改变光标的位置
        this.printBoard()
    }
}

module.exports=EasyGame