package baseball.model

import java.lang.IllegalArgumentException

data class BaseBallResult(val strikeCnt: Int, val ballCnt: Int) {
    fun isWin(): Boolean = strikeCnt == 3
    fun hasStrike(): Boolean =
        strikeCnt !=0

    fun hasBall(): Boolean =
        ballCnt != 0

    fun isNothing(): Boolean = strikeCnt == 0 && ballCnt == 0

    companion object{
        fun getBaseBallResult(target: List<Int>, playerSelect: String) : BaseBallResult {
            if(validationPlayerSelect(playerSelect).not())
                throw IllegalArgumentException()
            val playerSelectNumbers = playerSelect.map {
                it.digitToInt()
            }
            val sameNumberCnt = getSameNumberCnt(target,playerSelectNumbers)
            val strikeCnt = getMatchNumberCnt(target,playerSelectNumbers)
            val ballCnt = sameNumberCnt-strikeCnt
            return BaseBallResult(strikeCnt,ballCnt)
        }

        private fun validationPlayerSelect(playerSelect : String) : Boolean{
            return playerSelect.length == 3 && playerSelect.toSet()
                .count {
                    it.code in 49..57 } == 3
        }

        private fun getSameNumberCnt(target : List<Int>, player : List<Int>) : Int{
            return target.count { player.contains(it)}
        }

        private fun getMatchNumberCnt(target : List<Int>, player : List<Int>) : Int{
            var idx = 0
            return target.count { it == player[idx++] }
        }
    }
}
