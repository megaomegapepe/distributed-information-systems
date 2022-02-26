package ru.safenreiter.lab1.config

/**
 * Класс свойств программы.
 * В падлу выносить.
 */
object Properties {

    /**
     * Наименование тега, для которого будет
     * собираться статистика.
     */
    const val NODE_ELEMENT_NAME = "node"

    /**
     * Количество элементов с именем [NODE_ELEMENT_NAME]
     * для обработки.
     */
    const val COUNT_NODES_FOR_READ = 10000000

    /**
     * Наименование файла open-street map.
     * Должен лежать в папке /src/main/resources.
     */
    const val FILE_NAME = "RU-NVS.osm"
}