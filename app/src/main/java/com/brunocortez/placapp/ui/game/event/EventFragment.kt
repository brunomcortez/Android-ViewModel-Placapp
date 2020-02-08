package com.brunocortez.placapp.ui.game.event

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.localbroadcastmanager.content.LocalBroadcastManager

import com.brunocortez.placapp.R
import com.brunocortez.placapp.ui.extensions.setupClearButtonWithAction
import com.brunocortez.placapp.ui.game.hometeam.HomeTeamFragment
import kotlinx.android.synthetic.main.fragment_event.*


class EventFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inputEvent.setupClearButtonWithAction()
        btNextStep.setOnClickListener { sendEventName() }
    }

    private fun nextScreen() {

        val ft = activity?.supportFragmentManager?.beginTransaction()
        ft?.setCustomAnimations(
            R.anim.enter_from_right,
            R.anim.exit_to_left,
            R.anim.enter_from_left,
            R.anim.exit_to_right
        )
        ft?.replace(R.id.containerGame, HomeTeamFragment())
        ft?.addToBackStack(null)
        ft?.commit()
    }

    private fun sendEventName() {
        val intent = Intent("FILTER_EVENT")
        intent.putExtra("event_name", inputEvent.text.toString())
        LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
    }


}
