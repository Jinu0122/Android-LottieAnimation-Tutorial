package com.example.lottieanimationtutorial

import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object{
        const val TAG: String = "로그"
    }

    var isLiked:Boolean= false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        isLiked = false

        //좋아요 버튼의 클릭리스너를 받아준다.
        like_btn.setOnClickListener {
            Log.d(TAG,"MainActivity - onCreate() called / 좋아요 버튼이 클릭 되었다.")

            //좋아요 상태가 아닐때
            if (isLiked == false){
                //버튼이 눌리면 로티애니메이션이 실행되라
//            like_btn.playAnimation()

                // Custom animation speed or duration.
                // 애니메이션의 커스
                // 0f가 0퍼센트(처음), 1f = 100퍼센트(끝)
                // ifFloat(시작지점,종료지점. setDuration(지속시간) 1000 = 1초
                val animator = ValueAnimator.ofFloat(0f, 0.5f).setDuration(1000)
                animator.addUpdateListener { animation: ValueAnimator ->
                    like_btn.setProgress(
                        // 애니메이션 값을 가져와야한다 그리고 Float 로 받아야하기때문에 as Float 입
                        animation.getAnimatedValue() as Float
                    )
                }
                animator.start()

                isLiked = true

            }else{ // 좋아요 상태일때
                //버튼이 눌리면 로티애니메이션이 실행되라
//            like_btn.playAnimation()

                // Custom animation speed or duration.
                // 애니메이션의 커스
                // 0f가 0퍼센트(처음), 1f = 100퍼센트(끝)
                // ifFloat(시작지점,종료지점. setDuration(지속시간) 1000 = 1초
                val animator = ValueAnimator.ofFloat(0.5f, 1f).setDuration(300)
                animator.addUpdateListener { animation: ValueAnimator ->
                    like_btn.setProgress(
                        // 애니메이션 값을 가져와야한다 그리고 Float 로 받아야하기때문에 as Float 입
                        animation.getAnimatedValue() as Float
                    )
                }
                animator.start()

                isLiked = false

            }

            Log.d(TAG,"MainActivity - onCreate() called / 좋아요 버튼이 클릭 되었다. isLike : ${isLiked}")


        }
    }
}