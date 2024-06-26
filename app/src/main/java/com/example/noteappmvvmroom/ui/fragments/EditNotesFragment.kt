package com.example.noteappmvvmroom.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.noteappmvvmroom.R
import com.example.noteappmvvmroom.databinding.FragmentEditNotesBinding
import com.example.noteappmvvmroom.model.Notes
import com.example.noteappmvvmroom.viewmodel.NotesViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.util.Date

class EditNotesFragment : Fragment() {

    val oldNotes by navArgs<EditNotesFragmentArgs>()
    lateinit var binding: FragmentEditNotesBinding
    private var priority: String = "1"
    val viewModel: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditNotesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        binding.editTitle.setText(oldNotes.data.title)
        binding.editSubTitle.setText(oldNotes.data.subTitle)
        binding.editNotes.setText(oldNotes.data.notes)

        when (oldNotes.data.priority) {
            "1" -> {
                priority = "1"
                binding.pGreen.setImageResource(R.drawable.baseline_done_24)
                binding.pRed.setImageResource(0)
                binding.pYellow.setImageResource(0)
            }

            "2" -> {
                priority = "2"
                binding.pYellow.setImageResource(R.drawable.baseline_done_24)
                binding.pRed.setImageResource(0)
                binding.pGreen.setImageResource(0)
            }

            "3" -> {
                priority = "3"
                binding.pRed.setImageResource(R.drawable.baseline_done_24)
                binding.pGreen.setImageResource(0)
                binding.pYellow.setImageResource(0)
            }
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
        binding.btnSaveNotes.setOnClickListener {
            updateNotes(it)
        }

    }

    private fun updateNotes(it: View?) {

        val title = binding.editTitle.text.toString()
        val subTitle = binding.editSubTitle.text.toString()
        val notes = binding.editNotes.text.toString()
        val d = Date()
        val notesDate: CharSequence = android.text.format.DateFormat.format("MMMM d,yyyy", d.time)
        Log.e("@@@@", "updateNotes:$notesDate ")

        val data = Notes(
            oldNotes.data.id,
            title = title,
            subTitle = subTitle,
            notes = notes,
            date = notesDate.toString(),
            priority
        )
        Log.e("@@@@@@", "updateNotes: Title : $title Subtitle : $subTitle notes : $notes")

        viewModel.updateNotes(data)
        Toast.makeText(requireContext(), "Notes Update Successfully", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(it!!).navigate(R.id.action_editNotesFragment_to_homeFragment)

    }

    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {

            val bottomSheetDialog: BottomSheetDialog =
                BottomSheetDialog(requireContext(), R.style.BottomSheetStyle)
            bottomSheetDialog.setContentView(R.layout.dialog_delete)

            val textViewYes = bottomSheetDialog.findViewById<TextView>(R.id.dialigYes)
            val textViewNo = bottomSheetDialog.findViewById<TextView>(R.id.dialogNo)

            textViewYes?.setOnClickListener {
                viewModel.deleteNotes(oldNotes.data.id!!)
                findNavController().navigate(R.id.action_editNotesFragment_to_homeFragment)
                bottomSheetDialog.dismiss()
            }
            textViewNo?.setOnClickListener {
                bottomSheetDialog.dismiss()

            }
            bottomSheetDialog.show()

        }
        return super.onOptionsItemSelected(item)
    }

}