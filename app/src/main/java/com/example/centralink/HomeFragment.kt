// ST10452404 OPSC6312 ICE TASK 2
package com.example.centralink

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navigation to Map
        val btnViewMap = view.findViewById<Button>(R.id.btnViewMap)
        btnViewMap.setOnClickListener {
            findNavController().navigate(R.id.mapFragment)
        }

        // Navigation to Services
        val btnServices = view.findViewById<Button>(R.id.btnServices)
        btnServices.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_services)
        }

        // Navigation to Deliveries
        val btnAnnouncements = view.findViewById<Button>(R.id.btnAnnouncements)
        btnAnnouncements.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_announcementsFragment)
        }

        // Navigation to User List (SQLite)
        val btnViewUsers = view.findViewById<Button>(R.id.btnViewUsers)
        btnViewUsers.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_userListFragment)
        }
    }
}
