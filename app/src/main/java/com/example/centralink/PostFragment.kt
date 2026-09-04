// ST10452404 OPSC6312 ICE TASK 1
package com.example.centralink

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

/**
 * FRAGMENT: A modular part of the UI that handles its own Lifecycle.
 * This fragment connects to a Web Service using Retrofit to fetch JSON data.
 */
class PostFragment : Fragment() {

    private lateinit var titleTxt: TextView
    private lateinit var contentTxt: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_post, container, false)
        titleTxt = view.findViewById(R.id.postTitle)
        contentTxt = view.findViewById(R.id.postContent)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchPost()
    }

    private fun fetchPost() {
        lifecycleScope.launch {
            try {
                val post = RetrofitInstance.api.getPost()
                titleTxt.text = post.title
                contentTxt.text = post.content
            } catch (e: Exception) {
                Toast.makeText(context, "Error fetching data", Toast.LENGTH_SHORT).show()
            }
        }
    }
}