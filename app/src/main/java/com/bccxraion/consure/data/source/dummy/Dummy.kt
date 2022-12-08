package com.bccxraion.consure.data.source.dummy

import com.bccxraion.consure.R
import com.bccxraion.consure.model.chat.Chat
import com.bccxraion.consure.util.Tag

object Dummy {
    
    fun getFakeTopExperts() = listOf(
        Pair(Tag.SCHOLARSHIP.tag, R.drawable.img_fake_scholarship_expert_1),
        Pair(Tag.CAREER.tag, R.drawable.img_fake_career_expert_2),
        Pair(Tag.CAREER.tag, R.drawable.img_fake_career_expert_1),
        Pair(Tag.SCHOLARSHIP.tag, R.drawable.img_fake_scholarship_expert_2),
        Pair(Tag.COMPETITION.tag, R.drawable.img_fake_competition_expert_1),
        Pair(Tag.COMPETITION.tag, R.drawable.img_fake_competition_expert_2),
    )
    
    fun getFakePackages() = listOf(
        R.drawable.img_fake_package_1,
        R.drawable.img_fake_package_2,
    )
    
    fun getDummyPost() = listOf(
        Pair(Tag.CAREER.tag, R.drawable.img_fake_post_1),
        Pair(Tag.SCHOLARSHIP.tag, R.drawable.img_fake_post_2),
        Pair(Tag.COMPETITION.tag, R.drawable.img_fake_post_3),
    )
    
    fun getDummyChat() = listOf(
        Chat(R.drawable.img_ava_1, "Belinda Azzahra", "Okey,thanks", "12:00", false),
        Chat(R.drawable.img_ava_2, "Claura Sophia", "Okay, try to send the \u2028data that you have found \u2028for me to see first", "12:00", false),
        Chat(R.drawable.img_ava_3, "Kevin William", "Problem of unemployment", "12/08/22", false),
        Chat(R.drawable.img_ava_4, "Nathan Roestandy", "Thankyou !", "09/09/22", true),
        Chat(R.drawable.img_ava_5, "Syafa Fadilah", "See u next journey!", "23/08/22", true),
    )
    
}