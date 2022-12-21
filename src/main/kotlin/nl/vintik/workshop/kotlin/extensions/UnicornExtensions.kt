package nl.vintik.workshop.kotlin.extensions

import nl.vintik.workshop.kotlin.basics.Unicorn
import nl.vintik.workshop.kotlin.basics.UnicornType

fun Unicorn.toMalicorn(): Unicorn = TODO("Implement extension function with Unicorn as receiver")

fun Unicorn.computePower(): Int? = TODO("Implement extension function with Unicorn as receiver")

fun List<Unicorn>.filterByType(vararg unicornType: UnicornType): List<Unicorn> = TODO("Implement extension function with List<Unicorn> as receiver")

fun List<Unicorn>.filterBySize(sizeFrom: Int): List<Unicorn> = TODO("Implement extension function with List<Unicorn> as receiver")
