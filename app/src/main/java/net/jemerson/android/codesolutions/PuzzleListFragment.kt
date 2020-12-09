package net.jemerson.android.codesolutions

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

private const val TAG = "SolutionListFragment"

class PuzzleListFragment : Fragment() {

    /**
     * * Hosting activity implements this interface
     */
    interface Callbacks {
        fun onPuzzleSelected(puzzleId: UUID)
    }

    private var callbacks: Callbacks? = null

    private lateinit var puzzleListViewModel: PuzzleListViewModel
    private lateinit var puzzleRecyclerView: RecyclerView
    private var adapter: PuzzleAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "TOTAL PUZZLES: ${puzzleListViewModel.puzzles.size}")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        puzzleListViewModel = ViewModelProvider(this).get(PuzzleListViewModel::class.java)
        callbacks = context as Callbacks?
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_puzzle_list, container, false)

        puzzleRecyclerView =
            view.findViewById(R.id.puzzle_recycler_view) as RecyclerView
        puzzleRecyclerView.layoutManager = LinearLayoutManager(context)

        updateUI()

        return view
    }

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }

    private fun updateUI() {
        val puzzles = puzzleListViewModel.puzzles
        adapter = PuzzleAdapter(puzzles)
        puzzleRecyclerView.adapter = adapter
    }

    private inner class PuzzleHolder(view: View)
        : RecyclerView.ViewHolder(view), View.OnClickListener {

            private lateinit var puzzle: Puzzle

            private val titleTextView: TextView = itemView.findViewById(R.id.puzzle_title)

            init {
                itemView.setOnClickListener(this)
            }

            fun bind(puzzle: Puzzle) {
                this.puzzle = puzzle
                titleTextView.text = this.puzzle.title
            }

            override fun onClick(v: View) {
                callbacks?.onPuzzleSelected(puzzle.id)
            }
        }

    private inner class PuzzleAdapter(var puzzles: List<Puzzle>)
        : RecyclerView.Adapter<PuzzleHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
                : PuzzleHolder {
            val view = layoutInflater.inflate(R.layout.list_item_puzzle, parent, false)
            return PuzzleHolder(view)
        }

        override fun getItemCount() = puzzles.size

        override fun onBindViewHolder(holder: PuzzleHolder, position: Int) {
            val puzzle = puzzles[position]
            holder.bind(puzzle)
        }
    }

    companion object {
        fun newInstance(): PuzzleListFragment {
            return PuzzleListFragment()
        }
    }
}

