package net.jemerson.android.codesolutions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

private const val TAG = "SolutionFragment"

class PuzzleFragment : Fragment()  {

    private lateinit var puzzle: Puzzle
    private lateinit var executeButton: Button
    private lateinit var solutionText: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        puzzle = Puzzle()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_puzzle, container, false)
        executeButton = view.findViewById(R.id.puzzle_execute) as Button
        solutionText = view.findViewById(R.id.puzzle_solution) as TextView

        return view
    }

    override fun onStart() {
        super.onStart()

        executeButton.setOnClickListener { view: View ->
            solutionText.text = puzzle.helloWorld()
        }
    }

    companion object {
        fun newInstance() : PuzzleFragment {
            return PuzzleFragment()
        }
    }
}