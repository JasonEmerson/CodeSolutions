package net.jemerson.android.codesolutions.puzzlesource

import net.jemerson.android.codesolutions.Puzzle

class TestPuzzle : Puzzle() {

    override var title = "HelloWorld"
    override var solution = sayHello()

    private fun sayHello(): String {
        return "Hello World!"
    }
}