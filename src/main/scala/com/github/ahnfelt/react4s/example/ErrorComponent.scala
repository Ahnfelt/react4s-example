package com.github.ahnfelt.react4s.example

import com.github.ahnfelt.react4s._

case class ErrorComponent(error : P[String]) extends Component[NoEmit] {
    override def render() : Element = E.div(
        ErrorCss,
        Text("Error: " + Option(error()).getOrElse("Couldn't load artists."))
    )
}

object ErrorCss extends CssClass(
    S.color.rgb(150, 150, 160),
    S.position.absolute(),
    S("text-align", "center"),
    S.font("16px verdana, sans-serif"),
    S.top.px(10),
    S.left.px(0),
    S.right.px(0)
)
