package net.jemerson.android.codesolutions

import android.app.Application

class CodeSolutionsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        PuzzleRepository.initialize(this)
    }
}