package net.jemerson.android.codesolutions

import androidx.lifecycle.ViewModel
import java.util.*

class PuzzleDetailViewModel : ViewModel() {

    private lateinit var uuid: UUID
    private val puzzleRepository = PuzzleRepository.get()
    private lateinit var puzzle: Puzzle

    fun loadPuzzle(uuid: UUID): Puzzle {
        puzzle = puzzleRepository.getPuzzleFromList(uuid)
        return puzzle
    }
}