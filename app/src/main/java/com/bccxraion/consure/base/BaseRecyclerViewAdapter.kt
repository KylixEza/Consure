package com.bccxraion.consure.base

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseRecyclerViewAdapter<VB: ViewBinding, ListType>
    : RecyclerView.Adapter<BaseRecyclerViewAdapter<VB, ListType>.BaseViewHolder>() {

    val itemList = arrayListOf<ListType>().toMutableList()

    protected abstract fun inflateViewBinding(
        parent: ViewGroup
    ): VB

    open val binder: (ListType, VB) -> Unit = { _, _ ->}
    open val binderWithPosition: (ListType, VB, Int) -> Unit = { _, _, _ ->}

    protected abstract val diffUtilBuilder: (List<ListType>, List<ListType>) -> DiffUtil.Callback?

    var position: Int? = null
    var specificItemPosition: Int = 0
    val size get() = itemList.size
    lateinit var itemView: View

    fun submitList(data: List<ListType>) {
        if(diffUtilBuilder != null) {
            val diffCallback = diffUtilBuilder(itemList, data)
            val diffResult = DiffUtil.calculateDiff(diffCallback!!)
            itemList.apply {
                clear()
                addAll(data)
            }
            
            diffResult.dispatchUpdatesTo(this)
        } else {
            itemList.apply {
                clear()
                addAll(data)
            }
            notifyDataSetChanged()
        }
        
    }

    inner class BaseViewHolder(val view: VB): RecyclerView.ViewHolder(view.root) {
        fun bind(item: ListType, position: Int) {
            this@BaseRecyclerViewAdapter.itemView = itemView
            binder(item, view)
            binderWithPosition(item, view, position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view = inflateViewBinding(parent)
        return BaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        this@BaseRecyclerViewAdapter.position = position
        holder.bind(itemList[position], position)
    }

    override fun getItemCount(): Int = itemList.size
    
}