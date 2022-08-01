package com.example.packers.presentation.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.packers.databinding.FragmentScheduleBinding
import com.example.packers.presentation.schedule.adapter.ScheduleAdapter
import com.example.packers.presentation.schedule.viewmodel.ScheduleViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ScheduleFragment : Fragment() {

    private var _binding: FragmentScheduleBinding? = null
    private val binding: FragmentScheduleBinding get() = _binding!!
    private val viewModel by viewModels<ScheduleViewModel>()
    private val scheduleAdapter by lazy {
        ScheduleAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScheduleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            recyclerViewSchedule.apply {
                adapter = scheduleAdapter
                addItemDecoration(
                    DividerItemDecoration(
                        requireContext(),
                        LinearLayoutManager.VERTICAL
                    )
                )
            }
            viewLifecycleOwner.lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.viewState.collect { state ->
                        viewLoading.root.isVisible = state.isLoading
                        viewError.root.isVisible = state.hasError
                        val recyclerViewIsVisible = !state.isLoading && !state.hasError
                        recyclerViewSchedule.isVisible = recyclerViewIsVisible
                        if (recyclerViewIsVisible) {
                            scheduleAdapter.submitList(state.gameInfo)
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}