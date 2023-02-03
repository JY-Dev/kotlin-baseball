package baseball

import baseball.model.BaseBallResult
import baseball.view.BaseBallView
import camp.nextstep.edu.missionutils.Randoms

class BaseBallGame(private val baseBallView: BaseBallView) {
    private lateinit var target: List<Int>
    fun startGame() {
        baseBallView.startGame()
        target = Randoms.pickUniqueNumbersInRange(1, 9, 3)
        while (true){
            val playerNumber = baseBallView.inputNumber()
            val baseBallResult = BaseBallResult.getBaseBallResult(target, playerNumber)
            baseBallView.printResult(baseBallResult)
            if(baseBallResult.isWin()){
                baseBallView.finishGame()
                break
            }
        }
        val restartGame = baseBallView.restartQuestion()
        if(restartGame)
            startGame()
    }
}