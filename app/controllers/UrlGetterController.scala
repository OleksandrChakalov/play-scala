package controllers

import play.api.data.Form
import play.api.libs.json.Json

import scala.collection.mutable.ListBuffer
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}

import javax.inject.{Inject, Singleton}

@Singleton
class UrlGetterController @Inject()(cc: ControllerComponents) (implicit assetsFinder: AssetsFinder)
  extends AbstractController(cc) {
  def index: Action[AnyContent] = Action {
    Ok(views.html.index("Your new application is ready. WOW!"))
  }

  var urlCollection: Map[String, String] = Map.empty
//
//  def insertIntoCollection(url: String): Unit = {
//    urlCollection += (url -> url)
//  }

  def getUrl: Action[AnyContent] = Action { implicit request =>
    val url = request.body.asFormUrlEncoded.get("url").head
    urlCollection += (url -> url)
    Ok(Json.toJson(url))
  }

}
