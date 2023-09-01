package controllers

import play.api.mvc._

import javax.inject.Inject


class MyNewController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def index = Action {
    Ok("It works!")
  }
}
