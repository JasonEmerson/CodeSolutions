package net.jemerson.android.codesolutions

import androidx.fragment.app.Fragment
import java.util.*

private const val TAG = "SolutionListFragment"

class PuzzleListFragment : Fragment() {

    /**
     * Required interface for hosting activities
     */
    interface Callbacks {
        fun onPuzzleSelected(crimeId: UUID)
    }
}

