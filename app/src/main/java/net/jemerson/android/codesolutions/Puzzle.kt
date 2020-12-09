package net.jemerson.android.codesolutions

import java.util.*

private const val TAG = "Puzzle"

open class Puzzle(val id: UUID = UUID.randomUUID(),
                      open var title: String = "",
                      open var solution: String = "SUPER CLASS SOLUTION")
