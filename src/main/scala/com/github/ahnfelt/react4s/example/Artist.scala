package com.github.ahnfelt.react4s.example

import scala.scalajs.js

case class Artist(
    id : String,
    url : String,
    name : String,
    followers : Int,
    genres : List[String],
    images : List[Artist.Image]
)

object Artist {
    case class Image(url : String, width : Int, height : Int)

    def fromDynamic(dynamic : js.Dynamic) : Artist = Artist(
        id = dynamic.id.asInstanceOf[String],
        url = dynamic.external_urls.spotify.asInstanceOf[String],
        name = dynamic.name.asInstanceOf[String],
        followers = dynamic.followers.total.asInstanceOf[Int],
        genres = dynamic.genres.asInstanceOf[js.Array[String]].toList,
        images = dynamic.images.asInstanceOf[js.Array[js.Dynamic]].toList.map(imageFromDynamic)
    )

    def imageFromDynamic(dynamic : js.Dynamic) : Artist.Image = Artist.Image(
        url = dynamic.url.asInstanceOf[String],
        width = dynamic.width.asInstanceOf[Int],
        height = dynamic.height.asInstanceOf[Int]
    )
}
