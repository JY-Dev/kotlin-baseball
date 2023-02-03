package baseball.view

import baseball.model.BaseBallResult
import camp.nextstep.edu.missionutils.Console
import java.lang.StringBuilder

class BaseBallView {
    fun startGame(){
        println("숫자 야구 게임을 시작합니다.")
    }

    fun inputNumber() : String{
        print("숫자를 입력해주세요 : ")
        val num = Console.readLine()
        println()
        return num
    }

    fun printResult(result : BaseBallResult){
        StringBuilder().apply {
            if(result.hasBall())
                this.append("${result.ballCnt}볼 ")
            if(result.hasStrike())
                this.append("${result.strikeCnt}스트라이크")
            if(result.isNothing())
                this.append("낫싱")
        }.also {
            println(it)
        }
    }

    fun finishGame(){
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

    fun restartQuestion() : Boolean {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        return Console.readLine().toInt() == 1
    }
}