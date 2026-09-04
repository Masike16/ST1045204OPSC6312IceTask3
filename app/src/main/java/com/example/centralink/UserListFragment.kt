package com.example.centralink

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class UserListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_list, container, false)

        val rvUserList = view.findViewById<RecyclerView>(R.id.rvUserList)
        val btnBack = view.findViewById<Button>(R.id.btnBackFromUsers)

        val users = DatabaseManager.getAllUsers(requireContext())
        rvUserList.layoutManager = LinearLayoutManager(context)
        rvUserList.adapter = UserAdapter(users)

        btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        return view
    }
}
