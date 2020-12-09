package net.jemerson.android.codesolutions

import androidx.lifecycle.ViewModel

class PuzzleListViewModel  : ViewModel() {

    private val puzzleRepository = PuzzleRepository.get()
    val puzzles = puzzleRepository.getPuzzleList()
}