package nl.vintik.workshop.kotlin.basics

import nl.vintik.workshop.kotlin.extensions.filterBySize
import nl.vintik.workshop.kotlin.extensions.filterByType
import java.util.UUID

class UnicornHouse {
    /**
     * Collections such as list or map by default are immutable, you need to explicitly specify one as mutable
     * For more see https://kotlinlang.org/docs/list-operations.html
     */
    val unicorns = mutableListOf<Unicorn>()

    /**
     * When expression example, for more see https://kotlinlang.org/docs/control-flow.html#when-expression
     * @param unicorn is defined as not null
     */
    fun enter(unicorn: Unicorn): String {
        unicorns += unicorn
        unicorn.description?.let { println(it) }
        return when (unicorn.type) {
            UnicornType.MALICORN -> "Welcome Malicious Unicorn Bob"
            UnicornType.DEMICORN -> "Not Used"
            UnicornType.UNICORN -> "Welcome European Unicorn Jane"
        }
    }

    fun bulkEnter(vararg unicorn: Unicorn): List<String> = unicorn.map { enter(it) }

    fun exit(unicornId: UUID): Boolean = unicorns.removeIf { it.id == unicornId }

    fun countUnicorns(): Int = unicorns.size

    fun countUnicornsByType(unicornType: UnicornType): Int = unicorns.filter { it.type == unicornType }.size

    fun mapUnicornsByType(): Map<UnicornType, Unicorn> = unicorns.associateBy { it.type }

    fun orderUnicornsBySizeDescending(): List<Unicorn> = unicorns.sortedByDescending { it.size }

    fun totalMagicInDaHouse(): Int = unicorns.sumOf { it.magic ?: 0 }

    fun filterUnicornsByType(vararg unicornType: UnicornType): List<Unicorn> = unicorns.filterByType(*unicornType)

    fun filterUnicornsBySize(sizeFrom: Int) =
        unicorns.filterBySize(sizeFrom)

}