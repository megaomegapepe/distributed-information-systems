package ru.safenreiter.lab1.service

import java.sql.Connection
import java.sql.DriverManager
import java.util.LinkedList
import ru.safenreiter.lab1.config.Properties
import ru.safenreiter.lab1.exception.AllContectionsAreBusyException

object ConnectionPool : AutoCloseable {

    private val freeConnections = LinkedList<Connection>()


    init {
        repeat(Properties.CONNECTION_POOL_SIZE) {
            Class.forName("org.postgresql.Driver")
            DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "postgres")
                .let { connection -> freeConnections.push(connection) }
        }
    }

    fun getConnection() =
        takeIf { freeConnections.isNotEmpty() }
            ?.let { freeConnections.pop() }
            ?: throw AllContectionsAreBusyException()

    fun close(connection: Connection) = freeConnections.push(connection)

    override fun close() =
        freeConnections
            .forEach { connection -> connection.close() }
            .also { freeConnections.clear() }
            .also { println("Все соединения к бд закрыты") }

}