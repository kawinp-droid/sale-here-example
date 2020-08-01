package com.application.proxumer.ui

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.application.proxumer.R
import kotlinx.android.synthetic.main.fragment_add_goal.view.*
import java.text.SimpleDateFormat
import java.util.*


class AddGoalFragment : Fragment() {

    private lateinit var mView: View
    private lateinit var currentCalendar: Calendar

    private var travelSelected = false
    private var educationSelected = false
    private var investSelected = false
    private var clothingSelected = false
    private var education2Selected = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.fragment_add_goal, container, false)

        initUI()

        return mView
    }

    private fun initUI() {
        mView.btnCancel.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
        }
        mView.btnAddGoal.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
        }

        currentCalendar = Calendar.getInstance()
        updateSelectedDate()

        mView.editTextAddGoalDate.isFocusable = false
        mView.editTextAddGoalDate.setOnClickListener {
            DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { _, year, month, day ->
                    currentCalendar.set(Calendar.YEAR, year)
                    currentCalendar.set(Calendar.MONTH, month)
                    currentCalendar.set(Calendar.DAY_OF_MONTH, day)
                    updateSelectedDate()
                }, currentCalendar.get(Calendar.YEAR),
                currentCalendar.get(Calendar.MONTH),
                currentCalendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        mView.cardViewTravelSelected.setOnClickListener {
            travelSelected = true
            educationSelected = false
            investSelected = false
            clothingSelected = false
            education2Selected = false

            mView.imageViewTravel.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
            mView.imageViewEducation.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorAccent))
            mView.imageViewInvest.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorAccent))
            mView.imageViewClothing.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorAccent))
            mView.imageViewEducation2.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorAccent))

            setButtonTypeSelection()
        }
        mView.cardViewEducationSelected.setOnClickListener {
            travelSelected = false
            educationSelected = true
            investSelected = false
            clothingSelected = false
            education2Selected = false

            mView.imageViewTravel.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorAccent))
            mView.imageViewEducation.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
            mView.imageViewInvest.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorAccent))
            mView.imageViewClothing.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorAccent))
            mView.imageViewEducation2.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorAccent))

            setButtonTypeSelection()
        }
        mView.cardViewInvestSelected.setOnClickListener {
            travelSelected = false
            educationSelected = false
            investSelected = true
            clothingSelected = false
            education2Selected = false

            mView.imageViewTravel.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorAccent))
            mView.imageViewEducation.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorAccent))
            mView.imageViewInvest.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
            mView.imageViewClothing.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorAccent))
            mView.imageViewEducation2.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorAccent))

            setButtonTypeSelection()
        }
        mView.cardViewClothingSelected.setOnClickListener {
            travelSelected = false
            educationSelected = false
            investSelected = false
            clothingSelected = true
            education2Selected = false

            mView.imageViewTravel.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorAccent))
            mView.imageViewEducation.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorAccent))
            mView.imageViewInvest.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorAccent))
            mView.imageViewClothing.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
            mView.imageViewEducation2.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorAccent))

            setButtonTypeSelection()
        }
        mView.cardViewEducation2Selected.setOnClickListener {
            travelSelected = false
            educationSelected = false
            investSelected = false
            clothingSelected = false
            education2Selected = true

            mView.imageViewTravel.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorAccent))
            mView.imageViewEducation.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorAccent))
            mView.imageViewInvest.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorAccent))
            mView.imageViewClothing.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorAccent))
            mView.imageViewEducation2.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorPrimary))

            setButtonTypeSelection()
        }
    }

    private fun setButtonTypeSelection() {
        mView.layoutTravel.isSelected = travelSelected
        mView.layoutEducation.isSelected = educationSelected
        mView.layoutInvest.isSelected = investSelected
        mView.layoutClothing.isSelected = clothingSelected
        mView.layoutEducation2.isSelected = education2Selected
    }

    private fun updateSelectedDate() {
        val myFormat = "MM/dd/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        mView.editTextAddGoalDate.setText(sdf.format(currentCalendar.time))
    }

    override fun onPause() {
        super.onPause()
        requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
    }
}