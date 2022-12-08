package com.bccxraion.consure.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.bccxraion.consure.base.BaseRecyclerViewAdapter
import com.bccxraion.consure.databinding.ItemListPackageStepBinding
import com.bccxraion.consure.diff_callback.PackageStepCallback

class PackageStepAdapter: BaseRecyclerViewAdapter<ItemListPackageStepBinding, Int>() {
    
    lateinit var listener: PackageStepListener
    
    override fun inflateViewBinding(parent: ViewGroup): ItemListPackageStepBinding {
        return ItemListPackageStepBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }
    
    override val binder: (Int, ItemListPackageStepBinding) -> Unit
        get() = { data, binding ->
            binding.ivPackage.setImageResource(data)
            itemView.setOnClickListener {
                listener.onPackageStepClicked()
            }
        }
    
    override val diffUtilBuilder: (List<Int>, List<Int>) -> DiffUtil.Callback?
        get() = { old, new -> PackageStepCallback(old, new) }
}

interface PackageStepListener {
    fun onPackageStepClicked()
}