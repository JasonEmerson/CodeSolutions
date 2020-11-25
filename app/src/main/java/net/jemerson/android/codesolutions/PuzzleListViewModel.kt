package net.jemerson.android.codesolutions

import androidx.lifecycle.ViewModel

class PuzzleListViewModel  : ViewModel() {

    var puzzles = mutableListOf<Puzzle>()

    init {
        for (i in 0 until 20) {
            val puzzle = Puzzle()
            puzzle.title = "Puzzle #$i"
            puzzles.plusAssign(puzzle)
        }
    }
}