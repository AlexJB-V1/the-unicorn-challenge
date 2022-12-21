package nl.vintik.workshop.kotlin.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

// TODO: Check out what zip does
// TODO: Debug to see coroutines working
// TODO: What is unusual in the restaurant?
// TODO: Fill unicorn house with unicorns
// TODO: Let unicorns eat Christmas dinner, display name of unicorn for each println within coroutine scope

val plates = listOf(
    "Stuffed Turkey",
    "Roast Potatoes",
    "Pigs in Blankets",
    "Yorkshire Pudding",
    "Brussel Sprouts"
).zip(listOf("30", "20", "15", "20", "15"))

fun main() {
    runBlocking {
        eatChristmasDinner()
    }
}

suspend fun eatChristmasDinner() {
    coroutineScope {
        plates.forEach { plate ->
            println("The Unicorn came in!")
            launch {
                serveAndEat(plate)
            }
        }
    }
    println("Is everyone done?")
}

suspend fun serveAndEat(plate: Pair<String, String>) {
    println("Waiting for food")
    val (dish, size) = plate
    delay(Random.nextLong(100, 3000))
    println("I got my food, let me start eating this: $dish that's $size cm")
    delay(Random.nextLong(100, 3000))
    println("I'm done eating: $dish that's $size cm")
}
