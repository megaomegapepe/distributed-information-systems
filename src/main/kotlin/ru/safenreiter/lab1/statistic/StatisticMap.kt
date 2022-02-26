package ru.safenreiter.lab1.statistic

/**
 * Map для хранения статистики пользователей.
 * Ключ - username пользователя.
 * Значение - количество правок пользователя.
 */
object StatisticMap : HashMap<String, Int>() {

    override fun toString(): String {
        StringBuilder().let {
            forEach { (key, value) ->
                it.append("$key:$value \n")
            }
            return it.toString()
        }
    }
}
