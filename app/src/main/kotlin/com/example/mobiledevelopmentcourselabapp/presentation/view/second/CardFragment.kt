package com.example.mobiledevelopmentcourselabapp.presentation.view.second

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.PluralsRes
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.mobiledevelopmentcourselabapp.R
import com.example.mobiledevelopmentcourselabapp.databinding.FragmentCardBinding
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.adapter.PlayersAdapter
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.model.PlayerUiModel

class CardFragment : Fragment() {

    private var _binding: FragmentCardBinding? = null

    private val binding get() = _binding!!
    private val player by lazy { arguments?.getSerializable(CARD_PLAYER_KEY) as? PlayerUiModel }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        
        return root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.card, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_share -> {
                sharePlayerText()
                true
            }
            else -> true
        }
    }

    private fun sharePlayerText() {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, player.toString())
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        player?.let { player ->
            binding.name.text = player.name
            binding.number.text = player.number.toString()

            setStat(binding.ageValue, player.age, R.plurals.age)
            binding.positionValue.text = player.position.rusName
            binding.teamValue.text = player.team

            Glide
                .with(this)
                .load(player.photoUrl)
                .circleCrop()
                .into(binding.icon)

            setStat(binding.gamesCount, player.gamesCount, R.plurals.games)
            setStat(binding.goalsCount, player.goalsCount, R.plurals.goals)
            setStat(binding.gamesGrade, player.gamesGrade, R.plurals.games)
            setStat(binding.matchGrade, player.matchGrade, R.plurals.games)
            setStat(binding.redCardsCount, player.redCardsCount, R.plurals.age)
        }

    }

    private fun setStat(view: TextView, count: Int, @PluralsRes plural: Int) {
        view.text =
            resources.getString(
                R.string.count_pattern,
                count,
                resources.getQuantityString(plural, count)
            )
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        const val CARD_PLAYER_KEY = "PLAYER"
    }
}
