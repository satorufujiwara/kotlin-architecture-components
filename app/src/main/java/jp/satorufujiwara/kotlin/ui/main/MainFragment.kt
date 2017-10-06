package jp.satorufujiwara.kotlin.ui.main

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.satorufujiwara.kotlin.R
import jp.satorufujiwara.kotlin.data.model.Repo
import jp.satorufujiwara.kotlin.databinding.MainFragmentBinding
import jp.satorufujiwara.kotlin.databinding.MainRepoItemBinding
import jp.satorufujiwara.kotlin.di.Injectable
import jp.satorufujiwara.kotlin.ui.app.UserViewModel
import jp.satorufujiwara.kotlin.util.ext.observe
import javax.inject.Inject

class MainFragment : Fragment(), Injectable {

  @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
  @Inject lateinit var userViewModel: UserViewModel
  private val viewModel by lazy { ViewModelProviders.of(activity, viewModelFactory).get(MainViewModel::class.java) }
  private lateinit var binding: MainFragmentBinding
  private val adapter = MainAdapter()

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
      DataBindingUtil.inflate<MainFragmentBinding>(inflater, R.layout.main_fragment, container, false).also {
        binding = it
      }.root

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    binding.recyclerView.adapter = adapter
    binding.recyclerView.layoutManager = LinearLayoutManager(activity)

    viewModel.repos.observe(this) {
      it ?: return@observe
      adapter.run {
        items.clear()
        items.addAll(it)
        notifyDataSetChanged()
      }
    }
    userViewModel.loginUserId.observe(this) {
      viewModel.ownerId.value = it
    }
  }

  companion object {
    fun newInstance() = MainFragment()
  }
}

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
  val items = ArrayList<Repo>()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
    return ViewHolder(DataBindingUtil.inflate<MainRepoItemBinding>(
        LayoutInflater.from(parent.context), R.layout.main_repo_item, parent, false))
  }

  override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
    holder.binding.repo = items[position]
  }

  override fun getItemCount() = items.size

  inner class ViewHolder(val binding: MainRepoItemBinding) : RecyclerView.ViewHolder(binding.root)
}