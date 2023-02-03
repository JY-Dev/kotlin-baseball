package baseball

import baseball.model.BaseBallResult
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

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

    @Test
    fun getBaseBallResultTest(){
        val target = listOf(1,3,4)
        val player = "143"
        val result = BaseBallResult.getBaseBallResult(target,player)
        val baseBallResult = BaseBallResult(1,2)
        Assertions.assertThat(result).isEqualTo(baseBallResult)
    }

    @Test
    fun getBaseBallResultExceptionOverLengthTest(){
        val target = listOf(1,3,4)
        val player = "1434"
        assertThrows(IllegalArgumentException::class.java){
            BaseBallResult.getBaseBallResult(target,player)
        }
    }

    @Test
    fun getBaseBallResultExceptionInvalidTypeTest(){
        val target = listOf(1,3,4)
        val player = "aaaaa"
        assertThrows(IllegalArgumentException::class.java){
            BaseBallResult.getBaseBallResult(target,player)
        }
    }
}