package com.example.noteappmvvmroom.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.noteappmvvmroom.R
import com.example.noteappmvvmroom.databinding.FragmentCreateNotesBinding
import com.example.noteappmvvmroom.model.Notes
import com.example.noteappmvvmroom.viewmodel.NotesViewModel
import java.util.Date

class CreateNotesFragment : Fragment() {

    private lateinit var binding: FragmentCreateNotesBinding
    var priority: String = "1"
    val viewModel: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateNotesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pGreen.setImageResource(R.drawable.baseline_done_24)

        binding.btnSaveNotes.setOnClickListener {
            createNotes(it)
        }
        binding.pGreen.setOnClickListener {
            priority = "1"
            binding.pGreen.setImageResource(R.drawable.baseline_done_24)
            binding.pRed.setImageResource(0)
            binding.pYellow.setImageResource(0)

        }
        binding.pYellow.setOnClickListener {
            priority = "2"
            binding.pYellow.setImageResource(R.drawable.baseline_done_24)
            binding.pRed.setImageResource(0)
            binding.pGreen.setImageResource(0)

        }
        binding.pRed.setOnClickListener {
            priority = "3"
            binding.pRed.setImageResource(R.drawable.baseline_done_24)
            binding.pGreen.setImageResource(0)
            binding.pYellow.setImageResource(0)

        }


    }


    private fun createNotes(it: View?) {
        val title = binding.edtTilte.text.toString()
        val subTitle = binding.editSubTitle.text.toString()
        val notes = binding.editNotes.text.toString()
        val d = Date()
        val notesDate: CharSequence = android.text.format.DateFormat.format("MMMM d,yyyy", d.time)
        Log.e("@@@@", "createNotes:$notesDate ")

        val data = Notes(
            null,
            title = title,
            subTitle = subTitle,
            notes = notes,
            date = notesDate.toString(),
            priority
        )

        viewModel.addNotes(data)
        Toast.makeText(requireContext(), "Notes Created Successfully", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(it!!).navigate(R.id.action_createNotesFragment_to_homeFragment)

    }
}