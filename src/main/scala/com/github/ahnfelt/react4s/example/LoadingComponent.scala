package com.github.ahnfelt.react4s.example

import com.github.ahnfelt.react4s._

case class LoadingComponent() extends Component[NoEmit] {
    override def render(get : Get) : Element = E.div(
        LoadingCss,
        Text("Loading...")
    )
}

object LoadingCss extends CssClass(
    S.color.rgb(150, 150, 160),
    S.position.absolute(),
    S("text-align", "center"),
    S.font("16px verdana, sans-serif"),
    S.top.px(90),
    S.left.px(0),
    S.right.px(0)
)
