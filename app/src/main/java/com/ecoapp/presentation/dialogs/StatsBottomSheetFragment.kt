package com.ecoapp.presentation.dialogs

import dagger.hilt.android.AndroidEntryPoint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ecoapp.R
import com.ecoapp.databinding.FragmentStatsBottomSheetBinding
import com.ecoapp.utils.ITEM_STATS_FORMAT
import com.ecoapp.utils.LINE_BREAK
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.Locale

@AndroidEntryPoint
class StatsBottomSheetFragment(
    private val itemCounts: List<Int>,
    private val topCharacters: List<Pair<Char, Int>>
) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentStatsBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStatsBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayStatistics()
    }

    private fun displayStatistics() {
        val itemStats = itemCounts.joinToString(separator = LINE_BREAK) { count ->
            String.format(Locale.getDefault(), ITEM_STATS_FORMAT, getString(R.string.total), count)
        }
        val characterStats = topCharacters.joinToString(LINE_BREAK) { "${it.first} = ${it.second}" }

        with(binding) {
            itemCountTextView.text = itemStats
            characterCountTextView.text = characterStats
        }
    }

}
