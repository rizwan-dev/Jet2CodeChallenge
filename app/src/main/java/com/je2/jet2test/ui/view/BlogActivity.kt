package com.je2.jet2test.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.android.codelabs.paging.ui.BlogsLoadStateAdapter
import com.je2.jet2test.Injection
import com.je2.jet2test.R
import com.je2.jet2test.databinding.ActivityBlogBinding
import com.je2.jet2test.ui.adapter.BlogsAdapter
import com.je2.jet2test.ui.viewmodel.BlogsViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class BlogActivity : AppCompatActivity() {
    lateinit var binding: ActivityBlogBinding

    private lateinit var viewModel: BlogsViewModel
    private val adapter = BlogsAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()

        setUpRecyclerView()
    }



    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, Injection.provideViewModelFactory(this))
            .get(BlogsViewModel::class.java)

        lifecycleScope.launch {
            viewModel.loadArticles().collectLatest {
                adapter.submitData(it)
            }
        }

    }

    private fun setUpRecyclerView() {
        val decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        binding.rvBlogs.addItemDecoration(decoration)

        initAdapter()
        binding.retryButton.setOnClickListener { adapter.retry() }
    }

    private fun initAdapter() {
        binding.rvBlogs.adapter = adapter.withLoadStateHeaderAndFooter(
            header = BlogsLoadStateAdapter { adapter.retry() },
            footer = BlogsLoadStateAdapter { adapter.retry() }
        )
        adapter.addLoadStateListener { loadState ->
            // Only show the list if refresh succeeds.
            binding.rvBlogs.isVisible = loadState.source.refresh is LoadState.NotLoading
            // Show loading spinner during initial load or refresh.
            binding.progressBar.isVisible = loadState.source.refresh is LoadState.Loading
            // Show the retry state if initial load or refresh fails.
            binding.retryButton.isVisible = loadState.source.refresh is LoadState.Error

            // Toast on any error, regardless of whether it came from RemoteMediator or PagingSource
            val errorState = loadState.source.append as? LoadState.Error
                ?: loadState.source.prepend as? LoadState.Error
                ?: loadState.append as? LoadState.Error
                ?: loadState.prepend as? LoadState.Error
            errorState?.let {
                Toast.makeText(
                    this,
                    "\uD83D\uDE28 Wooops ${it.error}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    }
}