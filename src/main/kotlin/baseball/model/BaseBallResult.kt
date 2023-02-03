package baseball.model

data class BaseBallResult(val strikeCnt: Int, val ballCnt: Int) {
    fun isWin(): Boolean = strikeCnt == 3
    fun hasStrike(): Boolean =
        strikeCnt !=0

    fun hasBall(): Boolean =
        ballCnt != 0

    fun isNothing(): Boolean = strikeCnt == 0 && ballCnt == 0
}
