package net.jemerson.android.codesolutions

import java.util.*

private const val TAG = "Puzzle"

class Puzzle(val id: UUID = UUID.randomUUID(),
             var title: String = "",
             var solution: String = "") {

     fun helloWorld(): String {
         solution = "Hello World"
         return solution
     }
}