package baseball

import baseball.view.BaseBallView

fun main() {
    val baseBallGame = BaseBallGame(BaseBallView())
    baseBallGame.startGame()
}
