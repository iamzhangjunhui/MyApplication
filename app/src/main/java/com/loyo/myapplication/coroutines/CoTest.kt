import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.lang.Thread.sleep
import kotlin.system.*


fun main() = runBlocking<Unit> {
    //    localThread.set("main")
//    print("value1:${localThread.get()}")
//    launch(
//        Dispatchers.Default + localThread.asContextElement("lauch")
//    ) {
//        print("value2:${localThread.get()}")
//
//    }
//    print("value3:${localThread.get()}")
    listOf(1, 2, 3).asFlow().transform {
        emit(1)
        emit(2)
    }.reduce { a, b -> a - b }

    val sum = (1..5).asFlow()
        .map { it * it } // 数字 1 至 5 的平方
        .flowOn(Dispatchers.Default).reduce() { a, b -> a + b } // 求和（末端操作符）
    flowOf(1,2,4)
    println(sum)
}

