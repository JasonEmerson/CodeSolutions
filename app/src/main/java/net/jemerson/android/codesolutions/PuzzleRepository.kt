package net.jemerson.android.codesolutions

import android.content.Context
import net.jemerson.android.codesolutions.puzzlesource.*
import java.util.*

class PuzzleRepository private constructor(context: Context) {

    private val puzzles = mutableListOf<Puzzle>()

    private val testPuzzle = TestPuzzle()
    private val testPuzzle2 = TestPuzzle2()


    fun getPuzzleList(): List<Puzzle> {
        addPuzzle(testPuzzle)
        addPuzzle(testPuzzle2)
        return puzzles
    }

    private fun addPuzzle(puzzle: Puzzle) {
        puzzles.add(puzzle)
    }

    fun getPuzzleFromList(uuid: UUID): Puzzle {
        val puzzlesFilter = puzzles.filter {it.id == uuid}
        return puzzlesFilter[0]
    }

    companion object {
        private var INSTANCE: PuzzleRepository? = null
        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = PuzzleRepository(context)
            }
        }

        fun get(): PuzzleRepository {
            return INSTANCE ?:
            throw IllegalStateException("PuzzleRepository must be initialized")
        }
    }
}