package baseball

import baseball.model.BaseBallResult
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class BaseBallResultTest {

    @Test
    fun baseBallResultHasStrikeTest(){
        val baseBallResult = BaseBallResult(1,0)
        Assertions.assertThat(baseBallResult.hasStrike()).isTrue
    }

    @Test
    fun baseBallResultHasBallTest(){
        val baseBallResult = BaseBallResult(0,1)
        Assertions.assertThat(baseBallResult.hasBall()).isTrue
    }

    @Test
    fun baseBallResultIsWinTest(){
        val baseBallResult = BaseBallResult(3,0)
        Assertions.assertThat(baseBallResult.isWin()).isTrue
    }

    @Test
    fun baseBallResultIsNothingTest(){
        val baseBallResult = BaseBallResult(0,0)
        Assertions.assertThat(baseBallResult.isNothing()).isTrue
    }
}