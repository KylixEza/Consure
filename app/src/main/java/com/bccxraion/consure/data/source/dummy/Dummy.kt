package com.bccxraion.consure.data.source.dummy

import com.bccxraion.consure.R
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
    
}