package com.bccxraion.consure.validator

import androidx.viewbinding.ViewBinding

interface ConstraintValidator<VB: ViewBinding> {

    fun VB.validate()

}