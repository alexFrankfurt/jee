package com.alex.jee

import akka.http.scaladsl.marshalling.{Marshaller, ToEntityMarshaller}
import akka.http.scaladsl.model.{HttpEntity, MediaType}
import akka.http.scaladsl.model.MediaTypes._

trait Marshallers {
  implicit val mar: ToEntityMarshaller[play.twirl.api.HtmlFormat.Appendable] =
    twirlTemplateMarshaller(`text/html`)
  def twirlTemplateMarshaller(mediaType: MediaType.WithOpenCharset):
  ToEntityMarshaller[play.twirl.api.HtmlFormat.Appendable] =
    Marshaller.withOpenCharset(mediaType) {(s, cs) => HttpEntity(mediaType withCharset cs, s.toString())}
}
