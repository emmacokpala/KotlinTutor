package com.example.kotlintutor.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.kotlintutor.databinding.FragmentProfileBinding

class Profile : Fragment() {
    private lateinit var _binding: FragmentProfileBinding
    private val binding get() = _binding
    private lateinit var navCon: NavController
    private lateinit var firstname: String
    private lateinit var lastname: String
    private lateinit var username: String
    private lateinit var email: String

    companion object {
        const val FIRSTNAME = "First Name"
        const val LASTNAME = "Last Name"
        const val USERNAME = "User Name"
        const val EMAIL = "Email"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            firstname = it.getString(FIRSTNAME).toString()
            lastname = it.getString(LASTNAME).toString()
            username = it.getString(USERNAME).toString()
            email = it.getString(EMAIL).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        navCon = NavHostFragment.findNavController(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.firstnameText.text = FIRSTNAME
        binding.lastnameText.text = LASTNAME
        binding.usernameText.text = USERNAME
        binding.emailText.text = EMAIL
    }
}
