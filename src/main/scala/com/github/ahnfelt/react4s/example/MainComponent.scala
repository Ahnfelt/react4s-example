package com.github.ahnfelt.react4s.example

import com.github.ahnfelt.react4s._
import org.scalajs.dom.ext.Ajax

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.scalajs.js

case class MainComponent() extends Component[NoEmit] {

    val query = State("")
    val debouncedQuery = Debounce(this, query, 500)

    val artists = Loader(this, debouncedQuery) { q =>
        if(q.trim.isEmpty) Future.successful(List()) else {
            Ajax.get("https://api.spotify.com/v1/search?q=" + js.URIUtils.encodeURIComponent(q) + "&type=artist").
                map { ajax =>
                    js.JSON.parse(ajax.responseText).
                        artists.items.
                        asInstanceOf[js.Array[js.Dynamic]].
                        toList.map(Artist.fromDynamic)
                }
        }
    }

    override def render() : Element = {
        E.div(
            E.div(
                Component(SearchInputComponent, query()).withHandler(q => query.set(q))
            ),
            E.div(
                Component(LoadingComponent).withKey("loading").when(artists.loading()),
                Tags(artists.error().map(e => Component(ErrorComponent, e.getMessage).withKey("error"))),
                Tags(artists().map(results => Component(ResultsComponent, results).withKey("results")))
            )
        )
    }
}
