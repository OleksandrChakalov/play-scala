package controllers

import play.api.data.Form
import play.api.libs.json.Json

import scala.collection.mutable.ListBuffer
import play.api.mvc.{AbstractController, ControllerComponents}

import javax.inject.{Inject, Singleton}

@Singleton
class UrlGetterController @Inject()(cc: ControllerComponents) (implicit assetsFinder: AssetsFinder)
  extends AbstractController(cc) {
  def index = Action {
    Ok(views.html.urlindex("Your new application is ready. WOW!"))
  }

  val urlCollection: ListBuffer[String] = ListBuffer()

  val urlForm: Form[String] = Form[String](
    "url" -> play.api.data.Forms.text
  )

  def submitUrl = Action { implicit request =>
    val url = request.body.asFormUrlEncoded.get("url").head
    urlCollection += url
    Ok(Json.toJson(url))
  }

}
