package com.example.kidsdrawingapp

import android.os.Bundle
import android.provider.DocumentsContract.Root
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

private const val DSPID = "DSPID"

class OperateFragment : Fragment() {

    private var mDispId: String = ""

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment レイアウトとクラスを紐付ける
            return inflater.inflate(R.layout.fragment_operate, container, false)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{
            mDispId = it.getString(DSPID, "0")

        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView: TextView  = view.findViewById(R.id.operate_textView)
        textView.setText(mDispId)

        var btnToOperate : Button = view.findViewById(R.id.to_operate)

        btnToOperate.setOnClickListener{
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.main_frame, RootFragment())
                addToBackStack(null)
                commit()
            }
        }
    }

    companion object {
        fun newInstance(text: String) =
            OperateFragment().apply {
                arguments = Bundle().apply{
                    putString(DSPID, text)
                }

            }
    }



}

