package com.example.laboratorio05.ui.movie

import android.app.ProgressDialog.show
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.laboratorio05.databinding.FragmentNewMovieBinding



class MovieNewFragment : Fragment() {

    private lateinit var Name : EditText
    private lateinit var Category: EditText
    private lateinit var Description: EditText
    private lateinit var Qualification: EditText
    private lateinit var Submit: Button

    private lateinit var binding: FragmentNewMovieBinding
    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewMovieBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()
    }

    private fun setViewModel() {
        binding.viewmodel = movieViewModel
    }
    private fun observeStatus() {
        movieViewModel.status.observe(viewLifecycleOwner){
            status -> when{
                status.equals(MovieViewModel.WRONG_INFORMATION) ->{
                    Log.d("APP_TAG", status)
                    movieViewModel.clearStatus()
                }
                status.equals(MovieViewModel.MOVIE_CREATED) ->{
                    Log.d("APP_TAG", status)
                    Log.d("APP_TAG", movieViewModel.getMovies().toString())

                    movieViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }


}