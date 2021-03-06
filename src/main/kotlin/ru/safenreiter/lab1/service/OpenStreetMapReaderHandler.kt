package ru.safenreiter.lab1.service

import javax.xml.stream.XMLEventReader
import ru.safenreiter.lab1.config.Properties.COUNT_NODES_FOR_READ
import ru.safenreiter.lab1.extensions.event.collectStatistic
import ru.safenreiter.lab1.statistic.StatisticMap

object OpenStreetMapReaderHandler {

    /**
     * Функция для обработки входящих ивентов
     * и сбора статистики, которая будет записана
     * в [StatisticMap].
     * Количество обработанных тегов с именем []
     *
     * @param reader - Event reader.
     */
    fun processTheReader(reader: XMLEventReader) {
        var countOfReadNodes = 1
        while (reader.hasNext()) {
            reader.nextEvent().collectStatistic()
            countOfReadNodes++
            if (countOfReadNodes > COUNT_NODES_FOR_READ)
                break
        }
        println(StatisticMap)
    }
}