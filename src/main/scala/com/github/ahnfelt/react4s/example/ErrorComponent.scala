package com.github.ahnfelt.react4s.example

import com.github.ahnfelt.react4s._

case class ErrorComponent(error : P[String]) extends Component[NoEmit] {
    override def render() : Element = E.div(
        ErrorCss,
        Text(error())
    )
}

object ErrorCss extends CssClass(
    S.color.rgb(255, 0, 0)
)
