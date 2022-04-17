package ru.safenreiter.lab1.extensions.connection

import java.sql.Connection
import ru.safenreiter.lab1.service.ConnectionPool


fun Connection.close() = ConnectionPool.close(this)
