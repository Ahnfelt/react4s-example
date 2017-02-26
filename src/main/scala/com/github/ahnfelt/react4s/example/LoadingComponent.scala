package com.github.ahnfelt.react4s.example

import com.github.ahnfelt.react4s._

case class LoadingComponent() extends Component[NoEmit] {
    override def render() : Element = E.div(
        Text("Loading...")
    )
}
