package kr.co.tjoeun.activitytest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //1000이라는 숫자만 봐서는 => 닉네임을 받는 요청이다 라는 사실 인지 힘듬.
    val REQUEST_FOR_NICKNAME = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        다른 화면으로 이동하기 버튼이 눌리면
        moveToOtherActivityBtn.setOnClickListener {
            val myIntent = Intent(this, OtherActivity::class.java)
            startActivity(myIntent)
        }
//  메세지 전달 버튼이 눌리면
        sendMessageBtn.setOnClickListener {

            val inputMessage = messageEdt.text.toString()
            val myIntent = Intent(this, MessageActivity::class.java)
            myIntent.putExtra("message",inputMessage)
            startActivity(myIntent)
            //수정
        }

        //닉네임 변경 버튼이 눌리면
        changeNickNameBtn.setOnClickListener{
            //닉네임 입력 화면으로 이동 (입력 결과를 받으러 가는것임)

            val myIntent = Intent(this, EditNickNameActivity::class.java)

            //(닉네임입력=>1000 숫자로 대신 표기)결과를 받으러 이동한다고 별도로 명시
            //1000대신 => 멤버변수로 만들어둔 REQUEST_FOR_NICKNAME를 활용, 가독성 향상
            startActivityForResult(myIntent,REQUEST_FOR_NICKNAME)
        }
    }
}
