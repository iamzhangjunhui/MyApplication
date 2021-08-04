package com.loyo.myapplication.use_autocompletetextview

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import com.loyo.myapplication.R


class AutoCompleteTextViewAdapter(var data: ArrayList<String>) : BaseAdapter(), Filterable {
    lateinit var filter: ArrayFilter
    lateinit var results:ArrayList<String>
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view: View
        var viewHolder: ViewHolder
        if (convertView == null) {
            view = View.inflate(parent.context, R.layout.item, null)
            viewHolder = ViewHolder()
            viewHolder.tv_name = view.findViewById<TextView>(R.id.tv)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = convertView.tag as ViewHolder
        }
        viewHolder.tv_name?.text = getItem(position)
        return view
    }

    override fun getItem(position: Int): String {
        return results[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return if (this::results.isInitialized) results.size else 0
    }

    override fun getFilter(): Filter {
        if (!this::filter.isInitialized) {
            filter = ArrayFilter()
        }
        return filter
    }

    inner class ArrayFilter : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val filterResults = FilterResults()
            if (constraint == null || constraint.isEmpty()) {
                filterResults.values = data
                filterResults.count = data.size
            } else {
                val results = arrayListOf<String>()
                val key = constraint.toString().toLowerCase()
                for (d in data) {
                    if (key in d) {
                        results.add(d)
                    }
                }
                filterResults.values = results
                filterResults.count = results.size
            }
            return filterResults

        }

        override fun publishResults(constraint: CharSequence?, filterResults: FilterResults) {
            results = filterResults.values as ArrayList<String>

            if (filterResults.count > 0) {
                notifyDataSetChanged()
            } else {
                notifyDataSetInvalidated()
            }
        }

    }

    internal class ViewHolder {
        var tv_name: TextView? = null
    }
}