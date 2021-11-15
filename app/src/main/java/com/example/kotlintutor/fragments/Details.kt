package com.example.kotlintutor.fragments

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.kotlintutor.databinding.FragmentDetailsBinding

class Details : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var navCon: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        navCon = NavHostFragment.findNavController(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupHyperlink()
        binding.topic01ShareButton.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "I'm sharing this Kotlin Topic with you")
                type = "text/plain"
            }
            startActivity(sendIntent)
        }
    }

    private fun setupHyperlink() {
        val linkTextView = binding.topic01ResourcesDesc
        linkTextView.movementMethod = LinkMovementMethod.getInstance()
        linkTextView.setLinkTextColor(Color.BLUE)
    }
}