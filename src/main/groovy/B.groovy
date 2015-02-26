import groovy.sql.Sql

/**
 * Created by ama on 2015/2/26.
 */



def sql = Sql.newInstance("jdbc:derby:MyDB","", "", "org.apache.derby.jdbc.EmbeddedDriver")

sql.eachRow("select * from MyTable", {
    println "likes ${it.name} ${it.id} ${it.score}"
    println it
})