package com.github.ahnfelt.react4s.example

import com.github.ahnfelt.react4s._

import scala.scalajs.js

object Main extends js.JSApp {
    def main() : Unit = {
        val component = Component(MainComponent)
        ReactBridge.renderToDomById(component, "main")
    }
}
