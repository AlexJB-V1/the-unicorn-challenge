package nl.vintik.workshop.kotlin.extensions

import nl.vintik.workshop.kotlin.basics.Unicorn
import nl.vintik.workshop.kotlin.basics.UnicornType

fun Unicorn.toMalicorn(): Unicorn = this.apply {
    type = UnicornType.MALICORN
}

fun Unicorn.computePower(): Int? = if (magic != null && size != null) magic * size else null // TODO better way?

fun List<Unicorn>.filterByType(vararg unicornType: UnicornType): List<Unicorn> = this.filter { it.type in unicornType }

fun List<Unicorn>.filterBySize(sizeFrom: Int): List<Unicorn> = this.filter { compareValues(it.size, sizeFrom) >= 0 }