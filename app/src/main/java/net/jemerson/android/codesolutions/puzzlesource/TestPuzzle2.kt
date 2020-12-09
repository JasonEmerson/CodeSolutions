package net.jemerson.android.codesolutions.puzzlesource

import net.jemerson.android.codesolutions.Puzzle

class TestPuzzle2 : Puzzle() {

    override var title = "HelloWorld2"
    override var solution = sayHello()

    private fun sayHello(): String {
        return "Hello World2!"
    }
}