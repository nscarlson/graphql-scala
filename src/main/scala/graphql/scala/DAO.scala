package graphql.scala

import DBSchema._
import slick.jdbc.H2Profile.api._

import graphql.scala.models.Link
import scala.concurrent.Future

class DAO(db: Database) {
  def allLinks =
    db.run(Links.result)

  def getLink(id: Int): Future[Option[Link]] =
    db.run(Links.filter(_.id === id).result.headOption)

  def getLinks(ids: Seq[Int]) =
    db.run(Links.filter(_.id inSet ids).result)
}
