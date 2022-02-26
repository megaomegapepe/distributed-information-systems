package ru.safenreiter.lab1.service

import java.io.InputStream
import javax.xml.stream.XMLEventReader
import javax.xml.stream.XMLInputFactory

object StaxStreamProcessor {

    private val xmlInputFactory = XMLInputFactory.newInstance()

    /**
     * Функция получения [XMLEventReader] из [InputStream].
     * @return [XMLEventReader], полученный из [InputStream].
     */
    fun getXmlEventReader(inputStream: InputStream): XMLEventReader {
        return xmlInputFactory.createXMLEventReader(inputStream)
    }
}
