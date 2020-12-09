package net.jemerson.android.codesolutions

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import java.util.*

private const val TAG = "PuzzleFragment"
private const val ARG_PUZZLE_ID = "puzzle_id"

class PuzzleFragment : Fragment()  {

    private lateinit var puzzle: Puzzle
    private lateinit var executeButton: Button
    private lateinit var solutionText: TextView
    private lateinit var puzzleDetailViewModel: PuzzleDetailViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //puzzle = Puzzle()
        val puzzleId: UUID = arguments?.getSerializable(ARG_PUZZLE_ID) as UUID
        Log.d(TAG, "args bundle puzzle ID: $puzzleId")
        puzzle = puzzleDetailViewModel.loadPuzzle(puzzleId)
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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        puzzleDetailViewModel = ViewModelProvider(this).get(PuzzleDetailViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()

        executeButton.setOnClickListener { view: View ->
            solutionText.text = puzzle.solution
        }
    }

    companion object {
        fun newInstance(puzzleId: UUID): PuzzleFragment {
            val args = Bundle().apply {
                putSerializable(ARG_PUZZLE_ID, puzzleId)
            }
            return PuzzleFragment().apply {
                arguments = args
            }
        }
    }
}