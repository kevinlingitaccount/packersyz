package com.example.packers.presentation.schedule.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.packers.databinding.ItemByeWeekBinding
import com.example.packers.databinding.ItemFinalGameBinding
import com.example.packers.databinding.ItemScheduledGameBinding
import com.example.packers.databinding.ItemSeasonHeaderBinding
import com.example.packers.presentation.schedule.model.WeekInfo
import com.example.packers.presentation.utils.BaseViewHolder
import com.example.packers.presentation.utils.utils.loadImage

class ScheduleAdapter : ListAdapter<WeekInfo, BaseViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            0 -> {
                SectionHeaderViewHolder(
                    ItemSeasonHeaderBinding.inflate(
                        layoutInflater,
                        parent,
                        false
                    )
                )
            }
            1 -> {
                ScheduledWeekViewHolder(
                    ItemScheduledGameBinding.inflate(
                        layoutInflater,
                        parent,
                        false
                    )
                )
            }
            2 -> {
                ByeWeekViewHolder(ItemByeWeekBinding.inflate(layoutInflater, parent, false))
            }
            else -> {
                FinalWeekViewHolder(
                    ItemFinalGameBinding.inflate(
                        layoutInflater,
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (val data = currentList[position]) {
            is WeekInfo.Header -> {
                (holder as SectionHeaderViewHolder).bind(data)
            }
            is WeekInfo.ScheduledGame -> {
                (holder as ScheduledWeekViewHolder).bind(data)
            }
            is WeekInfo.ByeWeek -> {}
            is WeekInfo.FinishedGame -> {
                (holder as FinalWeekViewHolder).bind(data)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (currentList[position]) {
            is WeekInfo.Header -> 0
            is WeekInfo.ScheduledGame -> 1
            is WeekInfo.ByeWeek -> 2
            is WeekInfo.FinishedGame -> 3
        }
    }

    class SectionHeaderViewHolder(
        private val binding: ItemSeasonHeaderBinding
    ) : BaseViewHolder(binding.root) {
        fun bind(data: WeekInfo.Header) {
            binding.textHeader.text = data.header
        }
    }

    class ScheduledWeekViewHolder(
        private val binding: ItemScheduledGameBinding
    ) : BaseViewHolder(binding.root) {
        fun bind(data: WeekInfo.ScheduledGame) {
            with(binding) {
                textHomeTeam.text = data.homeTeamName
                textHomeRecord.text = data.homeRecord
                imageHome.loadImage(data.homeTeamLogo)
                textDate.text = data.date
                textNetwork.text = data.network
                textWeek.text = data.week
                textAwayTeam.text = data.awayTeamName
                textAwayRecord.text = data.awayRecord
                textTime.text = data.time
                imageAway.loadImage(data.awayTeamLogo)
            }
        }
    }

    class FinalWeekViewHolder(
        private val binding: ItemFinalGameBinding
    ) : BaseViewHolder(binding.root) {
        fun bind(data: WeekInfo.FinishedGame) {
            with(binding) {
                textHomeTeam.text = data.homeTeamName
                textHomeScore.text = data.homeScore
                imageHome.loadImage(data.homeTeamLogo)
                textDate.text = data.date
                textWeek.text = data.week
                textAwayTeam.text = data.awayTeamName
                textAwayScore.text = data.awayScore
                imageAway.loadImage(data.awayTeamLogo)
                textGameState.text = data.gameState
            }
        }
    }

    class ByeWeekViewHolder(binding: ItemByeWeekBinding) : BaseViewHolder(binding.root)

    class DiffCallback : DiffUtil.ItemCallback<WeekInfo>() {
        override fun areItemsTheSame(oldItem: WeekInfo, newItem: WeekInfo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: WeekInfo, newItem: WeekInfo): Boolean {
            return oldItem == newItem
        }

    }
}