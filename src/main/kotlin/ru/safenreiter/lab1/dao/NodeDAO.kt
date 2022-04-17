package ru.safenreiter.lab1.dao

import java.sql.Date
import ru.safenreiter.lab1.Node
import ru.safenreiter.lab1.config.Properties
import ru.safenreiter.lab1.service.ConnectionPool

object NodeDAO {

    fun insertNode(node: Node) {
        var counter = 0
        ConnectionPool
            .getConnection()
            .prepareStatement("INSERT INTO node (id, lat, lon, username, uid, version, changeset, date_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")
            .apply {
                setLong(1, node.id.toLong())
                setDouble(2, node.lat)
                setDouble(3, node.lon)
                setString(4, node.user)
                setLong(5, node.uid.toLong())
                setLong(6, node.version.toLong())
                setLong(7, node.changeset.toLong())
                setDate(8, Date(node.timestamp.toGregorianCalendar().time.time))
            }
            .let { preparedStatement ->
                if (counter < Properties.BATCH_SIZE) {
                    preparedStatement.addBatch()
                    counter++
                } else {
                    preparedStatement.executeBatch()
                    counter = 0
                }
            }


    }

}