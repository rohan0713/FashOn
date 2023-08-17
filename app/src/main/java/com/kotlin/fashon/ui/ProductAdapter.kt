package com.kotlin.fashon.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.fashon.data.model.Product
import com.kotlin.fashon.databinding.ProductItemBinding
import com.squareup.picasso.Picasso

class ProductAdapter(
    val list: List<Product>
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    lateinit var view: ProductItemBinding

    inner class ProductViewHolder(itemView: ProductItemBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        fun bind(get: Product) {
            view.tvProductName.text = get.name
            view.tvProductCategory.text = get.category
            view.tvProductCost.text = "₹ ${get.cost}"
            Picasso.get().load(get.image).into(view.ivProductImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        view = ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        holder.bind(list[position])
    }
}