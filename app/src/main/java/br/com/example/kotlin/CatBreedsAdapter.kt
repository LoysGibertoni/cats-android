package br.com.example.kotlin

import android.util.TypedValue
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.setPadding
import androidx.recyclerview.widget.RecyclerView
import br.com.example.kotlin.data.CatBreed

class CatBreedsAdapter : RecyclerView.Adapter<CatBreedsAdapter.ViewHolder>() {

    var items: List<CatBreed> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            itemView = TextView(parent.context).apply {
                setPadding(
                    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16f, parent.context.resources.displayMetrics).toInt()
                )
            }
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text = items[position].name
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(itemView: TextView) : RecyclerView.ViewHolder(itemView) {
        var text: CharSequence by itemView::text
    }
}