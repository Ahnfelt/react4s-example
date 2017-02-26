package com.github.ahnfelt.react4s.example

import com.github.ahnfelt.react4s._

case class ResultsComponent(results : P[List[Artist]]) extends Component[NoEmit] {

    val timeout = Timeout(this, results)(_ => 100)

    override def render() : Element = E.div(
        ResultsCss,
        Tags(for((artist, index) <- results().zipWithIndex) yield E.a(
            ArtistCss,
            S("transition-delay").ms(index * 100),
            S("opacity", "1").when(timeout()),
            A.href(artist.url),
            A.target("_blank"),
            Tags(artist.images.headOption.map(i => S("background-image").url(i.url))),
            E.div(ArtistNameCss, Text(artist.name))
        ).withKey(artist.id))
    )
}



object ResultsCss extends CssClass(
    S("text-align", "center"),
    S.padding.px(20)
)

object ArtistCss extends CssClass(
    S.display.inlineBlock(),
    S.position.relative(),
    S.margin.px(20).px(20),
    S.width.px(200),
    S.height.px(180),
    S.backgroundColor.rgb(80, 80, 90),
    S.borderRadius.px(2),
    S("border", "none"),
    S("outline", "none"),
    S("text-decoration", "none"),
    S("opacity", "0"),
    S("transition", "opacity 1s"),
    S("overflow", "hidden"),
    S("background-size", "auto 200px"),
    S("background-position", "top center"),
    S("background-repeat", "no-repeat"),
    Css.hover(
        S.boxShadow.px(0).px(0).px(0).px(5).rgb(150, 150, 160)
    ),
    Css.active(
        S.boxShadow.px(0).px(0).px(0).px(3).rgb(150, 150, 160)
    )
)

object ArtistNameCss extends CssClass(
    S.position.absolute(),
    S.bottom.px(0),
    S.left.px(0),
    S.right.px(0),
    S.height.px(20),
    S("text-align", "center"),
    S.font("16px verdana, sans-serif"),
    S("padding-bottom").px(2),
    S.color("#ffffff"),
    S.textShadow("0 1px 4px black")
)
