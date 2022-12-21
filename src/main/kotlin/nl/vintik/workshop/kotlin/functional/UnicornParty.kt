package nl.vintik.workshop.kotlin.functional

import nl.vintik.workshop.kotlin.basics.Unicorn
import nl.vintik.workshop.kotlin.basics.UnicornHouse
import nl.vintik.workshop.kotlin.basics.UnicornType
import nl.vintik.workshop.kotlin.extensions.filterByType
import javax.script.Invocable


fun UnicornHouse.partyHardy(): List<String> {
    val faceControl = ::onlyBig and ::onlyBad
    return party(faceControl)
}

fun UnicornHouse.partyMildly(): List<String> {
    val faceControl = ::onlyGood
    return party(faceControl)
}

private fun UnicornHouse.party(faceControl: (List<Unicorn>) -> List<Unicorn>) =
    faceControl.invoke(this.unicorns).map { it.name }


private fun onlyBig(unicorns: List<Unicorn>): List<Unicorn> = unicorns.filter { compareValues(it.size, 10) > 0}

private fun onlyGood(unicorns: List<Unicorn>) = unicorns.filterByType(UnicornType.UNICORN, UnicornType.DEMICORN)

private fun onlyBad(unicorns: List<Unicorn>) = unicorns.filterByType(UnicornType.MALICORN)

private infix fun ((List<Unicorn>) -> List<Unicorn>).and(other: (List<Unicorn>) -> List<Unicorn>): (List<Unicorn>) -> List<Unicorn> =
    { other(this(it)) }
