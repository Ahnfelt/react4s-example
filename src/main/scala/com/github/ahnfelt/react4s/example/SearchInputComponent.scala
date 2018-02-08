package com.github.ahnfelt.react4s.example

import com.github.ahnfelt.react4s._

case class SearchInputComponent(query : P[String]) extends Component[String] {
    override def render(get : Get) : Element = E.div(
        SearchInputCss,
        E.input(
            InputCss,
            A.placeholder("Search Spotify"),
            A.autoFocus(),
            A.value(get(query)),
            A.onChangeText(q => emit(q))
        )
    )
}

object SearchInputCss extends CssClass(
    S("padding-top").px(40),
    S("text-align", "center")
)

object InputCss extends CssClass(
    S.outline.none(),
    S.height.px(30),
    S.width.px(250),
    S.borderRadius.px(30),
    S("padding-left").px(15),
    S.font("16px verdana, sans-serif"),
    S.color.rgb(255, 255, 255),
    S.backgroundColor.rgb(150, 150, 160),
    S.border.px(5).solid().rgb(80, 80, 90),
    Css.pseudo(":-webkit-input-placeholder", S.color.rgb(0, 0, 0)),
    Css.pseudo(":-ms-input-placeholder", S.color.rgb(0, 0, 0)),
    Css.pseudo(":-moz-placeholder", S.color.rgb(0, 0, 0)),
    Css.pseudo("-moz-placeholder", S.color.rgb(0, 0, 0)),
    Css.pseudo(":placeholder", S.color.rgb(0, 0, 0))
)
