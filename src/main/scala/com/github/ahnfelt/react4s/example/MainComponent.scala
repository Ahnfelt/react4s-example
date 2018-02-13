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
            Ajax.get("http://show.ahnfelt.net/react4s-spotify/?q=" + js.URIUtils.encodeURIComponent(q) + "&type=artist").
                map { ajax =>
                    js.JSON.parse(ajax.responseText).
                        artists.items.
                        asInstanceOf[js.Array[js.Dynamic]].
                        toList.map(Artist.fromDynamic)
                }
        }
    }

    override def render(get : Get) : Element = {
        E.div(
            E.div(
                Component(SearchInputComponent, get(query)).withHandler(q => query.set(q))
            ),
            E.div(
                Component(LoadingComponent).withKey("loading").when(get(artists.loading)),
                Tags(get(artists.error).map(e => Component(ErrorComponent, e.getMessage).withKey("error"))),
                Tags(get(artists).map(results => Component(ResultsComponent, results).withKey("results")))
            )
        )
    }
}
