package com.example.kidsdrawingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val inputDispId : TextView = findViewById(R.id.input_dispid)
        val btnJump : Button = findViewById(R.id.btn_jump)

        btnJump.setOnClickListener{
            if(inputDispId.text.isEmpty()){
                Toast.makeText(this, "Please enter DispID", Toast.LENGTH_LONG).show()
            }else{
                val DISPID = inputDispId.text.toString()
                Toast.makeText(this, "DISPID is ${DISPID}", Toast.LENGTH_LONG).show()
//                if(DISPID = "255"){
                    //supportFragmentManager Activity内のFragmentを管理するためのFragmentマネージャーを取得
                    //beginTransaction Fragmentの追加や置換、削除などの操作をまとめて行うトランザクションの開始
                    supportFragmentManager.beginTransaction().apply {
//                  Fragmentの追加
                    add(R.id.main_frame, OperateFragment.newInstance(DISPID))
//                  トランザクションをバックスタックに追加(戻るボタンで戻れるように)
                    addToBackStack(null)
//                    トランザクションの変更を確定して実行
                    commit()
//                }
                }


//                val intent = Intent(this, QuizQuestionsActivity::class.java) //this=MainActivity
//                startActivity(intent)
//                finish()//finish MainActivity
            }
        }
    }





}